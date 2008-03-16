package com.gangobana.gem;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(292, 210);
		mainFrame.setMinimumSize(new Dimension(292, 210));
//		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}
	
	/**
	 * define System properties
	 */
	private static void setSystemProperties() {

		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.brushMetalLook", "true");
		System.setProperty("apple.awt.antialiasing", "on");
	}

}
