package map;
import javax.swing.*;

public class map1 {
    protected JButton[][] buttons;
    public map1(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        
        int row = 3 ;
        int column = 7;
        buttons = new JButton[row][column];
        for(int i = 0 ;i < row ;i++){
            for(int j = 0 ;j < column ;j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setBounds(100+j*170, 100+i*170, 170, 170);
                frame.add(buttons[i][j]);
            }
        }
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
