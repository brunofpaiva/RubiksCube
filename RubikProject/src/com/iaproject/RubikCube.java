package com.iaproject;

public class RubikCube {
	
	private Face whiteSide;
	private Face yellowSide;
	private Face greenSide;
	private Face blueSide;
	private Face orangeSide;
	private Face redSide;
	
	public RubikCube(){
		whiteSide = new Face("w");
		yellowSide = new Face("y");
		greenSide = new Face("g");
		blueSide = new Face("b");
		orangeSide = new Face("o");
		redSide = new Face("r");
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
	
	public void right(Face face){
		
		String aux0 = face.getMatrix()[0][2];
		String aux1 = face.getMatrix()[1][2];
		String aux2 = face.getMatrix()[2][2];
			
		face.getMatrix()[0][2] = face.getBottom().getMatrix()[0][2];
		face.getMatrix()[1][2] = face.getBottom().getMatrix()[1][2];
		face.getMatrix()[2][2] = face.getBottom().getMatrix()[2][2];
		
		face.getBottom().getMatrix()[0][2] = face.getBack().getMatrix()[0][2];
		face.getBottom().getMatrix()[1][2] = face.getBack().getMatrix()[1][2];
		face.getBottom().getMatrix()[2][2] = face.getBack().getMatrix()[2][2];
			
		face.getBack().getMatrix()[0][2] = face.getTop().getMatrix()[0][2];
		face.getBack().getMatrix()[1][2] = face.getTop().getMatrix()[1][2];
		face.getBack().getMatrix()[2][2] = face.getTop().getMatrix()[2][2];
		
		face.getTop().getMatrix()[0][2] = aux0;
		face.getTop().getMatrix()[1][2] = aux1;
		face.getTop().getMatrix()[2][2] = aux2;	
	}
	
	public void rightInv(Face face){
		
		String aux0 = face.getMatrix()[0][2];
		String aux1 = face.getMatrix()[1][2];
		String aux2 = face.getMatrix()[2][2];
		
		face.getMatrix()[0][2] = face.getTop().getMatrix()[0][2];
		face.getMatrix()[1][2] = face.getTop().getMatrix()[1][2];
		face.getMatrix()[2][2] = face.getTop().getMatrix()[2][2];
			
		face.getTop().getMatrix()[0][2] = face.getBack().getMatrix()[0][2];
		face.getTop().getMatrix()[1][2] = face.getBack().getMatrix()[1][2];
		face.getTop().getMatrix()[2][2] = face.getBack().getMatrix()[2][2];
		
		face.getBack().getMatrix()[0][2] = face.getBottom().getMatrix()[0][2];
		face.getBack().getMatrix()[1][2] = face.getBottom().getMatrix()[1][2];
		face.getBack().getMatrix()[2][2] = face.getBottom().getMatrix()[2][2];
		
		face.getBottom().getMatrix()[0][2] = aux0;
		face.getBottom().getMatrix()[1][2] = aux1;
		face.getBottom().getMatrix()[2][2] = aux2;
	}
	
	public void left(Face face){

		String aux0 = face.getMatrix()[0][0];
		String aux1 = face.getMatrix()[1][0];
		String aux2 = face.getMatrix()[2][0];
		
		face.getMatrix()[0][0] = face.getTop().getMatrix()[0][0];
		face.getMatrix()[1][0] = face.getTop().getMatrix()[1][0];
		face.getMatrix()[2][0] = face.getTop().getMatrix()[2][0];
			
		face.getTop().getMatrix()[0][0] = face.getBack().getMatrix()[0][0];
		face.getTop().getMatrix()[1][0] = face.getBack().getMatrix()[1][0];
		face.getTop().getMatrix()[2][0] = face.getBack().getMatrix()[2][0];
		
		face.getBack().getMatrix()[0][0] = face.getBottom().getMatrix()[0][0];
		face.getBack().getMatrix()[1][0] = face.getBottom().getMatrix()[1][0];
		face.getBack().getMatrix()[2][0] = face.getBottom().getMatrix()[2][0];
		
		face.getBottom().getMatrix()[0][0] = aux0;
		face.getBottom().getMatrix()[1][0] = aux1;
		face.getBottom().getMatrix()[2][0] = aux2;
	}
	
	public void leftInv(Face face){
		
		String aux0 = face.getMatrix()[0][0];
		String aux1 = face.getMatrix()[1][0];
		String aux2 = face.getMatrix()[2][0];
			
		face.getMatrix()[0][0] = face.getBottom().getMatrix()[0][0];
		face.getMatrix()[1][0] = face.getBottom().getMatrix()[1][0];
		face.getMatrix()[2][0] = face.getBottom().getMatrix()[2][0];
		
		face.getBottom().getMatrix()[0][0] = face.getBack().getMatrix()[0][0];
		face.getBottom().getMatrix()[1][0] = face.getBack().getMatrix()[1][0];
		face.getBottom().getMatrix()[2][0] = face.getBack().getMatrix()[2][0];
			
		face.getBack().getMatrix()[0][0] = face.getTop().getMatrix()[0][0];
		face.getBack().getMatrix()[1][0] = face.getTop().getMatrix()[1][0];
		face.getBack().getMatrix()[2][0] = face.getTop().getMatrix()[2][0];
		
		face.getTop().getMatrix()[0][0] = aux0;
		face.getTop().getMatrix()[1][0] = aux1;
		face.getTop().getMatrix()[2][0] = aux2;	
	}
	
	public void up(Face face){
		//TODO
	}
	
	public void upInv(Face face){
		//TODO
	}
	
	public void down(Face face){
		//TODO
	}
	
	public void downInv(Face face){
		//TODO
	}
	
	public void front(Face face){
		//TODO
	}
	
	public void frontInv(Face face){
		//TODO
	}
	
	public void back(Face face){
		//TODO
	}
	
	public void backInv(Face face){
		//TODO
	}
	
// MOVE Methods END	
	
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
