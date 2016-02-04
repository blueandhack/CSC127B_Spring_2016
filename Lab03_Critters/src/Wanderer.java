public class Wanderer implements Critter {

	@Override
	public char getChar() {
		return 'W';
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
		} else {
			if (Math.random() > 0.25)
				return Move.HOP;
			else {
				if (Math.random() > 0.5)
					return Move.LEFT;
				else
					return Move.RIGHT;
			}
		}

	}
}
