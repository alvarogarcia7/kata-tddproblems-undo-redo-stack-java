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

}
