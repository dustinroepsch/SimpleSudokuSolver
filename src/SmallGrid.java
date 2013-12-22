import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dustin on 12/21/13.
 */
public class SmallGrid extends JPanel {
    private JTextField[][] grid;


    public SmallGrid(){
        super();
        grid = new JTextField[3][3];
        this.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                JTextField field = new JTextField();
                field.setFont(new Font("Font",Font.BOLD,70));
                grid[i][j] = field;
                add(field);
            }
        }
    }
    public JTextField[][] getGrid(){
        return grid;
    }
}
