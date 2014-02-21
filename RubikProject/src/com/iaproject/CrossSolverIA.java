package com.iaproject;

import java.util.ArrayList;

import com.rubikcube.RubikCube;

public class CrossSolverIA {
	
	private RubikCube cube;
	private String solution;
	private Move impossibleMove;
	private ArrayList<Move> possibleMoves;
	private int movesAvaliation[];
	private RubikCube cubeCopy;
	
	public CrossSolverIA(RubikCube cube){
		this.cube = cube;
		this.solution = "";
		this.impossibleMove = Move.NoMove;
		this.possibleMoves = new ArrayList<Move>();
		fillPossibleMoves();		
		
		this.movesAvaliation = new int[12];
		this.cubeCopy = cube.copy();
	}
	
	public String getSolution(){
		return solution;
	}
	
	/**
	 * Always solve a white cross 
	 */
	public void solveCross(){
		Move nextMove = Move.NoMove;
		
		while (!isCrossComplete()){
			
			System.out.println("\nPossible Moves: ");
			for (Move m : possibleMoves){
				System.out.println("- " + m);
			}
			
			nextMove = getBestMove();
			if (impossibleMove != Move.NoMove)
				possibleMoves.add(impossibleMove);
			
			switch (nextMove){
				case R: solution += "R ";
						possibleMoves.remove(Move.Rinv);
						impossibleMove = Move.Rinv;
						cube.right(cube.getGreenSide());
						cubeCopy.right(cubeCopy.getGreenSide());
						break;
				case L:	solution += "L ";
						possibleMoves.remove(Move.Linv);
						impossibleMove = Move.Linv;
						cube.left(cube.getGreenSide());
						cubeCopy.left(cubeCopy.getGreenSide());
						break;
				case U:	solution += "U ";
						possibleMoves.remove(Move.Uinv);
						impossibleMove = Move.Uinv;
						cube.up(cube.getGreenSide());
						cubeCopy.up(cubeCopy.getGreenSide());
						break;
				case D:	solution += "D ";
						possibleMoves.remove(Move.Dinv);
						impossibleMove = Move.Dinv;
						cube.down(cube.getGreenSide());
						cubeCopy.down(cubeCopy.getGreenSide());
						break;
				case F:solution += "F ";
						possibleMoves.remove(Move.Finv);
						impossibleMove = Move.Finv;
						cube.front(cube.getGreenSide());
						cubeCopy.front(cubeCopy.getGreenSide());
						break;
				case B: solution += "B ";
						possibleMoves.remove(Move.Binv);
						impossibleMove = Move.Binv;
						cube.back(cube.getGreenSide());
						cubeCopy.back(cubeCopy.getGreenSide());
						break;
				case Rinv: solution += "R' ";
						possibleMoves.remove(Move.R);
						impossibleMove = Move.R;
						cube.rightInv(cube.getGreenSide());
						cubeCopy.rightInv(cubeCopy.getGreenSide());
						break;
				case Linv: solution += "L' ";
						possibleMoves.remove(Move.L);
						impossibleMove = Move.L;
						cube.leftInv(cube.getGreenSide());
						cubeCopy.leftInv(cubeCopy.getGreenSide());
						break;
				case Uinv: solution += "U' ";
						possibleMoves.remove(Move.U);
						impossibleMove = Move.U;
						cube.upInv(cube.getGreenSide());
						cubeCopy.upInv(cubeCopy.getGreenSide());
						break;
				case Dinv: solution += "D' ";
						possibleMoves.remove(Move.D);
						impossibleMove = Move.D;
						cube.downInv(cube.getGreenSide());
						cubeCopy.downInv(cubeCopy.getGreenSide());
						break;
				case Finv: solution += "F' ";
						possibleMoves.remove(Move.F);
						impossibleMove = Move.F;
						cube.frontInv(cube.getGreenSide());
						cubeCopy.frontInv(cubeCopy.getGreenSide());
						break;
				case Binv: solution += "B' ";
						possibleMoves.remove(Move.B);
						impossibleMove = Move.B;
						cube.backInv(cube.getGreenSide());
						cubeCopy.backInv(cubeCopy.getGreenSide());
						break;
				case NoMove: 
						if (impossibleMove != Move.D){
							System.out.println("MOVE NOT FOUND - Forced MOVE - D");
							cubeCopy.down(cubeCopy.getGreenSide());
							this.cube.down(this.cube.getGreenSide());
							solution += "D ";
							
							possibleMoves.remove(Move.Dinv);
							impossibleMove = Move.Dinv;							
						}else{
							System.out.println("MOVE NOT FOUND - Forced MOVE - D'");
							cubeCopy.downInv(cubeCopy.getGreenSide());
							this.cube.downInv(this.cube.getGreenSide());
							solution += "D' ";
							
							possibleMoves.remove(Move.D);
							impossibleMove = Move.D;
						}
						break;
				default:
					if (impossibleMove != Move.D){
						System.out.println("MOVE NOT FOUND - Forced MOVE - D");
						cubeCopy.down(cubeCopy.getGreenSide());
						this.cube.down(this.cube.getGreenSide());
						solution += "D ";
						
						possibleMoves.remove(Move.Dinv);
						impossibleMove = Move.Dinv;							
					}else{
						System.out.println("MOVE NOT FOUND - Forced MOVE - D'");
						cubeCopy.downInv(cubeCopy.getGreenSide());
						this.cube.downInv(this.cube.getGreenSide());
						solution += "D' ";
						
						possibleMoves.remove(Move.D);
						impossibleMove = Move.D;
					}
					break;
			}
		}
		
		completeCrossSide();
	}

	private void evaluateMoves(){
		System.out.println("\n");
		for (Move m : possibleMoves){
			
			if (m == Move.R && m != impossibleMove){
				System.out.println("evaluating: MOVE - R");
				cubeCopy.right(cubeCopy.getGreenSide());
				movesAvaliation[0] = iaCrossHeuristic(cubeCopy);
				cubeCopy.rightInv(cubeCopy.getGreenSide());
			}
			
			if (m == Move.L && m != impossibleMove){
				System.out.println("evaluating: MOVE - L");
				cubeCopy.left(cubeCopy.getGreenSide());
				movesAvaliation[1] = iaCrossHeuristic(cubeCopy);
				cubeCopy.leftInv(cubeCopy.getGreenSide());
			}
			
			if (m == Move.U && m != impossibleMove){
				System.out.println("evaluating: MOVE - U");
				cubeCopy.up(cubeCopy.getGreenSide());
				movesAvaliation[2] = iaCrossHeuristic(cubeCopy);
				cubeCopy.upInv(cubeCopy.getGreenSide());
			}
			
			if (m == Move.D && m != impossibleMove){
				System.out.println("evaluating: MOVE - D");
				cubeCopy.down(cubeCopy.getGreenSide());
				movesAvaliation[3] = iaCrossHeuristic(cubeCopy);
				cubeCopy.downInv(cubeCopy.getGreenSide());
			}
			
			if (m == Move.F && m != impossibleMove){
				System.out.println("evaluating: MOVE - F");
				cubeCopy.front(cubeCopy.getGreenSide());
				movesAvaliation[4] = iaCrossHeuristic(cubeCopy);
				cubeCopy.frontInv(cubeCopy.getGreenSide());
			}
			
			if (m == Move.B && m != impossibleMove){
				System.out.println("evaluating: MOVE - B");
				cubeCopy.back(cubeCopy.getGreenSide());
				movesAvaliation[5] = iaCrossHeuristic(cubeCopy);
				cubeCopy.backInv(cubeCopy.getGreenSide());
			}
			
			if (m == Move.Rinv && m != impossibleMove){
				System.out.println("evaluating: MOVE - R'");
				cubeCopy.rightInv(cubeCopy.getGreenSide());
				movesAvaliation[6] = iaCrossHeuristic(cubeCopy);
				cubeCopy.right(cubeCopy.getGreenSide());
			}
			
			if (m == Move.Linv && m != impossibleMove){
				System.out.println("evaluating: MOVE - L'");
				cubeCopy.leftInv(cubeCopy.getGreenSide());
				movesAvaliation[7] = iaCrossHeuristic(cubeCopy);
				cubeCopy.left(cubeCopy.getGreenSide());
			}
			
			if (m == Move.Uinv && m != impossibleMove){
				System.out.println("evaluating: MOVE - U'");
				cubeCopy.upInv(cubeCopy.getGreenSide());
				movesAvaliation[8] = iaCrossHeuristic(cubeCopy);
				cubeCopy.up(cubeCopy.getGreenSide());
			}
			
			if (m == Move.Dinv && m != impossibleMove){
				System.out.println("evaluating: MOVE - D'");
				cubeCopy.downInv(cubeCopy.getGreenSide());
				movesAvaliation[9] = iaCrossHeuristic(cubeCopy);
				cubeCopy.down(cubeCopy.getGreenSide());
			}
			
			if (m == Move.Finv && m != impossibleMove){
				System.out.println("evaluating: MOVE - F'");
				cubeCopy.frontInv(cubeCopy.getGreenSide());
				movesAvaliation[10] = iaCrossHeuristic(cubeCopy);
				cubeCopy.front(cubeCopy.getGreenSide());
			}
			
			if (m == Move.Binv && m != impossibleMove){
				System.out.println("evaluating: MOVE - B'");
				cubeCopy.backInv(cubeCopy.getGreenSide());
				movesAvaliation[11] = iaCrossHeuristic(cubeCopy);
				cubeCopy.back(cubeCopy.getGreenSide());
			}
		}
	}
	
	private int iaCrossHeuristic(RubikCube cube) {
		int value = 0;
		if (countCrossPieces( this.cube) > countCrossPieces(cubeCopy) ){// removed 1 peace of the cross
			return -1;
		
		}else if (countCrossPieces( this.cube) < countCrossPieces(cubeCopy) ){// added 1 peace at the cross
			if (countSecondLayerPieces( this.cube) < countSecondLayerPieces(cubeCopy)){// added 1 peace at the secondLayer
				return 3;
			}else{// added 0 peace at the secondLayer
				return 2;
			}
		
		}else if (countCrossPieces( this.cube) == countCrossPieces(cubeCopy) ){// traded 1 peace at the cross for other peace of cross
			if (countSecondLayerPieces( this.cube) < countSecondLayerPieces(cubeCopy)){// added 1 peace to the second layer
				return 1;
			}else{// added 0 peace to the second layer
				return 0;
			}
		}
		return value;
	}
	
	private Move getBestMove() {
		evaluateMoves();
		
		int maxValue = -1;
		int index = 0;
		for (int i = 0; i < movesAvaliation.length; i++){
			System.out.println("Avaliação | " + i + " | " + movesAvaliation[i]);
			if (movesAvaliation[i] > maxValue){
				maxValue = movesAvaliation[i];
				index = i;
			}
		}
		
		switch(index){
			case 0: return Move.R;
			case 1: return Move.L;
			case 2: return Move.U;
			case 3: return Move.D;
			case 4: return Move.F;
			case 5: return Move.B;
			case 6: return Move.Rinv;
			case 7: return Move.Linv;
			case 8: return Move.Uinv;
			case 9: return Move.Dinv;
			case 10: return Move.Finv;
			case 11: return Move.Binv;
			default: return Move.NoMove;
		}
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
		if (cube.getRedSide().getMatrix()[1][0].equals("w") )
			count++;
		if (cube.getRedSide().getMatrix()[1][2].equals("w") )
			count++;
		if (cube.getOrangeSide().getMatrix()[1][0].equals("w") )
			count++;
		if (cube.getOrangeSide().getMatrix()[1][2].equals("w") )
			count++;
		
		return count;
	}
	
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
	
	/**
	 * 	This method initiates the correction of the cross Side Peaces
	 * 
	 * The Logic:
	 * 		If the current cube not have at least 2 cross peaces at your correct place
	 * execute a D' move until it have two correct cross peaces. After that call the  
	 * VerifyCrossSideCase() method to recognize the case and go on.
	 * 
	 * 		If it already have the four
	 * peaces that's ok - proceede with the solve 
	 */
	private void completeCrossSide(){
		
		int crossSideCorrect = countCrossSidePieces();
		
		while (crossSideCorrect < 2 && crossSideCorrect != 4){
			
			cubeCopy.downInv(cubeCopy.getGreenSide());
			this.cube.downInv(this.cube.getGreenSide());
			solution += "D' ";
			
			crossSideCorrect = countCrossSidePieces();
		}
		
		if (crossSideCorrect == 2)
			verifyCrossSideCase();
	}
	
	/**
	 * This method identifies the exactly case with just two correct cross peaces
	 * and redirect to the method of your specific case
	 */
	private void verifyCrossSideCase() {
		
		if (cube.getRedSide().getMatrix()[2][1].equals("r") && cube.getOrangeSide().getMatrix()[2][1].equals("o")){
			oppositeCrossSide("r");
		}else if (cube.getGreenSide().getMatrix()[2][1].equals("g") && cube.getBlueSide().getMatrix()[2][1].equals("b")){
			oppositeCrossSide("g");
		}else{
			neighborCrossSide();
		}
		
	}

	/**
	 * This method solve the cross if it has two neighbor wrong placed cross pieces  
	 */
	private void neighborCrossSide() {
		
		System.out.println("\nCase - Neighbor");
		
		boolean greenSide = cube.getGreenSide().getMatrix()[2][1].equals("g");//boolean that verifies if the greenSide of the cross is OK!
		boolean redSide = cube.getRedSide().getMatrix()[2][1].equals("r");//boolean that verifies if the redSide of the cross is OK!
		boolean blueSide = cube.getBlueSide().getMatrix()[2][1].equals("b");//boolean that verifies if the blueSide of the cross is OK!
		boolean orangeSide = cube.getOrangeSide().getMatrix()[2][1].equals("o");//boolean that verifies if the orangeSide of the cross is OK!
		
		if (greenSide && redSide){ //case 1
			cube.right(cube.getGreenSide());
			cube.right(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.right(cube.getGreenSide());
			cube.right(cube.getGreenSide());
			
			solution += "R R U' B B U R R ";
		} else if (orangeSide && greenSide){ //case2
			cube.back(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.left(cube.getGreenSide());
			cube.left(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			
			solution += "B B U' L L U B B ";
		} else if (blueSide && orangeSide){ //case3
			cube.left(cube.getGreenSide());
			cube.left(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.left(cube.getGreenSide());
			cube.left(cube.getGreenSide());
			
			solution += "L L U' F F U L L ";
		} else{ // redSide && blueSide - If it Needs specification
			cube.front(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			cube.upInv(cube.getGreenSide());
			cube.right(cube.getGreenSide());
			cube.right(cube.getGreenSide());
			cube.up(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			cube.front(cube.getGreenSide());
			
			solution += "F F U' R R U F F ";
		}
	}

	private void oppositeCrossSide(String face) {
		
		System.out.println("\nCase - Opposite");
		
		if(face.equals("r")){
			cube.right(cube.getGreenSide());
			cube.leftInv(cube.getGreenSide());
			cube.downInv(cube.getGreenSide());
			cube.downInv(cube.getGreenSide());
			cube.rightInv(cube.getGreenSide());
			cube.left(cube.getGreenSide());
			
			solution += "R L' D' D' R' L ";
			
		}else{
			
			cube.front(cube.getGreenSide());
			cube.backInv(cube.getGreenSide());
			cube.downInv(cube.getGreenSide());
			cube.downInv(cube.getGreenSide());
			cube.frontInv(cube.getGreenSide());
			cube.back(cube.getGreenSide());
			
			solution += "F B' D' D' F' B ";
		}
	}

	/**
	 * Count the corrected 
	 * @return
	 */
	private int countCrossSidePieces() {
		int countCrossSides = 0;
		
		if (cube.getGreenSide().getMatrix()[2][1].equals("g"))
			countCrossSides++;
		if (cube.getBlueSide().getMatrix()[2][1].equals("b"))
			countCrossSides++;
		if (cube.getRedSide().getMatrix()[2][1].equals("r"))
			countCrossSides++;
		if (cube.getOrangeSide().getMatrix()[2][1].equals("o"))
			countCrossSides++;
		
		return countCrossSides;
	}
	
	private void fillPossibleMoves(){
		possibleMoves.clear();
		possibleMoves.add(Move.R);
		possibleMoves.add(Move.L);
//		possibleMoves.add(Move.U);
		possibleMoves.add(Move.D);
		possibleMoves.add(Move.F);
		possibleMoves.add(Move.B);
		possibleMoves.add(Move.Rinv);
		possibleMoves.add(Move.Linv);
//		possibleMoves.add(Move.Uinv);
		possibleMoves.add(Move.Dinv);
		possibleMoves.add(Move.Finv);
		possibleMoves.add(Move.Binv);
	}
}
