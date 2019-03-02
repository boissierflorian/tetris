package net.mostlyoriginal.game.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import net.mostlyoriginal.api.screen.core.WorldScreen;
import net.mostlyoriginal.game.GdxArtemisGame;

public abstract class TransitionableWorldScreen extends WorldScreen {
	
	public Class<? extends Screen> target;
	
	@Override
	public void render(float delta) {
		super.render(delta);
		if (target != null) {
			try {
				GdxArtemisGame.getInstance().setScreen(ClassReflection.newInstance(target));
				dispose();
			} catch (ReflectionException e) {
				
			}
		}
	}
	
	@Override
	public void dispose() {
		world.dispose();
	}
}