package src.com.leetcode.s3212;

class Solution {

    private record Data(int x, int y) {
    }

    public int numberOfSubmatrices(char[][] grid) {
        Data[][] horizontalMap = new Data[grid.length][grid[0].length];
        Data[][] totalMap = new Data[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    x++;
                } else if (grid[i][j] == 'Y') {
                    y++;
                }
                horizontalMap[i][j] = new Data(x, y);
            }
        }


        for (int j = 0; j < horizontalMap[0].length; j++) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < horizontalMap.length; i++) {
                x += horizontalMap[i][j].x;
                y += horizontalMap[i][j].y;
                totalMap[i][j] = new Data(x, y);
            }
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (totalMap[i][j].x >= 1 && totalMap[i][j].y >= 1 && totalMap[i][j].x == totalMap[i][j].y) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubmatrices(new char[][]{
                {'X', 'Y', '.'},
                {'Y', '.', '.'},
        }));

        System.out.println(solution.numberOfSubmatrices(new char[][]{
                {'X', 'X'},
                {'X', 'Y'},
        }));

        System.out.println(solution.numberOfSubmatrices(new char[][]{
                {'.', '.'},
                {'.', '.'},
        }));
    }
}