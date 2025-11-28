package javaplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class login extends GameMain{
    static String last_ID;
    static int last_SCORE;
    static int last_SU;
    static String last_STYLE;
    JPanel p2 = new JPanel();
    JButton login = new JButton("로그인");
    JButton back = new JButton("뒤로가기");
    JLabel login1 = new JLabel("-로그인-");
    JLabel pw = new JLabel("PW");
    JLabel id= new JLabel("ID");
    JTextField t1 = new JTextField();
    JPasswordField t2 = new JPasswordField();

    login(JFrame f, JPanel p1){
        super(f,p1);
        p2.setSize(1000,700);
        p2.setLayout(null);

        login1.setFont(new Font("맑은 고딕",Font.PLAIN,48));
        login1.setBounds(49-login1.getWidth()/2,44-login1.getHeight()/2,260,64);

        login.setBounds(538-login.getWidth()/2,500-login.getHeight()/2,257,87);
        login.setFont(new Font("맑은 고딕",Font.BOLD,40));

        back.setBounds(233-back.getWidth()/2,500-back.getHeight()/2,257,87);
        back.setFont(new Font("맑은 고딕",Font.BOLD,40));

        t1.setBounds(317-t1.getWidth()/2,190-t1.getHeight()/2,455 ,78);
        t1.setFont(new Font("맑은 고딕",Font.BOLD,40));
        t2.setBounds(317-t2.getWidth()/2,340-t2.getHeight()/2,455 ,78);
        t2.setFont(new Font("맑은 고딕",Font.BOLD,40));


        id.setFont(new Font("맑은 고딕",Font.BOLD,80));
        id.setBounds(200-id.getWidth()/2,175-id.getHeight()/2,140,96);
        pw.setFont(new Font("맑은 고딕",Font.BOLD,80));
        pw.setBounds(168- pw.getWidth()/2,330- pw.getHeight()/2,158,96);

        p2.add(login);
        p2.add(login1);
        p2.add(back);
        p2.add(id);
        p2.add(pw);
        p2.add(t1);
        p2.add(t2);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ids = t1.getText();
                String pws = new String(t2.getPassword());
                boolean login = false;
                try {
                    FileWriter user = new FileWriter("user.txt",true);
                    long fileLine = Files.lines(Paths.get("user.txt")).count();
                    BufferedReader user_reader = new BufferedReader(new FileReader("user.txt"));
                    BufferedReader score_reader = new BufferedReader(new FileReader("score.txt"));
                    BufferedReader style_reader = new BufferedReader(new FileReader("style.txt"));


                    for(int i = 1 ; i <= fileLine ; i++){
                        String tid = user_reader.readLine();
                        String tscore = score_reader.readLine();
                        String tstyle = style_reader.readLine();
                        StringTokenizer id_st = new StringTokenizer(tid,",");
                        StringTokenizer sc_st = new StringTokenizer(tscore,"\n");
                        StringTokenizer st_st = new StringTokenizer(tstyle,"\n");
                        String check_ID = id_st.nextToken();
                        last_SCORE = Integer.parseInt(sc_st.nextToken());
                        last_STYLE = st_st.nextToken();
                        String check_PW = id_st.nextToken();
                        if(check_ID.equals(ids) && check_PW.equals(pws)){
                            login=true;
                            last_ID=ids;
                            last_SU=i;
                            break;
                        }

                    }
                    if (login){
                        JOptionPane.showMessageDialog(null,last_ID+"님 로그인을 환영합니다! ");
                        f.remove(p2);
                        f.add(p3);
                        f.revalidate();
                        f.repaint();
                        System.out.println("아이디 : "+last_ID);
                        System.out.println("점수 : "+last_SCORE);
                        System.out.println("칭호 : "+last_STYLE);
                        login=false;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"로그인에 실패하셨습니다.\n다시 입력해주세요");
                        t1.setText("");
                        t2.setText("");
                    }
                    t1.setText("");
                    t2.setText("");
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });


        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.remove(p2);
                f.add(p1);
                f.revalidate();
                f.repaint();
                t1.setText("");
                t2.setText("");
            }
        });
    }
}
