import game.Game;

public class Main {
    public static void main(String[] args) {
        try {
            new Game().start();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
