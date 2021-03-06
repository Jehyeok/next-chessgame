package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
	public List<Position> findPositionOneStepInDirection(Direction[] directions, Piece piece) {
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : directions) {
			positions.addAll(position.findsPositionOneStep(direction, piece));
		}
		return positions;
	}
	
	public List<Position> findPositionSequentialStepInDirection(Direction[] directions) {
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : directions) {
			positions.addAll(position.findsPositionThreeStep(direction));
		}
		return positions;
	}
}
