package HW4;

import java.util.Random;
import java.util.Scanner;
public class HomeWork4 {

    final int SIZE = 5; //размер поля
    final char DOT_X = 'x'; //Человек
    final char DOT_O = 'o'; //ИИ
    final char DOT_EMPTY = '.'; //пустая ячейка
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main (String[] args) {
        new HomeWork4().go();
    }
    //Инициализация поля
    void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    //Вывод поля в консоль
    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //Запуск игры
    void go() {
        initMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Искусственый интелект победил!");
                break;
            }
            if (isMapFull()) {
                System.out.println("OOOPS, Ничья!");
                break;
            }
        }
        System.out.println("ИГРА ЗАКОНЧЕНА.");
    }
    // Ход человека
    void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    // Ход ИИ
    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }
    // Проверка победы
    boolean checkWin(char dot) {
        int diag1, diag2, hor, ver;
        for (int i = 0; i < SIZE; i++) {
            hor = 0; ver = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    hor++;
                }
                if (map[j][i] == dot) {
                    ver++;
                }
            }
            if (hor == SIZE|| ver == SIZE) {
                return true;
            }
        }
        // Проверка по горизонтали и вертикали
        diag1 = 0; diag2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) {
                diag1++;
            }
            if (map[i][SIZE - i - 1] == dot) {
                diag2++;
            }
        }
        // Проверка по диагоналям
        if (diag1 == SIZE || diag2 == SIZE) {
            return true;
        }
        return false;
    }
    // Проверка на заполненность поля
    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    // Поиск свободной ячейки
    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
}