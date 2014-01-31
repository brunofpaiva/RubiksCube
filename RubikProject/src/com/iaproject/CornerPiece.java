package com.iaproject;

public class CornerPiece {
	
	private String colorH; // Horizontal
	private String colorL; // Left
	private String colorR; // Right

	private int position;
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	private LevelKind type;
	
	public CornerPiece(String colorH, String colorL, String colorR){
		this.colorH = colorH;
		this.colorL = colorL;
		this.colorR = colorR;
	}

	public String getColorH() {
		return colorH;
	}

	public void setColorH(String colorH) {
		this.colorH = colorH;
	}

	public String getColorL() {
		return colorL;
	}

	public void setColorL(String colorL) {
		this.colorL = colorL;
	}

	public String getColorR() {
		return colorR;
	}

	public void setColorR(String colorR) {
		this.colorR = colorR;
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
	 * @param colorL - Represents the left color of the corner
	 * @param colorR - Represents the right color of the corner
	 * @param color3 - Represents the horizontal color of the corner
	 * 
	 * @return Boolean - True if it satisfies and False if not
	 */
	public boolean isThatCorner(String colorL, String colorR, String color3){
		
		if (! (this.colorH.equals(colorL) || this.colorH.equals(colorR) || this.colorH.equals(color3)))
			return false;
		
		if (! (this.colorL.equals(colorL) || this.colorL.equals(colorR) || this.colorL.equals(color3)))
			return false;
		
		if (! (this.colorR.equals(colorL) || this.colorR.equals(colorR) || this.colorR.equals(color3)))
			return false;
			
		return true;
	}
	
	/**
	 * Verifies if this corner contains yellow color
	 * 
	 * @return Boolean answering if this corner is valid for the F2L Pair
	 */
	public boolean isValidToF2L(){
		if (colorH.equals("y") || colorL.equals("y") || colorR.equals("y"))
			return false;
		
		return true;
	}

}
