package com.gangobana.gem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.gangobana.gem.view.SubmitFormView;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		setSystemProperties();

		JPanel mainPanel = new SubmitFormView();
		
		JFrame mainFrame = new JFrame("GEM");
		mainFrame.add(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}
	
	/**
	 * define System properties
	 */
	private static void setSystemProperties() {
		
		// set the Quaqua Look and Feel in the UIManager
        try { 
             UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
        }
        catch (Exception e) {
        	e.printStackTrace();
        }

		System.setProperty("apple.laf.useScreenMenuBar", "true");
//		System.setProperty("apple.awt.brushMetalLook", "true");
		System.setProperty("apple.awt.antialiasing", "on");
		
		Border border = UIManager.getBorder("TitledBorder.aquaVariant");
		
		if (border != null) {
			UIManager.put("TitledBorder.border", border);
		}
	}

}
