package com.gangobana.gem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.gangobana.gem.presentationmodel.AbstractSubmitFormPresentationModel;
import com.gangobana.gem.presentationmodel.SubmitFormPresentationModel;
import com.gangobana.gem.view.SubmitFormView;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		setSystemProperties();
		
		AbstractSubmitFormPresentationModel pm = new SubmitFormPresentationModel(null);

		JPanel mainPanel = new SubmitFormView(pm);
		
		JFrame mainFrame = new JFrame("GEM");
		mainFrame.add(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(300, 230);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}
	
	/**
	 * define System properties
	 */
	private static void setSystemProperties() {

		System.setProperty("apple.laf.useScreenMenuBar", "true");
//		System.setProperty("apple.awt.brushMetalLook", "true");
		System.setProperty("apple.awt.antialiasing", "on");
		
		Border border = UIManager.getBorder("TitledBorder.aquaVariant");
		
		if (border != null) {
			UIManager.put("TitledBorder.border", border);
		}
	}

}
