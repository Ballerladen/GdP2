package studiplayer.audio;

import java.util.Comparator;

public class TitleComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile af1, AudioFile af2) {
		if (af1 == null || af2 == null)
			throw new NullPointerException("Compared Audiofiles cannot be null");

		if (af1.getTitle() == null || af2.getTitle() == null)
			throw new NullPointerException("Titles to compare cannot be null");

		return af1.getTitle().compareTo(af2.getTitle());

	}

}
