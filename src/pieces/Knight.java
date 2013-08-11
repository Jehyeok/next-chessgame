package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		PositionController psController = new PositionController(this.getPosition());
		Direction[] directions = Direction.linearDirection();
		
		possibleMoves = psController.findPositionSequentialStepInDirection(directions);
		return possibleMoves;
	}
}
