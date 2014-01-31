package com.iaproject;

public class CornerPiece {
	
	private String colorH;
	private String color1;
	private String color2;

	private LevelKind type;
	
	public CornerPiece(String colorH, String color1, String color2){
		this.colorH = colorH;
		this.color1 = color1;
		this.color2 = color2;
	}

	public String getColorH() {
		return colorH;
	}

	public void setColorH(String colorH) {
		this.colorH = colorH;
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
	
	public boolean isThatCorner(String color1, String color2, String color3){
		
		if (! (this.colorH.equals(color1) || this.colorH.equals(color2) || this.colorH.equals(color3)))
			return false;
		
		if (! (this.color1.equals(color1) || this.color1.equals(color2) || this.color1.equals(color3)))
			return false;
		
		if (! (this.color2.equals(color1) || this.color2.equals(color2) || this.color2.equals(color3)))
			return false;
			
		return true;
	}
	
	/**
	 * Verifies if this corner contains yellow color
	 * 
	 * @return Boolean answering if this corner is valid for the F2L Pair
	 */
	public boolean isValidToF2L(){
		if (color1.equals("y") || color2.equals("y"))
			return false;
		
		return true;
	}

}
