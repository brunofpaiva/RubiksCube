package com.iaproject;

import java.util.ArrayList;

public class F2LSolver {
	
	private RubikCube cube;
	private String solution;
	private ArrayList<CornerPiece> corners;
	private ArrayList<EdgePiece> edges;
	
	private final int FIRST_PAIR = 1; // Green and Red
//	private final int SECOND_PAIR = 2; // Green and Orange
//	private final int THIRD_PAIR = 3; // Orange and Blue
//	private final int FOURTH_PAIR = 4; // Blue and Red
	
	public F2LSolver(RubikCube cube, String solution) {
		this.cube = cube;
		this.solution = solution;
		this.corners = new ArrayList<CornerPiece>();
		fillCorners();
		this.edges = new ArrayList<EdgePiece>();
//		this.availableCorners = new ArrayList<CornerPlace>();
//		fillAvailableCorners();
	}

	public String getSolution(){
		return solution;
	}
	
	public void solveFirstTwoLayers() {
		int pairNumber = 1;
		
		while (pairNumber <= 1){
			
			System.out.println("====== CUBE ======");
			System.out.println(cube.toString());
			System.out.println("====== ==== ======");
			
			solveCorner(pairNumber);

//			System.out.println("pairNumber: " + count);
			pairNumber++;
		}
	}
	
	private void solveCorner(int curPair) {
		CornerPiece corner;
		EdgePiece edge;
		
		switch (curPair) {
		
			case FIRST_PAIR:
				corner = correctFirstCorner();
				fillEdges();
				edge = correctFirstEdge();
				solveF2LPair(corner, edge);
				break;
				
			default:
				break;
		}

	}
	
	private CornerPiece correctFirstCorner(){
		int i = 0;
		for (CornerPiece corner : corners){
			i++;
			if (corner.isThatCorner("w", "g", "r")){
				
				System.out.println("\nPosition of First Corner before correction: " + i);
				if (corner.getType() == LevelKind.UP){
					if (i == 5){
						cube.upInv(cube.getGreenSide());
						solution += "U' ";
					}else if (i == 6){
						cube.up(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "U U ";
					}else if (i == 7){
						cube.up(cube.getGreenSide());
						solution += "U ";
					}
					corner.setPosition(8);
					System.out.println("\nPosition of First Corner after correction: 8");
					
				}else{
					
				}
				System.out.println("Retornou o corner");
				return corner;
			}
		}
		return null;
	}
	
	private EdgePiece correctFirstEdge() {		
		int i = 0;
		for (EdgePiece edge : edges){
			i++;
			if (edge.isThatEdge("r", "g")){
				System.out.println("\nPositions of First Edge before correction: " + i);
				if (edge.getType() == LevelKind.BOTTOM && i != 1){
					if (i == 2){
						cube.right(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.rightInv(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						solution += "R U R' U'";
						System.out.println("\nPositions of First Edge before correction: 6");
						edge.setPosition(6);
					}else if(i == 3){
						cube.rightInv(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.right(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						solution += "R' U R U'";
						System.out.println("\nPositions of First Edge before correction: 6");
						edge.setPosition(6);
					}else{
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						solution += "L U L'";
						System.out.println("\nPositions of First Edge before correction: 5");
						edge.setPosition(5);
					}
				}else{
					//LevelKind.UP
					edge.setPosition(i);					
				}
				
				System.out.println("Retornou o edge");
				return edge;
			}
		}
		return null;
	}

	private void fillCorners(/*int curPair*/){
		corners.clear();
		
//TODO  corner1, corner2 e corner3 poderão ser dispensados a medida que se resolvem os pares (cada par)
//		if (curPair == 1){
		CornerPiece corner1 = new CornerPiece(cube.getWhiteSide().getMatrix()[0][0],
											  cube.getRedSide().getMatrix()[2][2],
											  cube.getGreenSide().getMatrix()[2][0]);
//TODO	passar a tratar so quatro quinas depois
//		if (corner1.isValidToF2L()){ 
		corner1.setType(LevelKind.BOTTOM);
		corners.add(corner1);
//		}
//		}
		
		CornerPiece corner2 = new CornerPiece(cube.getWhiteSide().getMatrix()[0][2],
											  cube.getGreenSide().getMatrix()[2][2],
											  cube.getOrangeSide().getMatrix()[2][0]);
//		if (corner2.isValidToF2L()){
		corner2.setType(LevelKind.BOTTOM);
		corners.add(corner2);
//		}
		
		CornerPiece corner3 = new CornerPiece(cube.getWhiteSide().getMatrix()[2][2],
											  cube.getOrangeSide().getMatrix()[2][2],
											  cube.getBlueSide().getMatrix()[2][0]);
//		if (corner3.isValidToF2L()){
		corner3.setType(LevelKind.BOTTOM);
		corners.add(corner3);
//		}
		
		CornerPiece corner4 = new CornerPiece(cube.getWhiteSide().getMatrix()[2][0],
											  cube.getBlueSide().getMatrix()[2][2],
											  cube.getRedSide().getMatrix()[2][0]);
//		if (corner4.isValidToF2L()){
		corner4.setType(LevelKind.BOTTOM);
		corners.add(corner4);
//		} 
		
		CornerPiece corner5 = new CornerPiece(cube.getYellowSide().getMatrix()[0][0],
											  cube.getRedSide().getMatrix()[0][0],
											  cube.getBlueSide().getMatrix()[0][2]);
//		if (corner5.isValidToF2L()){
		corner5.setType(LevelKind.UP);
		corners.add(corner5);
//		}
		
		CornerPiece corner6 = new CornerPiece(cube.getYellowSide().getMatrix()[0][2],
											  cube.getBlueSide().getMatrix()[0][0],							  
											  cube.getOrangeSide().getMatrix()[0][2]);
//		if (corner6.isValidToF2L()){
		corner6.setType(LevelKind.UP);
		corners.add(corner6);
//		}
		
		CornerPiece corner7 = new CornerPiece(cube.getYellowSide().getMatrix()[2][2],
											  cube.getOrangeSide().getMatrix()[0][0],
											  cube.getGreenSide().getMatrix()[0][2]);
//		if (corner7.isValidToF2L()){
		corner7.setType(LevelKind.UP);
		corners.add(corner7);
//		}
		
		CornerPiece corner8 = new CornerPiece(cube.getYellowSide().getMatrix()[2][0],
											  cube.getGreenSide().getMatrix()[0][0],
											  cube.getRedSide().getMatrix()[0][2]);
//		if (corner8.isValidToF2L()){
		corner8.setType(LevelKind.UP);
		corners.add(corner8);
//		}
	}
	
	private void fillEdges(){
		edges.clear();
		
		EdgePiece edge1 = new EdgePiece(cube.getGreenSide().getMatrix()[1][0],
										cube.getRedSide().getMatrix()[1][2]);
		
//TODO	passar a tratar so quatro meios depois		
//		if (edge1.isValidToF2L()){
		edge1.setType(LevelKind.BOTTOM);
		edges.add(edge1);
//		}
		
		EdgePiece edge2 = new EdgePiece(cube.getOrangeSide().getMatrix()[1][0],
										cube.getGreenSide().getMatrix()[1][2]);
							
//		if (edge2.isValidToF2L()){
		edge2.setType(LevelKind.BOTTOM);
		edges.add(edge2);
//		}
		
		EdgePiece edge3 = new EdgePiece(cube.getBlueSide().getMatrix()[1][0],
										cube.getOrangeSide().getMatrix()[1][2]);
		
//		if (edge3.isValidToF2L()){
		edge3.setType(LevelKind.BOTTOM);
		edges.add(edge3);
//		}
		
		EdgePiece edge4 = new EdgePiece(cube.getRedSide().getMatrix()[1][0],
										cube.getBlueSide().getMatrix()[1][2]);
		
//		if (edge4.isValidToF2L()){
		edge4.setType(LevelKind.BOTTOM);
		edges.add(edge4);
//		}
		
		EdgePiece edge5 = new EdgePiece(cube.getYellowSide().getMatrix()[0][1],
										cube.getBlueSide().getMatrix()[0][1]);
		
//		if(edge5.isValidToF2L()){
		edge5.setType(LevelKind.UP);
		edges.add(edge5);
//		}
		
		EdgePiece edge6 = new EdgePiece(cube.getYellowSide().getMatrix()[1][2],
										cube.getOrangeSide().getMatrix()[0][1]);
		
//		if(edge6.isValidToF2L()){
		edge6.setType(LevelKind.UP);
		edges.add(edge6);
//		}
		
		EdgePiece edge7 = new EdgePiece(cube.getYellowSide().getMatrix()[2][1],
										cube.getGreenSide().getMatrix()[0][1]);
//		if(edge7.isValidToF2L()){
		edge7.setType(LevelKind.UP);
		edges.add(edge7);
//		}
		
		EdgePiece edge8 = new EdgePiece(cube.getYellowSide().getMatrix()[1][0],
										cube.getRedSide().getMatrix()[0][1]);
//		if(edge8.isValidToF2L()){
		edge8.setType(LevelKind.UP);
		edges.add(edge8);
//		}
	}
	
	private void solveF2LPair(CornerPiece corner, EdgePiece edge){
		
		System.out.println("Hello Felas!\ncornerPos: "+corner.getPosition()+"\nedgePos: "+edge.getPosition());
		
		
		if ( (corner.getPosition() == 8 && edge.getPosition() == 7) &&
				(corner.getColorH().equals(edge.getColor1())) ){
			cube.up(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.frontInv(cube.getGreenSide());
			solution += "U F U' F'";
		}
		
	}	
	
/*	private void fillAvailableCorners() {
		availableCorners.add(CornerPlace.ONE);
		availableCorners.add(CornerPlace.TWO);
		availableCorners.add(CornerPlace.THREE);
		availableCorners.add(CornerPlace.FOUR);
		availableCorners.add(CornerPlace.FIVE);
		availableCorners.add(CornerPlace.SIX);
		availableCorners.add(CornerPlace.SEVEN);
		availableCorners.add(CornerPlace.EIGHT);
	}*/

}
