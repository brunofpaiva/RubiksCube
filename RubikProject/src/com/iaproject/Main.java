package com.iaproject;

import com.rubikcube.RubikCube;

public class Main {

	public static void main(String[] args) {		

//		RubikCube cube = Utils.shuffleCube("R2 U F2 B2 R' D2 L' B L R' F' D U R' U B D2 B' F2 L' F2 R2 L2 F B"); //Complete Solve (Directed)
//		RubikCube cube = Utils.shuffleCube("F B2 U' L' U2 R D2 R2 F' R' U2 R' B2 R B' U D F D' U L D2 U F2 B'");
		RubikCube cube = Utils.shuffleCube("F2 R U' F' B2 U' R2 B2 F L U' F L' D' B U' L2 B' D' F' D U' F' U2 R2");
				
		System.out.println("====== SHUFFLED CUBE ======");
		System.out.println(cube.toString());
		System.out.println("===========================");
		
		CrossSolverIA stepOne = new CrossSolverIA(cube);
		stepOne.solveCross();
		System.out.println("\n" + "Cross Solved: " + stepOne.getSolution());		
		
//		F2LSolver stepTwo = new F2LSolver(cube, stepOne.getSolution() + "- ");
//		stepTwo.solveFirstTwoLayers();
//		
//		OLLSolver stepThree = new OLLSolver(cube, stepTwo.getSolution().subSequence(0, stepTwo.getSolution().length() - 2) + "- ");
//		stepThree.solveOLL();
//		
//		PLLSolver stepFour = new PLLSolver(cube, stepThree.getSolution() + "- ");
//		stepFour.solvePLL();
//		
//		System.out.println("====== SOLVED CUBE ======");
//		System.out.println(cube.toString());
//		System.out.println("===========================");
//		
//		System.out.println("\n" + "Cross Solved: " + stepOne.getSolution());
//		System.out.println("\n" + "F2L Solved: " + stepTwo.getSolution());
//		System.out.println("\n" + "OLL Solved: " + stepThree.getSolution());
//		System.out.println("\n" + "PLL Solved: " + stepFour.getSolution());
	}
}