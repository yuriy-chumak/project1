package com.wata.battleships;

/**
 * Battleships shoot. This is simply a position on the battlefield described by its x and y coordinates.
 */

public class BattleshipsShoot implements Shoot{
	
	private final BattleshipsPosition position;

	/**
	 * @deprecated Battleships shoot should be obtained from a {@link BattleshipsShootFactory} rather.
	 */
	
	@Deprecated
	public BattleshipsShoot(int x, int y) {
		position = new BattleshipsPosition(x, y);
	}

	public BattleshipsPosition getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return position.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (getClass() != obj.getClass()) return false;
		final BattleshipsShoot other = (BattleshipsShoot) obj;
		if (position == null) {
			if (other.position != null) return false;
		} else if (!position.equals(other.position)) return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}
}
