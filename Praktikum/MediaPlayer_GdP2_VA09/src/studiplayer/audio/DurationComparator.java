package studiplayer.audio;

import java.util.Comparator;

public class DurationComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile af1, AudioFile af2) {
		int outcome = 0;

		if (af1 == null || af2 == null)
			throw new NullPointerException(
					"Audiofiles to compare cannot be null");

		SampledFile sf1 = (SampledFile) af1;
		SampledFile sf2 = (SampledFile) af2;

		if (sf1.getDuration() == sf2.getDuration()) {
			outcome = 0;
		} else if (sf1.getDuration() > sf2.getDuration()) {
			outcome = 1;
		} else if (sf1.getDuration() < sf2.getDuration()) {
			outcome = -1;

		}
		return outcome;
	}
}
