package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		
		Piece whiteRook = new Rook(Color.WHITE, this.getPosition());
		Piece whiteBishop = new Bishop(Color.WHITE, this.getPosition());
		
		possibleMoves = whiteRook.getPossibleMoves();
		possibleMoves.addAll(whiteBishop.getPossibleMoves());
				
		return possibleMoves;	
	}
}
