package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "         ";
        int n = 0;

        int nX = 0;
        int nO = 0;
        int xWin = 0;
        int oWin = 0;
        int no = 0;

        char[][] square = new char[3][3];

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                square[i][j] = str.charAt(n);
                n++;
                if (square[i][j] == 'X') {
                    nX++;
                }
                if (square[i][j] == 'O') {
                    nO++;
                }
                if (square[i][j] == ' ') {
                    no++;
                }

                System.out.print(" " + square[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");

        while (true) {
            System.out.println(nX + " " + nO + " " + no);
            System.out.print("Enter the coordinates: ");
            int line = scanner.nextInt();
            int column = scanner.nextInt();
            if (line < 1 || line > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (square[line - 1][column - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (square[line - 1][column - 1] == ' ') {
                if (nX == nO) {
                    square[line - 1][column - 1] = 'X';
                    nX++;
                    no--;
                } else {
                    square[line - 1][column - 1] = 'O';
                    nO++;
                    no--;
                }
                System.out.println("---------");
                for (int i = 0; i < 3; i++) {
                    System.out.print("|");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(" " + square[i][j]);
                    }
                    System.out.println(" |");
                }
                System.out.println("---------");

            } else {
                System.out.println("You should enter numbers!");
            }

            for (int i = 0; i < 3; i++) {
                if (square[i][0] + square[i][1] + square[i][2] == 264) {
                    xWin++;
                }
                if (square[0][i] + square[1][i] + square[2][i] == 264) {
                    xWin++;
                }
            }
            if (square[0][0] + square[1][1] + square[2][2] == 264) {
                xWin++;
            }
            if (square[2][0] + square[1][1] + square[0][2] == 264) {
                xWin++;
            }


            for (int i = 0; i < 3; i++) {
                if (square[i][0] + square[i][1] + square[i][2] == 237) {
                    oWin++;
                }
                if (square[0][i] + square[1][i] + square[2][i] == 237) {
                    oWin++;
                }
            }
            if (square[0][0] + square[1][1] + square[2][2] == 237) {
                oWin++;
            }
            if (square[2][0] + square[1][1] + square[0][2] == 237) {
                oWin++;
            }

            if (xWin > 0) {
                System.out.println("X wins");
                break;
            } else if (oWin > 0) {
                System.out.println("O wins");
                break;
            } else if (xWin == 0 && oWin == 0 && no == 0) {
                System.out.println("Draw");
                break;
            }

        }

    }
}
