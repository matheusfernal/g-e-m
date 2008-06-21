package com.gangobana.gem.action;

import java.awt.event.ActionListener;

import com.gangobana.gem.domain.IExpenseGateway;

public final class ListenerFactory {
	
	private static ListenerFactory instance = new ListenerFactory();
	
	private ShowDateListener showDateListerner;
	private ShowLoginPanelListener showLoginPanelListener;
	private SendBtnPressedListener sendBtnPressedListener;
	
	public static ListenerFactory getInstance() {	
		return instance;
	}
	
	private ListenerFactory() {
		this.showDateListerner = new ShowDateListener();
		this.showLoginPanelListener = new ShowLoginPanelListener();
		this.sendBtnPressedListener = new SendBtnPressedListener();
	}
	
	
	// The listeners available
	
	public ActionListener getShowLoginPanelListener() {
		return showLoginPanelListener;
	}
	
	public ShowDateListener getShowDateListerner() {
		return showDateListerner;
	}
	
	public SendBtnPressedListener getSendBtnPressedListener(IExpenseGateway expenseGateway) {
		sendBtnPressedListener.setExpense(expenseGateway);
		return sendBtnPressedListener;
	}
	
}
