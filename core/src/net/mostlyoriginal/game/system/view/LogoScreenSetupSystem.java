package net.mostlyoriginal.game.system.view;

import com.artemis.BaseSystem;
import com.artemis.E;
import com.artemis.annotations.Wire;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;

import net.mostlyoriginal.api.component.graphics.Tint;
import net.mostlyoriginal.api.operation.OperationFactory;
import net.mostlyoriginal.game.screen.GameScreen;
import net.mostlyoriginal.game.system.logic.TransitionSystem;
import net.mostlyoriginal.game.utils.Anims;
import static net.mostlyoriginal.api.operation.JamOperationFactory.moveBetween;
import static net.mostlyoriginal.api.operation.JamOperationFactory.scaleBetween;
import static net.mostlyoriginal.api.operation.JamOperationFactory.moveTo;
import static net.mostlyoriginal.api.operation.OperationFactory.*;

@Wire
public class LogoScreenSetupSystem extends BaseSystem {

	public static final Tint COLOR_LOGO_FADED = new Tint(1.0f, 1.0f, 1.0f,
			0.0f);
	public static final Tint COLOR_LOGO_FULL = new Tint(1.0f, 1.0f, 1.0f, 1.0f);

	private TransitionSystem transitionSystem;
	private float cooldown = 5f;
	private boolean finished = false;
	private E logo;

	@Override
	protected void processSystem() {
		cooldown -= world.delta;
		if (cooldown <= 0 && !finished) {
			finished = true;
			fadeLogo();
			transitionSystem.transition(GameScreen.class, 0.5f);
		}
	}

	@Override
	protected void initialize() {
		super.initialize();
		addLogo(0.8f);
	}

	private void fadeLogo() {
		logo.script(OperationFactory.sequence(delay(1f),
				tween(new Tint(COLOR_LOGO_FULL), Tint.TRANSPARENT, 0.5f,
						Interpolation.fade)));
	}

	private void addLogo(float scale) {
		float zoom = Anims.scaleToScreenRounded(scale,
				LogoScreenAssetSystem.LOGO_WIDTH);

		logo = Anims
				.createCenteredAt(LogoScreenAssetSystem.LOGO_WIDTH,
						LogoScreenAssetSystem.LOGO_HEIGHT, "logo", zoom)
				.tint(COLOR_LOGO_FADED)
				.script(scaleBetween(zoom * 2, zoom, 3f,
						Interpolation.bounceOut),
						tween(new Tint(COLOR_LOGO_FADED),
								new Tint(COLOR_LOGO_FULL), 5f,
								Interpolation.fade));

		logo.script(moveBetween(new Vector2(0, 0),
				new Vector2(logo.posX(), logo.posY()), 3f));
	}
}
