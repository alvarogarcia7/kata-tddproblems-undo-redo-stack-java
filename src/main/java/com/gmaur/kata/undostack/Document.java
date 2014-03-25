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
		boolean hasUndo = !this.commands.isEmpty();
		return hasUndo;
	}

	public void addCommand(AppendTextCommand appendTextCommand) {
		this.commands.add(appendTextCommand);
	}

	public boolean hasRedo() {
		boolean hasRedo = !this.undidCommands.isEmpty();
		return hasRedo;
	}

	public void undo() {
		AppendTextCommand lastCommand = commands.remove(commands.size() - 1);
		this.undidCommands.add(lastCommand);
	}

}
