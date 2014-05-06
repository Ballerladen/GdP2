package studiplayer.audio;

import java.util.Comparator;

public class AuthorComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile af1, AudioFile af2) {
		if (af1 == null || af2 == null)
			throw new NullPointerException("Compared Audiofiles cannot be null");

		if (af1.getAuthor() == null || af2.getAuthor() == null)
			throw new NullPointerException("Authors to compare can´t be null");

		return af1.getAuthor().compareTo(af2.getAuthor());
	}

}
