public class AudioFile {

	// attributes
	String pathname;
	String filename;

	// constructors
	public AudioFile() {
		pathname = "";
		filename = "";
	}

	// getters
	public String getPathname() {
		return pathname + filename;

	}

	public String getFilename() {
		return filename;
	}

	public void parseFilename(String filename) {

	}

	public String getAuthor() {
		return "";
	}

	public String getTitle() {
		return "";
	}

	// public methods
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
	public void test_parseFilename(String filename) {
		

	}

} // AudioFile end
