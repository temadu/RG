package temadu.rhythmgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Conductor {
	
	public Music song;
	private float offset;
	private float songpos;
	
	private float bpm;
	private float crotchet;
	private float lastbeat;
	private float nextbeat;
	
	private int beatnumber;
	private Sound sound;
	
	public Conductor() {
		this.songpos = 0f;
		this.lastbeat = 0.0f;
		sound = Gdx.audio.newSound(Gdx.files.internal("palma.wav"));
	}
	
	// If using a song.
	public void songUpdate(){
		songpos = song.getPosition();
		if(songpos > nextbeat){
			//sound.play();
			lastbeat = nextbeat;
			nextbeat += crotchet;
			beatnumber++;
			System.out.println("LastBeat = " + lastbeat + "; NextBeat = " + nextbeat);
			System.out.println(songpos);
		}
	}
	
	//If no song is being used
	public void deltaUpdate(){
		songpos += Gdx.graphics.getRawDeltaTime();
		if(songpos > lastbeat + crotchet){
			//sound.play();
			lastbeat = nextbeat;
			nextbeat += crotchet;
			beatnumber++;
			System.out.println("LastBeat = " + lastbeat + "; NextBeat = " + nextbeat);
			System.out.println(songpos);
			System.out.println(song.getPosition());
		}
	}

	//TODO:Instead of using OR, i should use AND for comprehension
	public boolean onBeat(){
		return ((songpos > (nextbeat - 0.1f)) || (songpos < (lastbeat + 0.1f)));
	}
	
	public void setBPM(float bpm) {
		this.bpm = bpm;
		this.crotchet = 60.0f/bpm;
		this.nextbeat = crotchet;
		System.out.println("BPM: " + bpm + "; Crotchet: " + crotchet);
	}
	
	public int getBeatNumber(){
		return beatnumber;
	}
	
	public float getSongpos() {
		return songpos;
	}
}
