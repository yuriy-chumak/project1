package com.wata.battleships;

/**
 * Interface that a class representing a player in the game must implement.
 * 
 */

public interface Player {

	/**
	 * Return a character symbol representing the player.
	 * @return A character symbol representing the player.
	 */
	char getSymbol();

	/**
	 * Get a name representing the player.
	 * @return A name representing the player.
	 */
	String getName();
}
