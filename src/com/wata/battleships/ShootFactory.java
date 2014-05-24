package com.wata.battleships;

/**
 * Interface for a factory that provides {@link Shoot} instances.
 * 
 */

public interface ShootFactory {

	/**
	 * Create a move from the representation of the move in the provided string.
	 * @param moveAsString A string representation of the move, which is game-dependent.
	 * @return A move instance.
	 */
	Shoot createMoveFromString(String moveAsString);
}