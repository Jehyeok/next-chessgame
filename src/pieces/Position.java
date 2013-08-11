package pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import chess.Board;

public class Position {
	private static final char COLUMN_START_CHAR = 'a';

	private int x;
	private int y;

	public Position(String position) {
		// ������ ��������� ������ ������ ���������.
		this.x = generateColumnIndex(position.charAt(0));
		this.y = Integer.parseInt(position.substring(1)) - 1;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	Position move(Direction direction) {
		return new Position(this.x + direction.getXDegree(), this.y + direction.getYDegree());
	}
	
	List<Position> findsPositionOneStep(Direction direction, Piece piece) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		if (isBlackPawnInitialState(piece) && (direction == Direction.SOUTH)) {
			currentPosition = currentPosition.move(direction);
		}
		if (isWhitePawnInitialState(piece) && (direction == Direction.NORTH)) {
			currentPosition = currentPosition.move(direction);
		}
		if (currentPosition.isValid()) {
			positions.add(currentPosition);
		}
		return positions;
	}
	
	List<Position> findsPositionThreeStep(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		currentPosition = currentPosition.move(direction);
		
		if ((direction == Direction.EAST) || (direction == Direction.WEST)) {
			if (currentPosition.move(Direction.NORTH).isValid()) {
				positions.add(currentPosition.move(Direction.NORTH));
			}
			if (currentPosition.move(Direction.SOUTH).isValid()) {
				positions.add(currentPosition.move(Direction.SOUTH));
			}
		}
		
		if ((direction == Direction.NORTH) || (direction == Direction.SOUTH)) {
			if (currentPosition.move(Direction.EAST).isValid()) {
				positions.add(currentPosition.move(Direction.EAST));
			}
			if (currentPosition.move(Direction.WEST).isValid()) {
				positions.add(currentPosition.move(Direction.WEST));
			}
		}
		
		return positions;
	}

	public boolean isBlackPawnInitialState(Piece piece) {
		return (piece.getPosition().getY() == 6) && piece instanceof Pawn && piece.isBlack();
	}
	
	public boolean isWhitePawnInitialState(Piece piece) {
		return (piece.getPosition().getY() == 1) && piece instanceof Pawn && piece.isWhite();
	}
	
	List<Position> findsPosition(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
		}
		return positions;
	}
	
	public boolean isValid() {
		if ( y < 0 || y >= Board.ROW_SIZE) {
			return false;
		}

		if ( x < 0 || x >= Board.COLUMN_SIZE) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
