package com.rubikcube;

public class Face {

	private String[][] matrix;
	
	private Face Top;
	private Face Back;
	private Face Bottom;
	private Face Right;
	private Face Left;	
	
	public Face(){
		this.matrix = new String[2][2];
	}
	
	public void setMatrix(String[][] matrix){
		this.matrix = matrix;
	}
	
	public String[][] getMatrix(){
		return this.matrix;
	}
	
	public String getCenter(){
		return this.matrix[1][1];
	}
	
	public Face getTop() {
		return Top;
	}

	public void setTop(Face top) {
		Top = top;
	}

	public Face getBack() {
		return Back;
	}

	public void setBack(Face back) {
		Back = back;
	}

	public Face getBottom() {
		return Bottom;
	}

	public void setBottom(Face bottom) {
		Bottom = bottom;
	}

	public Face getRight() {
		return Right;
	}

	public void setRight(Face right) {
		Right = right;
	}

	public Face getLeft() {
		return Left;
	}

	public void setLeft(Face left) {
		Left = left;
	}

	public String toString(){
		String output = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				output += matrix[i][j] + " ";
			}
			output += "\n";
		}
		return output;
	}
	
}
