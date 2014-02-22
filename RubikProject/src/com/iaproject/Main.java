package com.iaproject;

import com.rubikcube.RubikCube;

public class Main {

	public static void main(String[] args) {		

//		RubikCube cube = Utils.shuffleCube("R2 U F2 B2 R' D2 L' B L R' F' D U R' U B D2 B' F2 L' F2 R2 L2 F B");
//		RubikCube cube = Utils.shuffleCube("F B2 U' L' U2 R D2 R2 F' R' U2 R' B2 R B' U D F D' U L D2 U F2 B'");
//		RubikCube cube = Utils.shuffleCube("F2 R U' F' B2 U' R2 B2 F L U' F L' D' B U' L2 B' D' F' D U' F' U2 R2");
//		RubikCube cube = Utils.shuffleCube("R B R D U2 B2 D2 L2 B' L2 U' F2 D' B' D2 L2 D2 B2 U' F2 D B R B2 F");
//		RubikCube cube = Utils.shuffleCube("F R U B L2 R' D F D' F2 L B' D' L2 R2 D' U2 L' R B2 L' R B' R' D");
//		RubikCube cube = Utils.shuffleCube("F' U2 D' R' D' B U' B L F2 B2 U' B U' D' F R' L' B' R' D2 L D U' R'");
//		RubikCube cube = Utils.shuffleCube("F L' F U F B2 U L2 D U R U' B2 L R F U L B' D2 F' L' F2 B' D");
//		RubikCube cube = Utils.shuffleCube("F L2 F' D' U' B U' F' B2 L2 U F R2 L' U' D' L R B' L2 D U2 F2 D L");
//		RubikCube cube = Utils.shuffleCube("U2 R' B2 D' B2 R2 B2 D2 B' R2 U D' R' U2 L' R B' F' U2 B2 R' L F2 U2 D'");
//		RubikCube cube = Utils.shuffleCube("D' U' L R2 B' U2 R2 F2 B' L' R B' L' B' F2 D F2 L' R F' D' U' B2 F' U'");
//		RubikCube cube = Utils.shuffleCube("F' D2 U' L U' B D2 L2 D2 R2 U' R B2 U' F U D2 R' B U2 F' B' U F2 L2");
//		RubikCube cube = Utils.shuffleCube("D B U B2 R D U2 B D R B' D' L' R D' F' U R2 D2 R2 U D' F' B L");
//		RubikCube cube = Utils.shuffleCube("L' R2 B' L' D U2 F2 L R2 U2 L' R' D2 U' L F2 B R' D2 B2 D' F' R' D2 F'");
//		RubikCube cube = Utils.shuffleCube("B2 U B R F L2 R2 B2 R2 B2 R2 B2 L2 D' L2 D B2 U' B D' R2 L' F U L");
		RubikCube cube = Utils.shuffleCube("F U' R' B2 F' U2 B' D2 L U2 D' L U' F' R D L R B D' F2 B2 D2 F2 B'");
				
		System.out.println("====== SHUFFLED CUBE ======");
		System.out.println(cube.toString());
		System.out.println("===========================");
		
		CrossSolverIA stepOne = new CrossSolverIA(cube);
		stepOne.solveCross();
		
		System.out.println("====== SOLVED CUBE ======");
		System.out.println(cube.toString());
		System.out.println("===========================");
		
		System.out.println("\n" + "Cross Solved: " + stepOne.getSolution());
		
	}
}