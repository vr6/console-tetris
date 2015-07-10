package org.test.pieces;

import org.test.types.MoveType;

public interface Piece {

	public abstract void draw();

	public abstract boolean isValidMove(MoveType mtype);

	public abstract void clear();

	public abstract void performMove(MoveType mtype);

	public abstract void moveDown();

	public abstract boolean canMove();

	public abstract boolean contains(int i, int j);

}