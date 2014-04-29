import studiplayer.basic.BasicPlayer;
import studiplayer.basic.WavParamReader;

public class WavFile extends SampledFile {

	// constructor
	public WavFile() {
		super();
	}

	public WavFile(String s) throws NotPlayableException {
		super(s);
		readAndSetDurationFromFile(this.getPathname());

	}

	// methods
	public static long computeDuration(long numberOfFrames, float frameRate) {
		return (long) (numberOfFrames / frameRate * 1000000);

	}

	public void readAndSetDurationFromFile(String pathname)
			throws NotPlayableException {
		WavParamReader.readParams(pathname);

		try {
			BasicPlayer.play(this.getPathname());

		} catch (Exception e) {
			throw new NotPlayableException(this.getPathname(), e.getMessage());

		}

		this.duration = computeDuration(WavParamReader.getNumberOfFrames(),
				WavParamReader.getFrameRate());

	}

	// toString
	public String toString() {
		return super.toString() + " - " + getFormattedDuration();
	}

	public String[] fields() {
		String[] fields = { author, title, "", this.getFormattedDuration() };

		return fields;
	}
}
