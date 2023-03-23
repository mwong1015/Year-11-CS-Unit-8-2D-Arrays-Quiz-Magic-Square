public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int num: array2d[0]){
            sum = sum + num;
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */

    public static boolean magicRows(int[][] array2d, int checkSum) {
        boolean isEqual = true;
        int sum = 0;
        for(int i = 1; i < array2d.length; i++){
            for (int j = 0; j <array2d[i].length; j++){
                sum += array2d[i][j];
            }
            if (!(sum == checkSum)){
                isEqual = false;
            }
            sum = 0;
        }
        return isEqual;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        boolean isEqual = true;
        int sum = 0;
        int columns = array2d[0].length;
        for(int i = 0; i < columns; i++){
            for (int j = 0; j <array2d.length; j++){
                sum += array2d[j][i];
            }
            if (!(sum == checkSum)){
                isEqual = false;
            }
            sum = 0;
        }
        return isEqual;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        boolean isEqual = true;
        int sum = 0;
        for(int i = 0; i < array2d.length; i++){
            sum += array2d[i][i];// [0,0], [1,1]... [n][n]
        }
        if (!(sum == checkSum)){
            isEqual = false;
        }
        sum = 0;
        for(int i = array2d.length-1; i >= 0; i--){
            sum += array2d[i][array2d.length-1]; //[n][0], [n-1][1] ... [0][n]
        }
        if (!(sum == checkSum)){
            isEqual = false;
        }
        return isEqual;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        if((magicRows(array2d,calculateCheckSum(array2d)))&&(magicColumns(array2d,calculateCheckSum(array2d)))&&(magicDiagonals(array2d,calculateCheckSum(array2d)))){
            return true;
        }
        return false;
    }

}
