import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;

public class HangmanGame {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(System.in);

		

		// Hangman game
		String word;
		System.out.println("1 or 2 players");
		String players = key.nextLine();
		
		if(players.equals("1")) {
			System.out.println("Enter the file path for the words list:");
			String filePath = key.nextLine();
			File file = new File(filePath);
			Scanner scan = new Scanner(file);

			ArrayList<String> words = new ArrayList<>();
			while (scan.hasNext()) {
				words.add(scan.nextLine());
			}
			Random rand = new Random();

			word = words.get(rand.nextInt(words.size()));
			 
		}else {
			System.out.println("Player 1, please enter word");
			word = key.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Player 2 start!");
			
		}
		//System.out.println(word);

		ArrayList<Character> guesses = new ArrayList<>();

		int wrong = 0;
		while (true) {

			hangmanPrint(wrong);
			
			if(wrong>=6) {
				System.out.println("You lost!");
				System.out.println("The word was: "+word);
				break;
			}

			currentState(word, guesses);
			if (!getPlayerGuess(key, word, guesses)) {
				wrong++;
			}

			if (currentState(word, guesses)) {
				System.out.println("you win");

				break;
			}

			System.out.println("Please enter your word guess:");
			if (key.nextLine().equals(word)) {
				System.out.println("you win");

				break;
			} else {
				System.out.println("incorrect, try again");
			}

		}

	}

	private static void hangmanPrint(int wrong) {
		System.out.println(" -------");
		System.out.println(" |     |");
		if (wrong >= 1) {
			System.out.println(" O");

		}

		if (wrong >= 2) {
			System.out.print("\\ ");

			if (wrong >= 3) {
				System.out.println("/ ");
			} else {
				System.out.println("");
			}
		}

		if (wrong >= 4) {
			System.out.println(" |");

		}

		if (wrong >= 5) {
			System.out.print("/ ");

			if (wrong >= 6) {
				System.out.print("\\ ");
			} else {
				System.out.println("");
			}
		}
		System.out.println();
		System.out.println();
	}

	private static boolean getPlayerGuess(Scanner key, String word, ArrayList<Character> guesses) {
		System.out.println("Please enter letter: ");
		String guess = key.nextLine();
		guesses.add(guess.charAt(0));

		return word.contains(guess);
	}

	private static boolean currentState(String word, ArrayList<Character> guesses) {
		int correctCount = 0;
		for (int i = 0; i < word.length(); i++) {
			if (guesses.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
				correctCount++;
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
		return (word.length() == correctCount);
	}
}
