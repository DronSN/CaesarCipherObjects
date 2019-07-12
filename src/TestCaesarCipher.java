import edu.duke.*;

public class TestCaesarCipher {
	
	static void countLetters(String stringCount, int[] array) {
		
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
	
	static void breakCaesarCipher(String message) {
		int[] array = new int[30];
		countLetters(message, array);
		
		int max = maxIndex(array); 
		int dkey = max - 4;
		if (max < 4)
			dkey = 26 - (4 - max);
		CaesarCipher cc = new CaesarCipher(dkey);
		System.out.println(cc.decrypt(message));
		
		
		
	}
	
	static void simpleTests() {
		
//		FileResource fl = new FileResource();
//		String testString = fl.asString();
		String testString = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
		System.out.println(testString);
		System.out.println();
		CaesarCipher cc = new CaesarCipher(15);
		String encryptString = cc.encrypt(testString);
		System.out.println(encryptString);
		System.out.println();
		String decryptString = cc.decrypt(encryptString);
		System.out.println(decryptString);
		
//		String testString = "WIVV TRBV ZE KYV TFEWVIVETV IFFD!";
//		breakCaesarCipher(testString);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simpleTests();
	}

}
