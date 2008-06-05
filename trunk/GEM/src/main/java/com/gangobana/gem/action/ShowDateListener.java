package com.gangobana.gem.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXMonthView;

public class ShowDateListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		JPopupMenu popup = new JPopupMenu();
		
		JXMonthView mv = new JXMonthView();
		
		popup.add(mv);
		
		mv.addActionListener(new DateSelectedListener());
		
		popup.show((Component)e.getSource(), 0, 0);

	}
	
	private class DateSelectedListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
