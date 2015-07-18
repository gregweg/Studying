package Study;

public class StringRemoveADuplicateB {
	// Given a string, remove all 'b's and duplicate all a's
	public String removeADupB(String initialStr) {
		char[] chars = initialStr.toCharArray();
		int strIndex = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'a') {
				chars[strIndex++] = chars[i];
				chars[strIndex++] = chars[i];
			} else if (chars[i] != 'b') {
				chars[strIndex++] = chars[i];
			}
		}
		
		return chars.toString();
	}

}
