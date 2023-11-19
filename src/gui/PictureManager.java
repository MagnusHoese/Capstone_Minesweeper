package gui;

import gameObjects.Block;
import gameObjects.Board;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PictureManager {

    private String blockPath = "/assets/block.png";
    private String blank0Path = "/assets/blank0.png";
    private String blank1Path = "/assets/blank1.png";
    private String blank2Path = "/assets/blank2.png";
    private String blank3Path = "/assets/blank3.png";
    private String blank4Path = "/assets/blank4.png";
    private String blank5Path = "/assets/blank5.png";
    private String blank6Path = "/assets/blank6.png";
    private String blank7Path = "/assets/blank7.png";
    private String blank8Path = "/assets/blank8.png";
    private String bombPath = "/assets/bomb.png";

    private Board board;
    private Block[][] blockArray;

    private List<JLabel> clickablePictures = new ArrayList<>();

    public PictureManager(Board board) {

        this.board = board;
        this.blockArray = board.getBlockArray();;

        for(int y = 0; y < 8; y++){
            for (int x = 0; x < 8; x++){
                addBlank(blockPath, x*16, y*16);
            }
        }
    }


    public void addBlank(String imageName, int x, int y) {

        ImageIcon icon = createImageIcon(imageName);

        if (icon != null) {
            JLabel label = new JLabel(icon);
            label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());


            clickablePictures.add(label);
        } else {
            // Handle image loading failure
            System.err.println("Couldn't find file: " + blockPath);
        }
    }

    private ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            // Handle image loading failure
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public List<JLabel> getClickablePictures() {
        return clickablePictures;
    }

    public void changeIcon(JLabel source, int x, int y) {
        Block current = board.getBlockObject(x, y);
        int surroundingBombs = current.getSurroundingBombs();
        String path;

        if(!current.getBombStatus()) {
            String[] paths = {
                    blank0Path, blank1Path, blank2Path, blank3Path,
                    blank4Path, blank5Path, blank6Path, blank7Path, blank8Path
            };

            // Use the surroundingBombs value as an index to get the path
            int index = Math.min(surroundingBombs, paths.length - 1);
            path = paths[index];

            ImageIcon icon = createImageIcon(path);
            source.setIcon(icon);
        } else {
            //If the block is a bomb
            path = bombPath;
            ImageIcon icon = createImageIcon(path);
            source.setIcon(icon);

            changeAllIcons(source);

        }

    }

    public void changeAllIcons(JLabel source) { //TODO skal nok kaldes gameLost eller lignende
        Block[][] blockArray = board.getBlockArray();
        String path;



        for (int y = 0; y < board.getBoardHeight(); y++) {
            for (int x = 0; x < board.getBoardWidth(); x++) {

                if (!blockArray[x][y].getBombStatus()) {
                    String[] paths = {
                            blank0Path, blank1Path, blank2Path, blank3Path,
                            blank4Path, blank5Path, blank6Path, blank7Path, blank8Path
                    };
                    int surroundingBombs = blockArray[x][y].getSurroundingBombs();
                    // Use the surroundingBombs value as an index to get the path
                    int index = Math.min(surroundingBombs, paths.length - 1);
                    path = paths[index];

                } else {
                    //If the block is a bomb
                    path = bombPath;
                }
                ImageIcon icon = createImageIcon(path);
                source.setIcon(icon);
            }
        }

    }
}

