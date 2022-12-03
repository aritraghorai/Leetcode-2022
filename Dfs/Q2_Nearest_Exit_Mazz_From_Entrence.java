package Dfs;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:21/11/2022
 ?Program Details:1926. Nearest Exit from Entrance in Maze
 *https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
   */
public class Q2_Nearest_Exit_Mazz_From_Entrence {
    public static void main(String[] args) {
        // char[][] arr = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
        char[][] arr = { { '+', '.', '+', '+', '+', '+', '+' }, { '+', '.', '+', '.', '.', '.', '+' },
                { '+', '.', '+', '.', '+', '.', '+' }, { '+', '.', '.', '.', '+', '.', '+' },
                { '+', '+', '+', '+', '+', '.', '+' } };
        System.out.println(nearestExit(arr, new int[] { 0, 1 }));
    }

    private static final int[][] paths = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public static int nearestExit(char[][] maze, int[] entrance) {
        // int res = helper(maze, entrance[0], entrance[1], entrance);
        // if (res == 0 || res >= 1000) {
        // return -1;
        // }
        // return res;
        LinkedList<int[]> qu = new LinkedList<>();
        // *Add initial point into the queue
        qu.offer(entrance);
        // *Mark the initial point to be visited */
        maze[entrance[0]][entrance[1]] = '*';
        int res = 0;
        int nr = -1, nc = -1;
        while (!qu.isEmpty()) {
            int si = qu.size();
            // System.out.println(qu);
            for (int i = 1; i <= si; i++) {
                int[] ri = qu.poll();
                for (int[] path : paths) {
                    nr = ri[0] + path[0];
                    nc = ri[1] + path[1];
                    if (isValid(maze, nr, nc)) {
                        if (maze[nr][nc] == '.') {
                            qu.offer(new int[] { nr, nc });
                            maze[nr][nc] = '*';
                        }
                    } else if (res != 0) {
                        return res;
                    }
                }
            }
            res += 1;
        }
        return -1;
    }

    static boolean isValid(char[][] mazz, int row, int colm) {
        if (row == -1 || colm == -1 || row == mazz.length || colm == mazz[0].length) {
            return false;
        }
        return true;
    }

    static int helper(char[][] mazz, int row, int colm, int[] entrance) {
        if (row == -1 || colm == -1 || row == mazz.length || colm == mazz[0].length) {
            return -1;
        }
        if (mazz[row][colm] == '+' ||
                mazz[row][colm] == '*') {
            return 1000;
        }

        mazz[row][colm] = '*';
        int res = 1000;
        for (int[] path : paths) {
            int rr = Math.min(res, helper(mazz, row + path[0], colm + path[1], entrance));
            if (rr == -1 && row == entrance[0] && colm == entrance[1]) {
                continue;
            } else {
                res = Math.min(rr, res);
            }
        }
        // System.out.println(res);
        res += 1;
        if (mazz[row][colm] == '*') {
            mazz[row][colm] = '.';
        }

        return res;
    }
}
