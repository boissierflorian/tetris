package net.mostlyoriginal.game.system.view;

import com.badlogic.gdx.Gdx;

import net.mostlyoriginal.api.manager.AbstractAssetSystem;
import net.mostlyoriginal.game.GameRules;

@SuppressWarnings("deprecation")
public class GameScreenAssetSystem extends AbstractAssetSystem {
	public static final int GRID_WIDTH = 244;
	public static final int GRID_HEIGHT = 484;
	
	public GameScreenAssetSystem() {
		super("tileset.png");
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		loadAssets();
		playMusic("sfx/tetris_main.mp3");
	}
	
	private void loadAssets() {
		// MAP => 10 LARGEUR et 10 HAUTEUR
		// Carré de taille 24/24
		System.out.println("Loading assets");
		add("grid", 567, 12, 244, 484, 1);
		add("l", 813, 448, 72, 48, 1);
		add("cube", 887, 448, 48, 48, 1);
		add("stick", 2, 2, 24, 96, 1);
		add("t", 28, 50, 72, 48, 1);
		add("z", 813, 374, 48, 72, 1);
	}
	
	public void playMusic(String mp3) {
		if (GameRules.music != null) {
			GameRules.music.stop();
			GameRules.music.dispose();
		}
		
		GameRules.music = Gdx.audio.newMusic(Gdx.files.internal(mp3));
		GameRules.music.stop();
		GameRules.music.setLooping(true);
		
		if (GameRules.musicOn) {
			GameRules.music.play();
		}
		
		GameRules.music.setVolume(GameRules.musicVolume);
		GameRules.music.setPan(0, 0.1f);
	}
}
