abstract class SampledFile extends AudioFile {

	// attributes
	String album;
	long duration;

	// constructor

	public SampledFile() {
		super();
		duration = 0L;
	}

	public SampledFile(String s) {
		super(s);
		duration = 0L;
	}

	// getters
	public void play() {

	}

	public void togglePause() {

	}

	public void stop() {

	}

	public String getFormattedDuration() {
		return timeFormatter(duration);
	}

	public String getFormattedPosition() {
		return timeFormatter(studiplayer.basic.BasicPlayer.getPosition());
	}

	public String getAlbum() {
		return album;
	}

	// timeFormatter
	public static String timeFormatter(long microseconds) {
		if (microseconds < 0) {
			throw new RuntimeException("Negativ time value provided");
		}
		if (microseconds > 599999999L) {
			throw new RuntimeException("Time value exceeds allowed format");
		}

		int minutes = (int) ((microseconds / 1000000) / 60);
		int seconds = (int) ((microseconds / 1000000) % 60);

		return String.format("%02d:%02d", minutes, seconds);
	}

} // SampledFile end