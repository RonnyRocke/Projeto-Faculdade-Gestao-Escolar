package src.main;

public class Nota {
    private String matricula;
    private String disciplina;
    private double nota;

    public Nota(String matricula, String disciplina, double nota) {
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double novaNota) {
        this.nota = novaNota;
    }
}
