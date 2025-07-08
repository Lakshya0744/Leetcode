import java.util.HashSet;

public class SpecialFloorFill {
    public static int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    static HashSet<String> set;
    public static char[][] matrix;
    public static void main(String[] args){
        set = new HashSet<>();
        matrix = new char[][]{{'O','X','O'},{'X','O','X'},{'O','X','O'}};
        floodFill(matrix);
    }
    public static void floodFill(char[][] matrix){

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]=='O'){
                dfs(i,0);
            }
            if(matrix[i][matrix[0].length-1]=='O'){
                dfs(i, matrix[0].length-1);
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]=='O'){
                dfs(0,j);
            }
            if(matrix[matrix.length-1][j]=='O'){
                dfs(matrix.length-1, j);
            }
        }

        for(int i=0;i<matrix.length;i++){
            System.out.println();
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='O'){
                    matrix[i][j] = 'X';
                }
                else if(matrix[i][j]=='#'){
                    matrix[i][j] = 'O';
                }
                System.out.print(matrix[i][j]);
            }
        }
    }
    public static void dfs(int row, int col){
        if(row<0 || row>=matrix.length || col<0 || col>=matrix[0].length){
            return;
        }
        if(matrix[row][col]=='O'){
            matrix[row][col]='#';
        }
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow>=0 && newRow<matrix.length && newCol>=0 && newCol<matrix[0].length && matrix[newRow][newCol]=='O') {
                dfs(newRow, newCol);
            }
        }
    }
}
