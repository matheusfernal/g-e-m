package com.gangobana.gem.action;

import java.awt.event.ActionListener;

public final class ListenerFactory {
	
	private static ListenerFactory instance = new ListenerFactory();
	
	private ShowDateListener showDateListerner;
	private ShowLoginPanelListener showLoginPanelListener;
	
	public static ListenerFactory getInstance() {	
		return instance;
	}
	
	private ListenerFactory() {
		this.showDateListerner = new ShowDateListener();
		this.showLoginPanelListener = new ShowLoginPanelListener();
	}
	
	
	// The listeners available
	
	public ActionListener getShowLoginPanelListener() {
		return showLoginPanelListener;
	}
	
	public ShowDateListener getShowDateListerner() {
		return showDateListerner;
	}
	
}
