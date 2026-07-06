package question;


public class FillBlankQuestion extends Question {

    private String correctAnswer;

    public FillBlankQuestion(String statement, String correctAnswer,
                              Category category, int difficulty) {
        super(statement, category, difficulty);
        this.correctAnswer = correctAnswer.trim().toLowerCase();
    }

    @Override
    public void display() {
        System.out.println("[Completar Lacuna | " + category + " | Dificuldade: " + difficulty + "]");
        System.out.println(statement);
        System.out.println("Digite a palavra que preenche o ___:");
    }

    @Override
    public boolean isCorrect(String answer) {
        if (answer == null || answer.isEmpty()) return false;
        return answer.trim().toLowerCase().equals(correctAnswer);
    }

    @Override
    public String getCorrectAnswerText() {
        return "Resposta correta: " + correctAnswer;
    }
}
