package com.gmaur.kata.undostack;

import java.util.ArrayList;
import java.util.List;

public class Document {

	public static class Commands {
		private List<Command> commands;

		public Commands() {
			this.commands = new ArrayList<Command>();
		}

		public Command peek() {
			return commands.get(commands.size() - 1);
		}

		public Command pop() {
			return commands.remove(commands.size() - 1);
		}

		public void add(Command lastCommand) {
			commands.add(lastCommand);
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
