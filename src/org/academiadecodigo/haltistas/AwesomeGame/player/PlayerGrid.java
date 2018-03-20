package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;


public class PlayerGrid {

    private final int CELL_SIZE = 10;
    private final int PADDING = 10;
    private final int ROWS = 100;
    private final int COLS = 60;
    private final int wallPos1 = 49;
    private final int wallPos2 = 50;

    private PlayerPosition[][] positions;
    private int initialWidth = 0;
    private int initialHeight = 0;
    private ArrayList<Snake> snakeList;

    public void init() {
        new Picture(0, 0, "resources/sand.jpg").draw();
        new Rectangle(PADDING, PADDING, ROWS * CELL_SIZE, COLS * CELL_SIZE).draw();


        positions = new PlayerPosition[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                positions[i][j] = new PlayerPosition(initialWidth, initialHeight, CELL_SIZE, PADDING);

                initialHeight += 1;

            }
            initialHeight = 0;
            initialWidth += 1;
        }
        snakeList = new ArrayList<>();
        Snake snake1 = new Snake(this, positions[20][30], positions[20][31],
                positions[20][32], Color.BLUE);
        snakeList.add(snake1);
        Snake snake2 = new Snake(this, positions[80][30], positions[80][31],
                positions[80][32], Color.PINK);
        snakeList.add(snake2);
    }

    public void start() {
        fillWall();

    }

    public PlayerPosition getPos(int row, int col) {
        return positions[row][col];
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
        positions[row][col].paintGreenApple();
    }

    public void deleteApple(int row, int col) {
        positions[row][col].deleteAp();
    }

    public void redApple(int row, int col) {
        positions[row][col].paintRedApple();
    }

    private void fillWall() {
        int i = 0;
        while (i < COLS) {

            positions[wallPos1][i].paintPos(Color.GRAY);
            positions[wallPos2][i].paintPos(Color.GRAY);
            i++;

        }
    }

    public void deleteWall() {
        int i = 0;

        while (i < COLS) {
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
            case "p1":
                Picture picturePlayer2 = new Picture(PADDING, PADDING, "resources/player_2_wins.jpg");
                picturePlayer2.draw();
                break;
            case "p2":
                Picture picturePlayer1 = new Picture(PADDING, PADDING, "resources/player_1_wins.jpg");
                picturePlayer1.draw();
                break;
        }
    }
}



