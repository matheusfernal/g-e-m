package com.gangobana.gem.action;

/**
 * Interface for the Command design pattern
 * @author matheusfernal
 *
 */
public interface Command {
	boolean setUp();
	boolean execute();
	boolean undo();
	boolean tearDown();
}
