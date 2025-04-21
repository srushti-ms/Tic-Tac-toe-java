
import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame{
    boolean isXturn = true;
    JButton[][] button = new JButton[3][3];
    public TicTacToe(){
        setTitle("tic - tac - toe");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));

        initialiseButtons();

        JButton reset = new JButton("reset");

        setVisible(true);
    }

    private void initialiseButtons(){

        

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j] = new JButton();
                button[i][j].setFont(new Font("Arial",Font.BOLD,60));
                add(button[i][j]);

                int row =i;
                int col = j;
                button[row][col].addActionListener(e -> {
                    if(button[row][col].getText().equals("")){
                        button[row][col].setText(isXturn? "X":"O");
                        button[row][col].setEnabled(false);
                        isXturn = !isXturn;
                        checkWinner();
                    }
                });
            }
        }
    }

    private void checkWinner(){
        for(int i =0;i<3;i++){
            if(!button[i][0].getText().equals("") && 
            button[i][0].getText().equals(button[i][1].getText()) &&
            button[i][1].getText().equals(button[i][2].getText())){
                showWinner(button[i][0].getText());
                return;
            }

            if(!button[0][i].getText().equals("") && 
            button[0][i].getText().equals(button[1][i].getText()) &&
            button[1][i].getText().equals(button[2][i].getText())){
                showWinner(button[0][i].getText());
                return;
            }
        }

        if(!button[0][0].getText().equals("")&&
        button[0][0].getText().equals(button[1][1].getText()) &&
        button[1][1].getText().equals(button[2][2].getText())){
            showWinner(button[0][0].getText());
            return;
        }

        if(!button[0][2].getText().equals("") &&
        button[0][2].getText().equals(button[1][1].getText()) &&
        button[1][1].getText().equals(button[2][0].getText())){
            showWinner(button[0][2].getText());
            return;
        }

        boolean isDraw = true;

        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                if(button[i][j].getText().equals("")){
                    isDraw = false;
                    break;
                }
            }
        }

        if(isDraw){
            JOptionPane.showMessageDialog(this, "Mannnn, its a draw, try again :) ");
            resetBoard();
            return;
        }

    }

    private void showWinner(String winner){
        JOptionPane.showMessageDialog(this, "Player " + winner + " wins :)");
        resetBoard();
    }


    private void resetBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setText("");
                button[i][j].setEnabled(true);
            }
        }
    }



    public static void main(String[] args){
        new TicTacToe();
    }

}


