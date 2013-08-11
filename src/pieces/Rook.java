package pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		PositionController psController = new PositionController(this.getPosition());
		
		possibleMoves = psController.findsLinearPositionAll();
		possibleMoves.addAll(psController.findsDiagonalPositionAll());
		
		return possibleMoves;		
	}
}
