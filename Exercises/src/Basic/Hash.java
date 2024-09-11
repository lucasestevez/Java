package Basic;

import java.util.*;
import javax.swing.*;
import java.awt.*;


public class Hash {
    static String nameplayer1,nameplayer2;
    static  String[][] plays = new String[3][3];
    static String letterplayeratual = "X";
    static JLabel labelinformations, labelplayer1, labelplayer2, labeltie;
    static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9,randombutton;
    static JFrame window;
    static int winsplayer1 = 0, winsplayer2 = 0, winstie = 0,level;
    static boolean cpu = false;
    static Random random = new Random();
    static Color originalcolorbackground;

    public static void main(String[] args) {

        nameplayer1 = JOptionPane.showInputDialog("Informe o nome do primeiro jogador");

        int answer = JOptionPane.showConfirmDialog(null, "Deseja jogar contra o computador?", "CPU", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            nameplayer2 = "CPU";
            cpu = true;
            Object[] options = {"Fácil","Médio","Difícil"};
            level = JOptionPane.showOptionDialog(null, "Escolha o nível",
                    "Nível",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,
                    options,options[0]);


        }else nameplayer2 = JOptionPane.showInputDialog("Informe o nome do segundo jogador");

        window = new JFrame("###Jogo da Velha###");
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        JPanel principalpanel = new JPanel();
        window.setContentPane(principalpanel);
        principalpanel.setLayout(new BorderLayout());

        JPanel buttonspanel = new JPanel();
        buttonspanel.setLayout(new GridLayout(3,3));
        principalpanel.add(buttonspanel, BorderLayout.CENTER);

        JPanel southpanel = new JPanel();
        southpanel.setLayout(new GridLayout(4,1));
        principalpanel.add(southpanel,BorderLayout.SOUTH);

        labelinformations  = new JLabel();
        southpanel.add(labelinformations);
        labelplayer1  = new JLabel();
        southpanel.add(labelplayer1 );
        labelplayer2  = new JLabel();
        southpanel.add(labelplayer2);
        labeltie = new JLabel();
        southpanel.add(labeltie);

        button1 = new JButton();
        originalcolorbackground = button1.getBackground();
        button1.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button1);
        button1.addActionListener(e -> executionmove(button1, 0,0));
        button2 = new JButton();
        button2.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button2);
        button2.addActionListener(e -> executionmove(button2, 0,1));
        button3 = new JButton();
        button3.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button3);
        button3.addActionListener(e -> executionmove(button3, 0,2));
        button4 = new JButton();
        button4.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button4);
        button4.addActionListener(e -> executionmove(button4, 1,0));
        button5 = new JButton();
        button5.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button5);
        button5.addActionListener(e -> executionmove(button5, 1,1));
        button6 = new JButton();
        button6.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button6);
        button6.addActionListener(e -> executionmove(button6, 1,2));
        button7 = new JButton();
        button7.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button7);
        button7.addActionListener(e -> executionmove(button7, 2,0));
        button8 = new JButton();
        button8.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button8);
        button8.addActionListener(e -> executionmove(button8, 2,1));
        button9 = new JButton();
        button9.setFont(new Font("Arial",Font.PLAIN,80));
        buttonspanel.add(button9);
        button9.addActionListener(e -> executionmove(button9, 2,2));

    }
    public static void executionmove(JButton button , int i, int j){
           //invalid play
         if((plays[i][j]) != null)
               JOptionPane.showMessageDialog(null,"A posição já está ocupada","Jogada Inválida",JOptionPane.ERROR_MESSAGE);
           //valid play
            else {
             //registered play
               button.setText(letterplayeratual);
               plays[i][j] = letterplayeratual;
               scoreboard();
               button.setText("<html><font color="+ (letterplayeratual.equals("X")? "red" : "blue")+
                       ">" + button.getText()+ "</font></html>");
           }
            //verify win
            if (winner()){
                if(letterplayeratual.equals("X"))
                   winsplayer1++;
                else winsplayer2++;
                playagain();
           }else if(tie()){
               winstie++;
                playagain();
           }
           if (letterplayeratual.equals("X")){
               letterplayeratual = "O";
               if(cpu){
                   automaticMove();
               }else {
                   labelinformations.setText("Jogada Atual: " + nameplayer2 + " (X)");
               }
           }else {
               letterplayeratual = "X";
               labelinformations.setText("Jogada Atual: "+nameplayer1+ " (O)");
           }
    }
    private static void automaticMove() {

        if (level == 0) {//level = Easy
            aleatorymove();
        } else if (level == 1) {//level = Medium
            if (onlywin()) { //win
            }else if (onlydefense()) {//defense
        } else
            aleatorymove();
        } else if (level == 2) {
            if (onlywin()) {//win
            } else if (onlydefense()) {//defense
            } else{//strategy play
                strategicmove();
            }
        }
    }
    private static void strategicmove() {
        if(plays[1][1] == null){

            executionmove(button5,1,1);

        }else if(verifyfirstmoveCPU()){
            if (plays[0][0] == null)
                executionmove(button1, 0, 0);
            else if (plays[0][2] == null)
                executionmove(button3, 0, 2);
            else if (plays[2][0] == null)
                executionmove(button7, 2, 0);
            else if (plays[2][2] == null)
                executionmove(button9, 2, 2);

        } else if (verifydefendedcorner()) {
            if (plays[0][1] == null)
                executionmove(button2, 0, 1);
            else if (plays[1][0] == null)
                executionmove(button4, 1, 0);
            else if (plays[1][2] == null)
                executionmove(button6, 1, 2);
            else if (plays[2][1] == null)
                executionmove(button8, 2, 1);
        }else aleatorymove();
    }
    private static boolean verifydefendedcorner() {
       return "O".equals(plays[1][1]) &&(
                "X".equals(plays[0][0]) && "X".equals(plays[2][2]) ||
                "X".equals(plays[0][2]) && "X".equals(plays[2][0])
       );
    }
    private static boolean verifyfirstmoveCPU() {
        int i=0;
        if("X".equals(plays[0][0]))
                    i++;
        if("X".equals(plays[0][1]))
                    i++;
        if("X".equals(plays[0][2]))
                    i++;
        if("X".equals(plays[1][0]))
                    i++;
        if("X".equals(plays[1][1]))
                    i++;
        if("X".equals(plays[1][2]))
                    i++;
        if("X".equals(plays[2][0]))
                    i++;
        if("X".equals(plays[2][1]))
                    i++;
        if("X".equals(plays[2][2]))
                    i++;

        return i<2;
    }
    private static void aleatorymove() {
        int irandom,jrandom;
        do {
            irandom = random.nextInt(3);
            jrandom = random.nextInt(3);
        } while ((plays[irandom][jrandom]) != null);
        randombutton = getButton(irandom, jrandom);
        executionmove(randombutton, irandom, jrandom);
    }
    private static boolean onlydefense() {
        String letterturnplayer = letterplayeratual.equals("X") ? "O" : "X";

        if (moveposicion1(letterturnplayer)) {
            randombutton = getButton(0, 0);
            executionmove(randombutton, 0, 0);
            return true;
        } else if (moveposicion2(letterturnplayer)) {
            randombutton = getButton(0, 1);
            executionmove(randombutton, 0, 1);
            return true;
        } else if (moveposicion3(letterturnplayer)) {
            randombutton = getButton(0, 2);
            executionmove(randombutton, 0, 2);
            return true;
        } else if (moveposicion4(letterturnplayer)) {
            randombutton = getButton(1, 0);
            executionmove(randombutton, 1, 0);
            return true;
        } else if (moveposicion5(letterturnplayer)) {
            randombutton = getButton(1, 1);
            executionmove(randombutton, 1, 1);
            return true;
        } else if (moveposicion6(letterturnplayer)) {
            randombutton = getButton(1, 2);
            executionmove(randombutton, 1, 2);
            return true;
        } else if (moveposicion7(letterturnplayer)) {
            randombutton = getButton(2, 0);
            executionmove(randombutton, 2, 0);
            return true;
        } else if (moveposicion8(letterturnplayer)) {
            randombutton = getButton(2, 1);
            executionmove(randombutton, 2, 1);
            return true;
        } else if (moveposicion9(letterturnplayer)) {
            randombutton = getButton(2, 2);
            executionmove(randombutton, 2, 2);
            return true;
        }
        return false;
    }
    private static boolean onlywin() {
        
        if (moveposicion1(letterplayeratual)) {
            randombutton = getButton(0, 0);
            executionmove(randombutton, 0, 0);
            return true;
        } else if (moveposicion2(letterplayeratual)) {
            randombutton = getButton(0, 1);
            executionmove(randombutton, 0, 1);
            return true;
        } else if (moveposicion3(letterplayeratual)) {
            randombutton = getButton(0, 2);
            executionmove(randombutton, 0, 2);
            return true;
        } else if (moveposicion4(letterplayeratual)) {
            randombutton = getButton(1, 0);
            executionmove(randombutton, 1, 0);
            return true;
        } else if (moveposicion5(letterplayeratual)) {
            randombutton = getButton(1, 1);
            executionmove(randombutton, 1, 1);
            return true;
        } else if (moveposicion6(letterplayeratual)) {
            randombutton = getButton(1, 2);
            executionmove(randombutton, 1, 2);
            return true;
        } else if (moveposicion7(letterplayeratual)) {
            randombutton = getButton(2, 0);
            executionmove(randombutton, 2, 0);
            return true;
        } else if (moveposicion8(letterplayeratual)) {
            randombutton = getButton(2, 1);
            executionmove(randombutton, 2, 1);
            return true;
        } else if (moveposicion9(letterplayeratual)) {
            randombutton = getButton(2, 2);
            executionmove(randombutton, 2, 2);
            return true;
        }
    return false;
    }
    private static boolean moveposicion9(String letterturnplayer) {
        if(plays[2][2] == null)
            if (letterturnplayer.equals(plays[2][0]) && letterturnplayer.equals(plays[2][1]))
                return true;
            else if (letterturnplayer.equals(plays[0][2]) && letterturnplayer.equals(plays[1][2]))
                return true;
            else return letterturnplayer.equals(plays[0][0]) && letterturnplayer.equals(plays[1][1]);
        return false;
    }
    private static boolean moveposicion8(String letterturnplayer) {
        if(plays[2][1] == null)
            if (letterturnplayer.equals(plays[2][0]) && letterturnplayer.equals(plays[2][2]))
                return true;
            else return letterturnplayer.equals(plays[0][1]) && letterturnplayer.equals(plays[1][1]);
        return false;
    }
    private static boolean moveposicion7(String letterturnplayer) {
        if(plays[2][0] == null)
            if (letterturnplayer.equals(plays[2][1]) && letterturnplayer.equals(plays[2][2]))
                return true;
            else if (letterturnplayer.equals(plays[0][0]) && letterturnplayer.equals(plays[1][0]))
                return true;
            else return letterturnplayer.equals(plays[0][2]) && letterturnplayer.equals(plays[1][1]);
        return false;
    }
    private static boolean moveposicion6(String letterturnplayer) {
        if(plays[1][2] == null)
            if (letterturnplayer.equals(plays[1][0]) && letterturnplayer.equals(plays[1][1]))
                return true;
            else return letterturnplayer.equals(plays[0][2]) && letterturnplayer.equals(plays[2][2]);
        return false;
    }
    private static boolean moveposicion5(String letterturnplayer) {
        if(plays[1][1] == null)
            if (letterturnplayer.equals(plays[1][0]) && letterturnplayer.equals(plays[1][2]))
                return true;
            else if (letterturnplayer.equals(plays[0][1]) && letterturnplayer.equals(plays[2][1]))
                return true;
            else if (letterturnplayer.equals(plays[0][0]) && letterturnplayer.equals(plays[2][2]))
                return true;
            else return letterturnplayer.equals(plays[0][2]) && letterturnplayer.equals(plays[2][0]);
        return false;
    }
    private static boolean moveposicion4(String letterturnplayer) {
        if(plays[1][0] == null)
            if (letterturnplayer.equals(plays[1][1]) && letterturnplayer.equals(plays[1][2]))
                return true;
            else return letterturnplayer.equals(plays[0][0]) && letterturnplayer.equals(plays[2][0]);
        return false;
    }
    private static boolean moveposicion3(String letterturnplayer) {
        if(plays[0][2] == null)
            if (letterturnplayer.equals(plays[0][0]) && letterturnplayer.equals(plays[0][1]))
                return true;
            else if (letterturnplayer.equals(plays[1][2]) && letterturnplayer.equals(plays[2][2]))
                return true;
            else return letterturnplayer.equals(plays[1][1]) && letterturnplayer.equals(plays[2][0]);
        return false;
    }
    private static boolean moveposicion2(String letterturnplayer) {
        if (plays [0][1] == null)
            if (letterturnplayer.equals(plays[0][0]) && letterturnplayer.equals(plays[0][2]))
                return true;
            else return letterturnplayer.equals(plays[1][1]) && letterturnplayer.equals(plays[2][1]);
        return false;
    }
    private static boolean moveposicion1(String letterturnplayer) {
        if (plays[0][0] == null)
            if (letterturnplayer.equals(plays[0][1]) && letterturnplayer.equals(plays[0][2]))
                return true;
            else if (letterturnplayer.equals(plays[1][0]) && letterturnplayer.equals(plays[2][0]))
                return true;
            else return letterturnplayer.equals(plays[1][1]) && letterturnplayer.equals(plays[2][2]);

        return false;
    }
    private static JButton getButton(int irandom, int jrandom) {
        JButton randombutton = null;
        if(irandom == 0 && jrandom == 0)
            randombutton = button1;
        if(irandom == 0 && jrandom == 1)
            randombutton = button2;
        if(irandom == 0 && jrandom == 2)
            randombutton = button3;
        if(irandom == 1 && jrandom == 0)
            randombutton = button4;
        if(irandom == 1 && jrandom == 1)
            randombutton = button5;
        if(irandom == 1 && jrandom == 2)
            randombutton = button6;
        if(irandom == 2 && jrandom == 0)
            randombutton = button7;
        if(irandom == 2 && jrandom == 1)
            randombutton = button8;
        if(irandom == 2 && jrandom == 2)
            randombutton = button9;
        return randombutton;
    }
    public static void playagain() {
        scoreboard();
        int answer = JOptionPane.showConfirmDialog(null,"Quer jogar novamente?",
                "De Novo", JOptionPane.YES_NO_OPTION);
        if(answer == JOptionPane.YES_OPTION){

            resetgame();

        }else {

            window.setVisible(false);
            System.exit(0);
        }
    }
    private static void resetgame() {
        plays = new String[3][3];
        button1.setText("");
        button1.setBackground(originalcolorbackground);
        button2.setText("");
        button2.setBackground(originalcolorbackground);
        button3.setText("");
        button3.setBackground(originalcolorbackground);
        button4.setText("");
        button4.setBackground(originalcolorbackground);
        button5.setText("");
        button5.setBackground(originalcolorbackground);
        button6.setText("");
        button6.setBackground(originalcolorbackground);
        button7.setText("");
        button7.setBackground(originalcolorbackground);
        button8.setText("");
        button8.setBackground(originalcolorbackground);
        button9.setText("");
        button9.setBackground(originalcolorbackground);
        letterplayeratual = letterplayeratual.equals("X") ? ("O") : ("X");
        labelinformations = new JLabel("Próximo Jogador: "+
                (letterplayeratual.equals("X") ? nameplayer1 :
                        nameplayer2)+ " ("+ letterplayeratual +")");

    }
    private static void scoreboard() {
        labelplayer1.setText(nameplayer1+": "+winsplayer1);
        labelplayer2.setText(nameplayer2+": "+winsplayer2);
        labeltie.setText("Velha: "+ winstie);
    }
    public static boolean tie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                if(plays[i][j] == null)
                    return false;
            }
        }
                    return true;
    }
    public static boolean winner() {
        if((letterplayeratual.equals(plays[0][0])&&
                letterplayeratual.equals(plays[0][1])&&
                letterplayeratual.equals(plays[0][2]))){

            button1.setBackground(Color.GREEN);
            button2.setBackground(Color.GREEN);
            button3.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[1][0])&&
                letterplayeratual.equals(plays[1][1])&&
                letterplayeratual.equals(plays[1][2]))) {

            button4.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button6.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[2][0])&&
                letterplayeratual.equals(plays[2][1])&&
                letterplayeratual.equals(plays[2][2]))){

            button7.setBackground(Color.GREEN);
            button8.setBackground(Color.GREEN);
            button9.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[0][0])&&
                letterplayeratual.equals(plays[1][0])&&
                letterplayeratual.equals(plays[2][0]))){

            button1.setBackground(Color.GREEN);
            button4.setBackground(Color.GREEN);
            button7.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[0][1])&&
                letterplayeratual.equals(plays[1][1])&&
                letterplayeratual.equals(plays[2][1]))){

            button2.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button8.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[0][2])&&
                letterplayeratual.equals(plays[1][2])&&
                letterplayeratual.equals(plays[2][2]))){

            button3.setBackground(Color.GREEN);
            button6.setBackground(Color.GREEN);
            button9.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[0][0])&&
                letterplayeratual.equals(plays[1][1])&&
                letterplayeratual.equals(plays[2][2]))){

            button1.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button9.setBackground(Color.GREEN);
            return true;
        }

        if((letterplayeratual.equals(plays[0][2])&&
                letterplayeratual.equals(plays[1][1])&&
                letterplayeratual.equals(plays[2][0]))){

            button3.setBackground(Color.GREEN);
            button5.setBackground(Color.GREEN);
            button7.setBackground(Color.GREEN);
            return true;
        }
            return false;
    }
}

