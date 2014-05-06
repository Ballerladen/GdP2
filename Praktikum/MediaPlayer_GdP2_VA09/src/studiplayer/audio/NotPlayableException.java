package studiplayer.audio;

@SuppressWarnings("serial")
public class NotPlayableException extends Exception {

	// attributes
	String pathname;

	// constructors
	public NotPlayableException(String pathname, String msg) {
		super(msg);
		this.setPathname(pathname);

	}

	public NotPlayableException(String pathname, Throwable t) {
		super(t);
		this.setPathname(pathname);
	}

	public NotPlayableException(String pathname, String msg, Throwable t) {
		super(msg, t);
		this.setPathname(pathname);
	}

	private void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public String toString() {
		return this.pathname + ": " + super.toString();
	}

}
