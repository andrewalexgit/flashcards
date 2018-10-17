import java.io.*;
import java.util.*;

public class FlashCards {

	private File FILE;
	private Scanner sc;
	private HashMap<String, String> questions_and_answers = new HashMap<String, String>();
	private List<String> keys;
	private int numQuestions;
	
	// The custom file constructor makes it possible to load from a user specified field, or otherwise.
	FlashCards(String customFile) throws IOException {
		FILE = new File(customFile);
		sc = new Scanner(FILE);
		numQuestions = 0;
		while(sc.hasNext()) {
			questions_and_answers.put(sc.nextLine(), sc.nextLine());
			numQuestions++;
		}

		keys = new ArrayList<>(questions_and_answers.keySet());
		numQuestions = keys.size();
	}

	FlashCards() throws IOException {
		FILE = new File("cards.text");
		sc = new Scanner(FILE);
		numQuestions = 0;
		while(sc.hasNext()) {
			questions_and_answers.put(sc.nextLine(), sc.nextLine());
			numQuestions++;
		}

		// Storing all keys associated with the HashMap of Questions and answers provides a secondary way of accessing data
		keys = new ArrayList<>(questions_and_answers.keySet());
		numQuestions = keys.size();

	}

	public int getQuestionCount() {
		return numQuestions;
	}

	public String getAnswer(String question) {
		return questions_and_answers.get(question);
	}

	public String getQuestion(int index) {
		return keys.get(index);
	}

	// The algorithm used to go in reverse to acquire a key from data
	public String getQuestion(String answer) {

		String question = "Not found";

		for (String s: keys) {
			if (answer.equals(questions_and_answers.get(s))) {
				question = questions_and_answers.get(s);
			}
		}

		return question;
	}

}
