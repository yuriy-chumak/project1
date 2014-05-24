package com.wata.battleships;

/**
 * Factory class that provides {@link BattleshipsShoot} instances specified by a set of x and y co-ordinates
 * or by a string in the usual Battleships notation (for example, "c5").
 *
 */

public class BattleshipsShootFactory implements ShootFactory{
	public BattleshipsShoot moves[][] = {
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null }
		};

		@SuppressWarnings("deprecation")
		public BattleshipsShootFactory() {
			for (int x = 1; x <= moves.length; x++) {
				for (int y = 1; y <= moves[x - 1].length; y++) {
					moves[x - 1][y - 1] = new BattleshipsShoot(x, y);
				}
			}
		}

		public BattleshipsShoot createMove(int x, int y) {
			return moves[x - 1][y - 1];
		}

		public BattleshipsShoot createMoveFromString(String moveAsString) {
			if (moveAsString.length() != 2) {
				throw new IllegalArgumentException("Cannot set reversi move from provided string");
			}
			int x = moveAsString.charAt(0) - 96;
			int y = moveAsString.charAt(1) - 48;
			if (x < 1 || x > BattleField.X_DIMENSION || y < 1 || y > BattleField.Y_DIMENSION) {
				throw new IllegalArgumentException("Invalid reversi move");
			}
			return createMove(x, y);
		}
	

}
