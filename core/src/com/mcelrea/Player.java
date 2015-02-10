package com.mcelrea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created on 2/10/2015.
 */
public class Player {

    Body body;
    float speed = 6;

    public Player(World world) {

        //reusable defs
        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();

        //create temp body
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);
        PolygonShape box = new PolygonShape();
        box.setAsBox(0.5f, 1);
        fixtureDef.shape = box;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.1f;
        fixtureDef.density = 1;
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);

        body.getFixtureList().first().setUserData("player");
    }

    public void act(float delta) {

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            body.setTransform(body.getPosition().x + speed * delta, body.getPosition().y, body.getAngle());
            body.setAwake(true);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            body.setTransform(body.getPosition().x - speed * delta, body.getPosition().y, body.getAngle());
            body.setAwake(true);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            body.setTransform(body.getPosition().x, body.getPosition().y + speed * delta, body.getAngle());
            body.setAwake(true);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            body.setTransform(body.getPosition().x, body.getPosition().y - speed * delta, body.getAngle());
            body.setAwake(true);
        }
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
