package javaplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {
    JPanel mp = new JPanel();
    JLabel title = new JLabel("-메모리 게임-");
    JLabel m_card = new JLabel(new ImageIcon("img/Group 5.png"));

    JButton start = new JButton("게임 시작");
    JButton rule = new JButton("규칙");
    JButton back = new JButton("뒤로가기");

    Game(JFrame f, JPanel p3) {
        //메모리게임 시작화면
        mp.setSize(1000, 700);
        mp.setLayout(null);

        title.setBounds(240 - title.getWidth() / 2, 41 - title.getHeight() / 2, 625, 107);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 96));
        m_card.setBounds(362 - m_card.getWidth() / 2, 182 - m_card.getHeight() / 2, 257, 205);

        start.setBounds(67 - start.getWidth() / 2, 486 - start.getHeight() / 2, 275, 104);
        start.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        rule.setBounds(362 - rule.getWidth() / 2, 486 - rule.getHeight() / 2, 275, 104);
        rule.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        back.setBounds(657 - back.getWidth() / 2, 486 - back.getHeight() / 2, 275, 104);
        back.setFont(new Font("맑은 고딕", Font.BOLD, 40));


        mp.add(title);
        mp.add(m_card);
        mp.add(start);
        mp.add(rule);
        mp.add(back);

        //메모리 게임 규칙

        JFrame mr = new JFrame("게임 규칙");
        mr.setSize(400, 400);
        mr.setLayout(null);

        JLabel rulegame = new JLabel("<html>" +
                "1. 6 × 4 판에서 게임을 시작한다.<br>" +
                "2. 게임이 시작되면 5초 동안 카드가 보인다.<br>" +
                "3. 그 후 카드를 같은 것끼리 선택하면 된다.<br>" +
                "4. 카드를 연속해서 맞출 경우 점수가 증가한다.<br>" +
                "5. 난이도에 따라 맞출 수 있는 횟수가 부여된다.<br>" +
                "6. 쉬움 : 18번, 보통 : 15번, 어려움 : 12번<br>" +
                "7. 성공하면 점수를 획득한다!" +
                "</html>");
        rulegame.setBounds(20, 20, 350, 300);
        rulegame.setFont(new Font("맑은 고딕", Font.BOLD, 15));

        mr.add(rulegame);

        //게임창

        int[] Check = new int[1];

        JPanel modep = new JPanel();
        modep.setSize(1000, 700);
        modep.setLayout(null);

        JLabel modetitle = new JLabel("-난이도 선택-");
        JButton hard = new JButton("어려움");
        JButton nomal = new JButton("보통");
        JButton easy = new JButton("쉬움");

        modetitle.setBounds(234 - modetitle.getWidth() / 2, 49 - modetitle.getHeight() / 2, 600, 90);
        modetitle.setFont(new Font("맑은 고딕", Font.BOLD, 96));
        hard.setBounds(349 - hard.getWidth() / 2, 212 - hard.getHeight() / 2, 303, 114);
        hard.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        nomal.setBounds(349 - nomal.getWidth() / 2, 376 - nomal.getHeight() / 2, 303, 114);
        nomal.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        easy.setBounds(349 - easy.getWidth() / 2, 540 - easy.getHeight() / 2, 303, 114);
        easy.setFont(new Font("맑은 고딕", Font.BOLD, 40));

        modep.add(modetitle);
        modep.add(easy);
        modep.add(nomal);
        modep.add(hard);

        //메모리 게임 플레이

        JPanel memory_play = new JPanel();
        memory_play.setSize(1000, 700);
        memory_play.setLayout(null);

            hard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Check[0] = 3;
                }
            });

            nomal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Check[0] = 2;
                }
            });

            easy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Check[0] = 1;
                }
            });


            start.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.remove(mp);
                    f.add(modep);
                    f.revalidate();
                    f.repaint();
                }
            });

            rule.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mr.setVisible(true);
                }
            });


        }
    }