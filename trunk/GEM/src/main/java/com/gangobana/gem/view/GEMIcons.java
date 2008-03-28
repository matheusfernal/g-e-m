package com.gangobana.gem.view;

import javax.swing.ImageIcon;

/**
 * Gives the icons used by the application
 * @author matheusfernal
 *
 */
public class GEMIcons extends ImageIcon {
	
	private static final long serialVersionUID = 7180427661840168094L;
	
	// Load the icons
	private static ClassLoader classLoader;
	static {
		classLoader = GEMIcons.class.getClassLoader();
	}
	
	/**
	 * Creates a new icon
	 */
	private GEMIcons(String imagePath) {
		super(classLoader.getResource(imagePath));
	}
	
	// Main tool bar
	public static final GEMIcons LOGIN = new GEMIcons("images/system-users.png");
	public static final GEMIcons CALENDAR = new GEMIcons("images/office-calendar.png");
	
}
