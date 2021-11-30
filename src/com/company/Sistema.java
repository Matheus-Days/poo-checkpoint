package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
    private double caixa;
    private double gastoMateriais;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Atividade> atividades = new ArrayList<>();
    private ArrayList<Instrutor> instrutores = new ArrayList<>();

    public Sistema(double caixa, double gastoMateriais) {
        this.caixa = caixa;
        this.gastoMateriais = gastoMateriais;
    }

    public void listarAlunos() {
        String output = "";

        for(int i = 0; i < alunos.size(); i++) {
            output += (i != 0 ? "\n" : "") + String.valueOf(i + 1) + " - " + alunos.get(i).getNome() + " - Matrícula: " + alunos.get(i).getMatricula();
        }

        if(output.equals(""))
            System.out.println("---------------------\n" + "Nenhum aluno registrado." + "\n---------------------");
        else
            System.out.println("---------------------\n" +output + "\n---------------------");;
    }

    public void listarFuncionarios() {
        String output = "";

        for(int i = 0; i < funcionarios.size(); i++) {
            output += (i != 0 ? "\n" : "") + String.valueOf(i + 1) + " - " + funcionarios.get(i).getNome() + " - Ocupação: " + funcionarios.get(i).getOcupacao();
        }

        if(output.equals(""))
            System.out.println("---------------------\n" + "Nenhum funcionário registrado." + "\n---------------------");
        else
            System.out.println("---------------------\n" +output + "\n---------------------");;
    }

    public void listarInstrutores() {
        String output = "";

        for(int i = 0; i < instrutores.size(); i++) {
                output += ((i != 0 ? "\n" : "") + String.valueOf(i + 1) + " - " + instrutores.get(i).getNome());
        }

        if(output.equals(""))
            System.out.println("---------------------\n" + "Nenhum instrutor registrado." + "\n---------------------");
        else
            System.out.println("---------------------\n" +output + "\n---------------------");;
    }

    public void listarAtividades() {
        String output = "";

        for(int i = 0; i < atividades.size(); i++) {
            output += (i != 0 ? "\n" : "") + String.valueOf(i + 1) + " - " + atividades.get(i).getNome() + " - Preço: " + atividades.get(i).getPreco();
        }

        if(output.equals(""))
            System.out.println("---------------------\n" + "Nenhuma atividade registrada." + "\n---------------------");
        else
            System.out.println("---------------------\n" +output + "\n---------------------");;
    }

    public void adicionarAtividade(Atividade o) {
        atividades.add(o);
    }

    public void adicionarAluno(Aluno o) {
        alunos.add(o);
    }

    public void adicionarFuncionario(Funcionario o) {
        funcionarios.add(o);
    }

    public void adicionarFuncionario(Instrutor o) {
        funcionarios.add(o);
        instrutores.add(o);
    }

    public void mostrarFuncionario(int pos) {
        System.out.println(funcionarios.get(pos).toString());
    }

    public Atividade pegarAtividade(int pos) {
        return atividades.get(pos);
    }

    public Instrutor pegarInstrutor(int pos) {
        return instrutores.get(pos);
    }

    public Funcionario pegarFuncionario(int pos) {
        return funcionarios.get(pos);
    }

    public void mostrarAluno(int pos) {
        System.out.println(alunos.get(pos).toString());
    }

    public void descontarGastosMateriais() {
        this.caixa -= this.gastoMateriais;
    }

    public void pagarFuncionarios() {
        double montante = 0;

        for(Funcionario f: funcionarios) {
            montante += f.calcularRemuneracao();
        }

        if(montante > caixa) {
            System.out.println("Saldo insuficiente para pagar todos os funcionários!");
        } else {
            for(Funcionario f: funcionarios) {
                f.setUltimoPagamento(LocalDate.now());
            }
            caixa -= montante;
            System.out.println("Pagamentos realizados com sucesso!");
        }
    }

    public void pagarFuncionario(int pos) {
        double remuneracao = funcionarios.get(pos).calcularRemuneracao();

        if(remuneracao < caixa) {
            caixa -= remuneracao;
            funcionarios.get(pos).setUltimoPagamento(LocalDate.now());
        } else {
            System.out.println("Fundos insuficientes para realizar o pagamento.");
        }
    }

    public void receberPagamentos() {
        for(Aluno a: alunos) {
            caixa += a.calcularMensalidade();
            a.setUltimoPagamento(LocalDate.now());
        }
        System.out.println("Mensalidades recebidas com sucesso!");
    }

    public void receberPagamento(int pos) {
        double mensalidade = alunos.get(pos).calcularMensalidade();

        caixa += mensalidade;
        alunos.get(pos).setUltimoPagamento(LocalDate.now());

        System.out.println("Mensalidade recebida com sucesso!");
    }

    // Setters e getters

    public double getCaixa() {
        return caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public double getGastoMateriais() {
        return gastoMateriais;
    }

    public void setGastoMateriais(double gastoMateriais) {
        this.gastoMateriais = gastoMateriais;
    }
}
