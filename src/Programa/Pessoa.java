package Programa;

public class Pessoa {

    private static int contador = 1;

    private String nome;
    private String CPF;
    private String email;

    public Pessoa(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        contador += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String toString() {
        return "\nNome: " + this.getNome() +
               "\nCPF: " + this.getCPF() +
               "\nEmail: " + this.getEmail();

    }
}
