package com.wata.battleships;

import java.lang.RuntimeException;

/**
 * Runtime exception for object pool errors.
 *
 */
public class ObjectPoolException extends RuntimeException {

	static final long serialVersionUID = -8701676077635260292L;

	public ObjectPoolException(String message) {
		super(message);
	}
}