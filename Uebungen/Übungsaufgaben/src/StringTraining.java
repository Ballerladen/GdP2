
public class StringTraining {

public void enumerateStringChars (String s){
	
	for (int i = 0; i < s.length(); i++) {
		System.out.println(i + ": " + s.charAt(i));}
}


public static int countOccurrences(String s, char c){
	int count = 0;
	
	for (int i = 0; i < s.length(); i++); {
		if (s.charAt(c) == c) count++;
	}
	return count;
}


public static int countLongestSequence(String s){
	int rChar = 0;
	int rCount = 0;
	
	
	for (int i = 0; i < s.length(); i++); {
		int i = 0;
		if (s.charAt(i) == rChar)
			rCount++;
		
			
	}
	return 0;
}

}