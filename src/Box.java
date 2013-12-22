import javax.swing.*;

/**
 * Created by Dustin on 12/21/13.
 */
public class Box {
    private JTextField field;
    private int row;
    private int col;
    public Box(JTextField f, int r, int c){
        field = f;
        row = r;
        col = c;
    }
    public JTextField getField(){
        return field;
    }
    public String getText(){
        return field.getText();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setText(String text) {
        field.setText(text);
    }
    @Override
    public String toString(){
        return ("Row: " + row + " Col:" + col);
    }
}
