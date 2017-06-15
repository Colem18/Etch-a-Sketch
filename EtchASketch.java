package etch.a.sketch;

import javax.swing.JFrame;

public class EtchASketch {

    public static void main(String[] args) {
        jframe j = new jframe();
        j.setSize(950, 950);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SketchBoard board = new SketchBoard();
        board.setVisible(true);
        board.setLocation(0, 0);
        j.add(board);
        board.Start();
    }

}
