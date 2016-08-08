import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Music {
	private String title, mood, file;

	public Music(String t, String m, String f) {
		// TODO Auto-generated constructor stub
		title = t;
		mood = m;
		file = f;
		System.out.println(t);
		//System.out.println("Play");
		Play(m);
	}
 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	public void Play(String sound) {
		System.out.println("Weather: " + sound);
		try {
			java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new java.net.URL("file:///C:/Users/tesht/workspace/Mood Clock/src/" + sound + ".wav"));
			clip.play();
			
		} catch (java.net.MalformedURLException error) {
			System.out.println(error);
		}
		System.out.println();
		System.out.println();

	}
}
