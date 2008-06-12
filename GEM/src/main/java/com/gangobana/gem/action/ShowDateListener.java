package com.gangobana.gem.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXMonthView;

public class ShowDateListener implements ActionListener {

	private JPopupMenu popup;
	private JXMonthView monthView;
	
	public ShowDateListener() {
		popup = new JPopupMenu();
		monthView = new JXMonthView();
		
		popup.add(monthView);
		monthView.setTraversable(true);
		monthView.addActionListener(new DateSelectedListener());
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Component component = (Component)e.getSource();
		popup.show(component, 0, component.getHeight());

	}
	
	private class DateSelectedListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			popup.setVisible(false);
			
		}
		
	}

}
