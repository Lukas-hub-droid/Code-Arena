package question;


public class TrueFalseQuestion extends Question {

    private boolean correctAnswer;

    public TrueFalseQuestion(String statement, boolean correctAnswer,
                              Category category, int difficulty) {
        super(statement, category, difficulty);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void display() {
        System.out.println("[Verdadeiro ou Falso | " + category + " | Dificuldade: " + difficulty + "]");
        System.out.println(statement);
        System.out.println("V) Verdadeiro");
        System.out.println("F) Falso");
    }

    @Override
    public boolean isCorrect(String answer) {
        if (answer == null || answer.isEmpty()) return false;
        String a = answer.trim().toUpperCase();
        return correctAnswer ? a.equals("V") : a.equals("F");
    }

    @Override
    public String getCorrectAnswerText() {
        return "Resposta correta: " + (correctAnswer ? "V) Verdadeiro" : "F) Falso");
    }
}
