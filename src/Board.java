import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dustin on 12/21/13.
 */
public class Board {
    private Box[][] board;
    public Board(SmallGrid[][] grids){
         board = new Box[9][9];
        for (int sgRow = 0; sgRow < 3; sgRow++){
            for (int sgCol = 0; sgCol <3; sgCol++){
                SmallGrid temp = grids[sgRow][sgCol];

                for (int i = 0; i < 3; i++){
                    for (int j = 0; j <3; j++){
                        JTextField textBox = temp.getGrid()[i][j];
                        textBox.setText("");
                        textBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                solve();
                            }
                        });
                        board[i + sgRow*3][j + sgCol*3] = new Box(textBox,i + sgRow*3,j + sgCol*3);
                    }
                }
            }
        }

    }


    public boolean solve() {

        Box box = getNext();
        if (box == null){
            return true;
        }

        for (int i = 1; i <= 9; i++){
            if(isPossible(box.getRow(), box.getCol(), i)){
                box.setText(String.valueOf(i));
                if (solve()){
                    return true;
                }
                else{
                    box.setText("");
                }
            }
        }
        return false;
    }

    private boolean isPossible(int row, int col, int num) {
        boolean possible = true;
        for (int i = 0; i < 9 && possible ; i++){
            possible = (board[row][i].getText().equals("")  || !(Integer.valueOf(board[row][i].getText()) == num));
            if (possible){
                possible = board[i][col].getText().equals("") ||!(Integer.valueOf(board[i][col].getText()) == num);
            }
        }
        int rowMult = getMult(row);
        int colMult = getMult(col);

        for (int i = 0; i < 3 && possible; i++){
            for (int j = 0; j < 3 && possible; j++){
                possible =  board[i + rowMult*3][j + colMult*3].getText().equals("") ||!(Integer.valueOf(board[i + rowMult*3][j + colMult*3].getText()) == num);
            }
        }
        return possible;
    }

    private int getMult(int i) {
        if (i < 3){
            return 0;
        }
        if (i < 6){
            return 1;
        }
        return 2;
    }

    private Box getNext(){
        Box box = null;
        for (int i = 0; i < 9 && box == null; i++){
            for (int j = 0; j < 9 && box == null; j++){
                if (board[i][j].getText().equals("")){
                    box = board[i][j];

                }
            }
        }
        return box;
    }
}
