package com.microsoft;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {

	public static final float WORLD_WIDTH = 1024;
	public static final float WORLD_HEIGHT = 768;

	@Override
	public void create() {
		setScreen(new GameScreen());

	}
}
