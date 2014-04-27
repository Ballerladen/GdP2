import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class PlayList extends LinkedList<AudioFile> {

	// attributes
	private int current;

	// constructor
	public PlayList() {
		current = 0;
	}

	// setters
	public void setCurrent(int current) {
		this.current = current;
	}

	// getters
	public int getCurrent() {
		return current;

	}

	public AudioFile getCurrentAudioFile() {
		if (this.getCurrent() < this.size() && this.getCurrent() >= 0) {
			// element exists
			return this.get(getCurrent());
		} else {
			return null;
		}
	}

	public void changeCurrent() {
		if (this.getCurrent() >= this.size() - 1) {
			this.setCurrent(0);
			if (true) {
				Collections.shuffle(this);
			}
		} else {
			setCurrent(getCurrent() + 1);
		}
	}

	public void setRandomOrder(boolean randomOrder) {
		randomOrder = true;
		if (randomOrder) {
			Collections.shuffle(this);
		}

	}
	
	public void saveAsM3U(String pathname) {
		
	}

} // PlayList end
