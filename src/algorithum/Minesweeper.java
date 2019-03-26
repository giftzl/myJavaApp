package algorithum;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Random;

public class Minesweeper {

    HashSet<String> positionSet = new HashSet<>();

    public static void main(String[] args) {
        new Minesweeper().printMineset(20, 20, 30);
    }

    private int getvalidRandom(int bound) {
        int random = new Random().nextInt(bound);
        return random == 0 ? random + 2 : random;
    }

    /**
     * Randomly generate the bomb chart
     *
     * @param m width
     * @param n height
     * @param b bomb count
     */
    public void printMineset(int m, int n, int b) {
        int[][] board = new int[m + 2][n + 2];

        for (int bc = 1; bc <= b; bc++) {
            int[] pos = getPosition(m, n);
            int x = pos[0];
            int y = pos[1];
            board[x][y] = -1;
        }

        //calculate value around the mine
        for (String pos : positionSet) {
            String[] xy = pos.split("\\,");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            //left
            if (board[x - 1][y] != -1)
                board[x - 1][y]++;
            //right
            if (board[x + 1][y] != -1)
                board[x + 1][y]++;
            //up
            if (board[x][y - 1] != -1)
                board[x][y - 1]++;
            //down
            if (board[x][y + 1] != -1)
                board[x][y + 1]++;
            //upright
            if (board[x + 1][y - 1] != -1)
                board[x + 1][y - 1]++;
            //upleft
            if (board[x - 1][y - 1] != -1)
                board[x - 1][y - 1]++;
            //downleft
            if (board[x - 1][y + 1] != -1)
                board[x - 1][y + 1]++;
            //downright
            if (board[x + 1][y + 1] != -1)
                board[x + 1][y + 1]++;


        }
        // print game
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if ((i == 0 && j == 0) || (i == 0 && j == n - 1) || (i == n - 1 && j == 0) || (i == n - 1 && j == m - 1))
                    System.out.print("+ ");
                else if (i == 0 || i == n - 1)
                    System.out.print("- ");
                else if (j == 0 || j == m - 1)
                    System.out.print("|");
                else if (board[i][j] == -1)
                    System.out.print("* ");
                else if (board[i][j] == 0)
                    System.out.print("  ");
                else if (board[i][j] != 0)
                    System.out.print(Integer.toString(board[i][j]) + " ");
            System.out.println();
        }
    }

    private int[] getPosition(int m, int n) {
        int[] pos = new int[2];

        int x = getvalidRandom(m - 2);
        int y = getvalidRandom(n - 2);
        String v = x + "," + y;
//        System.out.println("bomb position: ["+v+"]");
        if (positionSet.contains(v))
            getPosition(m, n);
        else {
            pos[0] = x;
            pos[1] = y;
            positionSet.add(v);
        }
        return pos;
    }

    public void minePrint(int m, int n, int b) {

        // game grid is [1..m][1..n], border is used to handle boundary cases
        boolean[][] bombs = new boolean[m + 2][n + 2];
        for (int c = 0; c < b; c++) {
            int[] pos = getPosition(m, n);

            bombs[pos[0]][pos[1]] = true;
        }

        // print game
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                if (bombs[i][j])
                    System.out.print(" * ");
                else
                    System.out.print(". ");
            System.out.println();
        }

        // sol[i][j] = # bombs adjacent to cell (i, j)
        int[][] sol = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                // (ii, jj) indexes neighboring cells
                for (int ii = i - 1; ii <= i + 1; ii++)
                    for (int jj = j - 1; jj <= j + 1; jj++)
                        if (bombs[ii][jj]) sol[i][j]++;

        // print solution
        System.out.println();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (bombs[i][j]) System.out.print("* ");
                else System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }

    }
}