package com.iaproject;

public class EdgePiece {
	
	private String color1;
	private String color2;
	
	private int position;
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
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	public LevelKind getType() {
		return type;
	}

	public void setType(LevelKind type) {
		this.type = type;
	}
	
	/**
	 * Verifies if this edge is the edge that is colored like the parameters
	 *  
	 * @param color1 - Represents one color of the edge
	 * @param color2 - Represents the other color of the edge
	 * 
	 * @return Boolean - True if it satisfies and False if not
	 */
	public boolean isThatEdge(String color1, String color2){
		
		if (! (this.color1.equals(color1) || this.color1.equals(color2)))
			return false;
		
		if (! (this.color2.equals(color1) || this.color2.equals(color2)))
			return false;
			
		return true;
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
