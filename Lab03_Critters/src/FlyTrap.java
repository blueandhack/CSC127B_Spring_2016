public class FlyTrap implements Critter {

	@Override
	public char getChar() {
		return 'T';
	}

	@Override
	public Move getMove(Neighbor front, Neighbor back, Neighbor right,
			Neighbor left) {

		if (front == Neighbor.OTHER) {
			return Move.INFECT;
		} else {
			return Move.LEFT;
		}
		
		
	}

}
