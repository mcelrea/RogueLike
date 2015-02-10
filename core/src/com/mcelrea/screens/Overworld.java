package com.mcelrea.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mcelrea.Player;

/**
 * Created on 2/10/2015.
 */
public class Overworld implements Screen {

    SpriteBatch batch;
    World world;
    OrthographicCamera camera;
    Box2DDebugRenderer debugRenderer;
    Player player;

    @Override
    public void show() {

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), true);
        camera = new OrthographicCamera();
        debugRenderer = new Box2DDebugRenderer();

        //reusable defs
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();

        player = new Player(world);

    }

    public void update(float delta) {
        player.act(delta);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        world.step(1/60f, 8, 3);

        camera.update();

        batch.begin();
        batch.end();

        debugRenderer.render(world, camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width/25f;
        camera.viewportHeight = height/25f;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
