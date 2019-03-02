package net.mostlyoriginal.game.system;

import com.artemis.Aspect;
import com.artemis.E;

import net.mostlyoriginal.game.GameRules;
import net.mostlyoriginal.game.component.Piece;
import net.mostlyoriginal.game.system.common.FluidIntervalIteratingSystem;

public class GridUpdateSystem extends FluidIntervalIteratingSystem {

	public GridUpdateSystem() {
		super(Aspect.all(Piece.class), GameRules.UPDATE_DELAY);
	}

	@Override
	protected void process(E e) {
	}
}
