package com.microsoft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {


    // Object that allows us to draw all our graphics
    private SpriteBatch spriteBatch;


    // Object that allows us to draw shapes
    private ShapeRenderer shapeRenderer;


    // Camera to view the virtual world
    private Camera camera;

    // Control how the camera views the world
    // zoom in/out? Keep everything scaled?
    private Viewport viewport;

    private GameBoard myGameBoard;

    private BitmapFont defaultFont = new BitmapFont();
    private boolean debug = true;


    public GameScreen() {
        myGameBoard = new GameBoard();
    }


    // Runs one time at the very beginning, all setup should happen here

    @Override
    public void show() {
        camera = new OrthographicCamera(); // 2D Camera
        camera.position.set(MyGdxGame.WORLD_WIDTH/2,
                            MyGdxGame.WORLD_HEIGHT/2, 0);
        camera.update();

        // Freeze my view to WORLD_WIDTH x WORLD_HEIGHT
        // no matter the resolution of the window
        viewport = new FitViewport(MyGdxGame.WORLD_WIDTH, MyGdxGame.WORLD_HEIGHT, camera);

        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        // ???? I just know this was the solution to a problem
        shapeRenderer.setAutoShapeType(true);

    }



    public void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    // this method runs as fast as it can (or to a set FPS)
    // repeatedly, constantly looped
    // things to include in this method:
    //          1. Process user input
    //          2. AI
    //          3. Draw all Graphics

    @Override
    public void render(float delta) {
        clearScreen();

        // all drawing of shapes MUST go between begin and end

        shapeRenderer.begin();
        shapeRenderer.setColor(1, 1, 0, 1);
        shapeRenderer.circle(MyGdxGame.WORLD_WIDTH/2, MyGdxGame.WORLD_HEIGHT/2, 30);
        shapeRenderer.end();

        // all drawings of graphics must be between begin and end
        spriteBatch.begin();
        myGameBoard.draw(spriteBatch);
        if(debug) {
            drawDebugText();
        }
        spriteBatch.end();

    }

    private void drawDebugText() {
        int mouseX = Gdx.input.getX();
        int mouseY = (int) Gdx.graphics.getWidth() - Gdx.input.getY();
        Location currentLoc = myGameBoard.getTileAt(mouseX, mouseY);
        defaultFont.draw(spriteBatch, Gdx.input.getX() + " " + (768 - Gdx.input.getY()), 6, 700);
        defaultFont.draw(spriteBatch, currentLoc.getRow() + " " + currentLoc.getCol(), 6, 400);
    }

    @Override
    public void resize(int width, int height) {

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
