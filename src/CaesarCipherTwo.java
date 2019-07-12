
public class CaesarCipherTwo {
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainKey1;
	private int mainKey2;

	public CaesarCipherTwo(int key1, int key2) {
		
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		mainKey1 = key1;
		mainKey2 = key2;
	
	}
	
	public String encrypt(String input) {
		
		String returnStr = "";
		for (int i = 0; i< input.length(); i++) {
			
			int alphabetIndex = alphabet.indexOf(Character.toUpperCase(input.charAt(i)));
			if (alphabetIndex == -1)
				returnStr = returnStr + input.charAt(i);
			else {
				char encryptChar;
				if (i%2 == 0)
					encryptChar = shiftedAlphabet1.charAt(alphabetIndex);
				else
					encryptChar = shiftedAlphabet2.charAt(alphabetIndex);
				
				if (Character.isUpperCase(input.charAt(i)))
					returnStr = returnStr + Character.toUpperCase(encryptChar);
				else
					returnStr = returnStr + Character.toLowerCase(encryptChar);
				
			}
		}		
		return returnStr;		
		
	}
	
	public String decrypt(String input) {
		CaesarCipherTwo cc = new CaesarCipherTwo(26-mainKey1,26-mainKey2);
		return cc.encrypt(input);
		
	}

}
