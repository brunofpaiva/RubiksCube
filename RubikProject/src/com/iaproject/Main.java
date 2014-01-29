package com.iaproject;

public class Main {

	public static void main(String[] args) {
		
//		RubikCube cube = Utils.shuffleCube("B R2 U2 D L2 F' R' L' F2 D U2 F U B U2 D' F' R D R' F2 R' F L' U"); INFINITO!
//		RubikCube cube = Utils.shuffleCube("U2 F U' L' U B L' R' B2 U' L2 U' B' L R2 D U' L' B' R' D F L2 F' B2"); OK 5 moves
//		RubikCube cube = Utils.shuffleCube("F B U L' R' U' D L2 D' R L' U' D2 F' U' L2 D' L R B2 L D' B' L' D'"); OK 8 moves
		RubikCube cube = Utils.shuffleCube("L2 U2 L2 R2 B' L2 F L2 R2 D' L U R' D L' U' L2 D' U L' B2 U F' D U'");// OK 9 moves
//		RubikCube cube = Utils.shuffleCube("D2 F U D2 R L U' B' R2 L B L' B L R2 D2 B' U' F' U L' D2 B' R D'"); OK 8 moves
//		RubikCube cube = Utils.shuffleCube("U2 D' F B' R' L U R2 B' D2 F' L U2 R2 L' D' B' D' U2 B' L' F D L' D'"); OK 9 moves
//		RubikCube cube = Utils.shuffleCube("D F L' U' R B2 R2 U' R D' U' L F' U2 F' R' B D2 U' B' D U F2 R2 F2"); OK 8 moves
//		RubikCube cube = Utils.shuffleCube("L2 R2 B R L2 F2 B' U' L' D2 U B L2 R U D2 L2 B2 D L2 D R' U F' R2"); INFINITO!
//		RubikCube cube = Utils.shuffleCube("F' B2 L' U D' R' D2 U2 R F R L F B2 U2 L' B L' U F R2 D R' U' R2"); OK 6 moves
//		RubikCube cube = Utils.shuffleCube("F' L R' F L U2 D' B' R U2 R2 B2 L' U2 F R2 L2 B L D R2 L' U2 R2 D"); OK 6 moves
//		RubikCube cube = Utils.shuffleCube("F' L R' F L U2 D' B' R U2 R2 B2 L' U2 F R2 L2 B L D R2 L' U2 R2 D");
				
		System.out.println("======");
		System.out.println(cube.toString());
		System.out.println("======");
		
		Solver me = new Solver(cube);
		me.solveCube();
		System.out.println("\n" + me.getSolution());
		
//		System.out.println("======");
//		System.out.println(cube.toString());
//		System.out.println("======");
	}
}