package question;


public abstract class Question {

    protected String   statement;
    protected Category category;
    protected int      difficulty; // 1 = facil | 2 = medio | 3 = dificil

    public Question(String statement, Category category, int difficulty) {

        if (difficulty < 1 || difficulty > 3) {
            throw new IllegalArgumentException(
                "Dificuldade invalida: " + difficulty + ". Use 1, 2 ou 3.");
        }

        this.statement  = statement;
        this.category   = category;
        this.difficulty = difficulty;
    }


    public abstract void display();


    public abstract boolean isCorrect(String answer);


    public abstract String getCorrectAnswerText();


    public int getPoints() {
        return difficulty * 10;
    }

    public String   getStatement()  { return statement; }
    public Category getCategory()   { return category; }
    public int      getDifficulty() { return difficulty; }
}
