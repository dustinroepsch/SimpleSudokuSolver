import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Dustin on 12/21/13.
 */
public class Sudoku extends JApplet{
    private Board board;

    @Override
    public void init(){
        try {
            SwingUtilities.invokeAndWait(new Runnable(){
                @Override
                public void run() {
                    createGui();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void createGui() {
        SmallGrid[][] superGrid = new SmallGrid[3][3];
        setLayout(new GridLayout(3, 3, 5, 5));
        setBackground(Color.BLACK);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                SmallGrid temp = new SmallGrid();
                add(temp);
                superGrid[i][j] = temp;
            }
        }
        board = new Board(superGrid);

    }

}
