class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();

        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(Integer i:row){
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }
        }
        for(Integer j:col){
            for(int i=0;i<m;i++){
                matrix[i][j]=0;
            }
        }
    }
}