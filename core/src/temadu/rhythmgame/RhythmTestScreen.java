package temadu.rhythmgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RhythmTestScreen extends BasicScreen {

	private BitmapFont font;
	private SpriteBatch batch;
	private Conductor conductor;
	private Sound sound;
	
	private float hitTimer;
	private HitFlag flag;
	
	public RhythmTestScreen(RhythmGame game) {
		super(game);
	}
	
	@Override
	public void show() {
		font = game.getFont();
		batch = game.getBatch();
		conductor = game.getConductor();
		sound = Gdx.audio.newSound(Gdx.files.internal("palma.wav"));
		hitTimer = 0f;
		conductor.setBPM(120);
		
		conductor.song = Gdx.audio.newMusic(Gdx.files.internal("retro120.wav"));
		conductor.song.setLooping(true);
		conductor.song.setVolume(0.05f);
		conductor.song.play();
	}
	
	@Override
	public void render(float delta) {
		//conductor.songUpdate(); // song too short (problem with loop)
		conductor.deltaUpdate();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		if(conductor.onBeat()){
			font.draw(batch, "BEAT", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 - 30);
		}
		checkBeat();
		font.draw(batch, String.valueOf(conductor.getBeatNumber()), Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		font.draw(batch,"FPS: " + Gdx.graphics.getFramesPerSecond(), Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 + 30);
		batch.end();
		
	}
	
	public void checkBeat(){
		
		hitTimer -= Gdx.graphics.getDeltaTime();
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			if(conductor.onBeat()){
				sound.play(1.0f);
				flag = HitFlag.HIT1;
			}
			else{
				flag = HitFlag.MISS;
			}
			hitTimer = 0.2f;
		}
		
		if(hitTimer < 0)
			flag = HitFlag.NONE;
		
		switch (flag) {
		case HIT1:
			font.draw(batch, "HIT!!!", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 + 60);
			break;
		case MISS:
			font.draw(batch, "MISS!!!", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 + 60);
			break;
		case NONE:
			break;
		}
	}
	
	

}
