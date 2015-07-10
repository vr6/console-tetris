package org.test.types;

public enum PieceType {
	HORIZONTAL, L_SHAPE, REVERSE_L, ZIGZAG, BOX;

	public static PieceType getType(int i) {
		return values()[i];
	}
}
