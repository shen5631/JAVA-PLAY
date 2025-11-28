package javaplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class GameMain {
    JPanel p3= new JPanel();
    JLabel big_name = new JLabel("-JAVA PLAY-");
    JButton gameplay = new JButton("게임  플레이");
    JButton shop = new JButton("상점");
    JButton logout = new JButton("로그아웃");
    JButton rank = new JButton("랭킹");

    GameMain(){

    }

    GameMain(JFrame f, JPanel p1){
        p3.setSize(1000,700);
        p3.setLayout(null);
        Rank rankp = new Rank(f,p3);
        Shop shopp = new Shop(f,p3);
        GamyPlay gpp = new GamyPlay(f,p3);

        big_name.setBounds(209-big_name.getWidth()/2,112-big_name.getHeight()/2,626,105);
        big_name.setFont(new Font("맑은 고딕",Font.BOLD,96));

        gameplay.setBounds(192-gameplay.getWidth()/2,350-gameplay.getHeight()/2,286,108);
        gameplay.setFont(new Font("맑은 고딕",Font.BOLD,40));

        shop.setBounds(522-shop.getWidth()/2,350-shop.getHeight()/2,286,108);
        shop.setFont(new Font("맑은 고딕",Font.BOLD,40));

        rank.setBounds(192-rank.getWidth()/2,481-rank.getHeight()/2,286,108);
        rank.setFont(new Font("맑은 고딕",Font.BOLD,40));

        logout.setBounds(522- logout.getWidth()/2,481- logout.getHeight()/2,286,108);
        logout.setFont(new Font("맑은 고딕",Font.BOLD,40));



        p3.add(big_name);
        p3.add(gameplay);
        p3.add(shop);
        p3.add(logout);
        p3.add(rank);

        shop.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(p3);
                f.add(shopp.shopp);
                f.revalidate();
                f.repaint();}
        });

        rank.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(p3);
                f.add(rankp.rankp);
                f.revalidate();
                f.repaint();}
        });

        gameplay.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(p3);
                f.add(gpp.gpp);
                f.revalidate();
                f.repaint();}
        });

        logout.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(p3);
                f.add(p1);
                f.revalidate();
                f.repaint();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        });

    }
}

class GamyPlay extends Game{

    //게임플레이 화면
    JPanel gpp = new JPanel();

    JLabel name = new JLabel("-게임 선택-");

    JLabel memory = new JLabel(new ImageIcon("img/Group 5.png"));
    JLabel war = new JLabel(new ImageIcon("img/Group 7.png"));

    JButton mb = new JButton("메모리 게임");
    JButton wb = new JButton("벽돌 깨기");
    JButton back = new JButton("뒤로가기");
    GamyPlay(JFrame f,JPanel p3){
        super(f,p3);
        gpp.setSize(1000,700);
        gpp.setLayout(null);

        name.setBounds(240-name.getWidth()/2,41-name.getHeight()/2,625,107);
        name.setFont(new Font("맑은 고딕",Font.BOLD,96));

        memory.setBounds(145-memory.getWidth()/2,217-memory.getHeight()/2,270,216);

        war.setBounds(539-war.getWidth()/2,220-war.getHeight()/2,244,203);

        wb.setBounds(537-wb.getWidth()/2,445-wb.getHeight()/2,209,110);
        wb.setFont(new Font("맑은 고딕",Font.BOLD,30));
        mb.setBounds(163-mb.getWidth()/2,445-mb.getHeight()/2,209,110);
        mb.setFont(new Font("맑은 고딕",Font.BOLD,30));

        back.setBounds(354-back.getWidth()/2,575-back.getHeight()/2,235,89);
        back.setFont(new Font("맑은 고딕",Font.BOLD,40));




        gpp.add(name);
        gpp.add(war);
        gpp.add(memory);
        gpp.add(mb);
        gpp.add(wb);
        gpp.add(back);




        back.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(gpp);
                f.add(p3);
                f.revalidate();
                f.repaint();
            }
        });

        wb.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(gpp);
                f.add(p3);
                f.revalidate();
                f.repaint();
            }
        });

        mb.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(gpp);
                f.add(mp);
                f.revalidate();
                f.repaint();
            }
        });

    }
}

class Shop{
    JPanel shopp = new JPanel();
    JLabel shop = new JLabel("-상점-");
    JButton back = new JButton("뒤로가기");
    JLabel nemo1 = new JLabel(new ImageIcon("img/Rectangle 42.png"));
    JLabel nemo2 = new JLabel(new ImageIcon("img/Rectangle 42.png"));
    JLabel nemo3 = new JLabel(new ImageIcon("img/Rectangle 42.png"));
    JButton buy1 = new JButton("50 점수");
    JButton buy2 = new JButton("500 점수");
    JButton buy3 = new JButton("9999 점수");
    JLabel ching1 = new JLabel(new ImageIcon("img/Group 12.png"));
    JLabel ching2 = new JLabel(new ImageIcon("img/Group 13.png"));
    JLabel ching3 = new JLabel(new ImageIcon("img/Group 14.png"));

    Shop(JFrame f,JPanel p3){
        shopp.setSize(1000,700);
        shopp.setLayout(null);

        back.setBounds(344-back.getWidth()/2,557-back.getHeight()/2,297,112);
        back.setFont(new Font("맑은 고딕",Font.BOLD,40));

        shop.setBounds(363-shop.getWidth()/2,44-shop.getWidth()/2 ,274,109);
        shop.setFont(new Font("맑은 고딕",Font.BOLD,96));

        nemo1.setBounds(31-nemo1.getWidth()/2,220-nemo1.getHeight()/2,241,227);
        nemo2.setBounds(372-nemo2.getWidth()/2,220-nemo2.getHeight()/2,241,227);
        nemo3.setBounds(714-nemo3.getWidth()/2,220-nemo3.getHeight()/2,241,227);

        buy1.setBounds(54-buy1.getWidth()/2,384-buy1.getHeight()/2,192,42);
        buy1.setFont(new Font("맑은 고딕",Font.BOLD,20));
        buy2.setBounds(397-buy2.getWidth()/2,384-buy2.getHeight()/2,192,42);
        buy2.setFont(new Font("맑은 고딕",Font.BOLD,20));
        buy3.setBounds(739-buy3.getWidth()/2,384-buy3.getHeight()/2,192,42);
        buy3.setFont(new Font("맑은 고딕",Font.BOLD,20));

        ching1.setBounds(55-ching1.getWidth()/2,310-ching1.getHeight()/2,210,39);
        ching2.setBounds(389-ching2.getWidth()/2,310-ching2.getHeight()/2,210,39);
        ching3.setBounds(730-ching3.getWidth()/2,310-ching3.getHeight()/2,210,39);

        shopp.add(ching1);
        shopp.add(ching2);
        shopp.add(ching3);
        shopp.add(buy1);
        shopp.add(buy2);
        shopp.add(buy3);
        shopp.add(back);
        shopp.add(nemo1);
        shopp.add(nemo2);
        shopp.add(nemo3);
        shopp.add(shop);


        buy1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(login.last_SCORE<50){
                    JOptionPane.showMessageDialog(null,"포인트가 부족합니다.");
                }
                else {
                    try{
                        BufferedReader rstyle = new BufferedReader(new FileReader("style.txt"));
                        FileWriter style = new FileWriter("style.txt",true);
                        String tstyle = rstyle.readLine();
                        StringTokenizer st = new StringTokenizer(tstyle,",");
                        String check_ID = st.nextToken();
                        for (int i =1 ; i < login.last_SU ; i++){
                            st.nextToken();
                        }
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }

                }
            }
        });

        buy2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(login.last_SCORE<500){
                    JOptionPane.showMessageDialog(null,"포인트가 부족합니다.");
                }
            }
        });

        buy3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(login.last_SCORE<9999){
                    JOptionPane.showMessageDialog(null,"포인트가 부족합니다.");
                }
            }
        });

        back.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(shopp);
                f.add(p3);
                f.revalidate();
                f.repaint();
            }
        });

    }
}

class Rank extends GameMain{
    JPanel rankp = new JPanel();
    JLabel rank = new JLabel("-랭킹-");
    JLabel rank1 = new JLabel(new ImageIcon("img/Rectangle 45.png"));
    JLabel rank2 = new JLabel(new ImageIcon("img/Rectangle 46.png"));
    JLabel rank3 = new JLabel(new ImageIcon("img/Rectangle 47.png"));
    JLabel rank4 = new JLabel(new ImageIcon("img/Rectangle 48.png"));
    JLabel rank5 = new JLabel(new ImageIcon("img/Rectangle 49.png"));
    JButton back = new JButton("뒤로가기");
    Rank(JFrame f,JPanel p3){
        rankp.setSize(1000,700);
        rankp.setLayout(null);

        rank.setBounds(362-rank.getWidth()/2,46-rank.getHeight()/2,276,103);
        rank.setFont(new Font("맑은 고딕",Font.BOLD,96));


        rank1.setBounds(77-rank1.getWidth()/2,204-rank1.getHeight()/2,846,59);
        rank2.setBounds(77-rank2.getWidth()/2,280-rank2.getHeight()/2,846,59);
        rank3.setBounds(77-rank3.getWidth()/2,356-rank3.getHeight()/2,846,59);
        rank4.setBounds(77-rank4.getWidth()/2,431-rank4.getHeight()/2,846,59);
        rank5.setBounds(77-rank5.getWidth()/2,507-rank5.getHeight()/2,846,59);
        back.setBounds(321-back.getWidth()/2,599-back.getHeight()/2,357,64);
        back.setFont(new Font("맑은 고딕",Font.BOLD,40));


        rankp.add(rank);
        rankp.add(rank1);
        rankp.add(rank2);
        rankp.add(rank3);
        rankp.add(rank4);
        rankp.add(rank5);
        rankp.add(back);



        back.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                f.remove(rankp);
                f.add(p3);
                f.revalidate();
                f.repaint();
            }
        });

    }
}
