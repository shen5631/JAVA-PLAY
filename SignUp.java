package javaplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class SignUp{
    JPanel p2 = new JPanel();
    JButton signUp = new JButton("회원가입");
    JLabel sign = new JLabel("-회원 가입-");
    JLabel pw = new JLabel("PW");
    JLabel id= new JLabel("ID");
    JTextField t1 = new JTextField();
    JPasswordField t2 = new JPasswordField();
    JButton back = new JButton("뒤로가기");


    SignUp(JFrame f, JPanel p1){
        sign.setFont(new Font("맑은 고딕",Font.PLAIN,48));
        sign.setBounds(49-sign.getWidth()/2,44-sign.getHeight()/2,260,64);
        signUp.setBounds(538- signUp.getWidth()/2,500- signUp.getHeight()/2,257,87);
        signUp.setFont(new Font("맑은 고딕",Font.BOLD,40));
        p2.setSize(1000,700);
        p2.setLayout(null);

        back.setBounds(233-back.getWidth()/2,500-back.getHeight()/2,257,87);
        back.setFont(new Font("맑은 고딕",Font.BOLD,40));

        t1.setBounds(317-t1.getWidth()/2,190-t1.getHeight()/2,455 ,78);
        t1.setFont(new Font("맑은 고딕",Font.BOLD,40));
        t2.setBounds(317-t2.getWidth()/2,340-t2.getHeight()/2,455 ,78);
        t2.setFont(new Font("맑은 고딕",Font.BOLD,40));


        id.setFont(new Font("맑은 고딕",Font.BOLD,80));
        id.setBounds(200-id.getWidth()/2,175-id.getHeight()/2,140,96);
        pw.setFont(new Font("맑은 고딕",Font.BOLD,80));
        pw.setBounds(168-pw.getWidth()/2,330-pw.getHeight()/2,158,96);



        p2.add(signUp);
        p2.add(sign);
        p2.add(id);
        p2.add(pw);
        p2.add(t1);
        p2.add(t2);
        p2.add(back);


        signUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String ids = t1.getText();
                String pws = new String(t2.getPassword());
                boolean login = true;
                try {
                    FileWriter user = new FileWriter("user.txt",true);
                    FileWriter score = new FileWriter("score.txt",true);
                    FileWriter style = new FileWriter("style.txt",true);
                    long fileLine = Files.lines(Paths.get("user.txt")).count();
                    BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
                    for(int i = 1 ; i<= fileLine ; i++){
                        String tid = reader.readLine();
                        StringTokenizer st = new StringTokenizer(tid,",");
                        String check_ID = st.nextToken();
                        st.nextToken();
                        if (check_ID.equals(ids)){
                            JOptionPane.showMessageDialog(null,"중복된 아이디 입니다.");
                            f.remove(p2);
                            f.add(p1);
                            f.revalidate();
                            f.repaint();
                            login=false;
                        }

                    }

                    if (login){
                        user.write(ids+","+pws+"\n");
                        score.write("0\n");
                        style.write("없음\n");
                        user.close();
                        score.close();
                        style.close();

                        JOptionPane.showMessageDialog(null,"회원가입을 완료하셨습니다!");
                        f.remove(p2);
                        f.add(p1);
                        f.revalidate();
                        f.repaint();
                    }
                    t1.setText("");
                    t2.setText("");
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        );

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
