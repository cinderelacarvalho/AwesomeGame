package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerGrid {

    private final int CELLSIZE = 10;
    private final int PADDING = 10;
    private final int ROWS = 100;
    private final int COLS = 60;

    private Snake snake;
    private PlayerPosition[][] positions;
    private int initialWidth = 1;
    private int initialHeight = 1;

    public void init() {
        Rectangle rectangle = new Rectangle(PADDING, PADDING, ROWS * CELLSIZE, COLS * CELLSIZE);
        rectangle.draw();
        snake = new Snake();

        positions = new PlayerPosition[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                positions[i][j] = new PlayerPosition(initialWidth, initialHeight);

                initialHeight += 1;

            }
            initialHeight = 1;
            initialWidth += 1;
        }
        start();


    }

    public void start() {
        fillWall();
        drawInitialSnake1(20, 30);
        drawInitialSnake1(20, 31);
        drawInitialSnake1(20, 32);
        drawInitialSnake2(80, 30);
        drawInitialSnake2(80, 31);
        drawInitialSnake2(80, 32);
        greenApple(44,7);
        redApple(3,3);

        try {
            Thread.sleep(5000);
            deleteWall();
            snake.moveUpP1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void delete(int row, int col) {
        positions[row][col].deletePos();
    }

    public void drawInitialSnake1(int rowP1, int colP1) {
        snake.initialSnakeP1(positions[rowP1][colP1]);

    }

    public void drawInitialSnake2(int rowP2, int colP2) {
        snake.initialSnakeP2(positions[rowP2][colP2]);
    }

    public void greenApple(int row, int col) {
        positions[row][col].paintGreenApple();

    }

    public void redApple(int row, int col){
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


