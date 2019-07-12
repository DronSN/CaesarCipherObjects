
public class CaesarCipher {
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	
	public CaesarCipher(int key) {
		
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		mainKey = key;
		
	}
	
	public String encrypt(String input) {
		
		String returnStr = "";
		
		for (int i = 0; i< input.length(); i++) {
			
			int alphabetIndex = alphabet.indexOf(Character.toUpperCase(input.charAt(i)));
			if (alphabetIndex == -1)
				returnStr = returnStr + input.charAt(i);
			else {
				char encryptChar = shiftedAlphabet.charAt(alphabetIndex);
				if (Character.isUpperCase(input.charAt(i)))
					returnStr = returnStr + Character.toUpperCase(encryptChar);
				else
					returnStr = returnStr + Character.toLowerCase(encryptChar);
				
			}
		}
		
		return returnStr;		
		
	}
	
	public String decrypt(String input) {
		
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		return cc.encrypt(input);
		
	}
	
	

}
