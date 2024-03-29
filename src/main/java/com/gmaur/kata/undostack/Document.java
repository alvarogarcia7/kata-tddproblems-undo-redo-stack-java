package com.gmaur.kata.undostack;

public class Document {

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
		return undoCommands.getCommandOrder();
	}

	public Object getRedoCommandNumber() {
		return redoCommands.getCommandOrder();
	}
}
