package leetcode_interviewed_100;
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
public class Set_Matrix_Zeroes {

	public void setZeroes(int[][] matrix) {
        boolean isCol=false;
        int R=matrix.length;
        int C=matrix[0].length;
        //第一列是否要变零，isCol记录
        for(int i=0;i<R;i++){
            if(matrix[i][0]==0){
                isCol=true;
            }
            //检查第一列第一行以外的元素是否为0，若为0，把该元素所在的行和列的第一个元素
            //设为0
            for(int j=1;j<C;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //第一列第一行以外的元素设0
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                 if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                       matrix[i][j] = 0;
            }
          }
      }
        //第一行设0
        if (matrix[0][0] == 0) {
             for (int j = 0; j < C; j++) {
                 matrix[0][j] = 0;
      }
    }
        //第一列设0
        if (isCol) {
           for (int i = 0; i < R; i++) {
              matrix[i][0] = 0;
         }
       }
    }
	
}
