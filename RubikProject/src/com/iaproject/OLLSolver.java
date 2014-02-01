package com.iaproject;

import java.util.ArrayList;

public class OLLSolver {
	
	private RubikCube cube;
	private String solution;
	private ArrayList<CornerPiece> corners;
	private ArrayList<EdgePiece> edges;
	
	public OLLSolver(RubikCube cube, String solution){
		this.cube = cube;
		this.solution = solution;
		this.corners = new ArrayList<CornerPiece>();
		this.edges = new ArrayList<EdgePiece>();
	}
	
	public String getSolution(){
		return solution;
	}
	
	public void solveOLL(){
		
		fillCorners();
		fillEdges();
		
		if (isCrossComplete()){
			solveOLLCrossCase();
		}
	}
	
	private void solveOLLCrossCase() {
		// OLL 27
		
		if(corners.get(0).getPosition() == 5 && corners.get(0).getColorL().equals("y")){
			if (corners.get(3).getPosition() == 8 && corners.get(3).getColorL().equals("y")){
				if (corners.get(2).getPosition() == 7 && corners.get(2).getColorL().equals("y")){
					if (corners.get(1).getPosition() == 6 && corners.get(1).getColorH().equals("y")){
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.left(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.up(cube.getGreenSide());
						cube.leftInv(cube.getGreenSide());
						solution += "L U L' U L U2 L' ";
					}
				}
			}
		}
		
	}

	private boolean isCrossComplete(){
		for (EdgePiece e : edges){
			if (! e.getColor1().equals("y"))
				return false;
		}
		return true;
	}
	
	private void fillCorners(){
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
