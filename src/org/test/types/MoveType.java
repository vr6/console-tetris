package org.test.types;

public enum MoveType {
	LEFT, RIGHT, COUNTER_CLOCK, CLOCK_WISE;

	public static MoveType getType(int i) {
		return values()[i];
	}
}
