package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		PositionController psController = new PositionController(this.getPosition());
		Direction[] directions = Direction.linearDirection();
		
		possibleMoves = psController.findPositionOneStepInDirection(directions, this); 
		return possibleMoves;
	}
}

