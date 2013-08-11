package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		PositionController psController = new PositionController(this.getPosition());
		Direction[] directions = null;
		if(this.isWhite()) directions = Direction.whitePawnDirection();
		if(this.isBlack()) directions = Direction.blackPawnDirection();
		
		possibleMoves = psController.findPositionOneStepInDirection(directions, this); 
		return possibleMoves;
	}
}
