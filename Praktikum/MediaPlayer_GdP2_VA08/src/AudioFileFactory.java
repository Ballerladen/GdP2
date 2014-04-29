public class AudioFileFactory {

	public static AudioFile getInstance(String pathname) {
		if (pathname == null)
			throw new RuntimeException("pathname can not be null");

		if (pathname.isEmpty() || !pathname.contains(".")) {
			throw new RuntimeException("invalid pathname provided");
		}

		if (pathname.endsWith(".wav")) {
			WavFile wf = new WavFile(pathname);
			return (AudioFile) wf;

		} else if (pathname.toLowerCase().endsWith(".mp3") || pathname.toLowerCase().endsWith(".ogg")) {
			TaggedFile tf = new TaggedFile(pathname);
			return (AudioFile) tf;
		}

		throw new RuntimeException("Unknow suffix for Audiofile: \"" + pathname
				+ "\"");
	}

}
