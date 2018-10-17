import java.io.*;
import java.util.*;
import java.math.*;

public class Study {
	
	public static void main(String[] args) throws IOException {

		System.out.println("Flash Study : Version 1.3");

		FlashCards flashcards = new FlashCards();

		int questionsAsked = 0;
		int correctlyAnswered = 0;
		int questionNumber = 0;
		String question;
		String answer = "";
		boolean isRunning = true;
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Created "+ flashcards.getQuestionCount() + " flash cards");

		do {

			System.out.println("`a` To ask a question, or `q` to quit");

			switch(keyboard.next()) {

				case "a":
					questionsAsked++;
					questionNumber = getRandom(questionNumber, flashcards.getQuestionCount(), rand);
					System.out.print(" #"+ questionsAsked);
					question = flashcards.getQuestion(questionNumber);
					System.out.println("\n" + questionNumber + ": " +question);
					keyboard.nextLine();
					answer = keyboard.nextLine();

					if (answer.equalsIgnoreCase(flashcards.getAnswer(question))) {
						correctlyAnswered++;
						System.out.println("Great job!" + "\n");
					} else {
						System.out.println("Sorry the correct answer is " + flashcards.getAnswer(question) + "\n");
					}

				break;

				case "q":
					System.out.println(correctlyAnswered + " right out of " + questionsAsked);
					System.out.println("Score: " + ((double) correctlyAnswered/ (double) questionsAsked) * 100);
					isRunning = false;
				break;

				default:
					System.out.println("Invalid command.");
				break;

			}


		} while(isRunning);

	}

	public static int getRandom(int k, int questionCount, Random rand) {

		System.out.print("\nGenerating question.");

		int n = k;

		while (n == k) {
			System.out.print(".");
			n = rand.nextInt(questionCount);
		}

		return n;
	}
}