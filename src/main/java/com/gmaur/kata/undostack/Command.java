package com.gmaur.kata.undostack;

public class Command {

	private int order;

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return Integer.toString(order);
	}

	public int getOrder() {
		return order;
	}

}
