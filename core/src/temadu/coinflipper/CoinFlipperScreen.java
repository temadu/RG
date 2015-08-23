package temadu.coinflipper;

import temadu.rhythmgame.BasicScreen;
import temadu.rhythmgame.Conductor;
import temadu.rhythmgame.RhythmGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class CoinFlipperScreen extends BasicScreen {
	
	BitmapFont font;
	Conductor conductor;
	
	public CoinFlipperScreen(RhythmGame game) {
		super(game);
	}
	
	@Override
	public void show() {
		font = game.getFont();
		conductor = game.getConductor();
	}
	
	@Override
	public void render(float delta) {
		
		
	}
}
