package net.mostlyoriginal.game.screen;

import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.graphics.Color;

import net.mostlyoriginal.api.manager.FontManager;
import net.mostlyoriginal.api.system.camera.CameraSystem;
import net.mostlyoriginal.api.system.graphics.RenderBatchingSystem;
import net.mostlyoriginal.api.system.render.ClearScreenSystem;
import net.mostlyoriginal.game.GameRules;
import net.mostlyoriginal.game.GdxArtemisGame;
import net.mostlyoriginal.game.system.MyAnimRenderSystem;
import net.mostlyoriginal.game.system.MyLabelRenderSystem;
import net.mostlyoriginal.game.system.logic.TransitionSystem;
import net.mostlyoriginal.game.system.view.LogoScreenAssetSystem;
import net.mostlyoriginal.game.system.view.LogoScreenSetupSystem;
import net.mostlyoriginal.plugin.OperationsPlugin;

public class LogoScreen extends TransitionableWorldScreen {

	@Override
	protected World createWorld() {
		final RenderBatchingSystem renderBatchingSystem;
		
		return new World(new WorldConfigurationBuilder()
				.dependsOn(OperationsPlugin.class)
				.with(WorldConfigurationBuilder.Priority.HIGH,
					new SuperMapper(),
					new TagManager(),
					new FontManager(),
					new CameraSystem(GameRules.CAMERA_ZOOM),
					new LogoScreenAssetSystem()
				).with(WorldConfigurationBuilder.Priority.LOW,
					new ClearScreenSystem(Color.valueOf("3D6B9F")),
					renderBatchingSystem = new RenderBatchingSystem(),
					new MyAnimRenderSystem(renderBatchingSystem),
					new MyLabelRenderSystem(renderBatchingSystem),
					new LogoScreenSetupSystem(),
					new TransitionSystem(GdxArtemisGame.getInstance(), this))
				.build());
	}

}
