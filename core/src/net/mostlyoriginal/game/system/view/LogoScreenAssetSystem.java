package net.mostlyoriginal.game.system.view;

import net.mostlyoriginal.api.manager.AbstractAssetSystem;

@SuppressWarnings("deprecation")
public class LogoScreenAssetSystem extends AbstractAssetSystem {
	
	public static final int LOGO_WIDTH = 563;
	public static final int LOGO_HEIGHT = 396;
	
	public LogoScreenAssetSystem() {
		super("tileset.png");
	}
	
	@Override
	public void initialize() {
		super.initialize();
		add("logo", 2, 100, 563, 396, 1);
	}	
}