package HW8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    private final int HUMAN = 1;
    private final int AI = 2;
    private final int EMPTY_FIELD = 0;

    private int mapSizeX;
    private int mapSizeY;

    private int winLength;
    private int[][] map;

    private int cellW;
    private int cellH;

    private boolean isPressStartButton;

    private Random random = new Random();

     Map() {
                  setBackground(Color.WHITE);
                  isPressStartButton = false;

                  addMouseListener(new MouseAdapter() {
                      @Override
                      public void mouseReleased(MouseEvent mouse) {
                          super.mouseReleased(mouse);
                          gameLogic(mouse);
                      }
                  });
     }


    void startGame(int sizeX, int sizeY, int wLen) {
        this.mapSizeX = sizeX;
        this.mapSizeY = sizeY;
        this.winLength = wLen;
        isPressStartButton = true;
        map = new int[mapSizeY][mapSizeX];
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
                renderGame(g);
    }

    private void gameLogic(MouseEvent mouse) {
        System.out.println(mouse.getX());
        System.out.println(mouse.getY());
    }
    private void renderGame(Graphics g) {

         if (!isPressStartButton) {
             return;
         }

         createMap(g);

    }
    private void createMap(Graphics g) {
         int widthMe = getWidth();
         int heightMe = getHeight();

         cellW = widthMe / mapSizeX;
         cellH = heightMe / mapSizeY;

         g.setColor(Color.BLACK);

         for (int i = 0; i <= mapSizeY; i++) {
             int y = i * cellH;
             g.drawLine(0, y, widthMe, y);
         }

        for (int i = 0; i <= mapSizeX; i++) {
            int x = i * cellW;
            g.drawLine(x, 0, x, heightMe);
        }
    }

    private void aiTurn() {
        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }
        int x;
        int y;
        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        } while (!isEmptyCell(x, y));
        map[y][x] = AI;
        HomeWork8.sendToLog("AI turn to [" + (x + 1) + ":" + (y + 1) + "]");
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = AI;
                    if (checkWin(AI)) {
                        HomeWork8.sendToLog("AI turn to [" + (j + 1) + ":" + (i + 1) + "]");
                        return true;
                    }
                    map[i][j] = EMPTY_FIELD;
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = HUMAN;
                    if (checkWin(HUMAN)) {
                        map[i][j] = AI;
                        HomeWork8.sendToLog("AI turn to [" + (j + 1) + ":" + (i + 1) + "]");
                        return true;
                    }
                    map[i][j] = EMPTY_FIELD;
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int checkChar) {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (checkVector(i, j, 1, 0, winLength, checkChar)) {
                    return true;
                }
                if (checkVector(i, j, 1, 1, winLength, checkChar)) {
                    return true;
                }
                if (checkVector(i, j, 0, 1, winLength, checkChar)) {
                    return true;
                }
                if (checkVector(i, j, 1, -1, winLength, checkChar)) {
                    return true;
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkVector(int x, int y, int vx, int vy, int len, int checkChar) {
        int farX = x + (len - 1) * vx;
        int farY = y + (len - 1) * vy;

        if (!isValidCell(farX, farY)) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (map[y + i * vy][x + i * vx] != checkChar) {
                return false;
            }
        }
        return true;
    }

    private boolean isFullMap() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return map[y][x] == EMPTY_FIELD;
    }
}



