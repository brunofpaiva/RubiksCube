package com.iaproject;

public class EdgePiece {
	
	private String color1;
	private String color2;
	
	private LevelKind type;
	
	public EdgePiece(String color1, String color2){
		this.color1 = color1;
		this.color2 = color2;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}
	
	public LevelKind getType() {
		return type;
	}

	public void setType(LevelKind type) {
		this.type = type;
	}

	/**
	 * Verifies if this edge contains yellow color
	 * 
	 * @return Boolean answering if this edge is valid for the F2L Pair
	 */
	public boolean isValidToF2L(){
		if (color1.equals("y") || color2.equals("y"))
			return false;
		
		return true;
	}
	
}
