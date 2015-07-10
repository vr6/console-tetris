package org.test.pieces;

import org.test.Board;
import org.test.types.PieceType;

public class BoxPiece extends PieceBase {

	public BoxPiece(PieceType type, int x, Board board) {
		super(type, board);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.points[i * 2 + j] = new Point(x + i, j);
			}
		}
	}

	@Override
	protected void moveCounterClock(Point[] pts) {
	}

	@Override
	protected void moveClockWise(Point[] pts) {
	}

}
