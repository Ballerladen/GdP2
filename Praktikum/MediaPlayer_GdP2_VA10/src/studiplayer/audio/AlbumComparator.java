package studiplayer.audio;

import java.util.Comparator;

public class AlbumComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile af1, AudioFile af2) {
		int outcome;

		if (af1 == null || af2 == null)
			throw new NullPointerException();

		TaggedFile tf1 = null, tf2 = null;

		if (af1 instanceof TaggedFile) {
			tf1 = (TaggedFile) af1;
		}

		if (af2 instanceof TaggedFile) {
			tf2 = (TaggedFile) af2;
		}

		if (tf1 == null && tf2 != null) {

			outcome = -1;
		} else if (tf1 != null && tf2 == null) {

			outcome = 1;
		} else if (tf1 == null && tf2 == null) {

			outcome = 0;
		} else {
			outcome = tf1.getAlbum().compareTo(tf2.getAlbum());
		}

		return outcome;
	}

}
