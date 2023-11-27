package gui;

import gameLogic.GameController;
import gameObjects.Block;
import gameObjects.Board;
import input.ConsoleInput;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input {

    private PictureManager pictureManager;
    private Board board;
    private Block[][] blockArray;


    public Input(PictureManager pictureManager, Board board) {
        this.pictureManager = pictureManager;
        this.board = board;
        //this.blockArray = board.getBlockArray();

        // Access the list of clickable pictures
        for (JLabel label : pictureManager.getClickablePictures()) {
            // Add a MouseListener to each clickable picture
            label.addMouseListener(new CustomMouseListener());
        }
    }

    private class CustomMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                JLabel source = (JLabel) e.getSource();
                String imageName = getImageNameFromLabel(source);

                int x = source.getX() / 16;
                int y = source.getY() / 16;
                System.out.println("x: " + x + ", y: " + y);
                System.out.println(source);
                pictureManager.update(source, x, y);
                //source.setIcon(pictureManager.createImageIcon("/assets/blank1.png"));
                //JOptionPane.showMessageDialog(null, "Picture clicked: " + imageName);

            } else if (e.getButton() == MouseEvent.BUTTON3) {

            }


        }

        private String getImageNameFromLabel(JLabel label) {
            // Extract the image name from the label's icon description
            return label.getIcon().toString();
        }
    }

}
