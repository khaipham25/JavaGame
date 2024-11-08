package btlgame;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int GameWidth = 768;
        int GameHeight = 864;

        JFrame frame = new JFrame("Cat Mario");
         frame.setVisible(true);
		frame.setSize(GameWidth, GameHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CatMario cm = new CatMario();
        frame.add(cm);
        frame.pack();
        cm.requestFocus();
        frame.setVisible(true);
    }
}
