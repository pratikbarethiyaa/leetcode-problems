class Solution {
    public static void dfs(int row,int col,char grid[][],boolean vis[][],int dirt[][]){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || vis[row][col] || grid[row][col]=='0'){
            return;
        }
        vis[row][col]=true;
        for(int dir[] : dirt){
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            dfs(newRow,newCol,grid,vis,dirt);
        }
        
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        boolean vis[][] =new boolean[m][n];

        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,vis,dirt);
                    count++;
                }
            }
        }
        return count;
    }
}