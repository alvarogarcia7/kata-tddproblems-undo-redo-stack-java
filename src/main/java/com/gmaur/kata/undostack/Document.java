package com.gmaur.kata.undostack;

import java.util.ArrayList;
import java.util.List;

public class Document {

	public static class Commands {
		private List<Command> commands;

		public Commands() {
		}

		public List<Command> getCommands() {
			return commands;
		}

		public void setCommands(List<Command> commands) {
			this.commands = commands;
		}
		
		public List<Command> getUndidCommands() {
			return commands;
		}

		public void setUndidCommands(List<Command> undidCommands) {
			this.commands = undidCommands;
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

	private Commands data = new Commands();
	private Commands data2 = new Commands();
	private int orderNumber;

	public Document() {
		this.data.setCommands(new ArrayList<Command>());
		this.data2.setUndidCommands(new ArrayList<Command>());
		orderNumber = 0;
	}

	public boolean hasUndo() {
		return data.isNotEmpty();
	}

	public void addCommand(Command appendTextCommand) {
		++orderNumber;
		appendTextCommand.setOrder(orderNumber);
		this.data.add(appendTextCommand);
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public boolean hasRedo() {
		return data2.isNotEmpty();
	}

	public void undo() {
		moveLastCommand(data, data2);
	}

	private void moveLastCommand(Commands from, Commands to) {
		Command lastCommand = from.pop();
		to.add(lastCommand);
	}

	public void redo() {
		moveLastCommand(data2, data);
	}

	public int getUndoCommandNumber() {
		return data.peek().getOrder();
	}

	public Object getRedoCommandNumber() {
		return data2.peek().getOrder();
	}
}
