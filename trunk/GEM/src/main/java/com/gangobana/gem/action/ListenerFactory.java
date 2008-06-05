package com.gangobana.gem.action;

public final class ListenerFactory {
	
	private static ListenerFactory instance = new ListenerFactory();
	private ShowDateListener showDateListerner;
	
	private ListenerFactory() {
		this.showDateListerner = new ShowDateListener(); 
	}

	public ShowDateListener getShowDateListerner() {
		return showDateListerner;
	}
	
	public static ListenerFactory getInstance() {	
		return instance;
	}
	
}
