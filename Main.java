package javaplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame("java play");
        f.setSize(1000,700);
        f.setResizable(false);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);

        //창설정

        //판넬설정
        JPanel p1 = new JPanel();
        p1.setSize(1000,700);
        p1.setLayout(null);
        SignUp signUp = new SignUp(f,p1);
        login login = new login(f,p1);
        GameMain gm = new GameMain(f,p1);
        Game game = new Game(f,p1);

        //이름표시
        JLabel l = new JLabel("-JAVA PLAY-");
        l.setFont(new Font("맑은 고딕",Font.BOLD,96));
        l.setBounds(186-l.getWidth()/2,89-l.getHeight()/2,608,109);
        p1.add(l);
        f.add(p1);

        //회원가입

        //버튼
        JButton b1 = new JButton("회원가입");
        JButton b2 = new JButton("로그인");

        b1.setFont(new Font("맑은 고딕",Font.BOLD,40));
        b1.setBounds(348-b1.getWidth()/2,319-b1.getHeight()/2,305,122);
        p1.add(b1);
        b2.setFont(new Font("맑은 고딕",Font.BOLD,40));
        b2.setBounds(348-b2.getWidth()/2,467-b2.getHeight()/2,305,122);
        p1.add(b2);

        f.revalidate();
        f.repaint();


        //이벤트

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.remove(p1);
                f.add(signUp.p2);
                f.revalidate();
                f.repaint();
            }
        }
        );
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.remove(p1);
                f.add(login.p2);
                f.revalidate();
                f.repaint();
            }
        });
    }

}
