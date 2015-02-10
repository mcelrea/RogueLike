package com.mcelrea;

import com.badlogic.gdx.Game;
import com.mcelrea.screens.Overworld;

public class MyGdxGame extends Game {

	@Override
	public void create() {
		setScreen(new Overworld());
	}
}
