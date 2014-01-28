package com.iaproject;

import java.util.ArrayList;

public class Solver {
	
	ArrayList<String> possibleMoves;
	RubikCube cube;
	
	public Solver(RubikCube cube){
		this.cube = cube;
	}
	
	public void solveCube(){
		solveCross(); //Always solve a white one
//		f2l();
//		oll();
//		pll();
	}
	
	public void solveCross(){
		while (! isCrossComplete()){
			
		}
	}
	
	//D F' U' F' R2 U' B2
	private boolean isCrossComplete(){
		boolean cross = true;
		
		if (! cube.getWhiteSide().getMatrix()[1][0].equals("w") )
			cross = false;
		if (! cube.getWhiteSide().getMatrix()[0][1].equals("w") )
			cross = false;
		if (! cube.getWhiteSide().getMatrix()[1][2].equals("w") )
			cross = false;
		if (! cube.getWhiteSide().getMatrix()[2][1].equals("w") )
			cross = false;
		
		return cross;
	}
	
	private RubikCube heuristic(RubikCube cubeA, RubikCube cubeB){
		
		if (countCrossPieces(cubeA) > countCrossPieces(cubeB)){
			return cubeA;
		
		}else if (countCrossPieces(cubeA) < countCrossPieces(cubeB)){
			return cubeB;
		
		}else if (countCrossPieces(cubeA) == countCrossPieces(cubeB)){
			if (countSecondLayerPieces(cubeA) > countSecondLayerPieces(cubeB))
				return cubeA;
			else
				return cubeB;
		}
		return cubeB;
	}
	
	private int countCrossPieces(RubikCube cube){
		int count = 0;
		
		if (cube.getWhiteSide().getMatrix()[1][0].equals("w") )
			count++;
		if (cube.getWhiteSide().getMatrix()[0][1].equals("w") )
			count++;
		if (cube.getWhiteSide().getMatrix()[1][2].equals("w") )
			count++;
		if (cube.getWhiteSide().getMatrix()[2][1].equals("w") )
			count++;
		
		return count;
	}
	
	private int countSecondLayerPieces(RubikCube cube){
		int count = 0;
		
		if (cube.getGreenSide().getMatrix()[1][0].equals("w") )
			count++;
		if (cube.getGreenSide().getMatrix()[1][2].equals("w") )
			count++;
		if (cube.getBlueSide().getMatrix()[1][0].equals("w") )
			count++;
		if (cube.getBlueSide().getMatrix()[1][2].equals("w") )
			count++;
		
		return count;
	}
	
}
