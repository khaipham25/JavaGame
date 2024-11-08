package btlgame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class CatMario extends JPanel implements ActionListener,KeyListener{
    int GameWidth = 600;
    int GameHeight = 750;
    
    private boolean GameStarted= false;
    Random random = new Random();
    Image bgImg,BatDauImg; Image nhanvatImg; Image ongImg; Image gaiImg; Image gachImg, sanImg;
    Image namImg;
    Timer gameLoop;
    class NhanVat {
        int x = 45;
        int y = 511;
        int width = 30;
        int height = 40;
        Image img;

        NhanVat(Image img) {
            this.img = img;
        }
    }
    NhanVat nhanvat;
    class Ong {
        int x = random.nextInt(GameWidth)+20;
        int y = random.nextInt(GameHeight);
        int width = 25;
        int height = 35;
        Image img;
        boolean passed = false;

        Ong(Image img) {
            this.img = img;
        }
    }
    Ong ong;
    class Nam {
        int x = random.nextInt(GameWidth)+20;
        int y = random.nextInt(GameHeight);
        int width = 25;
        int height = 35;
        Image img;
        boolean passed = false;

        Nam(Image img) {
            this.img = img;
        }
    }
    Nam nam;
    class Gach {
        int x = random.nextInt(GameWidth)+20;//tuy bien
        int y = random.nextInt(GameHeight);
        int width = 25;
        int height = 30;
        Image img;
        boolean passed = false;

        Gach(Image img) {
            this.img = img;
        }
    }
    Gach gach;
    class Gai {
        int x = random.nextInt(GameWidth)+20;
        int y = random.nextInt(GameHeight);
        int width = 25;
        int height = 30;
        Image img;
        boolean passed = false;

        Gai(Image img) {
            this.img = img;
        }
    }
    Gai gai;

    CatMario() {
        setPreferredSize(new Dimension(GameWidth, GameHeight));
        // setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        //load images
        BatDauImg = new ImageIcon(getClass().getResource("/btlgame/IMG/batDau.png")).getImage();
        bgImg = new ImageIcon(getClass().getResource("/btlgame/IMG/bg.png")).getImage();
        nhanvatImg = new ImageIcon(getClass().getResource("/btlgame/IMG/nv20.png")).getImage();
        ongImg = new ImageIcon(getClass().getResource("/btlgame/IMG/ong.jpg")).getImage();
        gaiImg = new ImageIcon(getClass().getResource("/btlgame/IMG/gai.png")).getImage();
        gachImg = new ImageIcon(getClass().getResource("/btlgame/IMG/gach.png")).getImage();
        namImg = new ImageIcon(getClass().getResource("/btlgame/IMG/nam.png")).getImage();
        sanImg = new ImageIcon(getClass().getResource("/btlgame/IMG/san.png")).getImage();

        nhanvat = new NhanVat(nhanvatImg);
        gameLoop = new Timer(1000 / 60, this); // Cập nhật 60 lần mỗi giây
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	if(!GameStarted){
            drawStartedScreen(g);
        }else {
            draw(g);
        }
    }
    public void drawStartedScreen(Graphics g){
        g.drawImage(BatDauImg, 0, 0, this.GameWidth, this.GameHeight, null);
    }
    public void draw(Graphics g) {
        //background
       // g.drawImage(BatDauImg, 0, 0, this.GameWidth, this.GameHeight, null);
        g.drawImage(bgImg, 0, 0, this.GameWidth, this.GameHeight, null);
        g.drawImage(nhanvatImg, nhanvat.x, nhanvat.y, nhanvat.width, nhanvat.height, null);
        g.drawImage(sanImg, 0, 550,Integer.MAX_VALUE, 200, null);

        //pipes
//        for (int i = 0; i < pipes.size(); i++) {
//            Pipe pipe = pipes.get(i);
//            g.drawImage(pipe.img, Ong.x, pipe.y, pipe.width, pipe.height, null);
//        }

        //score
        g.setColor(Color.white);

//        g.setFont(new Font("Arial", Font.PLAIN, 32));
//        if (gameOver) {
//            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
//        }
//        else {
//            g.drawString(String.valueOf((int) score), 10, 35);
//        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        //repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!GameStarted){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){//su kien man hinh bat dau
                GameStarted= true;
                repaint();
            }
        }else {
            //xu ly su kien khi tro choi bat dau
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
