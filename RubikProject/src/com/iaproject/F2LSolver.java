package com.iaproject;

import java.util.ArrayList;

public class F2LSolver {
	
	private RubikCube cube;
	private String solution;
	private ArrayList<CornerPiece> corners;
	private ArrayList<EdgePiece> edges;
	
	private final int FIRST_PAIR = 1; // Green and Red
	private final int SECOND_PAIR = 2; // Green and Orange
	private final int THIRD_PAIR = 3; // Orange and Blue
	private final int FOURTH_PAIR = 4; // Blue and Red
	
	public F2LSolver(RubikCube cube, String solution) {
		this.cube = cube;
		this.solution = solution;
		this.corners = new ArrayList<CornerPiece>();
		this.edges = new ArrayList<EdgePiece>();
	}

	public String getSolution(){
		return solution;
	}
	
	public void solveFirstTwoLayers() {
		int pairNumber = 1;
		
		while (pairNumber <= 4){
			
			solveCorner(pairNumber);
			pairNumber++;
			
//			System.out.println("====== CUBE ======");
//			System.out.println(cube.toString());
//			System.out.println("====== ==== ======");
		}
	}
	
	private void solveCorner(int curPair) {
		CornerPiece corner;
		EdgePiece edge;
		
		switch (curPair) {
		
			case FIRST_PAIR:
				fillCorners();
				corner = correctFirstCorner();
				fillEdges();
				edge = correctFirstEdge();
				solveF2LPair(corner, edge);
				break;
				
			case SECOND_PAIR:
				fillCorners();
				corner = correctSecondCorner();
				fillEdges();
				edge = correctSecondEdge();
				solveF2LPair(corner, edge);
				break;
				
			case THIRD_PAIR:
				fillCorners();
				corner = correctThirdCorner();
				fillEdges();
				edge = correctThirdEdge();
				solveF2LPair(corner, edge);
				break;
				
			case FOURTH_PAIR:
				fillCorners();
				corner = correctFourthCorner();
				fillEdges();
				edge = correctFourthEdge();
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
				System.out.println("Retornou o corner1");
				return corner;
			}
		}
		return null;
	}
	
	private CornerPiece correctSecondCorner() {
		int i = 0;
		for (CornerPiece corner : corners){
			i++;
			if (corner.isThatCorner("w", "o", "g")){
				
				System.out.println("\nPosition of Second Corner before correction: " + i);
				if (corner.getType() == LevelKind.UP){
					if (i == 5){
						cube.up(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "U U ";
					}else if (i == 6){
						cube.up(cube.getGreenSide());
						solution += "U ";
					}else if (i == 8){
						cube.upInv(cube.getGreenSide());
						solution += "U' ";
					}
					corner.setPosition(7);
					System.out.println("\nPosition of Second Corner after correction: 7");
					
				}else{ //LevelKind.BOTTOM
					if (i == 2){ // OK
						corner.setPosition(2);
						System.out.println("\nPosition of Second Corner after correction: 2");
					}else if(i == 3){
						cube.rightInv(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						cube.right(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "R' U' R U U ";
						corner.setPosition(7);
						
						corner.setType(LevelKind.UP);
						corner.setColorH(cube.getYellowSide().getMatrix()[2][2]);
						corner.setColorL(cube.getGreenSide().getMatrix()[0][2]);
						corner.setColorR(cube.getOrangeSide().getMatrix()[0][0]);
						
						System.out.println("\nPosition of Second Corner after correction: 7");
					}else{ //i == 4
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "L U L' U ";
						corner.setPosition(7);
						
						corner.setType(LevelKind.UP);
						corner.setColorH(cube.getYellowSide().getMatrix()[2][2]);
						corner.setColorL(cube.getGreenSide().getMatrix()[0][2]);
						corner.setColorR(cube.getOrangeSide().getMatrix()[0][0]);
						
						System.out.println("\nPosition of Second Corner after correction: 7");
					}
				}
				System.out.println("Retornou o corner2");
				return corner;
			}
		}
		return null;
	}
	
	private CornerPiece correctThirdCorner() {
		int i = 0;
		for (CornerPiece corner : corners){
			i++;
			if (corner.isThatCorner("w", "b", "o")){
				
				System.out.println("\nPosition of Third Corner before correction: " + i);
				if (corner.getType() == LevelKind.UP){
					if (i == 5){
						cube.up(cube.getGreenSide());
						solution += "U ";
					}else if (i == 7){
						cube.upInv(cube.getGreenSide());
						solution += "U' ";
					}else if (i == 8){
						cube.up(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "U U ";						
					}
					corner.setPosition(6);
					System.out.println("\nPosition of Third Corner after correction: 6");
					
				}else{ //LevelKind.BOTTOM
					if(i == 3){ // OK
						corner.setPosition(3);
						System.out.println("\nPosition of Third Corner after correction: 3");

					}else{ //i == 4
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						solution += "L U L' ";
						corner.setPosition(6);
						
						corner.setType(LevelKind.UP);
						corner.setColorH(cube.getYellowSide().getMatrix()[0][2]);
						corner.setColorL(cube.getOrangeSide().getMatrix()[0][2]);
						corner.setColorR(cube.getBlueSide().getMatrix()[0][0]);
						
						System.out.println("\nPosition of Third Corner after correction: 6");
					}
				}
				System.out.println("Retornou o corner3");
				return corner;
			}
		}
		return null;
	}
	
	private CornerPiece correctFourthCorner() {
		int i = 0;
		for (CornerPiece corner : corners){
			i++;
			if (corner.isThatCorner("w", "r", "b")){
				
				System.out.println("\nPosition of Fourth Corner before correction: " + i);
				if (corner.getType() == LevelKind.UP){
					if (i == 6){
						cube.upInv(cube.getGreenSide());
						solution += "U' ";
					}else if (i == 7){
						cube.up(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "U U ";
						
					}else if (i == 8){
						cube.up(cube.getGreenSide());
						solution += "U ";
					}
					corner.setPosition(5);
					System.out.println("\nPosition of Fourth Corner after correction: 5");
					
				}else{ //LevelKind.BOTTOM Only remains the correct place
					corner.setPosition(4);
					System.out.println("\nPosition of Fourth Corner after correction: 4");
				}
				System.out.println("Retornou o corner4");
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
						solution += "R U R' U' ";
						System.out.println("\nPositions of First Edge after correction: 6");
						
						edge.setPosition(6);
						edge.setType(LevelKind.UP);
						edge.setColor1(cube.getYellowSide().getMatrix()[1][2]);
						edge.setColor2(cube.getOrangeSide().getMatrix()[0][1]);
						
					}else if(i == 3){
						cube.rightInv(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.right(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						solution += "R' U R U' ";
						System.out.println("\nPositions of First Edge after correction: 6");
						
						edge.setPosition(6);
						//TODO
						
						
					}else{
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						solution += "L U L' ";
						System.out.println("\nPositions of First Edge after correction: 5");
						
						edge.setPosition(5);
						//TODO
					}
				}else{
					//LevelKind.UP
					System.out.println("\nPositions of First Edge after correction: " + i);
					edge.setPosition(i);					
				}
				
				System.out.println("Retornou o edge1\n");
				return edge;
			}
		}
		return null;
	}
	
	private EdgePiece correctSecondEdge() {
		int i = 0;
		for (EdgePiece edge : edges){
			i++;
			if (edge.isThatEdge("g", "o")){
				System.out.println("\nPositions of Second Edge before correction: " + i);
				if (edge.getType() == LevelKind.BOTTOM && i != 2){
					if (i == 1){// Already Done
					}else if(i == 2){// Correct Place
						System.out.println("\nPositions of Second Edge after correction: 2");
						edge.setPosition(2);
					}else if(i == 3){
						cube.rightInv(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						cube.right(cube.getGreenSide());
						solution += "R' U' R ";
						System.out.println("\nPositions of Second Edge after correction: 5");
						edge.setPosition(5);
					}else{ //(i == 4)
						cube.left(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						solution += "L U' L' U ";
						System.out.println("\nPositions of Second Edge after correction: 8");
						edge.setPosition(8);
					}
				}else{
					//LevelKind.UP
					System.out.println("\nPositions of Second Edge after correction: " + i);
					edge.setPosition(i);					
				}
				
				System.out.println("Retornou o edge2\n");
				return edge;
			}
		}
		return null;
	}
	
	private EdgePiece correctThirdEdge() {
		int i = 0;
		for (EdgePiece edge : edges){
			i++;
			if (edge.isThatEdge("o", "b")){
				System.out.println("\nPositions of Third Edge before correction: " + i);
				if (edge.getType() == LevelKind.BOTTOM && i != 3){
					if (i == 1){// Already Done
					}else if(i == 2){// Already Done
					}else if(i == 3){// Already Done
						System.out.println("\nPositions of Third Edge after correction: 3");
						edge.setPosition(3);
					}else{ //(i == 4)
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						cube.upInv(cube.getGreenSide());
						solution += "L U L' U' ";
						System.out.println("\nPositions of Third Edge after correction: 8");
						edge.setPosition(8);
						edge.setType(LevelKind.UP);
					}
				}else{
					//LevelKind.UP
					System.out.println("\nPositions of Third Edge after correction: " + i);
					edge.setPosition(i);					
				}
				
				System.out.println("Retornou o edge3\n");
				return edge;
			}
		}
		return null;
	}
	
	private EdgePiece correctFourthEdge(/*receive the corner pair*/) {
		int i = 0;
		for (EdgePiece edge : edges){
			i++;
			if (edge.isThatEdge("b", "r")){
				System.out.println("\nPositions of Third Edge before correction: " + i);
				//LevelKind.BOTTOM - only remains the correct place
				//LevelKind.UP - all UP places is correct except when the corner is already correct (pos 4)
				System.out.println("\nPositions of Third Edge after correction: " + i);
				edge.setPosition(i);					
				
				System.out.println("Retornou o edge4\n");
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
		System.out.println("Finding The F2L Case!\ncornerPos: "+corner.getPosition()+"\nedgePos: "+edge.getPosition());
//		System.out.println("CornerH: " +corner.getColorH());
//		System.out.println("EdgeL: " + edge.getColor2());		
		
		// CASE F2L 1 - First Pair of that scrambe
		if ( (corner.getPosition() == 8 && edge.getPosition() == 7) && // Seeing the Position
			 (corner.getColorH().equals(edge.getColor1())) ){		   // Comparing orientation the Orientation    
			cube.up(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.frontInv(cube.getGreenSide());
			solution += "U F U' F' \\ ";
		}
		
		// CASE F2L 17 - Second Pair of that scramble
		if ( (corner.getPosition() == 7 && edge.getPosition() == 6) &&
			 (corner.getColorH().equals("w")) && (corner.getColorL().equals(edge.getColor2())) ){
			cube.right(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.rightInv(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.right(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.rightInv(cube.getGreenSide());
			solution += "R U U R' U' R U R' \\ ";
		}
		
		// CASE F2L 33 - Third Pair of that scramble
		if ( (corner.getPosition() == 6 && edge.getPosition() == 3) &&
			 (corner.getColorH().equals(edge.getColor2())) ){			
			cube.upInv(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.backInv(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.backInv(cube.getGreenSide());
			
			solution += "U' B U' B' U U B U' B' \\ ";
		}
		
		// CASE F2L 11 - Fourth Pair of that scramble
		if ( (corner.getPosition() == 5 && edge.getPosition() == 8) &&
			 (corner.getColorH().equals(edge.getColor2())) ) {
			cube.back(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.backInv(cube.getGreenSide());
			
			solution += "B U U B B U' B B U' B' \\ ";
		}
	}	
}
