package QuizCardPlayerPac;

/**
 * Created by Саша on 17.06.2017.
 */
public class QuizCard {
    String question;
    String answer;

    //Конструктор public QuizCard
    public QuizCard (String q, String a) {
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
