package temadu.rhythmgame;

import temadu.coinflipper.CoinFlipperScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RhythmGame extends Game {
	SpriteBatch batch;
	BitmapFont font;
	OrthographicCamera camera;
	Conductor conductor;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		conductor = new Conductor();
		setScreen(new RhythmTestScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public Conductor getConductor() {
		return conductor;
	}
}
