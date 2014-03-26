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
		assertEquals(1, document.getUndoCommandNumber());
		assertEquals("[1]", document.toString());
	}

	@Test
	public void document_after_undo_has_redo() {
		document.undo();
		assertTrue(document.hasRedo());
		assertEquals(1, document.getRedoCommandNumber());
		assertEquals("[]", document.toString());
	}

	@Test
	public void document_after_redo_has_undo_again() {
		document.undo();
		document.redo();
		assertTrue(document.hasUndo());
		assertEquals("[1]", document.toString());
	}
	
	@Test
	public void acceptance_test_with_two_commands() {
		document.addCommand(new Command()); //2
		assertEquals(2, document.getUndoCommandNumber());
		assertFalse(document.hasRedo());
		
		document.undo(); //2
		
		assertEquals(1, document.getUndoCommandNumber());
		assertEquals(2, document.getRedoCommandNumber());
		
		document.undo(); //1
		assertEquals(1, document.getRedoCommandNumber());
		document.redo(); //1
		assertEquals(2, document.getRedoCommandNumber());
	}
	
	@Test
	public void acceptance_test_with_three_commands() {
		document.addCommand(new Command()); //2
		document.undo(); //2
		document.addCommand(new Command()); //3
		document.undo(); //3 
		
		assertEquals(3, document.getRedoCommandNumber());
		assertEquals(1, document.getUndoCommandNumber());
		
		document.undo(); //1 
		assertEquals(1, document.getRedoCommandNumber());
		document.redo(); //1
		
		assertEquals(3, document.getRedoCommandNumber());
		assertEquals(1, document.getUndoCommandNumber());
	}
}
