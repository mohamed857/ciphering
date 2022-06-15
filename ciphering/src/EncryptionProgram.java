import java.util.*;
public class EncryptionProgram {
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String cipher;
	private String plane;
	private char[] letters;
	private char[] secretLetters;
	EncryptionProgram(){
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();;
		character = ' ';
		newKey();
		choose();
	}
	private void choose(){
		while(true) {
			System.out.println("**************************");
			System.out.println("* enter (N) for new Key "
					+ "OR (K) To get the key"
					+ "OR (E) to encrypt"
					+ "OR (D) to decrypt"
					+ "OR (Q) to quit *");
			char r = Character.toUpperCase(scanner.nextLine().charAt(0));
			switch(r) {
			case 'N':
				newKey();
				break;
			case 'K':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q' :
				quit();
				break;
				default:
					System.out.println("unValid choose");
				
			}
		}
		 
	}
	private void newKey(){
		character = ' ';
		list.clear();
		shuffledList.clear();
		for(int i=32;i<127;i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("A new key has been generated");
		
	}
	private void getKey(){
		System.out.println("key: ");
		for(Character y :list) {
			System.out.print(y);
		}
		System.out.println();
		for(Character x :shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void encrypt(){
		cipher = "";
		System.out.println("enter a message to be encrypted: ");
		String message = scanner.nextLine();
		letters = message.toCharArray();
		for(Character c: letters) {
			cipher +=shuffledList.get(list.indexOf(c));
		}
		System.out.println("the cipher text is :"+cipher);
		 
		
	}
	private void decrypt(){
		plane = "";
		System.out.println("enter a message to be decrypted: ");
		String message0 = scanner.nextLine();
		letters = message0.toCharArray();
		for(Character c: letters) {
			plane +=list.get(shuffledList.indexOf(c));
		}
		System.out.println("the cipher text is :"+plane);
		
		
	}
	private void quit(){
		System.out.println("you exist the programe:");
		System.exit(0);
	}

}
