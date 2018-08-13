package com.abhay.file.main;

import java.time.Duration;
import java.time.LocalTime;

public class Matrix {
	
	public int Island(int[][] matrix){
	    if(matrix == null) return 0;
	    int row = matrix.length;
	    int column = matrix[0].length;
	    int res = 0;
	    if(row*column == 0) return 0; 
	    for(int i = 0 ; i < row ;i++) 
	      for(int j = 0 ; j < column ; j++) 
	        if(matrix[i][j] == 1)
	          {
	            res++;
	            mark(matrix,i,j);
	          }  
	    return res;
	  }
	  public void mark(int[][] matrix, int x , int y){
	  
	    int row = matrix.length;
	    int column = matrix[0].length;
	    if(x<0 || x>= row || y<0 ||y>=column) return;
	    if(matrix[x][y] == 1) 
	    	matrix[x][y] = 0;
	    else 
	    	return;
	    mark(matrix,x-1,y);
	    mark(matrix,x+1,y);
	    mark(matrix,x,y-1);
	    mark(matrix,x,y+1);
	  }
	  
	  public static void main(String[] args) {
		Matrix m = new Matrix();
		int matrix[][] = {
				{0, 0, 1, 0}, 
				{0, 0, 1, 1},
				{1, 0, 0, 0}, 
				{1, 0, 0, 0}
				/*{1, 1, 1, 0, 1}, 
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0}, 
				{0, 0, 0, 1, 0},
				{1, 1, 1, 0, 0}*/
		};
		
		LocalTime startTime = LocalTime.now();
		System.out.println("Number of Block is: "+m.Island(matrix));
		LocalTime EndTime = LocalTime.now();
		Duration d = Duration.between(startTime, EndTime);
		System.out.println("Total Time: "+ d.toMillis() +"ms");
	}

}
