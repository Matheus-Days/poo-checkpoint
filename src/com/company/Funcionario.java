package com.company;

import java.time.LocalDate;

public class Funcionario {
    private String nome;
    private String cpf;
    private String ocupacao;
    private double salario;
    private LocalDate ultimoPagamento;

    public Funcionario(String nome, String cpf, String ocupacao, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.ocupacao = ocupacao;
        this.salario = salario;
        this.ultimoPagamento = null;
    }

    public double calcularRemuneracao() {
        return this.salario;
    }

    @Override
    public String toString() {
        return "---------------------" +
                "Nome: " + nome + '\n' +
                "CPF: " + cpf + '\n' +
                "Ocupação: " + ocupacao + '\n' +
                "Salário: " + salario + '\n' +
                "Último pagamento: " + ultimoPagamento + '\n' +
                "---------------------";
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getUltimoPagamento() {
        return ultimoPagamento;
    }

    public void setUltimoPagamento(LocalDate ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }
}
