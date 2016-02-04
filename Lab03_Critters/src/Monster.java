public class Monster implements Critter {

	@Override
	public char getChar() {
		return 'M';
	}

	@Override
	public Move getMove(Neighbor front, Neighbor back, Neighbor right,
			Neighbor left) {
		if (front == Neighbor.OTHER) {
			return Move.INFECT;
		} else if (front == Neighbor.SAME) {
			if (Math.random() > 0.5) {
				return Move.LEFT;
			} else {
				return Move.RIGHT;
			}
		} else if (front == Neighbor.WALL) {
			return Move.HOP;
		} else {
			return Move.RIGHT;
		}
	}
}
