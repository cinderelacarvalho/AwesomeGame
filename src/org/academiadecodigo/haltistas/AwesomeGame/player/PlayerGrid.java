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

        drawInitialSnake(20, 30, 80, 30);


        positions = new PlayerPosition[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                positions[i][j] = new PlayerPosition(initialWidth, initialHeight);

                initialHeight += 1;

            }
            initialHeight = 1;
            initialWidth += 1;

        }


        try {
            Thread.sleep(3000);
            deleteWall();

            System.out.println("ASfgdhfjhk");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void delete(int row, int col) {
        positions[row][col].delete();
    }

    public void drawInitialSnake(int rowP1, int colP1, int rowP2, int colP2) {
        snake.initialSnakeP1(rowP1, colP1);
        snake.intialSnakeP2(rowP2, colP2);
        ObjectFactory.getWall();
    }

    public void deleteWall() {
        int i = 0;
        while (i < COLS) {

            positions[50][i].drawPos();
            positions[49][i].delete();
            i++;
            //new PlayerPosition(50, i).delete();

        }

    }
}


