package com.jeffreydiaz.exceptions;

/**
 * Exception raised given an invalid size as input.
 * @author Jeffrey Diaz
 */
public class InvalidInputException extends Exception {

	/**
	 * Create an Exception with a message attached.
	 * @param msg Message explaining the cause of exception.
	 */
	public InvalidInputException(String msg)
	{
		super(msg);
	}
}