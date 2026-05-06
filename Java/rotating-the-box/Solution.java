class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Simulate gravity in each row
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // position where stone can fall

            for (int j = n - 1; j >= 0; j--) {

                // Obstacle resets the empty position
                if (boxGrid[i][j] == '*') {
                    empty = j - 1;
                }

                // Stone falls to the rightmost possible place
                else if (boxGrid[i][j] == '#') {

                    // Make current empty
                    boxGrid[i][j] = '.';

                    // Place stone at empty position
                    boxGrid[i][empty] = '#';

                    empty--;
                }
            }
        }

        // Step 2: Rotate matrix 90 degrees clockwise
        char[][] result = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return result;
    }
}