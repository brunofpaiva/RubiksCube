package com.iaproject;

public enum Move {
	
	R(0), L(1), U(2), D(3), F(4), B(5), Rinv(6), Linv(7), Uinv(8), Dinv(9), Finv(10), Binv(11), NoMove(12), NoCrossMove(13);
	
    private int move;

    Move(int move) {
            this.move = move;
    }

}
