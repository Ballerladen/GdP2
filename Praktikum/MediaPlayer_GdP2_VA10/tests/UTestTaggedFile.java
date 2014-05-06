import static org.junit.Assert.*;
import studiplayer.audio.TaggedFile;
import studiplayer.audio.WavFile;
import studiplayer.basic.TagReader;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class UTestTaggedFile {

	@Test @Ignore
	public void test_play_01() throws Exception {
		TaggedFile tf = new TaggedFile("audiofiles/Rock 812.mp3");
		tf.play();
		// Note: cancel playback in eclipse console window
	}

	@Test
	public void test_timeFormatter_10() throws Exception {
		assertEquals("Wrong time format", "05:05",
				TaggedFile.timeFormatter(305862000L));
	}

	@Test
	public void test_timeFormatter_08() throws Exception {
		try {
			// Call method with time value that underflows our format
			TaggedFile.timeFormatter(-1L);
			// We should never get here
			fail("Time value underflows format; expecting exception");

		} catch (RuntimeException e) {
			// Expected
		}
	}

	// Read all tags from a TaggedFile
	// This test demonstrates the functionality of TagReader.readTags()
	@Test
	// Ignore
	public void test_readTags_01() throws Exception {
		TaggedFile tf = new TaggedFile("audiofiles/Rock 812.mp3");
		Map<String, Object> tag_map = TagReader.readTags(tf.getPathname());
		for (String key : tag_map.keySet()) {
			System.out.printf("\nKey: %s\n", key);
			System.out.printf("Type of value: %s\n", tag_map.get(key)
					.getClass().toString());
			System.out.println("Value: " + tag_map.get(key));

		}
	}

	@Test
	public void test_readAndStoreTags_03() throws Exception {
		TaggedFile tf = new TaggedFile();
		tf.readAndStoreTags("audiofiles/Rock 812.mp3");
		assertEquals("Wrong author", "Eisbach", tf.getAuthor());
		assertEquals("Wrong title", "Rock 812", tf.getTitle());
		assertEquals("Wrong album", "The Sea, the Sky", tf.getAlbum());
		assertEquals("Wrong time format", "05:31", tf.getFormattedDuration());

	}

	@Test
	public void test_computeDuration_02() throws Exception {
		assertEquals("Wrong duration", 2000000L,
				WavFile.computeDuration(88200L, 44100.0f));
	}

	@Test
	public void test_readAndSetDurationFromFile_01() throws Exception {
		WavFile wf = new WavFile();
		wf.parsePathname("audiofiles/wellenmeister - tranquility.wav");
		wf.readAndSetDurationFromFile(wf.getPathname());
		assertEquals("Wrong time format", "02:21", wf.getFormattedDuration());

	}
}
