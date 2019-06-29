package leetcode_interviewed_100;
//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell, 
//where "adjacent" cells are those horizontally or vertically neighboring. 
//The same letter cell may not be used more than once.
public class Word_Search {

	public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray(); 
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int y=0; y<board.length; y++) {
    	   for (int x=0; x<board[y].length; x++) {
    		if (exist(board, y, x, w, 0,visited)) return true;
    	     }
        }
          return false;
    }
    
    private boolean exist(char[][] board, int y, int x, char[] word, int i,boolean[][] visited ){
	    if (i == word.length) return true;
	    if (y<0 || x<0 || y >= board.length || x >= board[y].length||visited[y][x]) return false;
	    if (board[y][x] != word[i]) return false;
	    visited[y][x] = true;//该次尝试此位置已经走过
	    boolean exist = exist(board, y, x+1, word, i+1,visited)
		    || exist(board, y, x-1, word, i+1,visited)		
		    || exist(board, y+1, x, word, i+1,visited)
		    || exist(board, y-1, x, word, i+1,visited);
	    visited[y][x] = false;//此路径此位置尝试完毕，复原
	    return exist;
    }
    
}
