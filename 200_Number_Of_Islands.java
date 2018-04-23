//https://leetcode-cn.com/problems/number-of-islands/description/
public class Solution {  
    public int numIslands(char[][] grid) {  
        int count = 0;  
        for(int i=0; i<grid.length; i++) {  
            for(int j=0; j<grid[0].length; j++) {  
                if(grid[i][j]=='1') {//1必定是一个岛屿啦
                    count++;
                    search(grid, i, j);   
                }  
            }  
        }  
        return count;  
    }  
      
    private void search(char[][] grid, int x, int y) {  
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return;//越界或者是碰到海了,直接返回
        grid[x][y] = '0'; //如果还是在岛屿上，让海水淹没自己，并且向四周探索
        search(grid, x-1, y);  
        search(grid, x+1, y);  
        search(grid, x , y-1);  
        search(grid, x, y+1);  
    }  
} 
