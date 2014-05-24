package com.wata.battleships;

/**
 * Runtime exception to indicate a pool is full.
 *
 */

public class ObjectPoolFullException extends ObjectPoolException {

	static final long serialVersionUID = -6727883683594336582L;

	public ObjectPoolFullException(String message) {
		super(message);
	}
}
