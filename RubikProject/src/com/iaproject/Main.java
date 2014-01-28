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

// TEST
	
//	Scramble = L D L' D B2 D' F' L' U' F' D' R U D' R2 B2 D' B L' F U' F' D' F2 R
		
		cube.left(greenSide);
		cube.down(greenSide);
		cube.leftInv(greenSide);
		cube.down(greenSide);
		cube.back(greenSide);
		cube.back(greenSide);
		cube.downInv(greenSide);
		cube.frontInv(greenSide);
		cube.leftInv(greenSide);
		cube.upInv(greenSide);
		cube.frontInv(greenSide);
		cube.downInv(greenSide);
		cube.right(greenSide);
		cube.up(greenSide);
		cube.downInv(greenSide);
		cube.right(greenSide);
		cube.right(greenSide);
		cube.back(greenSide);
		cube.back(greenSide);
		cube.downInv(greenSide);
		cube.back(greenSide);
		cube.leftInv(greenSide);
		cube.front(greenSide);
		cube.upInv(greenSide);
		cube.frontInv(greenSide);
		cube.downInv(greenSide);
		cube.front(greenSide);
		cube.front(greenSide);
		cube.right(greenSide);

		System.out.println("======");
		System.out.println(cube.toString());
		System.out.println("======");
		
		Solver me = new Solver(cube);
		me.solveCube();
		
//		System.out.println("======");
//		System.out.println(cube.toString());
//		System.out.println("======");
	}

}
