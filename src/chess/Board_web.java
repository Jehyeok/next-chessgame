package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Empty;
import pieces.Piece.Color;
import pieces.PieceOperations;
import pieces.Position;

public class Board_web implements BoardGenerations {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board_web() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		if (findPiece(source).equals(new Empty(Color.NOCOLOR, source))) return;
		if (!target.isValid()) return;
		if (findPiece(source).isWhite() && findPiece(target).isWhite()) return;
		if (findPiece(source).isBlack() && findPiece(target).isBlack()) return;
		if (!findPiece(source).getPossibleMoves().contains(target)) return;
		
		PieceOperations targetPiece = findPiece(source);
		PieceOperations sourcePiece = targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);
	}
	
	public String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see chess.BoardGenerations#generateBoard()
	 */
	@Override
	public String generateBoard() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>" + "<head>" + "</head>" + "<body>");
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + NEW_LINE);
		}
		sb.append("</body>" + "</html>");
		return sb.toString();
	}
}
