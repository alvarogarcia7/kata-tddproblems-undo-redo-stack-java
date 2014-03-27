package com.gmaur.kata.undostack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Document {

	public static class Commands {
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

	private Commands undoCommands = new Commands();
	private Commands redoCommands = new Commands();
	private int orderNumber;

	public Document() {
		this.undoCommands = new Commands();
		this.redoCommands = new Commands();
		orderNumber = 0;
	}

	public boolean hasUndo() {
		return undoCommands.isNotEmpty();
	}

	public void addCommand(Command appendTextCommand) {
		++orderNumber;
		appendTextCommand.setOrder(orderNumber);
		this.undoCommands.add(appendTextCommand);
	}

	@Override
	public String toString() {
		return undoCommands.toString();
	}

	public boolean hasRedo() {
		return redoCommands.isNotEmpty();
	}

	public void undo() {
		moveLastCommand(undoCommands, redoCommands);
	}

	private void moveLastCommand(Commands from, Commands to) {
		Command lastCommand = from.pop();
		to.add(lastCommand);
	}

	public void redo() {
		moveLastCommand(redoCommands, undoCommands);
	}

	public int getUndoCommandNumber() {
		return undoCommands.peek().getOrder();
	}

	public Object getRedoCommandNumber() {
		return redoCommands.peek().getOrder();
	}
}
