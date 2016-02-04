class Rover implements Critter {
	public char getChar() {
		return 'R';
	}

	public Move getMove(Neighbor front, Neighbor back, Neighbor right,
			Neighbor left) {
		if (front == Neighbor.EMPTY)
			return Move.HOP;
		else if (front == Neighbor.OTHER)
			return Move.INFECT;
		else {
			if (Math.random() > 0.5) // 50% chance of turning left. 0.3, means a
										// 70% chance
				return Move.LEFT;
			else
				return Move.RIGHT;
		}
	}
}