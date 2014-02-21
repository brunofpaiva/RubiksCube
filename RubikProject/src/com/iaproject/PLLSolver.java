package com.iaproject;

import com.rubikcube.RubikCube;

public class PLLSolver {
	
	private RubikCube cube;
	private String solution;
	
	private int greenSide = 0;
	private int orangeSide = 0;
	private int blueSide = 0;
	private int redSide = 0;
	
	
	//POSSIBLE CASES
//	H U1 U2 Z A1 A2 E F G1 G2 G3 G4 J1 J2 N1 N2 R1 R2 T V Y
	
// CASES WITH 3 equal colors at 1 side and 2 equal colors at 1 side
//	J1 J2
	
// CASES WITH 3 equal colors at 1 side
//	U1 U2 F
	
// CASES WITH 2 equal colors at 4 sides
//	H Z N1 N2
	
// CASES WITH 2 equal colors at 3 sides
//	A1 A2 T
	
// CASES WITH 2 equal colors at 2 sides
//	G1 G2 G3 G4 R1 R2 V Y
	
// CASES WITH 0 equal colors at 1 side
//	E

	public PLLSolver(RubikCube cube, String solution){
		this.cube = cube;
		this.solution = solution;
//		this.corners = new ArrayList<CornerPiece>();
//		this.edges = new ArrayList<EdgePiece>();
	}
	
	public String getSolution(){
		return solution;
	}
	
	public void solvePLL(){

		countPiecesSide();
		
		System.out.println("Green Side: " + greenSide);
		System.out.println("Orange Side: " + orangeSide);
		System.out.println("Blue Side: " + blueSide);
		System.out.println("Red Side: " + redSide);
		
		verifyPLLGroup();
		
	}
	
	private void correctLastLayer() {
		
		cube.up(cube.getGreenSide());
		cube.up(cube.getGreenSide());
		solution += "U U ";
		
		verifyCase();
	}
	
	private void verifyCase() {
		
		if (true){ // A1 Case
			solveA1();
		}
		
	}

	private void solveA1() {
		cube.left(cube.getGreenSide());
		cube.frontInv(cube.getGreenSide());
		cube.left(cube.getGreenSide());
		cube.back(cube.getGreenSide());
		cube.back(cube.getGreenSide());
		cube.leftInv(cube.getGreenSide());
		cube.front(cube.getGreenSide());
		cube.left(cube.getGreenSide());
		cube.back(cube.getGreenSide());
		cube.back(cube.getGreenSide());
		cube.left(cube.getGreenSide());
		cube.left(cube.getGreenSide());
		
		solution += "L F' L B B L' F L B B L L";
	}

	private void verifyPLLGroup(){
		
		if(greenSide == 3 || orangeSide == 3 || blueSide == 3 || redSide == 3){
			if (greenSide > 0 || orangeSide > 0 || blueSide > 0 || redSide > 0){
				// J1 J2
			}else{
				// U1 U2 F
			}
		}
		
		if (greenSide == 2 && orangeSide == 2 && blueSide == 2 && redSide == 0){
			// A1 A2 T
		}
		if (greenSide == 2 && orangeSide == 2 && blueSide == 0 && redSide == 2){
			// A1 A2 T
		}
		if (greenSide == 2 && orangeSide == 0 && blueSide == 2 && redSide == 2){
			// A1 A2 T
			correctLastLayer();
			
		}
		if (greenSide == 0 && orangeSide == 2 && blueSide == 2 && redSide == 2){
			// A1 A2 T
		}
		
		
		
	}
	
	private void countPiecesSide(){
			
	//greenSide
		String c1 = cube.getGreenSide().getMatrix()[0][0];
		String c2 = cube.getGreenSide().getMatrix()[0][1];
		String c3 = cube.getGreenSide().getMatrix()[0][2];
		
		setSideCount(c1,c2,c3, 0);

	//orangeSide
		c1 = cube.getOrangeSide().getMatrix()[0][0];
		c2 = cube.getOrangeSide().getMatrix()[0][1];
		c3 = cube.getOrangeSide().getMatrix()[0][2];

		setSideCount(c1,c2,c3, 1);
		
	//blueSide
		c1 = cube.getBlueSide().getMatrix()[0][0];
		c2 = cube.getBlueSide().getMatrix()[0][1];
		c3 = cube.getBlueSide().getMatrix()[0][2];
		
		setSideCount(c1,c2,c3, 2);
		
	//redSide
		c1 = cube.getRedSide().getMatrix()[0][0];
		c2 = cube.getRedSide().getMatrix()[0][1];
		c3 = cube.getRedSide().getMatrix()[0][2];
		
		setSideCount(c1,c2,c3, 3);		
	}


	private void setSideCount(String c1, String c2, String c3, int color){
		int countSide = 0;
		
		if (c1.equals(c2)){
			countSide = 2;
			if (c1.equals(c3)){
				countSide = 3;	
			}
		}else if (c1.equals(c3) || (c2.equals(c3))){
			countSide = 2;
		}else{
			countSide = 0;
		}
		
		if (color == 0){
			greenSide = countSide;
		}else if (color == 1){
			orangeSide = countSide;
		}else if (color == 2){
			blueSide = countSide;
		}else{
			redSide = countSide;
		}		
	}

}
/*	private void fillCorners(){
		corners.clear();
		
		CornerPiece corner5 = new CornerPiece(cube.getYellowSide().getMatrix()[0][0], //colorH
											  cube.getBlueSide().getMatrix()[0][2],   //colorL
											  cube.getRedSide().getMatrix()[0][0]);   //colorR
		corner5.setType(LevelKind.UP);
		corner5.setPosition(5);
		corners.add(corner5);
		
		CornerPiece corner6 = new CornerPiece(cube.getYellowSide().getMatrix()[0][2], //colorH							  
				  							  cube.getOrangeSide().getMatrix()[0][2], //colorL
											  cube.getBlueSide().getMatrix()[0][0]);  //colorR
		corner6.setType(LevelKind.UP);
		corner6.setPosition(6);
		corners.add(corner6);
		
		CornerPiece corner7 = new CornerPiece(cube.getYellowSide().getMatrix()[2][2], //colorH
											  cube.getGreenSide().getMatrix()[0][2],  //colorL							  
											  cube.getOrangeSide().getMatrix()[0][0]);//colorR
		corner7.setType(LevelKind.UP);
		corner7.setPosition(7);
		corners.add(corner7);
		
		CornerPiece corner8 = new CornerPiece(cube.getYellowSide().getMatrix()[2][0], //colorH
											  cube.getRedSide().getMatrix()[0][2],    //colorL			  
											  cube.getGreenSide().getMatrix()[0][0]); //colorR
		corner8.setType(LevelKind.UP);
		corner8.setPosition(8);
		corners.add(corner8);
	}
	
	private void fillEdges(){
		edges.clear();

		EdgePiece edge5 = new EdgePiece(cube.getYellowSide().getMatrix()[0][1],
										cube.getBlueSide().getMatrix()[0][1]);
		edge5.setType(LevelKind.UP);
		edge5.setPosition(5);
		edges.add(edge5);
		
		EdgePiece edge6 = new EdgePiece(cube.getYellowSide().getMatrix()[1][2],
										cube.getOrangeSide().getMatrix()[0][1]);
		edge6.setType(LevelKind.UP);
		edge6.setPosition(6);
		edges.add(edge6);
		
		EdgePiece edge7 = new EdgePiece(cube.getYellowSide().getMatrix()[2][1],
										cube.getGreenSide().getMatrix()[0][1]);
		edge7.setType(LevelKind.UP);
		edge7.setPosition(7);
		edges.add(edge7);
		
		EdgePiece edge8 = new EdgePiece(cube.getYellowSide().getMatrix()[1][0],
										cube.getRedSide().getMatrix()[0][1]);
		edge8.setType(LevelKind.UP);
		edge8.setPosition(8);
		edges.add(edge8);
	}	
}
*/