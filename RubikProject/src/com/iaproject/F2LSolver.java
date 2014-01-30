package com.iaproject;

public class F2LSolver {
	
	private RubikCube cube;
	private String solution;
	
	public F2LSolver(RubikCube cube, String solution) {
		this.cube = cube;
		this.solution = solution;
	}
	
	public String getSolution(){
		return solution;
	}
	
	public void solveFirstTwoLayers() {
		int count = 0;
		
		while (!isF2lComplete() && count < 1){

			searchValidCorner();
			
			System.out.println("====== CUBE ======");
			System.out.println(cube.toString());
			System.out.println("====== ==== ======");
			System.out.println("count: " + count);
			
			count++;
		}
	}
	
	private void searchValidCorner() {
		// TODO Auto-generated method stub
		
	}

//	private void searchingF2lCase(){
//		
//	}
	
	private boolean isF2lComplete(){
		boolean answer = true;
		
		if (!(cube.getGreenSide().getMatrix()[1][0].equals("g") &&
				cube.getGreenSide().getMatrix()[1][2].equals("g") &&
				cube.getGreenSide().getMatrix()[2][0].equals("g") &&
				cube.getGreenSide().getMatrix()[2][1].equals("g") &&
				cube.getGreenSide().getMatrix()[2][2].equals("g")))
			
			answer = false;
		
		if (!(cube.getBlueSide().getMatrix()[1][0].equals("b") &&
				cube.getBlueSide().getMatrix()[1][2].equals("b") &&
				cube.getBlueSide().getMatrix()[2][0].equals("b") &&
				cube.getBlueSide().getMatrix()[2][1].equals("b") &&
				cube.getBlueSide().getMatrix()[2][2].equals("b")))
			
			answer = false;
		
		return answer;
	}

}
