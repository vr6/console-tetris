package org.test.pieces;

import org.test.Board;
import org.test.types.PieceType;

public class ZigzagPiece extends PieceBase {

	public ZigzagPiece(PieceType type, int x, Board board) {
		super(type, board);
		this.points[0] = new Point(x, 2);
		this.points[1] = new Point(x, 1);
		this.points[2] = new Point(x + 1, 1);
		this.points[3] = new Point(x + 1, 0);
	}

	@Override
	protected void moveCounterClock(Point[] pts) {
		switch (posture) {
		case ANGLE_0:
			pts[0].x++;
			pts[0].y--;
			pts[2].x--;
			pts[2].y--;
			pts[3].x -= 2;
			// pts[3].y -= 2;
			break;
		case ANGLE_90:
			pts[0].x--;
			pts[0].y--;
			pts[2].x--;
			pts[2].y++;
			// pts[3].x -= 2;
			pts[3].y += 2;
			break;
		case ANGLE_180:
			pts[0].x--;
			pts[0].y++;
			pts[2].x++;
			pts[2].y++;
			pts[3].x += 2;
			// pts[3].y += 2;
			break;
		case ANGLE_270:
			pts[0].x++;
			pts[0].y++;
			pts[2].x++;
			pts[2].y--;
			// pts[3].x += 2;
			pts[3].y -= 2;
			break;
		}
	}

	@Override
	protected void moveClockWise(Point[] pts) {
		switch (posture) {
		case ANGLE_0:
			pts[0].x--;
			pts[0].y--;
			pts[2].x--;
			pts[2].y++;
			// pts[3].x -= 2;
			pts[3].y += 2;
			break;
		case ANGLE_90:
			pts[0].x--;
			pts[0].y++;
			pts[2].x++;
			pts[2].y++;
			pts[3].x += 2;
			// pts[3].y += 2;
			break;
		case ANGLE_180:
			pts[0].x++;
			pts[0].y++;
			pts[2].x++;
			pts[2].y--;
			// pts[3].x += 2;
			pts[3].y -= 2;
			break;
		case ANGLE_270:
			pts[0].x++;
			pts[0].y--;
			pts[2].x--;
			pts[2].y--;
			pts[3].x -= 2;
			// pts[3].y -= 2;
			break;
		}
	}

}
