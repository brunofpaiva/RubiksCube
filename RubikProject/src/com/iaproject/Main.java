package com.iaproject;

public class Main {

	public static void main(String[] args) {
		
		RubikCube cube = new RubikCube();
		
		Face whiteSide = new Face("w"); 
		Face yellowSide = new Face("y");
		Face greenSide = new Face("g");
		Face blueSide = new Face("b");
		Face orangeSide = new Face("o");
		Face redSide = new Face("r");
		
		whiteSide.setMatrix(new String[][] {{"w", "w", "w"},{"w", "w", "w"},{"w", "w", "w"}});
		yellowSide.setMatrix(new String[][] {{"y", "y", "y"},{"y", "y", "y"},{"y", "y", "y"}});
		greenSide.setMatrix(new String[][] {{"g", "g", "g"},{"g", "g", "g"},{"g", "g", "g"}});
		blueSide.setMatrix(new String[][] {{"b", "b", "b"},{"b", "b", "b"},{"b", "b", "b"}});
		orangeSide.setMatrix(new String[][] {{"o", "o", "o"},{"o", "o", "o"},{"o", "o", "o"}});
		redSide.setMatrix(new String[][] {{"r", "r", "r"},{"r", "r", "r"},{"r", "r", "r"}});
		
		cube.setWhiteSide(whiteSide);
		cube.setYellowSide(yellowSide);
		cube.setGreenSide(greenSide);
		cube.setBlueSide(blueSide);
		cube.setOrangeSide(orangeSide);
		cube.setRedSide(redSide);
		
		//Seting the greenSide as the FrontFace
		greenSide.setTop(yellowSide);
		greenSide.setBottom(whiteSide);
		greenSide.setBack(blueSide);
		greenSide.setLeft(redSide);
		greenSide.setRight(orangeSide);
		
		// TESTS
		
//		cube.left(greenSide);
//		cube.right(greenSide);
		
		System.out.println("======");
		System.out.println(cube.toString());
		System.out.println("======");		
		
		cube.leftInv(greenSide);
//		cube.rightInv(greenSide);
		
		System.out.println("======");
		System.out.println(cube.toString());
		System.out.println("======");
	}

}
