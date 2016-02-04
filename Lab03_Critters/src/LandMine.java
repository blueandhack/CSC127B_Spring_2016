public class LandMine implements Critter {

	@Override
	public char getChar() {
		return 'L';
	}

	@Override
	public Move getMove(Neighbor front, Neighbor back, Neighbor right,
			Neighbor left) {
		if (front == Neighbor.WALL) {
			return Move.LEFT;
		} else {
			return Move.INFECT;
		}
	}

}
