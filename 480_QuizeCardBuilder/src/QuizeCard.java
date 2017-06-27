/**
 * Created by Саша on 16.06.2017.
 */
public class QuizeCard {
    String question;
    String answer;

    public QuizeCard (String q, String a) {
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
}
