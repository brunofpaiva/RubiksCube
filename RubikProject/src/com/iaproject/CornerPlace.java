package com.iaproject;

public enum CornerPlace {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8);
	
	private int corner;

    CornerPlace(int corner) {
            this.corner = corner;
    }
    
    public int getCornerPlace(){
    	return this.corner;
    }
}
