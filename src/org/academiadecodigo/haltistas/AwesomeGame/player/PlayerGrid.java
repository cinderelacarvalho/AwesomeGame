package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Arrays;


public class PlayerGrid {

    private Picture background;
    private final int CELL_SIZE = 10;
    private final int PADDING = 10;
    private final int ROWS = 60;
    private final int COLS = 100;
    private final int wallPos1 = 49;
    private final int wallPos2 = 50;

    private PlayerPosition[][] positions;

    private ArrayList<Snake> snakeList;

    public void init() {
        background = new Picture(0, 0, "resources/sand.jpg");
        background.draw();
        new Rectangle(PADDING, PADDING, COLS * CELL_SIZE, ROWS * CELL_SIZE).draw();


        positions = new PlayerPosition[COLS][ROWS];
        int initialColSnake1 = 24;
        int initialColSnake2 = 75;
        int initialRowSnakes = 30;

        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS; row++) {
                positions[col][row] = new PlayerPosition(col, row, CELL_SIZE, PADDING);
            }
        }
        snakeList = new ArrayList<>();
        Snake snake1 = new Snake(this, positions[initialColSnake1][initialRowSnakes], positions[initialColSnake1][initialRowSnakes + 1],
                positions[initialColSnake1][initialRowSnakes + 2], Color.BLUE);
        snakeList.add(snake1);
        Snake snake2 = new Snake(this, positions[initialColSnake2][initialRowSnakes], positions[initialColSnake2][initialRowSnakes + 1],
                positions[initialColSnake2][initialRowSnakes + 2], Color.PINK);
        snakeList.add(snake2);
    }

    public void start() {

        fillWall();

    }

    public PlayerPosition getPos(int col, int row) {
        return positions[col][row];
    }

    public void move(int snake, String dir) {

        switch (dir) {
            case "r":
                snakeList.get(snake).moveRight();
                break;
            case "l":
                snakeList.get(snake).moveLeft();
                break;
            case "u":
                snakeList.get(snake).moveUp();
                break;
            case "d":
                snakeList.get(snake).moveDown();
                break;
            default:
                System.out.println("shit");
        }

    }

    public void deleteSnake(int snake) {
        snakeList.get(snake).removePos();
    }

    public void greenApple(int row, int col) {
        positions[col][row].paintGreenApple();
    }

    public void deleteApple(int row, int col) {
        System.out.println(positions[col][row]);
        positions[col][row].deleteAp();
    }

    public void redApple(int row, int col) {
        positions[col][row].paintRedApple();
    }

    private void fillWall() {
        int i = 0;
        while (i < ROWS) {

            positions[wallPos1][i].paintPos(Color.GRAY);
            positions[wallPos2][i].paintPos(Color.GRAY);
            i++;

        }
    }

    public void deleteWall() {
        int i = 0;

        while (i < ROWS) {
            positions[wallPos1][i].deletePos();
            positions[wallPos2][i].deletePos();
            i++;

        }
    }

    public void gameOver(String player) {

        Picture pictureGameOver = new Picture(PADDING, PADDING, "resources/Game_Over.jpg");
        pictureGameOver.draw();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (player) {
            case "1":
                Picture picturePlayer2 = new Picture(PADDING, PADDING, "resources/player_2_wins.jpg");
                picturePlayer2.draw();
                break;
            case "2":
                Picture picturePlayer1 = new Picture(PADDING, PADDING, "resources/player_1_wins.jpg");
                picturePlayer1.draw();
                break;
        }

        init();
    }


    @Override
    public String toString() {
        return "PlayerGrid{" +
                "positions=" + Arrays.toString(positions) +
                ", snakeList=" + snakeList +
                '}';
    }

    public void shrink() {

        int cols = positions.length;
        int rows = positions[0].length;


        PlayerPosition[][] newPositions = new PlayerPosition[cols - 1][rows - 1];

        for (int i = 0; i < cols - 1; i++) {
            for (int j = 0; j < rows - 1; j++) {

                newPositions[i][j] = positions[i][j];
            }
        }

        int resize = 5;

        positions = newPositions;
        background.translate(resize, resize);
        background.grow(-resize, -resize);

    }
}



