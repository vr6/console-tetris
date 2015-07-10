package org.test.pieces;

import org.test.Board;
import org.test.types.MoveType;
import org.test.types.PieceType;
import org.test.types.RotationState;

public abstract class PieceBase implements Piece {
	protected PieceType type;
	protected Board board;
	protected Point[] points;
	protected RotationState posture;
	protected static final int numPoints = 4;

	public PieceBase(PieceType type, Board board) {
		this.type = type;
		this.board = board;
		this.points = new Point[numPoints];
		this.posture = RotationState.ANGLE_0;
	}

	public static Piece getInstance(PieceType ptype, int xPos, Board board2) {
		switch (ptype) {
		case HORIZONTAL:
			return new HorizontalPiece(ptype, xPos, board2);
		case L_SHAPE:
			return new LShapePiece(ptype, xPos, board2);
		case REVERSE_L:
			return new ReverseLPiece(ptype, xPos, board2);
		case ZIGZAG:
			return new ZigzagPiece(ptype, xPos, board2);
		case BOX:
			return new BoxPiece(ptype, xPos, board2);
		}
		return null;
	}

	@Override
	public void draw() {
		for (int i = 0; i < points.length; i++) {
			this.board.set(points[i].x, points[i].y);
		}
	}

	@Override
	public boolean isValidMove(MoveType mtype) {
		return canMove(mtype);
	}

	@Override
	public void clear() {
		for (int i = 0; i < points.length; i++) {
			this.board.clear(points[i].x, points[i].y);
		}
	}

	@Override
	public void performMove(MoveType mtype) {
		switch (mtype) {
		case LEFT:
			moveLeft(points);
			break;
		case RIGHT:
			moveRight(points);
			break;
		case COUNTER_CLOCK:
			moveCounterClock(points);
			int postureTemp = this.posture.ordinal();
			postureTemp++;
			if (postureTemp > 3) {
				postureTemp = 0;
			}
			this.posture = RotationState.getType(postureTemp);
			break;
		case CLOCK_WISE:
			moveClockWise(points);
			postureTemp = this.posture.ordinal();
			postureTemp--;
			if (postureTemp < 0) {
				postureTemp = 3;
			}
			this.posture = RotationState.getType(postureTemp);
			break;
		}
	}

	private void moveLeft(Point[] pts) {
		for (int i = 0; i < pts.length; i++) {
			pts[i].x--;
		}
	}

	private void moveRight(Point[] pts) {
		for (int i = 0; i < pts.length; i++) {
			pts[i].x++;
		}
	}

	public void moveDown() {
		for (int i = 0; i < points.length; i++) {
			points[i].y++;
		}
	}

	@Override
	public boolean canMove() {
		if (canMove(MoveType.LEFT) || canMove(MoveType.RIGHT)
				|| canMove(MoveType.COUNTER_CLOCK)
				|| canMove(MoveType.CLOCK_WISE)) {
			return true;
		}
		return false;
	}

	private boolean canMove(MoveType mtype) {
		Point[] pts = new Point[numPoints];
		for (int i = 0; i < pts.length; i++) {
			pts[i] = new Point(points[i].x, points[i].y);
		}
		switch (mtype) {
		case LEFT:
			moveLeft(pts);
			break;
		case RIGHT:
			moveRight(pts);
			break;
		case CLOCK_WISE:
			moveClockWise(pts);
			break;
		case COUNTER_CLOCK:
			moveCounterClock(pts);
			break;
		}
		for (int i = 0; i < pts.length; i++) {
			if (!this.board.isClear(pts[i].x, pts[i].y + 1, this)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(int x, int y) {
		for (int i = 0; i < points.length; i++) {
			if (points[i].x == x && points[i].y == y) {
				return true;
			}
		}
		return false;
	}

	protected abstract void moveClockWise(Point[] pts);

	protected abstract void moveCounterClock(Point[] pts);
}
