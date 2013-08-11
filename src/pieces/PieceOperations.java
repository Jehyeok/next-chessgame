package pieces;

import java.util.List;

public interface PieceOperations {

	public abstract char getSymbol();

	public abstract boolean isWhite();

	public abstract boolean isBlack();

	public abstract PieceOperations leave();

	public abstract PieceOperations move(Position target);

	public abstract List<Position> getPossibleMoves();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}