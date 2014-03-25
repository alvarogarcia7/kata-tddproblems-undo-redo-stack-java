package com.gmaur.kata.undostack;
import static org.junit.Assert.*;

import org.junit.Test;


public class CommandUndoTest {

	@Test
	public void document_with_a_command_has_undo() {
		Document document = new Document();
		document.addCommand(new AppendTextCommand("hola"));
		assertTrue(document.hasUndo());
	}
	
	@Test
	public void document_after_undo_has_redo() {
		Document document = new Document();
		document.addCommand(new AppendTextCommand("hola"));
		document.undo();
		assertTrue(document.hasRedo());
	}
	
	@Test
	public void document_after_redo_has_undo_again() {
		Document document = new Document();
		document.addCommand(new AppendTextCommand("hola"));
		document.undo();
		document.redo();
		assertTrue(document.hasUndo());
	}

}
