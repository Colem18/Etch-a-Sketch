package etch.a.sketch;

import java.awt.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SketchBoard extends JPanel implements KeyListener, ActionListener {

    Cursor cursor;
    private Timer timer;
    boolean buttonPressed = false;

    public SketchBoard() {
        cursor = new Cursor();
        this.setFocusable(true);
        this.requestFocusInWindow();
        addKeyListener(this);
    }

    public void Start() {
        timer = new Timer(25, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (buttonPressed == true) {
            try {
                cursor.move1();
            } catch (InterruptedException ex) {
                Logger.getLogger(SketchBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cursor.getxpos() < 0) {
            cursor.setxpos(0);
        }
        if (cursor.getxpos() > this.size().width - 10) {
            cursor.setxpos(this.size().width - 10);
        }
        if (cursor.getypos() < 0) {
            cursor.setypos(0);
        }
        if (cursor.getypos() > this.size().height - 10) {
            cursor.setypos(this.size().height - 10);
        }
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(cursor.getxpos(), cursor.getypos(), 5, 5);
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == VK_LEFT) {
            buttonPressed = true;
            cursor.setDirection(1);
        } else if (ke.getKeyCode() == VK_UP) {
            buttonPressed = true;
            cursor.setDirection(2);
        } else if (ke.getKeyCode() == VK_RIGHT) {
            buttonPressed = true;
            cursor.setDirection(3);
        } else if (ke.getKeyCode() == VK_DOWN) {
            buttonPressed = true;
            cursor.setDirection(4);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        buttonPressed = false;
    }
}
