package com.iaproject;

public class Utils {
	
	public static RubikCube shuffleCube(String scramble){
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
		
		String[] moves = scramble.split(" ");
		
		for (int i = 0; i < moves.length; i++) {
			if (moves[i].equals("R")){
				cube.right(greenSide);
			}
			
			if (moves[i].equals("L")){
				cube.left(greenSide);
			}
			
			if (moves[i].equals("U")){
				cube.up(greenSide);
			}
			
			if (moves[i].equals("D")){
				cube.down(greenSide);
			}
			
			if (moves[i].equals("F")){
				cube.front(greenSide);
			}
			
			if (moves[i].equals("B")){
				cube.back(greenSide);
			}
			
			if (moves[i].equals("R'")){
				cube.rightInv(greenSide);
			}
			
			if (moves[i].equals("L'")){
				cube.leftInv(greenSide);
			}
			
			if (moves[i].equals("U'")){
				cube.upInv(greenSide);
			}
			
			if (moves[i].equals("D'")){
				cube.downInv(greenSide);
			}
			
			if (moves[i].equals("F'")){
				cube.frontInv(greenSide);
			}
			
			if (moves[i].equals("B'")){
				cube.backInv(greenSide);
			}
			
			if (moves[i].equals("R2")){
				cube.right(greenSide);
				cube.right(greenSide);
			}
			
			if (moves[i].equals("L2")){
				cube.left(greenSide);
				cube.left(greenSide);
			}
			
			if (moves[i].equals("U2")){
				cube.up(greenSide);
				cube.up(greenSide);
			}
			
			if (moves[i].equals("D2")){
				cube.down(greenSide);
				cube.down(greenSide);
			}
			
			if (moves[i].equals("F2")){
				cube.front(greenSide);
				cube.front(greenSide);
			}
			
			if (moves[i].equals("B2")){
				cube.back(greenSide);
				cube.back(greenSide);
			}
			
		}
		
		return cube; 
	}


}
