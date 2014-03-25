package com.gmaur.kata.undostack;

import java.util.ArrayList;
import java.util.List;

public class Document {

	private List<Command> commands;
	private List<Command> undidCommands;

	public Document() {
		this.commands = new ArrayList<Command>();
		this.undidCommands = new ArrayList<Command>();
	}

	public boolean hasUndo() {
		return isNotEmpty(commands);
	}

	public void addCommand(Command appendTextCommand) {
		appendTextCommand.setOrder(commands.size()+1);
		this.commands.add(appendTextCommand);
	}

	@Override
	public String toString() {
		return commands.toString();
	}

	public boolean hasRedo() {
		return isNotEmpty(undidCommands);
	}

	private boolean isNotEmpty(List<Command> list) {
		return !list.isEmpty();
	}

	public void undo() {
		moveLastCommand(commands, undidCommands);
	}

	private void moveLastCommand(List<Command> from, List<Command> to) {
		Command lastCommand = pop(from);
		to.add(lastCommand);
	}

	private Command pop(List<Command> list) {
		return list.remove(list.size() - 1);
	}

	public void redo() {
		moveLastCommand(undidCommands, commands);
	}

	public int getUndoCommandNumber() {
		return peek(commands).getOrder();
	}

	public Object getRedoCommandNumber() {
		return peek(undidCommands).getOrder();
	}

	private Command peek(List<Command> from) {
		return from.get(from.size() - 1);
	}
}
