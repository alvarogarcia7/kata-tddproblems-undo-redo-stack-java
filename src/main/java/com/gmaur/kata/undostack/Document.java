package com.gmaur.kata.undostack;

import java.util.ArrayList;
import java.util.List;

public class Document {

	private List<AppendTextCommand> commands;
	private List<AppendTextCommand> undidCommands;

	public Document() {
		this.commands = new ArrayList<AppendTextCommand>();
		this.undidCommands = new ArrayList<AppendTextCommand>();
	}

	public boolean hasUndo() {
		return isNotEmpty(this.commands);
	}

	public void addCommand(AppendTextCommand appendTextCommand) {
		this.commands.add(appendTextCommand);
	}

	public boolean hasRedo() {
		return isNotEmpty(this.undidCommands);
	}

	private boolean isNotEmpty(List<AppendTextCommand> list) {
		return !list.isEmpty();
	}

	public void undo() {
		AppendTextCommand lastCommand = pop(commands);
		this.undidCommands.add(lastCommand);
	}

	private AppendTextCommand pop(List<AppendTextCommand> list) {
		return list.remove(list.size() - 1);
	}

	public void redo() {
		AppendTextCommand lastCommand = pop(undidCommands);
		this.commands.add(lastCommand);
	}

}
