package com.abhay.file.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

import com.abhay.file.model.Matrix;

public class Matrix {

	public int Island(int[][] matrix) {
		if (matrix == null)
			return 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int res = 0;
		if (row * column == 0)
			return 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				if (matrix[i][j] == 1) {
					res++;
					mark(matrix, i, j);
				}
		return res;
	}

	public void mark(int[][] matrix, int x, int y) {
		int row = matrix.length;
		int column = matrix[0].length;
		if(x<0 || x >= row || y < 0 || y >= column) return;
		/*if (x != 0)
			x--;
		if (y != 0)
			y--;*/
		Queue<Point> queue = new LinkedList<Point>();
		if (matrix[x][y] != 1) {
			return;
		}
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			if(!(p.x < 0 || p.x >= row || p.y < 0 || p.y >= column)){
				if (matrix[p.x][p.y] == 1) {
					matrix[p.x][p.y] = 0;
					queue.add(new Point(p.x - 1, p.y)); //up (north)
					queue.add(new Point(p.x + 1, p.y)); //down (sound)
					queue.add(new Point(p.x, p.y - 1)); //left (west)
					queue.add(new Point(p.x, p.y + 1)); //right (east)
				}
			}			
		}

		return;
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
