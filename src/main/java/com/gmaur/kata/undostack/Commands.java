package com.gmaur.kata.undostack;

import java.util.Stack;

public class Commands {
	private Stack<Command> commands;

	public Commands() {
		this.commands = new Stack<Command>();
	}

	public Command peek() {
		return commands.peek();
	}

	public Command pop() {
		return commands.pop();
	}

	/**
	 * Prefer using {@link #push(Command)} instead of {@link #add(Command)}
	 */
	@Deprecated
	public void add(Command lastCommand) {
		commands.push(lastCommand);
	}
	
	public void push(Command lastCommand) {
		commands.push(lastCommand);
	}
	
	public boolean isNotEmpty() {
		return !commands.isEmpty();
	}

	@Override
	public String toString() {
		return commands.toString();
	}
}
