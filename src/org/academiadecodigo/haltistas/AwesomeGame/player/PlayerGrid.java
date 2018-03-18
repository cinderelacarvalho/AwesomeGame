package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerGrid {

    private static final int CELLSIZE = 10;
    private static final int PADDING = 10;
    private final int ROWS = 100;
    private final int COLS = 60;

    private Snake snake;
    private PlayerPosition[][] positions;
    private int initialWidth = 0;
    private int initialHeight = 0;

    public void init() {
        Rectangle rectangle = new Rectangle(PADDING, PADDING, ROWS * CELLSIZE, COLS * CELLSIZE);
        rectangle.draw();
        positions = new PlayerPosition[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                positions[i][j] = new PlayerPosition(initialWidth, initialHeight);

                initialHeight += 1;

            }
            initialHeight = 0;
            initialWidth += 1;
        }
        start();


    }

    public void start() {
        fillWall();
        snake = new Snake("S1", this, positions[20][30], positions[20][31], positions[20][32]);
        //  snake = new Snake("S2", this, positions[80][30], positions[80][31], positions[80][32]);
        greenApple(44, 7);
        redApple(3, 3);

        try {
            Thread.sleep(30000);
            deleteWall();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public PlayerPosition getPos(int row, int col) {
        return positions[row][col];
    }

    public void delete(int row, int col) {
        positions[row][col].deletePos();
    }

    public void increaseSnake(int rowP1, int colP1) {
        snake.increaseSnake(positions[rowP1][colP1]);
    }

    public void greenApple(int row, int col) {
        positions[row][col].paintGreenApple();

    }

    public void redApple(int row, int col) {
        positions[row][col].paintRedApple();
    }

    public void fillWall() {
        int i = 0;
        while (i < COLS) {

            positions[49][i].paintPos();
            positions[50][i].paintPos();
            i++;

        }
    }

    public void deleteWall() {
        int i = 0;
        while (i < COLS) {

            positions[49][i].deletePos();
            positions[50][i].deletePos();
            i++;

        }
    }
}


