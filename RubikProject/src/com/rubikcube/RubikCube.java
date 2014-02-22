package com.rubikcube;


public class RubikCube {
	
	private Face whiteSide;
	private Face yellowSide;
	private Face greenSide;
	private Face blueSide;
	private Face orangeSide;
	private Face redSide;
	
	public RubikCube(){
		whiteSide = new Face();
		yellowSide = new Face();
		greenSide = new Face();
		blueSide = new Face();
		orangeSide = new Face();
		redSide = new Face();
	}
	
// SET Methods

	public void setWhiteSide(Face whiteSide) {
		this.whiteSide = whiteSide;
	}

	public void setYellowSide(Face yellowSide) {
		this.yellowSide = yellowSide;
	}
	
	public void setGreenSide(Face greenSide) {
		this.greenSide = greenSide;
	}
	
	public void setBlueSide(Face blueSide) {
		this.blueSide = blueSide;
	}
	
	public void setOrangeSide(Face orangeSide) {
		this.orangeSide = orangeSide;
	}
	
	public void setRedSide(Face redSide) {
		this.redSide = redSide;
	}
	
// GET Methods
	
	public Face getWhiteSide() {
		return whiteSide;
	}
	
	public Face getYellowSide() {
		return yellowSide;
	}

	public Face getGreenSide() {
		return greenSide;
	}
	
	public Face getBlueSide() {
		return blueSide;
	}

	public Face getOrangeSide() {
		return orangeSide;
	}

	public Face getRedSide() {
		return redSide;
	}
	
// MOVE Methods
	
	public void right(Face face){//OK
		
		String aux0 = face.getMatrix()[0][2];
		String aux1 = face.getMatrix()[1][2];
		String aux2 = face.getMatrix()[2][2];
			
		face.getMatrix()[0][2] = face.getBottom().getMatrix()[0][2];
		face.getMatrix()[1][2] = face.getBottom().getMatrix()[1][2];
		face.getMatrix()[2][2] = face.getBottom().getMatrix()[2][2];
		
		face.getBottom().getMatrix()[0][2] = face.getBack().getMatrix()[2][0];//Inverse
		face.getBottom().getMatrix()[1][2] = face.getBack().getMatrix()[1][0];//Inverse
		face.getBottom().getMatrix()[2][2] = face.getBack().getMatrix()[0][0];//Inverse
			
		face.getBack().getMatrix()[0][0] = face.getTop().getMatrix()[2][2];
		face.getBack().getMatrix()[1][0] = face.getTop().getMatrix()[1][2];
		face.getBack().getMatrix()[2][0] = face.getTop().getMatrix()[0][2];
		
		face.getTop().getMatrix()[0][2] = aux0;
		face.getTop().getMatrix()[1][2] = aux1;
		face.getTop().getMatrix()[2][2] = aux2;
		
		rotate(face.getRight());
	}
	
	public void rightInv(Face face){//OK
		
		String aux0 = face.getMatrix()[0][2];
		String aux1 = face.getMatrix()[1][2];
		String aux2 = face.getMatrix()[2][2];
		
		face.getMatrix()[0][2] = face.getTop().getMatrix()[0][2];
		face.getMatrix()[1][2] = face.getTop().getMatrix()[1][2];
		face.getMatrix()[2][2] = face.getTop().getMatrix()[2][2];
			
		face.getTop().getMatrix()[0][2] = face.getBack().getMatrix()[2][0];//Inverse
		face.getTop().getMatrix()[1][2] = face.getBack().getMatrix()[1][0];//Inverse
		face.getTop().getMatrix()[2][2] = face.getBack().getMatrix()[0][0];//Inverse
		
		face.getBack().getMatrix()[0][0] = face.getBottom().getMatrix()[2][2];
		face.getBack().getMatrix()[1][0] = face.getBottom().getMatrix()[1][2];
		face.getBack().getMatrix()[2][0] = face.getBottom().getMatrix()[0][2];
		
		face.getBottom().getMatrix()[0][2] = aux0;
		face.getBottom().getMatrix()[1][2] = aux1;
		face.getBottom().getMatrix()[2][2] = aux2;
		
		rotateInv(face.getRight());
	}
	
	public void left(Face face){//OK

		String aux0 = face.getMatrix()[0][0];
		String aux1 = face.getMatrix()[1][0];
		String aux2 = face.getMatrix()[2][0];
		
		face.getMatrix()[0][0] = face.getTop().getMatrix()[0][0];
		face.getMatrix()[1][0] = face.getTop().getMatrix()[1][0];
		face.getMatrix()[2][0] = face.getTop().getMatrix()[2][0];
			
		face.getTop().getMatrix()[0][0] = face.getBack().getMatrix()[2][2];
		face.getTop().getMatrix()[1][0] = face.getBack().getMatrix()[1][2];
		face.getTop().getMatrix()[2][0] = face.getBack().getMatrix()[0][2];
		
		face.getBack().getMatrix()[0][2] = face.getBottom().getMatrix()[2][0];
		face.getBack().getMatrix()[1][2] = face.getBottom().getMatrix()[1][0];
		face.getBack().getMatrix()[2][2] = face.getBottom().getMatrix()[0][0];
		
		face.getBottom().getMatrix()[0][0] = aux0;
		face.getBottom().getMatrix()[1][0] = aux1;
		face.getBottom().getMatrix()[2][0] = aux2;
		
		rotate(face.getLeft());
	}
	
	public void leftInv(Face face){//OK
		
		String aux0 = face.getMatrix()[0][0];
		String aux1 = face.getMatrix()[1][0];
		String aux2 = face.getMatrix()[2][0];
			
		face.getMatrix()[0][0] = face.getBottom().getMatrix()[0][0];
		face.getMatrix()[1][0] = face.getBottom().getMatrix()[1][0];
		face.getMatrix()[2][0] = face.getBottom().getMatrix()[2][0];
		
		face.getBottom().getMatrix()[0][0] = face.getBack().getMatrix()[2][2];
		face.getBottom().getMatrix()[1][0] = face.getBack().getMatrix()[1][2];
		face.getBottom().getMatrix()[2][0] = face.getBack().getMatrix()[0][2];
			
		face.getBack().getMatrix()[0][2] = face.getTop().getMatrix()[2][0];
		face.getBack().getMatrix()[1][2] = face.getTop().getMatrix()[1][0];
		face.getBack().getMatrix()[2][2] = face.getTop().getMatrix()[0][0];
		
		face.getTop().getMatrix()[0][0] = aux0;
		face.getTop().getMatrix()[1][0] = aux1;
		face.getTop().getMatrix()[2][0] = aux2;
		
		rotateInv(face.getLeft());
	}
	
	public void up(Face face){

		String aux0 = face.getMatrix()[0][0];
		String aux1 = face.getMatrix()[0][1];
		String aux2 = face.getMatrix()[0][2];
			
		face.getMatrix()[0][0] = face.getRight().getMatrix()[0][0];
		face.getMatrix()[0][1] = face.getRight().getMatrix()[0][1];
		face.getMatrix()[0][2] = face.getRight().getMatrix()[0][2];
		
		face.getRight().getMatrix()[0][0] = face.getBack().getMatrix()[0][0];
		face.getRight().getMatrix()[0][1] = face.getBack().getMatrix()[0][1];
		face.getRight().getMatrix()[0][2] = face.getBack().getMatrix()[0][2];
		
		face.getBack().getMatrix()[0][0] = face.getLeft().getMatrix()[0][0];
		face.getBack().getMatrix()[0][1] = face.getLeft().getMatrix()[0][1];
		face.getBack().getMatrix()[0][2] = face.getLeft().getMatrix()[0][2];
		
		face.getLeft().getMatrix()[0][0] = aux0;
		face.getLeft().getMatrix()[0][1] = aux1;
		face.getLeft().getMatrix()[0][2] = aux2;
		
		rotate(face.getTop());
	}
	
	public void upInv(Face face){
		
		String aux0 = face.getMatrix()[0][0];
		String aux1 = face.getMatrix()[0][1];
		String aux2 = face.getMatrix()[0][2];
			
		face.getMatrix()[0][0] = face.getLeft().getMatrix()[0][0];
		face.getMatrix()[0][1] = face.getLeft().getMatrix()[0][1];
		face.getMatrix()[0][2] = face.getLeft().getMatrix()[0][2];
		
		face.getLeft().getMatrix()[0][0] = face.getBack().getMatrix()[0][0];
		face.getLeft().getMatrix()[0][1] = face.getBack().getMatrix()[0][1];
		face.getLeft().getMatrix()[0][2] = face.getBack().getMatrix()[0][2];
		
		face.getBack().getMatrix()[0][0] = face.getRight().getMatrix()[0][0];
		face.getBack().getMatrix()[0][1] = face.getRight().getMatrix()[0][1];
		face.getBack().getMatrix()[0][2] = face.getRight().getMatrix()[0][2];
		
		face.getRight().getMatrix()[0][0] = aux0;
		face.getRight().getMatrix()[0][1] = aux1;
		face.getRight().getMatrix()[0][2] = aux2;
		
		rotateInv(face.getTop());
	}
	
	public void down(Face face){
		
		String aux0 = face.getMatrix()[2][0];
		String aux1 = face.getMatrix()[2][1];
		String aux2 = face.getMatrix()[2][2];
			
		face.getMatrix()[2][0] = face.getLeft().getMatrix()[2][0];
		face.getMatrix()[2][1] = face.getLeft().getMatrix()[2][1];
		face.getMatrix()[2][2] = face.getLeft().getMatrix()[2][2];
		
		face.getLeft().getMatrix()[2][0] = face.getBack().getMatrix()[2][0];
		face.getLeft().getMatrix()[2][1] = face.getBack().getMatrix()[2][1];
		face.getLeft().getMatrix()[2][2] = face.getBack().getMatrix()[2][2];
		
		face.getBack().getMatrix()[2][0] = face.getRight().getMatrix()[2][0];
		face.getBack().getMatrix()[2][1] = face.getRight().getMatrix()[2][1];
		face.getBack().getMatrix()[2][2] = face.getRight().getMatrix()[2][2];
		
		face.getRight().getMatrix()[2][0] = aux0;
		face.getRight().getMatrix()[2][1] = aux1;
		face.getRight().getMatrix()[2][2] = aux2;
		
		rotate(face.getBottom());
	}
	
	public void downInv(Face face){
		
		String aux0 = face.getMatrix()[2][0];
		String aux1 = face.getMatrix()[2][1];
		String aux2 = face.getMatrix()[2][2];
			
		face.getMatrix()[2][0] = face.getRight().getMatrix()[2][0];
		face.getMatrix()[2][1] = face.getRight().getMatrix()[2][1];
		face.getMatrix()[2][2] = face.getRight().getMatrix()[2][2];
		
		face.getRight().getMatrix()[2][0] = face.getBack().getMatrix()[2][0];
		face.getRight().getMatrix()[2][1] = face.getBack().getMatrix()[2][1];
		face.getRight().getMatrix()[2][2] = face.getBack().getMatrix()[2][2];
		
		face.getBack().getMatrix()[2][0] = face.getLeft().getMatrix()[2][0];
		face.getBack().getMatrix()[2][1] = face.getLeft().getMatrix()[2][1];
		face.getBack().getMatrix()[2][2] = face.getLeft().getMatrix()[2][2];
		
		face.getLeft().getMatrix()[2][0] = aux0;
		face.getLeft().getMatrix()[2][1] = aux1;
		face.getLeft().getMatrix()[2][2] = aux2;
		
		rotateInv(face.getBottom());
	}
	
	public void front(Face face){//OK

		String aux0 = face.getTop().getMatrix()[2][0];
		String aux1 = face.getTop().getMatrix()[2][1];
		String aux2 = face.getTop().getMatrix()[2][2];
		
		face.getTop().getMatrix()[2][0] = face.getLeft().getMatrix()[2][2];
		face.getTop().getMatrix()[2][1] = face.getLeft().getMatrix()[1][2];
		face.getTop().getMatrix()[2][2] = face.getLeft().getMatrix()[0][2];
		
		face.getLeft().getMatrix()[0][2] = face.getBottom().getMatrix()[0][0];
		face.getLeft().getMatrix()[1][2] = face.getBottom().getMatrix()[0][1];
		face.getLeft().getMatrix()[2][2] = face.getBottom().getMatrix()[0][2];
		
		face.getBottom().getMatrix()[0][0] = face.getRight().getMatrix()[2][0];
		face.getBottom().getMatrix()[0][1] = face.getRight().getMatrix()[1][0];
		face.getBottom().getMatrix()[0][2] = face.getRight().getMatrix()[0][0];
		
		face.getRight().getMatrix()[0][0] = aux0;
		face.getRight().getMatrix()[1][0] = aux1;
		face.getRight().getMatrix()[2][0] = aux2;
		
		rotate(face);
	}
	
	public void frontInv(Face face){//OK

		String aux0 = face.getTop().getMatrix()[2][2];
		String aux1 = face.getTop().getMatrix()[2][1];
		String aux2 = face.getTop().getMatrix()[2][0];
		
		face.getTop().getMatrix()[2][0] = face.getRight().getMatrix()[0][0];
		face.getTop().getMatrix()[2][1] = face.getRight().getMatrix()[1][0];
		face.getTop().getMatrix()[2][2] = face.getRight().getMatrix()[2][0];
		
		face.getRight().getMatrix()[0][0] = face.getBottom().getMatrix()[0][2];
		face.getRight().getMatrix()[1][0] = face.getBottom().getMatrix()[0][1];
		face.getRight().getMatrix()[2][0] = face.getBottom().getMatrix()[0][0];
		
		face.getBottom().getMatrix()[0][0] = face.getLeft().getMatrix()[0][2];
		face.getBottom().getMatrix()[0][1] = face.getLeft().getMatrix()[1][2];
		face.getBottom().getMatrix()[0][2] = face.getLeft().getMatrix()[2][2];
		
		face.getLeft().getMatrix()[0][2] = aux0;
		face.getLeft().getMatrix()[1][2] = aux1;
		face.getLeft().getMatrix()[2][2] = aux2;
		
		rotateInv(face);
	}
	
	public void back(Face face){//OK

		String aux0 = face.getTop().getMatrix()[0][2];
		String aux1 = face.getTop().getMatrix()[0][1];
		String aux2 = face.getTop().getMatrix()[0][0];
		
		face.getTop().getMatrix()[0][0] = face.getRight().getMatrix()[0][2];
		face.getTop().getMatrix()[0][1] = face.getRight().getMatrix()[1][2];
		face.getTop().getMatrix()[0][2] = face.getRight().getMatrix()[2][2];
		
		face.getRight().getMatrix()[0][2] = face.getBottom().getMatrix()[2][2];
		face.getRight().getMatrix()[1][2] = face.getBottom().getMatrix()[2][1];
		face.getRight().getMatrix()[2][2] = face.getBottom().getMatrix()[2][0];
		
		face.getBottom().getMatrix()[2][0] = face.getLeft().getMatrix()[0][0];
		face.getBottom().getMatrix()[2][1] = face.getLeft().getMatrix()[1][0];
		face.getBottom().getMatrix()[2][2] = face.getLeft().getMatrix()[2][0];
		
		face.getLeft().getMatrix()[0][0] = aux0;
		face.getLeft().getMatrix()[1][0] = aux1;
		face.getLeft().getMatrix()[2][0] = aux2;
		
		rotate(face.getBack());
	}
	
	public void backInv(Face face){//OK
		
		String aux0 = face.getTop().getMatrix()[0][0];
		String aux1 = face.getTop().getMatrix()[0][1];
		String aux2 = face.getTop().getMatrix()[0][2];
		
		face.getTop().getMatrix()[0][0] = face.getLeft().getMatrix()[2][0];
		face.getTop().getMatrix()[0][1] = face.getLeft().getMatrix()[1][0];
		face.getTop().getMatrix()[0][2] = face.getLeft().getMatrix()[0][0];
		
		face.getLeft().getMatrix()[0][0] = face.getBottom().getMatrix()[2][0];
		face.getLeft().getMatrix()[1][0] = face.getBottom().getMatrix()[2][1];
		face.getLeft().getMatrix()[2][0] = face.getBottom().getMatrix()[2][2];
		
		face.getBottom().getMatrix()[2][0] = face.getRight().getMatrix()[2][2];
		face.getBottom().getMatrix()[2][1] = face.getRight().getMatrix()[1][2];
		face.getBottom().getMatrix()[2][2] = face.getRight().getMatrix()[0][2];
		
		face.getRight().getMatrix()[0][2] = aux0;
		face.getRight().getMatrix()[1][2] = aux1;
		face.getRight().getMatrix()[2][2] = aux2;
		
		rotateInv(face.getBack());
	}
	
// MOVE Methods END	
	
	private void rotate(Face face){

		String aux00 = face.getMatrix()[0][0]; 
		face.getMatrix()[0][0] = face.getMatrix()[2][0];
		face.getMatrix()[2][0] = face.getMatrix()[2][2];
		face.getMatrix()[2][2] = face.getMatrix()[0][2];
		face.getMatrix()[0][2] = aux00;
		
		String aux01 = face.getMatrix()[0][1];
		face.getMatrix()[0][1] = face.getMatrix()[1][0];
		face.getMatrix()[1][0] = face.getMatrix()[2][1];
		face.getMatrix()[2][1] = face.getMatrix()[1][2];
		face.getMatrix()[1][2] = aux01;
	}
	
	private void rotateInv(Face face){		

		String aux00 = face.getMatrix()[0][0];
		face.getMatrix()[0][0] = face.getMatrix()[0][2];
		face.getMatrix()[0][2] = face.getMatrix()[2][2];
		face.getMatrix()[2][2] = face.getMatrix()[2][0];
		face.getMatrix()[2][0] = aux00;
		
		String aux01 = face.getMatrix()[0][1];
		face.getMatrix()[0][1] = face.getMatrix()[1][2];
		face.getMatrix()[1][2] = face.getMatrix()[2][1];
		face.getMatrix()[2][1] = face.getMatrix()[1][0];
		face.getMatrix()[1][0] = aux01;
	}
	
	public boolean equals(RubikCube cube){
		boolean answer = true;
		
		//Comparing Green Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (!this.getGreenSide().getMatrix()[i][j].equals(cube.getGreenSide().getMatrix()[i][j]))
					return false;
			}
		}
		
		//Comparing Blue Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (!this.getBlueSide().getMatrix()[i][j].equals(cube.getBlueSide().getMatrix()[i][j]))
					return false;
			}
		}
		
		//Comparing Red Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (!this.getRedSide().getMatrix()[i][j].equals(cube.getRedSide().getMatrix()[i][j]))
					return false;
			}
		}
		
		//Comparing Orange Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (!this.getOrangeSide().getMatrix()[i][j].equals(cube.getOrangeSide().getMatrix()[i][j]))
					return false;
			}
		}
		
		//Comparing Yellow Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (!this.getYellowSide().getMatrix()[i][j].equals(cube.getYellowSide().getMatrix()[i][j]))
					return false;
			}
		}
		
		//Comparing White Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				if (!this.getWhiteSide().getMatrix()[i][j].equals(cube.getWhiteSide().getMatrix()[i][j]))
					return false;
			}
		}
		
		return answer;
	}
	
	public RubikCube copy(){
		RubikCube copy = new RubikCube();
		
		Face whiteSide = new Face(); 
		Face yellowSide = new Face();
		Face greenSide = new Face();
		Face blueSide = new Face();
		Face orangeSide = new Face();
		Face redSide = new Face();
		
		whiteSide.setMatrix(new String[][] {{"w", "w", "w"},{"w", "w", "w"},{"w", "w", "w"}});
		yellowSide.setMatrix(new String[][] {{"y", "y", "y"},{"y", "y", "y"},{"y", "y", "y"}});
		greenSide.setMatrix(new String[][] {{"g", "g", "g"},{"g", "g", "g"},{"g", "g", "g"}});
		blueSide.setMatrix(new String[][] {{"b", "b", "b"},{"b", "b", "b"},{"b", "b", "b"}});
		orangeSide.setMatrix(new String[][] {{"o", "o", "o"},{"o", "o", "o"},{"o", "o", "o"}});
		redSide.setMatrix(new String[][] {{"r", "r", "r"},{"r", "r", "r"},{"r", "r", "r"}});
		
		copy.setWhiteSide(whiteSide);
		copy.setYellowSide(yellowSide);
		copy.setGreenSide(greenSide);
		copy.setBlueSide(blueSide);
		copy.setOrangeSide(orangeSide);
		copy.setRedSide(redSide);
		
		//Seting the greenSide as the FrontFace
		greenSide.setTop(yellowSide);
		greenSide.setBottom(whiteSide);
		greenSide.setBack(blueSide);
		greenSide.setLeft(redSide);
		greenSide.setRight(orangeSide);
		
		//Comparing Green Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				copy.getGreenSide().getMatrix()[i][j] = this.greenSide.getMatrix()[i][j];
			}
		}
		
		//Comparing Blue Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				copy.getBlueSide().getMatrix()[i][j] = this.blueSide.getMatrix()[i][j];
			}
		}
		
		//Comparing Red Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				copy.getRedSide().getMatrix()[i][j] = this.redSide.getMatrix()[i][j];
			}
		}
		
		//Comparing Orange Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				copy.getOrangeSide().getMatrix()[i][j] = this.orangeSide.getMatrix()[i][j];
			}
		}
		
		//Comparing Yellow Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				copy.getYellowSide().getMatrix()[i][j] = this.yellowSide.getMatrix()[i][j];
			}
		}
		
		//Comparing White Side
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				copy.getWhiteSide().getMatrix()[i][j] = this.whiteSide.getMatrix()[i][j];
			}
		}		
		
		return copy;
	}
	
	public String toString(){
		String output = "";
		
		output += yellowSide.toString() + "\n";
		output += greenSide.toString() + "\n";
		output += whiteSide.toString() + "\n";
		output += blueSide.toString() + "\n";
		output += orangeSide.toString() + "\n";
		output += redSide.toString();
		
		return output;
	}

}
