package question;


public class MultipleChoiceQuestion extends Question {

    private String[] alternatives;
    private int      correctIndex;
    private int      eliminatedIndex = -1; // -1 = nenhuma eliminada

    public MultipleChoiceQuestion(String statement, String[] alternatives,
                                   int correctIndex, Category category, int difficulty) {
        super(statement, category, difficulty);
        this.alternatives = alternatives;
        this.correctIndex = correctIndex;
    }


    public void eliminateAlternative() {
        for (int i = 0; i < alternatives.length; i++) {
            if (i != correctIndex) {
                eliminatedIndex = i;
                break;
            }
        }
    }

    @Override
    public void display() {
        System.out.println("[Multipla Escolha | " + category + " | Dificuldade: " + difficulty + "]");
        System.out.println(statement);
        for (int i = 0; i < alternatives.length; i++) {
            if (i == eliminatedIndex) {
                System.out.println((char) ('A' + i) + ") [eliminada]");
            } else {
                System.out.println((char) ('A' + i) + ") " + alternatives[i]);
            }
        }
    }

    @Override
    public boolean isCorrect(String answer) {
        if (answer == null || answer.isEmpty()) return false;
        char typed = answer.trim().toUpperCase().charAt(0);
        return (typed - 'A') == correctIndex;
    }

    @Override
    public String getCorrectAnswerText() {
        return "Resposta correta: " + (char) ('A' + correctIndex) + ") " + alternatives[correctIndex];
    }
}
