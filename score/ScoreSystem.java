package score;

import model.Player;


public class ScoreSystem {


    public void showFinalStats(Player player, boolean playerWon) {
        System.out.println("\n==========================================");

        if (playerWon) {
            System.out.println("          VITORIA!");
            System.out.println("  Voce completou todas as batalhas!");
        } else {
            System.out.println("          DERROTA.");
            System.out.println("  Voce foi eliminado em combate.");
        }

        System.out.println("------------------------------------------");
        System.out.println("Jogador:           " + player.getPlayerName());
        System.out.println("Personagem:        " + player.getCharacter().getType());
        System.out.println("Inimigos vencidos: " + player.getEnemiesDefeated());
        System.out.println("Pontuacao final:   " + player.getScore());
        System.out.println("Acertos:           " + player.getCorrectAnswers());
        System.out.println("Erros:             " + player.getWrongAnswers());

        int total = player.getCorrectAnswers() + player.getWrongAnswers();
        if (total > 0) {
            int accuracy = (player.getCorrectAnswers() * 100) / total;
            System.out.println("Precisao:          " + accuracy + "%");
        }

        System.out.println("------------------------------------------");
        System.out.println("Classificacao: " + getRank(player.getScore()));
        System.out.println("==========================================");
    }


    private String getRank(int score) {
        if (score >= 300) return "MESTRE DO CONHECIMENTO";
        if (score >= 200) return "ESTUDIOSO";
        if (score >= 100) return "APRENDIZ";
        return "INICIANTE";
    }
}
