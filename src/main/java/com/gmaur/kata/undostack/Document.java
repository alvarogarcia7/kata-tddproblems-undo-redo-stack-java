package com.gmaur.kata.undostack;

import java.util.ArrayList;
import java.util.List;

public class Document {

	private List<AppendTextCommand> commands;
	
	public Document(){
		this. commands = new ArrayList<AppendTextCommand>();
	}

	public boolean hasUndo() {
		boolean hasUndo = !this.commands.isEmpty();
		return hasUndo;
	}

	public void addCommand(AppendTextCommand appendTextCommand) {
		this.commands.add(appendTextCommand);
	}

}
