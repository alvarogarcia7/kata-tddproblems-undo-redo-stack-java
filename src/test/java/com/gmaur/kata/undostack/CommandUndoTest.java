package com.gmaur.kata.undostack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandUndoTest {

	private Document document;

	@Before
	public void setUp() {
		document = new Document();
		document.addCommand(new Command());
	}

	@Test
	public void document_with_a_command_has_undo() {
		assertTrue(document.hasUndo());
		assertEquals("[1]", document.toString());
	}

	@Test
	public void document_after_undo_has_redo() {
		document.undo();
		assertTrue(document.hasRedo());
		assertEquals("[]", document.toString());
	}

	@Test
	public void document_after_redo_has_undo_again() {
		document.undo();
		document.redo();
		assertTrue(document.hasUndo());
		assertEquals("[1]", document.toString());
	}
}
