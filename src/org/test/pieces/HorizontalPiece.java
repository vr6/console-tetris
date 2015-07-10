package org.test.pieces;

import org.test.Board;
import org.test.types.PieceType;

public class HorizontalPiece extends PieceBase {

	public HorizontalPiece(PieceType type, int x, Board board) {
		super(type, board);
		for (int i = 0; i < numPoints; i++) {
			this.points[i] = new Point(x + i, 0);
		}
	}

	@Override
	protected void moveCounterClock(Point[] pts) {
		switch (posture) {
		case ANGLE_0:
			pts[0].x++;
			pts[0].y++;
			pts[2].x--;
			pts[2].y--;
			pts[3].x -= 2;
			pts[3].y -= 2;
			break;
		case ANGLE_90:
			pts[0].x++;
			pts[0].y--;
			pts[2].x--;
			pts[2].y++;
			pts[3].x -= 2;
			pts[3].y += 2;
			break;
		case ANGLE_180:
			pts[0].x--;
			pts[0].y--;
			pts[2].x++;
			pts[2].y++;
			pts[3].x += 2;
			pts[3].y += 2;
			break;
		case ANGLE_270:
			pts[0].x--;
			pts[0].y++;
			pts[2].x++;
			pts[2].y--;
			pts[3].x += 2;
			pts[3].y -= 2;
			break;
		}
	}

	@Override
	protected void moveClockWise(Point[] pts) {
		switch (posture) {
		case ANGLE_0:
			pts[0].x++;
			pts[0].y--;
			pts[2].x--;
			pts[2].y++;
			pts[3].x -= 2;
			pts[3].y += 2;
			break;
		case ANGLE_90:
			pts[0].x--;
			pts[0].y--;
			pts[2].x++;
			pts[2].y++;
			pts[3].x += 2;
			pts[3].y += 2;
			break;
		case ANGLE_180:
			pts[0].x--;
			pts[0].y++;
			pts[2].x++;
			pts[2].y--;
			pts[3].x += 2;
			pts[3].y -= 2;
			break;
		case ANGLE_270:
			pts[0].x++;
			pts[0].y++;
			pts[2].x--;
			pts[2].y--;
			pts[3].x -= 2;
			pts[3].y -= 2;
			break;
		}
	}

}
