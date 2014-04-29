import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class PlayList extends LinkedList<AudioFile> {

	// attributes
	private int current;

	// constructor
	public PlayList() {
		super();
		current = 0;
	}

	public PlayList(String pathname) throws NotPlayableException {
		this();
		this.loadFromM3U(pathname);

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
		FileWriter writer = null;
		String fname = pathname;
		String linesep = System.getProperty("line.separator");

		try {
			writer = new FileWriter(fname);
			writer.write("# My best songs" + linesep);
			writer.write("# Das " + linesep);
			writer.write("# hier " + linesep);
			writer.write("# ist " + linesep);
			writer.write("# eine " + linesep);
			writer.write("# Uebung zum " + linesep);
			writer.write("# Thema " + linesep);
			writer.write("# FileWriter " + linesep);
			writer.write(linesep);

			for (int i = 0; i < this.size(); i++) {
				writer.write(this.get(i).getPathname() + linesep);

			}
		} catch (IOException e) {
			throw new RuntimeException("Unable to write to file " + fname + ":"
					+ e.getMessage());
		} finally {
			try {
				writer.close();
			} catch (Exception e) {

			}
		}

	}

	public void loadFromM3U(String pathname) throws NotPlayableException {
		Scanner scanner = null;
		String line;
		this.clear();

		try {
			scanner = new Scanner(new File(pathname));
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (!line.trim().isEmpty() && !line.contains("#") && line.contains(".")) {

					this.add(AudioFileFactory.getInstance(line));
				}

			}

		} catch (IOException e) {
			throw new RuntimeException(e);
			e.printStackTrace();
			
		} finally {
			try {
				scanner.close();

			} catch (Exception e) {

			}
		}
	}
} // PlayList end
