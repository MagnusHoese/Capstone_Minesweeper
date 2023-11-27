package gui;

import gameObjects.Board;

import javax.swing.*;

public class TestMain {

    public static void main(String[] args) {

        /*SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });

         */

        Board board = new Board(8, 8, 10);

        PictureManager pictureManager = new PictureManager(board);
        Input input = new Input(pictureManager, board);

        // For example, you might add the clickablePictures JLabels to a JFrame
        JFrame frame = new JFrame("Minesweeper");
        frame.getContentPane().setLayout(null);

        for (JLabel label : pictureManager.getClickablePictures()) {
            frame.add(label);
        }


        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
