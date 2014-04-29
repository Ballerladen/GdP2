import java.util.Map;

import studiplayer.basic.BasicPlayer;
import studiplayer.basic.TagReader;

public class TaggedFile extends SampledFile {

	// attributes
	String album;

	// constructor
	public TaggedFile() {
		super();
		album = "";
	}

	public TaggedFile(String pathname) throws NotPlayableException {
		super(pathname);
		album = "";
		readAndStoreTags(getPathname());

	}

	// getter
	public String getAlbum() {
		return album;
	}

	// readAndStoreTags
	public void readAndStoreTags(String pathname) throws NotPlayableException {
		Map<String, Object> tag_map = TagReader.readTags(pathname);

		try {
			BasicPlayer.play(this.getPathname());

		} catch (Exception e) {
			throw new NotPlayableException(this.getPathname(), e.getMessage());

		}

		if (tag_map == null)
			throw new RuntimeException("Parsing map failed");

		if (tag_map.containsKey("title")) {
			if (!tag_map.get("title").toString().trim().isEmpty()) {
				title = tag_map.get("title").toString().trim();
			}
		}
		if (tag_map.containsKey("author")) {
			if (!tag_map.get("author").toString().trim().isEmpty()) {
				author = tag_map.get("author").toString().trim();
			}
		}
		if (tag_map.containsKey("album")) {
			if (!tag_map.get("album").toString().trim().isEmpty()) {
				album = tag_map.get("album").toString().trim();
			}
		}
		if (tag_map.containsKey("duration")) {
			if (!tag_map.get("duration").toString().trim().isEmpty()) {
				duration = Long.parseLong(tag_map.get("duration").toString()
						.trim());
			}
		}

	}

	// toString
	public String toString() {
		if (getFormattedDuration().isEmpty()) {
			return super.toString() + " - " + this.getFormattedDuration();
		} else {
			return super.toString() + " - " + album + " - "
					+ this.getFormattedDuration();
		}
	}

	public String[] fields() {
		String[] fields = { author, title, this.getAlbum(),
				this.getFormattedDuration() };

		return fields;
	}
} // public class TaggedFile end
