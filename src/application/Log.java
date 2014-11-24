package application;

public class Log {
	static Log instance;
	String text;
	private Log() {
		// TODO Auto-generated constructor stub
		text = "";
	}
	
	public static Log sharedInstance() {
		if(instance == null) {
			instance = new Log();
		}
		return instance;
	}
	
	public String get() {
		return text;
	}
	
	public void put(String str) {
		if(str.length() > 0) {
			text += str + "\n"; 
		}
	}
	
	public void clear() {
		text = "";
	}

}
