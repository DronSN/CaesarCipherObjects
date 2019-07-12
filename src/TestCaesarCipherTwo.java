import edu.duke.*;
public class TestCaesarCipherTwo {
	
	private static void countLetters(String stringCount, int[] array) {
		
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < stringCount.length(); i ++) {
			int indexLetter = abc.indexOf(Character.toUpperCase(stringCount.charAt(i)));
			if (indexLetter != -1)
				array[indexLetter]++;
		}
	}
	
	static int maxIndex(int[] array) {
		int maxValue = 0;
		int maxIndex = -1;
		
		for (int i =0 ; i< array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
				maxIndex = i;
			}
			
		}
		
		return maxIndex;
		
	}
	
	
	static String halfOfString(String message, int start) {
		String returnMessage = "";
		
		for (int i = start; i < message.length(); i = i + 2)
			returnMessage = returnMessage + message.charAt(i);
		
		return returnMessage;
	}
	
	static void simpleTests() {

		FileResource fl = new FileResource();
		String testString = fl.asString();
//		String testString ="Can you imagine life WITHOUT the internet AND computers in your pocket?";
//		System.out.println(testString);
//		System.out.println();
//		CaesarCipherTwo  cc = new CaesarCipherTwo(21, 8);
//		String encryptString = cc.encrypt(testString);
//		System.out.println(encryptString);
//		System.out.println();
//		String decryptString = cc.decrypt(encryptString);
//		System.out.println(decryptString);	
		
//		String testString = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
		breakCaesarCipher(testString);
//		String testString = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
//		CaesarCipherTwo  cc = new CaesarCipherTwo(14, 24);
//		String decryptString = cc.decrypt(testString);
//		System.out.println(decryptString);	
	}
	
	static int getKey(String message) {
		
		int[] counts = new int[30];
		countLetters(message, counts);
		int max = maxIndex(counts); 
		int dkey = max - 4;
		if (max < 4)
			dkey = 26 - (4 - max);
		
		return dkey;
	}
	
	static void breakCaesarCipher(String input) {
		
		int[] array = new int[30];
		
		
		int key1 = getKey(halfOfString(input, 0));
		int key2 = getKey(halfOfString(input, 1));
		
		System.out.println((26-key1) + "," + (26-key2));
				
		CaesarCipherTwo  cc = new CaesarCipherTwo (key1,key2);
		System.out.println(cc.decrypt(input));		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simpleTests();
	}

}
