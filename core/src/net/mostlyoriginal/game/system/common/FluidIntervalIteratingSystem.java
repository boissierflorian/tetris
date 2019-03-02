package net.mostlyoriginal.game.system.common;

import com.artemis.Aspect.Builder;
import com.artemis.E;
import com.artemis.systems.IntervalIteratingSystem;

public abstract class FluidIntervalIteratingSystem extends IntervalIteratingSystem {

	public FluidIntervalIteratingSystem(Builder aspect, float interval) {
		super(aspect, interval);
	}

	@Override
	protected void process(int entityId) {
		process(E.E(entityId));
	}

	protected abstract void process(E e);
}
