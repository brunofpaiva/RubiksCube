package com.iaproject;

import java.util.ArrayList;

public class CrossSolver {
	
	RubikCube cube;
	String solution;
	Move impossibleMove;
	ArrayList<Move> possibleMoves;
	
	RubikCube cubeCopy;
	
	public CrossSolver(RubikCube cube){
		this.cube = cube;
		this.solution = "";
		this.impossibleMove = Move.NoMove;
		this.possibleMoves = new ArrayList<Move>();
		fillPossibleMoves();		
		
		this.cubeCopy = cube.copy();
	}
	
	public String getSolution(){
		return solution;
	}
	
	/**
	 * Always solve a white cross 
	 */
	public void solveCross(){
//		int count = 0;
		Move nextMove = Move.NoMove;
		
		while (!isCrossComplete()){
			
			System.out.println("\nPossible Moves: ");
			for (Move m : possibleMoves){
				System.out.println("- " + m);
			}
			
			nextMove = verifyNextCrossMove();
			if (impossibleMove != Move.NoMove)
				possibleMoves.add(impossibleMove);
			
			switch (nextMove){
				case R: solution += "R ";
						possibleMoves.remove(Move.Rinv);
						impossibleMove = Move.Rinv;
						break;
				case L:	solution += "L ";
						possibleMoves.remove(Move.Linv);
						impossibleMove = Move.Linv;
						break;
				case U:	solution += "U ";
						possibleMoves.remove(Move.Uinv);
						impossibleMove = Move.Uinv;
						break;
				case D:	solution += "D ";
						possibleMoves.remove(Move.Dinv);
						impossibleMove = Move.Dinv;
						break;
				case F:solution += "F ";
						possibleMoves.remove(Move.Finv);
						impossibleMove = Move.Finv;
						break;
				case B: solution += "B ";
						possibleMoves.remove(Move.Binv);
						impossibleMove = Move.Binv;
						break;
				case Rinv: solution += "R' ";
						possibleMoves.remove(Move.R);
						impossibleMove = Move.R;
						break;
				case Linv: solution += "L' ";
						possibleMoves.remove(Move.L);
						impossibleMove = Move.L;
						break;
				case Uinv: solution += "U' ";
						possibleMoves.remove(Move.U);
						impossibleMove = Move.U;
						break;
				case Dinv: solution += "D' ";
						possibleMoves.remove(Move.D);
						impossibleMove = Move.D;
						break;
				case Finv: solution += "F' ";
						possibleMoves.remove(Move.F);
						impossibleMove = Move.F;
						break;
				case Binv: solution += "B' ";
						possibleMoves.remove(Move.B);
						impossibleMove = Move.B;
						break;
				case NoMove: 

						if (impossibleMove != Move.D){
						// Forced Down Move
							System.out.println("MOVE NOT FOUND - Forced MOVE - D");
							cubeCopy.down(cubeCopy.getGreenSide());
							solution += "D ";
							this.cube.down(this.cube.getGreenSide());
							
							possibleMoves.remove(Move.Dinv);
							impossibleMove = Move.Dinv;
							
						}else{
						// Forced Down Move
							System.out.println("MOVE NOT FOUND - Forced MOVE - D'");
							cubeCopy.downInv(cubeCopy.getGreenSide());
							solution += "D' ";
							this.cube.downInv(this.cube.getGreenSide());
							
							possibleMoves.remove(Move.D);
							impossibleMove = Move.D;
						}

						break;
				default:
					break;
			}					
			
//			count++;
//			
//			System.out.println("====== COPY ======");
//			System.out.println(cubeCopy.toString());
//			System.out.println("====== ==== ======");
//			System.out.println("count: " + count);
		}
		
		completeCrossSide();
	}

	private Move verifyNextCrossMove(){
		System.out.println("\n");
		for (Move m : possibleMoves){
			
			if (m == Move.R && m != impossibleMove){
				System.out.println("testing: MOVE - R");
				cubeCopy.right(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.right(this.cube.getGreenSide());
					return Move.R;
				}else{
					cubeCopy.rightInv(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.L && m != impossibleMove){
				System.out.println("testing: MOVE - L");
				cubeCopy.left(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.left(this.cube.getGreenSide());
					return Move.L;
				}else{
					cubeCopy.leftInv(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.U && m != impossibleMove){
				System.out.println("testing: MOVE - U");
				cubeCopy.up(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.up(this.cube.getGreenSide());
					return Move.U;
				}else{
					cubeCopy.upInv(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.D && m != impossibleMove){
				System.out.println("testing: MOVE - D");
				cubeCopy.down(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.down(this.cube.getGreenSide());
					return Move.D;
				}else{
					cubeCopy.downInv(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.F && m != impossibleMove){
				System.out.println("testing: MOVE - F");
				cubeCopy.front(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.front(this.cube.getGreenSide());
					return Move.F;
				}else{
					cubeCopy.frontInv(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.B && m != impossibleMove){
				System.out.println("testing: MOVE - B");
				cubeCopy.back(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.back(this.cube.getGreenSide());
					return Move.B;
				}else{
					cubeCopy.backInv(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.Rinv && m != impossibleMove){
				System.out.println("testing: MOVE - R'");
				cubeCopy.rightInv(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.rightInv(this.cube.getGreenSide());
					return Move.Rinv;
				}else{
					cubeCopy.right(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.Linv && m != impossibleMove){
				System.out.println("testing: MOVE - L'");
				cubeCopy.leftInv(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.leftInv(this.cube.getGreenSide());
					return Move.Linv;
				}else{
					cubeCopy.left(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.Uinv && m != impossibleMove){
				System.out.println("testing: MOVE - U'");
				cubeCopy.upInv(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.upInv(this.cube.getGreenSide());
					return Move.Uinv;
				}else{
					cubeCopy.up(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.Dinv && m != impossibleMove){
				System.out.println("testing: MOVE - D'");
				cubeCopy.downInv(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.downInv(this.cube.getGreenSide());
					return Move.Dinv;
				}else{
					cubeCopy.down(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.Finv && m != impossibleMove){
				System.out.println("testing: MOVE - F'");
				cubeCopy.frontInv(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.frontInv(this.cube.getGreenSide());
					return Move.Finv;
				}else{
					cubeCopy.front(cubeCopy.getGreenSide());
				}
			}
			
			if (m == Move.Binv && m != impossibleMove){
				System.out.println("testing: MOVE - B'");
				cubeCopy.backInv(cubeCopy.getGreenSide());
				if (crossHeuristic( cubeCopy ).equals(cubeCopy)){
					System.out.println("Good Move!");
					this.cube.backInv(this.cube.getGreenSide());
					return Move.Binv;
				}else{
					cubeCopy.back(cubeCopy.getGreenSide());
				}
			}
				
		}
		
		return Move.NoMove;
	}
	
	private RubikCube crossHeuristic(RubikCube cubeCopy){
		
		if (countCrossPieces( this.cube) > countCrossPieces(cubeCopy) ){
			return this.cube;
		
		}else if (countCrossPieces( this.cube) < countCrossPieces(cubeCopy) ){
			return cubeCopy;
		
		}else if (countCrossPieces( this.cube) == countCrossPieces(cubeCopy) ){
			if (countSecondLayerPieces( this.cube) < countSecondLayerPieces(cubeCopy)){
				return cubeCopy;
			}else{
				return this.cube;
			}
		}
		return cubeCopy;
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
		
		int crossSideCorrect = countCrossSidePieces(this.cube);
		
		while (crossSideCorrect < 2 && crossSideCorrect != 4){
			
			cubeCopy.downInv(cubeCopy.getGreenSide());
			this.cube.downInv(this.cube.getGreenSide());
			solution += "D' ";
			
			crossSideCorrect = countCrossSidePieces(this.cube);
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
		
		System.out.println("Case - Neighbor");
		
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
		
		System.out.println("Case - Opposite");
		
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

	private int countCrossSidePieces(RubikCube cube2) {
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
		possibleMoves.add(Move.U);
		possibleMoves.add(Move.D);
		possibleMoves.add(Move.F);
		possibleMoves.add(Move.B);
		possibleMoves.add(Move.Rinv);
		possibleMoves.add(Move.Linv);
		possibleMoves.add(Move.Uinv);
		possibleMoves.add(Move.Dinv);
		possibleMoves.add(Move.Finv);
		possibleMoves.add(Move.Binv);
	}
}
