import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import studiplayer.audio.AudioFile;
import studiplayer.audio.AudioFileFactory;
import studiplayer.audio.PlayList;
import studiplayer.audio.TaggedFile;
import studiplayer.audio.WavFile;

public class UTestAudioFileFactory {
	@Test
	public void test_getInstance_01() throws Exception {
		try {
			AudioFileFactory.getInstance("unknown.xxx");
			fail("Unknow suffix; expecting exception");
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void test_getInstance_02() throws Exception {
		try {
			AudioFileFactory.getInstance("nonexistent.mp3");
			fail("File is not readable; expecting exception");
		} catch (RuntimeException e) {
			// Expected
		}
	}

	@Test
	// @Ignore
	public void test_loadFromM3U_02() throws Exception {
		String m3u_pathname = "playlist.m3u";
		String mp3_pathname = "corrupt.mp3";

		// Create the M3U file with one entry for a non-existent mp3 file
		FileWriter writer = null;
		try {
			// Create a FileWriter
			writer = new FileWriter(m3u_pathname);
			writer.write(mp3_pathname + System.getProperty("line.seperator"));
		} catch (IOException e) {
			throw new RuntimeException("Unable to store M3U file: "
					+ m3u_pathname, e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// Just swallow
			}
		}

		PlayList pl = new PlayList();
		pl.loadFromM3U(m3u_pathname);
		new File(m3u_pathname).delete();

	}

	@Test
	public void test_getInstance_03() throws Exception {
		AudioFile af1 = AudioFileFactory
				.getInstance("audiofiles/Eisbach Deep Snow.ogg");
		assertTrue("Expecting object of type TaggedFile",
				(af1 instanceof TaggedFile));

		AudioFile af2 = AudioFileFactory
				.getInstance("audiofiles/wellenmeister - tranquility.wav");
		assertTrue("Expecting object of type WavFile", (af2 instanceof WavFile));

		AudioFile af3 = AudioFileFactory.getInstance("audiofiles/special.oGg");
		assertTrue("Expecting object of type TaggedFile",
				(af3 instanceof TaggedFile));
	}
}
