package com.iaproject;

public class Main {

	public static void main(String[] args) {
		
//		TODO TIRAR o U e U' dos possiblesMOVEs na cruz		

//		RubikCube cube = Utils.shuffleCube("R2 U F2 B2 R' D2 L' B L R' F' D U R' U B D2 B' F2 L' F2 R2 L2 F B"); //Complete Solve (Directed)
		RubikCube cube = Utils.shuffleCube("R2 U F2 B2 R' D2 L' B L R' F' D U R' U B D2 B' F2 L' F2 R2 L2 F B");
				
		System.out.println("====== SHUFFLED CUBE ======");
		System.out.println(cube.toString());
		System.out.println("===========================");
		
		CrossSolver stepOne = new CrossSolver(cube);
		stepOne.solveCross();
		System.out.println("\n" + "Cross Solved: " + stepOne.getSolution());		
		
		F2LSolver stepTwo = new F2LSolver(cube, stepOne.getSolution() + "- ");
		stepTwo.solveFirstTwoLayers();
		
		OLLSolver stepThree = new OLLSolver(cube, stepTwo.getSolution().subSequence(0, stepTwo.getSolution().length() - 2) + "- ");
		stepThree.solveOLL();
		
		PLLSolver stepFour = new PLLSolver(cube, stepThree.getSolution() + "- ");
		stepFour.solvePLL();
		
		System.out.println("====== SOLVED CUBE ======");
		System.out.println(cube.toString());
		System.out.println("===========================");
		
//		System.out.println("\n" + "Cross Solved: " + stepOne.getSolution());
//		System.out.println("\n" + "F2L Solved: " + stepTwo.getSolution());
//		System.out.println("\n" + "OLL Solved: " + stepThree.getSolution());
		System.out.println("\n" + "PLL Solved: " + stepFour.getSolution());
	}
}