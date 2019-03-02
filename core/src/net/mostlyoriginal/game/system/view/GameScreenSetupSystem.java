package net.mostlyoriginal.game.system.view;

import com.artemis.BaseSystem;
import com.artemis.E;
import com.artemis.annotations.Wire;

import net.mostlyoriginal.game.utils.Anims;

import static com.artemis.E.E;

@Wire
public class GameScreenSetupSystem extends BaseSystem {

	@Override
	protected void processSystem() {
	}
	
	
	@Override
	public void initialize() {
		super.initialize();
		spawnGrid();
	}
	
	public void spawnGrid() {
		float zoom = Anims.scaleToScreenRounded(1f,
				GameScreenAssetSystem.GRID_WIDTH);

		Anims.createCenteredAt(GameScreenAssetSystem.GRID_WIDTH,
				GameScreenAssetSystem.GRID_HEIGHT, "grid", 1f);
	}
}
