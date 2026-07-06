package question;

import java.util.Random;


public class QuestionBank {

    private Question[] questions;
    private int        count;
    private Random     random;

    public QuestionBank() {
        questions = new Question[150];
        count     = 0;
        random    = new Random();
        loadQuestions();
    }



    public Question getRandomQuestion() {
        return questions[random.nextInt(count)];
    }


    public Question getByDifficulty(int difficulty) {
        Question[] filtered = new Question[count];
        int fc = 0;
        for (int i = 0; i < count; i++) {
            if (questions[i].getDifficulty() == difficulty) {
                filtered[fc] = questions[i];
                fc++;
            }
        }
        if (fc == 0) return getRandomQuestion();
        return filtered[random.nextInt(fc)];
    }


    public Question getByCategory(Category category) {
        Question[] filtered = new Question[count];
        int fc = 0;
        for (int i = 0; i < count; i++) {
            if (questions[i].getCategory() == category) {
                filtered[fc] = questions[i];
                fc++;
            }
        }
        if (fc == 0) return getRandomQuestion();
        return filtered[random.nextInt(fc)];
    }

    public int size() { return count; }



    private void add(Question q) {
        questions[count] = q;
        count++;
    }

    private void loadQuestions() {
        loadPOO();
        loadJava();
        loadFisica();
        loadBiologia();
        loadFisiologia();
        loadEducacaoFisica();
        loadMatematica();
        loadHistoria();
    }

    // ── POO
    private void loadPOO() {
        add(new TrueFalseQuestion(
            "Em Java, toda classe herda implicitamente de Object.",
            true, Category.POO, 1));

        add(new TrueFalseQuestion(
            "Em Java e possivel herdar de multiplas classes ao mesmo tempo.",
            false, Category.POO, 1));

        add(new MultipleChoiceQuestion(
            "O que e um objeto em POO?",
            new String[]{"Uma variavel primitiva", "Uma instancia de uma classe",
                         "Um metodo estatico", "Um arquivo .java"},
            1, Category.POO, 1));

        add(new FillBlankQuestion(
            "O conceito de ___ consiste em esconder os detalhes internos de uma classe.",
            "encapsulamento", Category.POO, 1));

        add(new MultipleChoiceQuestion(
            "O que e heranca em POO?",
            new String[]{"Copiar o codigo de outra classe",
                         "Reutilizar atributos e metodos de uma classe pai",
                         "Dois objetos compartilharem memoria",
                         "Um metodo chamar a si mesmo"},
            1, Category.POO, 2));

        add(new MultipleChoiceQuestion(
            "O que e polimorfismo?",
            new String[]{"Ter multiplos construtores",
                         "Um objeto se comportar de formas diferentes conforme o contexto",
                         "Herdar de multiplas classes",
                         "Ter multiplos pacotes"},
            1, Category.POO, 2));

        add(new TrueFalseQuestion(
            "Uma classe abstrata pode ter metodos com implementacao.",
            true, Category.POO, 2));

        add(new FillBlankQuestion(
            "Em POO, ___ e o mecanismo pelo qual uma classe herda caracteristicas de outra.",
            "heranca", Category.POO, 2));

        add(new MultipleChoiceQuestion(
            "O que e sobrescrita de metodo (overriding)?",
            new String[]{"Criar metodos com mesmo nome mas parametros diferentes",
                         "Reescrever na subclasse um metodo herdado da superclasse",
                         "Chamar um metodo da classe pai com super",
                         "Criar um metodo com retorno void"},
            1, Category.POO, 2));

        add(new FillBlankQuestion(
            "A palavra-chave ___ indica que uma classe ou metodo nao pode ser modificado pelas subclasses.",
            "final", Category.POO, 3));

        add(new MultipleChoiceQuestion(
            "Qual principio do SOLID diz que uma classe deve ter apenas uma razao para mudar?",
            new String[]{"Open/Closed", "Liskov", "Single Responsibility", "Dependency Inversion"},
            2, Category.POO, 3));
    }

    // ── JAVA

    private void loadJava() {
        add(new MultipleChoiceQuestion(
            "Qual palavra-chave cria um objeto em Java?",
            new String[]{"create", "object", "new", "make"},
            2, Category.JAVA, 1));

        add(new MultipleChoiceQuestion(
            "Qual dos tipos abaixo e primitivo em Java?",
            new String[]{"String", "Integer", "int", "ArrayList"},
            2, Category.JAVA, 1));

        add(new TrueFalseQuestion(
            "int e Integer sao o mesmo tipo em Java.",
            false, Category.JAVA, 1));

        add(new FillBlankQuestion(
            "Em Java, a palavra-chave ___ e usada para uma classe herdar de outra.",
            "extends", Category.JAVA, 1));

        add(new MultipleChoiceQuestion(
            "Qual palavra-chave implementa uma interface em Java?",
            new String[]{"extends", "inherits", "implements", "interface"},
            2, Category.JAVA, 2));

        add(new TrueFalseQuestion(
            "Em Java, uma interface pode herdar de outra interface.",
            true, Category.JAVA, 2));

        add(new MultipleChoiceQuestion(
            "Qual anotacao indica sobrescrita de metodo em Java?",
            new String[]{"@Override", "@Overload", "@Super", "@Inherit"},
            0, Category.JAVA, 2));

        add(new FillBlankQuestion(
            "O modificador de acesso ___ permite acesso apenas dentro da propria classe.",
            "private", Category.JAVA, 1));

        add(new TrueFalseQuestion(
            "Em Java, String e uma classe imutavel.",
            true, Category.JAVA, 3));

        add(new MultipleChoiceQuestion(
            "O que e um enum em Java?",
            new String[]{"Uma classe abstrata", "Um tipo de array",
                         "Um conjunto fixo de constantes nomeadas", "Uma interface especial"},
            2, Category.JAVA, 2));
    }

    // ── FISICA
    private void loadFisica() {
        add(new MultipleChoiceQuestion(
            "Qual e a unidade de medida de forca no Sistema Internacional?",
            new String[]{"Joule", "Watt", "Newton", "Pascal"},
            2, Category.FISICA, 1));

        add(new TrueFalseQuestion(
            "A velocidade da luz no vacuo e aproximadamente 300.000 km/s.",
            true, Category.FISICA, 1));

        add(new MultipleChoiceQuestion(
            "Segunda Lei de Newton: Forca equivale a:",
            new String[]{"massa / aceleracao", "massa + aceleracao",
                         "massa x aceleracao", "aceleracao / massa"},
            2, Category.FISICA, 1));

        add(new TrueFalseQuestion(
            "Energia cinetica e proporcional ao quadrado da velocidade.",
            true, Category.FISICA, 2));

        add(new MultipleChoiceQuestion(
            "O que mede a unidade Joule?",
            new String[]{"Forca", "Potencia", "Energia", "Pressao"},
            2, Category.FISICA, 2));

        add(new FillBlankQuestion(
            "A ___ e a tendencia de um corpo em resistir a mudancas no seu estado de movimento.",
            "inercia", Category.FISICA, 2));

        add(new TrueFalseQuestion(
            "A Primeira Lei de Newton afirma que todo corpo em repouso tende a permanecer em repouso.",
            true, Category.FISICA, 1));

        add(new MultipleChoiceQuestion(
            "Qual fenomeno explica por que o ceu e azul?",
            new String[]{"Refracao", "Reflexao", "Espalhamento de Rayleigh", "Difracao"},
            2, Category.FISICA, 3));
    }

    // ── BIOLOGIA

    private void loadBiologia() {
        add(new MultipleChoiceQuestion(
            "Qual organela e responsavel pela respiracao celular?",
            new String[]{"Nucleo", "Mitocondria", "Ribossomo", "Vacuolo"},
            1, Category.BIOLOGIA, 1));

        add(new TrueFalseQuestion(
            "O DNA e encontrado principalmente no nucleo da celula.",
            true, Category.BIOLOGIA, 1));

        add(new MultipleChoiceQuestion(
            "Qual processo as plantas usam para produzir alimento?",
            new String[]{"Respiracao", "Fermentacao", "Fotossintese", "Digestao"},
            2, Category.BIOLOGIA, 1));

        add(new FillBlankQuestion(
            "A ___ e a organela responsavel pela producao de energia nas celulas.",
            "mitocondria", Category.BIOLOGIA, 1));

        add(new TrueFalseQuestion(
            "Os virus sao considerados seres vivos pois possuem celulas proprias.",
            false, Category.BIOLOGIA, 2));

        add(new MultipleChoiceQuestion(
            "Qual e a molecula que carrega o codigo genetico?",
            new String[]{"Proteina", "Lipideo", "DNA", "Glicose"},
            2, Category.BIOLOGIA, 2));

        add(new FillBlankQuestion(
            "O processo de duplicacao do DNA e chamado de ___.",
            "replicacao", Category.BIOLOGIA, 3));
    }

    // ── FISIOLOGIA

    private void loadFisiologia() {
        add(new MultipleChoiceQuestion(
            "Qual orgao bombeia o sangue pelo corpo?",
            new String[]{"Pulmao", "Figado", "Coracao", "Rim"},
            2, Category.FISIOLOGIA, 1));

        add(new TrueFalseQuestion(
            "O coracao adulto bate em media entre 60 e 100 vezes por minuto em repouso.",
            true, Category.FISIOLOGIA, 1));

        add(new MultipleChoiceQuestion(
            "Qual e a funcao principal dos globulos vermelhos?",
            new String[]{"Combater infeccoes", "Transportar oxigenio",
                         "Coagular o sangue", "Produzir anticorpos"},
            1, Category.FISIOLOGIA, 1));

        add(new FillBlankQuestion(
            "O ___ e o orgao responsavel por filtrar o sangue e produzir urina.",
            "rim", Category.FISIOLOGIA, 1));

        add(new TrueFalseQuestion(
            "O sistema nervoso central e composto pelo cerebro e pela medula espinhal.",
            true, Category.FISIOLOGIA, 2));

        add(new MultipleChoiceQuestion(
            "Qual hormonio e liberado em situacoes de estresse?",
            new String[]{"Insulina", "Adrenalina", "Estrogenio", "Melatonina"},
            1, Category.FISIOLOGIA, 2));

        add(new MultipleChoiceQuestion(
            "Onde ocorre a absorcao de nutrientes?",
            new String[]{"Estomago", "Esofago", "Intestino delgado", "Intestino grosso"},
            2, Category.FISIOLOGIA, 2));
    }

    // ── EDUCACAO FISICA

    private void loadEducacaoFisica() {
        add(new MultipleChoiceQuestion(
            "Quantos jogadores compoe um time de voleibol em quadra?",
            new String[]{"5", "6", "7", "9"},
            1, Category.EDUCACAO_FISICA, 1));

        add(new TrueFalseQuestion(
            "No futebol, dois cartoes amarelos resultam em expulsao.",
            true, Category.EDUCACAO_FISICA, 1));

        add(new MultipleChoiceQuestion(
            "Qual capacidade fisica e mais desenvolvida ao correr longas distancias?",
            new String[]{"Forca maxima", "Resistencia aerobica", "Velocidade", "Flexibilidade"},
            1, Category.EDUCACAO_FISICA, 1));

        add(new FillBlankQuestion(
            "A ___ aerobica e a capacidade do corpo de sustentar atividades de longa duracao.",
            "resistencia", Category.EDUCACAO_FISICA, 1));

        add(new TrueFalseQuestion(
            "O alongamento apos o exercicio ajuda a reduzir a rigidez muscular.",
            true, Category.EDUCACAO_FISICA, 2));

        add(new MultipleChoiceQuestion(
            "O que e frequencia cardiaca maxima?",
            new String[]{"Batimentos em repouso",
                         "Maior numero de batimentos por minuto que o coracao pode atingir",
                         "Batimentos durante o sono",
                         "Media diaria de batimentos"},
            1, Category.EDUCACAO_FISICA, 2));

        add(new MultipleChoiceQuestion(
            "Qual treinamento alterna alta intensidade com recuperacao?",
            new String[]{"Continuo", "HIIT", "Isometrico", "Flexibilidade"},
            1, Category.EDUCACAO_FISICA, 3));
    }

    // ── MATEMATICA

    private void loadMatematica() {
        add(new MultipleChoiceQuestion(
            "Quanto e a raiz quadrada de 144?",
            new String[]{"11", "12", "13", "14"},
            1, Category.MATEMATICA, 1));

        add(new TrueFalseQuestion(
            "Um numero primo e divisivel apenas por 1 e por ele mesmo.",
            true, Category.MATEMATICA, 1));

        add(new FillBlankQuestion(
            "O teorema de ___ relaciona os lados de um triangulo retangulo.",
            "pitagoras", Category.MATEMATICA, 2));

        add(new TrueFalseQuestion(
            "O triangulo retangulo possui um angulo interno de 90 graus.",
            true, Category.MATEMATICA, 1));

        add(new MultipleChoiceQuestion(
            "Numa progressao aritmetica a diferenca entre termos consecutivos e:",
            new String[]{"Variavel", "Sempre zero", "Constante", "Sempre negativa"},
            2, Category.MATEMATICA, 2));

        add(new FillBlankQuestion(
            "O valor aproximado de PI e 3,___.",
            "14", Category.MATEMATICA, 1));
    }

    // ── HISTORIA

    private void loadHistoria() {
        add(new MultipleChoiceQuestion(
            "Em que ano o Brasil foi descoberto pelos portugueses?",
            new String[]{"1492", "1500", "1530", "1488"},
            1, Category.HISTORIA, 1));

        add(new TrueFalseQuestion(
            "A Revolucao Francesa ocorreu no seculo XVIII.",
            true, Category.HISTORIA, 1));

        add(new MultipleChoiceQuestion(
            "Qual o principal motivo da Segunda Guerra Mundial?",
            new String[]{"Disputa por rotas maritimas",
                         "Expansionismo nazista e tensoes do pos-Primeira Guerra",
                         "Conflito direto entre EUA e URSS",
                         "Independencia de colonias africanas"},
            1, Category.HISTORIA, 2));

        add(new TrueFalseQuestion(
            "A Guerra Fria foi um conflito armado direto entre EUA e URSS.",
            false, Category.HISTORIA, 2));

        add(new MultipleChoiceQuestion(
            "Quem proclamou a Republica no Brasil em 1889?",
            new String[]{"Dom Pedro I", "Getulio Vargas",
                         "Marechal Deodoro da Fonseca", "Tiradentes"},
            2, Category.HISTORIA, 2));

        add(new FillBlankQuestion(
            "A ___ foi o periodo marcado pela transicao do trabalho escravo para o livre no Brasil.",
            "abolição", Category.HISTORIA, 3));
    }
}
