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
		return isNotEmpty(data.getCommands());
	}

	public void addCommand(Command appendTextCommand) {
		++orderNumber;
		appendTextCommand.setOrder(orderNumber);
		this.data.getCommands().add(appendTextCommand);
	}

	@Override
	public String toString() {
		return data.getCommands().toString();
	}

	public boolean hasRedo() {
		return isNotEmpty(data2.getUndidCommands());
	}

	private boolean isNotEmpty(List<Command> list) {
		return !list.isEmpty();
	}

	public void undo() {
		moveLastCommand(data.getCommands(), data2.getUndidCommands());
	}

	private void moveLastCommand(List<Command> from, List<Command> to) {
		Command lastCommand = pop(from);
		to.add(lastCommand);
	}

	private Command pop(List<Command> list) {
		return list.remove(list.size() - 1);
	}

	public void redo() {
		moveLastCommand(data2.getUndidCommands(), data.getCommands());
	}

	public int getUndoCommandNumber() {
		return peek(data.getCommands()).getOrder();
	}

	public Object getRedoCommandNumber() {
		return peek(data2.getUndidCommands()).getOrder();
	}

	private Command peek(List<Command> from) {
		return from.get(from.size() - 1);
	}
}
