package com.microsoft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    Texture sixTile;
    Texture sevenTile;
    Texture eightTile;
    Texture bombTile;
    Texture flagTile;
    private BitmapFont defaultFont = new BitmapFont();


    int xoffset = 135;
    int yoffset = 180;

    // +10 to any tile means it has been flagged
    // we will know the value of that tile is tile - 10
    public static final int EMPTYTILE = 0, BOMB = -1, EMPTYFLOOR = -2;


    public GameBoard() {
        board = new int[16][30];
        numBombs = 99;
        loadGraphics();
        placeBombs(); // run once
        xoffset = (int) ((MyGdxGame.WORLD_WIDTH - 30 * 25) / 2);
        yoffset = (int) ((MyGdxGame.WORLD_HEIGHT - 16 * 25) / 2) + 25 * 16;
        setNumberOnBoard();
    }


    public GameBoard(int numRows, int numCols, int numBombs) {
        board = new int[numRows][numCols];
        this.numBombs = numBombs;
        loadGraphics();
        placeBombs();
        xoffset = (int) ((MyGdxGame.WORLD_WIDTH - numCols * 25) / 2);
        yoffset = (int) ((MyGdxGame.WORLD_HEIGHT - numRows * 25) / 2) + 25 * numRows;
        if(numBombs > numRows * numCols) {
            numBombs = numRows * numCols;
        }
        setNumberOnBoard();
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    public int getBombsAroundMe(int row, int col) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(isValid(row + i, col + j)) {
                    if (board[row + i][col + j] == BOMB) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public void setNumberOnBoard() {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if (board[row][col] != -1) {
                    board[row][col] = getBombsAroundMe(row, col);
                }
            }
        }
    }


    private int makeSureAllBombsArePlaced() {
        int counter = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) { // double for loop thru board
                if(board[row][col] == BOMB) {
                    counter++; // add bomb to counter
                }
            }
        }
        return counter; // return counter
    }

    private void placeBombs() { // method to place the bombs
        while(makeSureAllBombsArePlaced() != numBombs) { // to run while there are still bombs to place
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) { // casual double for loop
                    boolean isBomb = false; // set a dummy variable to false
                    if (Math.random() > 0.89) { // randomize non frequentely
                        isBomb = true; // set dummy to true
                    }
                    if (isBomb) { // dummy true
                        if (makeSureAllBombsArePlaced() != numBombs) { // double check just in case, if not i error out and crash
                            board[row][col] = BOMB; // set to bomb
                            isBomb = false; // set back even though it will auto do it
                        }
                    }
                }
            }
        }
    }


    public Location getTileAt(int mouseX, int mouseY) {
        int startingX = mouseX - xoffset; // 0
        int startingY = yoffset - mouseY; // 256
        return new Location(startingX/25, ((startingY) / (board.length*25)));
    }

    private void loadGraphics() {
        emptyTile = new Texture("emptyTile.jpg");
        emptyFloorTile = new Texture("empty floor.jpg");
        oneTile = new Texture("oneTile.jpg");
        twoTile = new Texture("twoTile.jpg");
        threeTile = new Texture("threeTile.jpg");
        fourTile = new Texture("fourTile.jpg");
        fiveTile = new Texture("fiveTile.jpg");
        sixTile = new Texture("sixTile.jpg");
        sevenTile = new Texture("sevenTile.jpg");
        eightTile = new Texture("eightTile.jpg");
        bombTile = new Texture("bomb.jpg");
        flagTile = new Texture("flagTile.jpg");
    }

    public void draw(SpriteBatch spriteBatch) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] == EMPTYTILE) {
                    spriteBatch.draw(emptyFloorTile,xoffset+col*25, yoffset+row*-25);
                } else if (board[row][col] == BOMB) {
                    spriteBatch.draw(bombTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 1) {
                    spriteBatch.draw(oneTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 2) {
                    spriteBatch.draw(twoTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 3) {
                    spriteBatch.draw(threeTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 4) {
                    spriteBatch.draw(fourTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 5) {
                    spriteBatch.draw(fiveTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 6) {
                    spriteBatch.draw(sixTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 7) {
                    spriteBatch.draw(sevenTile,xoffset+col*25, yoffset+row*-25);
                }
                else if (board[row][col] == 8) {
                    spriteBatch.draw(eightTile,xoffset+col*25, yoffset+row*-25);
                }
                spriteBatch.draw(emptyTile,xoffset+col*25, yoffset+row*-25);
            }
        }
    }
}
