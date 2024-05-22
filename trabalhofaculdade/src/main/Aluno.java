package src.main;

public class Aluno {
    private String matricula;
    private String nome;
    private int idade;
    private String turma;

    public Aluno(String matricula, String nome, int idade, String turma) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTurma() {
        return turma;
    }
}
