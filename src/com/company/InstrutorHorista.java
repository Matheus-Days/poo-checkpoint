package com.company;

public class InstrutorHorista extends Instrutor {
    private double valorHora;
    private int horasTrabalhadas;
    private String cnpj;

    public InstrutorHorista(String nome, String cpf, String cnpj, double valorHora) {
        super(nome, cpf, 0.0);
        this.valorHora = valorHora;
        this.horasTrabalhadas = 0;
        this.cnpj = cnpj;
    }

    @Override
    public double calcularRemuneracao() {
        return valorHora * horasTrabalhadas;
    }

    public void adicionarHoras(int horas) {
        horasTrabalhadas += horas;
    }

    public void zerarHoras() {
        horasTrabalhadas = 0;
    }

    @Override
    public String toString() {
        return "---------------------\n" +
                "Nome: " + super.getNome() + '\n' +
                "CPF: " + super.getCpf() + '\n' +
                "CNPJ: " + this.cnpj + '\n' +
                "Ocupação: " + super.getOcupacao() + '\n' +
                "Atividades: \n" + "[" + this.listarAtividades() + "]\n" +
                "Valor-hora: R$" + valorHora + '\n' +
                "Horas trabalhadas: " + horasTrabalhadas + '\n' +
                "Último pagamento: " + super.getUltimoPagamento() + '\n' +
                "---------------------";
    }

    // Getters e setters

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
