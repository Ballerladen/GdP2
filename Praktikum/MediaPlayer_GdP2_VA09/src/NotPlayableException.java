public class NotPlayableException extends Exception{

	// attributes
	String pathname;

	// constructors
	public NotPlayableException(String pathname, String msg) {
		super();
	}

	public NotPlayableException(String pathname, Throwable t) {
		super();		
	}

	public NotPlayableException(String pathname, String msg, Throwable t) {
		super();
	}
	
	
	public String toString() {
		return this.pathname + ": " + super.toString();
	}
	
	
	
	

}
