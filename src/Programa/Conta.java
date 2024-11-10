package Programa;

import utils.Utils;

public class Conta {

    private static int contadordeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadordeContas;
        this.pessoa = pessoa;
        contadordeContas += 1;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
               "\nNome: " + this.pessoa.getNome() +
               "\nCPF: " + this.pessoa.getCPF() +
               "\nEmail: " + this.pessoa.getEmail() +
               "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
               "\n:";
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito");
        }
    }

    public void sacar (Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 &&  this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }
}
