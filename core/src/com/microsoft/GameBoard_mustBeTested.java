package com.microsoft;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameBoard {
    // 16x30
    // 99 bombs

    int[][] board;
    int numBombs;
    Texture emptyTile;
    Texture emptyFloorTile;
    Texture oneTile;
    Texture twoTile;
    Texture threeTile;
    Texture fourTile;
    Texture fiveTile;
    Texture sevenTile;
    Texture eightTile;
    Texture bombTile;
    Texture flagTile;

    int xoffset = 135;
    int yoffset = 180;

    // +10 to any tile means it has been flagged
    // we will know the value of that tile is tile - 10
    public static final int EMPTYTILE = 0, BOMB = -1, EMPTYFLOOR = -2;


    public GameBoard() {
        board = new int[16][30];
        numBombs = 99;
        loadGraphics();
    }



    private boolean makeSureAllBombsArePlaced() { 
        int counter = 0; 
        for(int row = 0; row < board.length; row++) {
                for(int col = 0; col < board[row].length; col++) {
                    if(board[row][col] == -1) { 
                        counter++;
                        
                    }
                }
            }
        if(counter == numBombs) { 
            return true; 
        }
        return false; 
    }

    // randomly place bombs onto the board
    private void placeBombs() {
        boolean isBomb = false; 
        int tempBomb = numBombs; 
        if(Math.random() > 0.49) {
            isBomb = true; 
        }
        while(makeSureAllBombsArePlaces != true) {  // method to make sure al lbombs that need to be places are placed
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(isBomb) { 
                    if(tempBomb != 0) { 
                        board[row][col] = -1;
                        tempBomb--;
                    }
                }
            }
        } // end double for loop, if the random choice flips the thing to true, then place a bomb in the 2d array
        }
    }

    //draw the bombs so we can see them

    public GameBoard(int numRows, int numCols, int numBombs) {
        board = new int[numRows][numCols];
        this.numBombs = numBombs;
        loadGraphics();
    }

    private void loadGraphics() {
        emptyTile = new Texture("emptyTile.jpg");
        emptyFloorTile = new Texture("empty floor.jpg");
        oneTile = new Texture("oneTile.jpg");
        twoTile = new Texture("twoTile.jpg");
        threeTile = new Texture("threeTile.jpg");
        fourTile = new Texture("fourTile.jpg");
        fiveTile = new Texture("fiveTile.jpg");
        sevenTile = new Texture("sevenTile.jpg");
        eightTile = new Texture("eightTile.jpg");
        bombTile = new Texture("bomb.jpg");
        flagTile = new Texture("flagTile.jpg");
    }

    public void draw(SpriteBatch spriteBatch) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                spriteBatch.draw(emptyTile,xoffset+col*25, yoffset+row*25);
                if(board[row][col] == -1) {
                    spriteBatch.draw(bombTile,xoffset+col*25, yoffset+row*25);
                }
            }
        }
    }
}
