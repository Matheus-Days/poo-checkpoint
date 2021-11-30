package com.company;

import java.time.LocalDate;

public class Aluno {
    private String nome;
    private String cpf;
    private LocalDate dataMatricula;
    private String responsavel;
    private double desconto;
    private LocalDate desligamento;
    private LocalDate ultimoPagamento;
    private Instrutor instrutor;
    private Atividade atividade;

    public Aluno(String nome, String cpf, LocalDate dataMatricula, String responsavel, double desconto, Atividade atividade, Instrutor instrutor) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataMatricula = dataMatricula;
        this.responsavel = responsavel;
        this.desconto = desconto;
        this.atividade = atividade;
        this.instrutor = instrutor;
    }

    public double calcularMensalidade() {
        return atividade.getPreco() * (1 - this.desconto);
    }

    @Override
    public String toString() {
        return "---------------------" + '\n' +
                "Nome: " + nome + '\n' +
                "CPF: " + cpf + '\n' +
                "Matricula: " + dataMatricula + '\n' +
                "Responsavel: " + responsavel + '\n' +
                "Desconto: " + Math.round(desconto * 100) + "%" + '\n' +
                "Desligamento: " + desligamento + '\n' +
                "Último pagamento: " + ultimoPagamento + '\n' +
                "Instrutor: " + instrutor.getNome() + '\n' +
                "Atividade: " + atividade.getNome() + '\n' +
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

    public LocalDate getMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LocalDate getDesligamento() {
        return desligamento;
    }

    public void setDesligamento(LocalDate desligamento) {
        this.desligamento = desligamento;
    }

    public LocalDate getUltimoPagamento() {
        return ultimoPagamento;
    }

    public void setUltimoPagamento(LocalDate ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
}
