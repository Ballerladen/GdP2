import java.io.File;

public abstract class AudioFile {

	// attributes
	String pathname;
	String filename;
	String author;
	String title;

	// constructor 1
	public AudioFile() {
		pathname = "";
		filename = "";
		author = "";
		title = "";

	}

	// constructor pathname at file
	public AudioFile(String file) {
		this();

		parsePathname(file);
		parseFilename(this.filename);

		File check = new File(this.getPathname());
		if (!check.canRead()) {
			throw new RuntimeException("Can't read file at: "
					+ this.getPathname());
		}

	}

	// abstract methods
	public abstract void play();

	public abstract void togglePause();

	public abstract void stop();

	public abstract String getFormattedDuration();

	public abstract String getFormattedPosition();
	

	// getters
	public String getPathname() {
		return pathname + filename;

	}

	public String getFilename() {
		return filename;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	// public methods

	public String toString() {
		if (getAuthor().isEmpty()) {
			return title;
		} else {
			return author + " - " + title;
		}
	}

	// parsePathname
	public void parsePathname(String pathName) {
		// Ueberpruefung pathname != leer
		if (pathName.isEmpty())
			return;

		String sepchar = java.io.File.separator;

		// slashes ausgerichtet
		pathName = pathName.replace("/", sepchar);
		pathName = pathName.replace("\\", sepchar);

		/* Backslash dezimieren */
		// leeren Stringpuffer anlegen
		StringBuffer neu = new StringBuffer();

		int ineu = 0;

		if (pathName.contains(":")) {
			neu.append("/");
			neu.append(pathName.charAt(0));
			ineu = 1;
		} else {
			neu.append(pathName.charAt(0));
		}

		// zeichen kopieren
		for (int i = 1; i < pathName.length(); i++) {
			if ((pathName.charAt(i) != sepchar.charAt(0) || neu.charAt(ineu) != sepchar
					.charAt(0)) && pathName.charAt(i) != ':') {
				neu.append(pathName.charAt(i));
				ineu++;
			}
		}

		// zurück konvertieren
		pathName = neu.toString();

		if (pathName.endsWith(sepchar)) {
			// kein audiofile
			pathname = pathName;
			filename = "";
		} else if (pathName.contains(sepchar)) {
			// audiofile + ordner
			int lastSep = pathName.lastIndexOf(sepchar);
			pathname = pathName.substring(0, lastSep + 1);
			filename = pathName.substring(lastSep + 1);
		} else {
			// nur audiofile
			pathname = "";
			filename = pathName;
		}

	} // parsePathname end

	// parseFilename
	public void parseFilename(String fileName) {
		// abbruchbedingungen
		if (fileName.lastIndexOf(".") == 0)
			return;

		if (fileName.contains(".")) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));

		}

		// unterscheide Author/Title
		if (fileName.contains(" - ")) {
			author = fileName.substring(0, fileName.lastIndexOf(" - ")).trim();
			title = fileName.substring(fileName.lastIndexOf(" - ") + 3).trim();

			if (fileName.contains(".")) {
				fileName = fileName.substring(0, fileName.lastIndexOf("."));

			}

		} else {
			author = "";
			title = fileName.trim();
		}

	} // parseFilename end

} // AudioFile end
