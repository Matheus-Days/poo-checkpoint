package com.company;

import java.util.ArrayList;

public class Instrutor extends Funcionario{
    private ArrayList<Atividade> atividades = new ArrayList<>();

    public Instrutor(String nome, String cpf, double salario) {
        super(nome, cpf, "Instrutor", salario);
    }

    public String adicionarAtividade(Atividade o) {
        try {
            atividades.add(o);
            return "Atividade adicionada com sucesso";
        } catch (Exception e) {
            return "Atividade inválida!";
        }

    }

    public String listarAtividades() {
        String output = "";

        for(int i = 0; i < atividades.size(); i++) {
            output += "\n\t" + String.valueOf(i + 1) + " - " + atividades.get(i).getNome() + "\n";
        }

        if(output.equals(""))
            return "Nenhuma atividade registrada para esse instrutor.";
        else
            return output;
    }

    @Override
    public String toString() {
        return "---------------------\n" +
                "Nome: " + super.getNome() + '\n' +
                "CPF: " + super.getCpf() + '\n' +
                "Ocupação: " + super.getOcupacao() + '\n' +
                "Atividades: \n" + "[" + this.listarAtividades() + "]\n" +
                "Salário: R$" + super.getSalario() + '\n' +
                "Último pagamento: " + super.getUltimoPagamento() + '\n' +
                "---------------------";
    }
}
