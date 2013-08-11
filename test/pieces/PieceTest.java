package pieces;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		PieceOperations whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		PieceOperations blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}
	
	public void testGetPossibleMovesOfEmpty() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations empty = new Empty(Color.NOCOLOR, new Position("a1"));
		
		possibleMoves = empty.getPossibleMoves();
		assertEquals(0, possibleMoves.size());
	}
	
	public void testGetPossibleMovesOfRook() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations whiteRook = new Rook(Color.WHITE, new Position("a1"));
		
		possibleMoves = whiteRook.getPossibleMoves();
		System.out.println(possibleMoves);
	}
	
	public void testGetPossibleMovesOfBishop() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations whiteBishop = new Bishop(Color.WHITE, new Position("a1"));
		
		possibleMoves = whiteBishop.getPossibleMoves();
		System.out.println(possibleMoves);
	}
	
	public void testGetPossibleMovesOfQueen() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations whiteQueen = new Queen(Color.WHITE, new Position("a1"));
		
		possibleMoves = whiteQueen.getPossibleMoves();
		System.out.println(possibleMoves);
	}
	
	public void testGetPossibleMovesOfKing() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations whiteKing = new King(Color.WHITE, new Position("b4"));
		
		possibleMoves = whiteKing.getPossibleMoves();
		System.out.println(possibleMoves);
	}
	
	public void testGetPossibleMovesOfPawn() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations whitePawn = new Pawn(Color.WHITE, new Position("b2"));
		
		possibleMoves = whitePawn.getPossibleMoves();
		System.out.println(possibleMoves);
	}
	
	public void testGetPossibleMovesOfBlackPawnTwoStep() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations blackPawn = new Pawn(Color.BLACK, new Position("b7"));
		
		possibleMoves = blackPawn.getPossibleMoves();
		System.out.println(possibleMoves);
	}
	
	public void testIsPawn() {
		PieceOperations piece = new Pawn(Color.BLACK, new Position("b7"));
		assertTrue(piece instanceof Pawn);
	}
	
	public void testBlackPawnIsInitialState() {
		Piece piece = new Pawn(Color.BLACK, new Position("b7"));
		assertTrue(piece.getPosition().getY() == 6 && piece instanceof Pawn && piece.isBlack());
	}
	
	public void testGetPossibleMovesOfNight() throws Exception {
		List<Position> possibleMoves = new ArrayList<Position>();
		PieceOperations whiteKnight = new Knight(Color.WHITE, new Position("d3"));
		
		possibleMoves = whiteKnight.getPossibleMoves();
		System.out.println(possibleMoves);
	}
}