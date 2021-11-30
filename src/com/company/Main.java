package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void gerenciarAlunos(Scanner scan, Sistema sys) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("(ALUNOS)\nDigite o número abaixo correspondente ao que você quer fazer.");
            System.out.println("1 - Listar todos os alunos.");
            System.out.println("2 - Visualizar um aluno.");
            System.out.println("3 - Adicionar um aluno ao sistema.");
            System.out.println("4 - Voltar ao menu anterior.");

            switch (scan.nextInt()) {
                case 1:
                    sys.listarAlunos();
                    System.out.println("\n Digite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                case 2:
                    sys.listarAlunos();
                    System.out.println("Digite o número do aluno que você deseja visualizar.");
                    sys.mostrarAluno(scan.nextInt() - 1);
                    System.out.println("\n Digite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                case 3:
                    System.out.println("Digite as informações do novo aluno.\n");

                    System.out.println("Nome:");
                    String nome = scan.next();

                    System.out.println("CPF:");
                    String cpf = scan.next();

                    System.out.println("Nome do Responsável (se houver):");
                    String responsavel = scan.next();

                    System.out.println("Desconto (em decimais):");
                    double desconto = scan.nextDouble();

                    System.out.println("\nDigite o número relativo à atividade listada. Qual delas o aluno fará?");
                    sys.listarAtividades();
                    Atividade atividade = sys.pegarAtividade(scan.nextInt() - 1);

                    System.out.println("\nDigite o número relativo ao instrutor listado. Qual deles acompanhará o aluno?");
                    sys.listarInstrutores();
                    Instrutor instrutor = sys.pegarInstrutor(scan.nextInt() - 1);

                    sys.adicionarAluno(new Aluno(nome, cpf, LocalDate.now() ,responsavel, desconto, atividade, instrutor));
                    System.out.println("\nAluno criado com sucesso!\nDigite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                default: continuar = false;
                    break;
            }
        }

    }

    public static void gerenciarFuncionarios(Scanner scan, Sistema sys) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("(Funcionários)\nDigite o número abaixo correspondente ao que você quer fazer.");
            System.out.println("1 - Listar todos os funcionários.");
            System.out.println("2 - Listar apenas os instrutores.");
            System.out.println("3 - Mostrar detalhes de um funcionário.");
            System.out.println("4 - Adicionar um funcionário.");
            System.out.println("5 - Voltar ao menu anterior.");

            switch (scan.nextInt()) {
                case 1:
                    sys.listarFuncionarios();
                    System.out.println("\n Digite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                case 2:
                    sys.listarInstrutores();
                    System.out.println("\n Digite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                case 3:
                    sys.listarFuncionarios();
                    System.out.println("Digite o número do funcionário que você deseja visualizar.");
                    sys.mostrarFuncionario(scan.nextInt() - 1);
                    System.out.println("\n Digite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                case 4:
                    System.out.println("Digite as informações do novo funcionário.\n");

                    System.out.println("Qual tipo de funcionário você deseja cadastrar? Digite o número correspondente abaixo.");
                    System.out.println("1 - Funcionário geral\n2 - Instrutor\n3 - Instrutor horista");

                    switch (scan.nextInt()) {
                        case 1:
                            System.out.println("Nome:");
                            String nome = scan.next();

                            System.out.println("CPF:");
                            String cpf = scan.next();

                            System.out.println("Ocupação:");
                            String ocupacao = scan.next();

                            System.out.println("Salário:");
                            double salario = scan.nextDouble();

                            sys.adicionarFuncionario(new Funcionario(nome, cpf, ocupacao, salario));
                            System.out.println("Novo funcionário adicionado com sucesso!\nDigite qualquer coisa e pressione enter para continuar...");
                            scan.next();
                            break;
                        case 2:
                            System.out.println("Nome:");
                            nome = scan.next();

                            System.out.println("CPF:");
                            cpf = scan.next();

                            System.out.println("Salário:");
                            salario = scan.nextDouble();

                            Instrutor instrutor = new Instrutor(nome, cpf, salario);

                            boolean continuar2 = true;
                            while(continuar2) {
                                System.out.println("Que atividades o instrutor exercerá? Escolha, uma de cada vez, dentre os números abaixo:");
                                sys.listarAtividades();
                                System.out.println("Ou digite 0 (zero) caso tenha acabado de selecionar as atividades.");
                                int opt = scan.nextInt();
                                if(opt == 0) {
                                    continuar2 = false;
                                } else {
                                    instrutor.adicionarAtividade(sys.pegarAtividade(opt - 1));
                                }
                            }

                            sys.adicionarFuncionario(instrutor);
                            System.out.println("Novo instrutor adicionado com sucesso!\nDigite qualquer coisa e pressione enter para continuar...");
                            scan.next();
                            break;
                        case 3:
                            System.out.println("Nome:");
                            nome = scan.next();

                            System.out.println("CPF:");
                            cpf = scan.next();

                            System.out.println("CNPJ:");
                            String cnpj = scan.next();

                            System.out.println("Valor-hora:");
                            double valorHora = scan.nextDouble();

                            Instrutor instrutorHorista = new InstrutorHorista(nome, cpf, cnpj, valorHora);

                            boolean continuar3 = true;
                            while(continuar3) {
                                System.out.println("Que atividades o instrutor exercerá? Escolha, uma de cada vez, dentre os números abaixo:");
                                sys.listarAtividades();
                                System.out.println("Ou digite 0 (zero) caso tenha acabado de selecionar as atividades.");
                                int opt = scan.nextInt();
                                if(opt == 0) {
                                    continuar3 = false;
                                } else {
                                    instrutorHorista.adicionarAtividade(sys.pegarAtividade(opt - 1));
                                }
                            }

                            sys.adicionarFuncionario(instrutorHorista);
                            System.out.println("Novo instrutor adicionado com sucesso!\nDigite qualquer coisa e pressione enter para continuar...");
                            scan.next();
                            break;
                        default: break;
                    }
                    break;
                default: continuar = false;
            }
        }
    }

    public static void gerenciarAtividades(Scanner scan, Sistema sys) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("(ATIVIDADES)\nDigite o número abaixo correspondente ao que você quer fazer.");
            System.out.println("1 - Listar todas as atividades.");
            System.out.println("2 - Adicionar uma nova atividade.");
            System.out.println("3 - Voltar ao menu anterior.");

            switch (scan.nextInt()) {
                case 1:
                    sys.listarAtividades();
                    System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                case 2:
                    System.out.println("Digite as informações da nova atividade.\n");

                    System.out.println("Nome:");
                    String nome = scan.next();

                    System.out.println("Preço:");
                    double preco = scan.nextDouble();

                    sys.adicionarAtividade(new Atividade(nome, preco));
                    System.out.println("Nova atividade criada com sucesso!\nDigite qualquer coisa e pressione enter para continuar...");
                    scan.next();
                    break;
                default: continuar = false;
            }
        }
    }

    public static void gerenciarFinancas(Scanner scan, Sistema sys) {
       boolean continuar = true;

       while (continuar) {
           System.out.println("(FINANÇAS)\nDigite o número abaixo correspondente ao que você quer fazer.");
           System.out.println("1 - Mostrar estado atual das finanças.");
           System.out.println("2 - Receber todas as mensalidades.");
           System.out.println("3 - Receber mensalidade de um aluno.");
           System.out.println("4 - Pagar todos os salários de funcionários.");
           System.out.println("5 - Pagar salário de um funcionário.");
           System.out.println("6 - Pagar custos com materiais do mês.");
           System.out.println("7 - Voltar ao menu anterior.");

           switch (scan.nextInt()) {
               case 1:
                   System.out.println("\nSaldo atual do caixa: R$" + sys.getCaixa());
                   System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                   scan.next();
                   break;
               case 2:
                   System.out.println("\nTem certeza de que deseja receber a mensalidade de TODOS os alunos?\nDigite S para sim e qualquer outra coisa para não.");
                   if(scan.next().equals("S")) {
                       sys.receberPagamentos();
                   }
                   System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                   scan.next();
                   break;
               case 3:
                   System.out.println("\nSelecione o número do aluno que está pagando a mensalidade.");
                   sys.listarAlunos();
                   sys.receberPagamento(scan.nextInt() - 1);
                   System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                   scan.next();
                   break;
               case 4:
                   System.out.println("\nTem certeza de que deseja pagar o salário de TODOS os funcionários?\nDigite S para sim e qualquer outra coisa para não.");
                   if(scan.next().equals("S")) {
                       sys.pagarFuncionarios();
                   }
                   System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                   scan.next();
                   break;
               case 5:
                   System.out.println("\nSelecione o número do funcionário que está recebendo pagamento.");
                   sys.listarFuncionarios();
                   sys.pagarFuncionario(scan.nextInt() - 1);
                   System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                   scan.next();
                   break;
               case 6:
                   System.out.println("\nTem certeza de que deseja pagar os custos com materiais do mês?\nDigite S para sim e qualquer outra coisa para não.");
                   if(scan.next().equals("S")) {
                       sys.descontarGastosMateriais();
                   }
                   System.out.println("Digite qualquer coisa e pressione enter para continuar...");
                   scan.next();
                   break;
               default: continuar = false;
           }
       }
    }

    public static void main(String[] args) {
        // Instanciando a classe mais importante, que centraliza a manipulação dos objetos das outras classes.

        Sistema sys = new Sistema(0, 0);

        // Instanciando alguns objetos de exemplo para popular o objeto 'sys'

        sys.adicionarAtividade(new Atividade("Natação", 100));
        sys.adicionarFuncionario(new Instrutor("Deoclécio", "12345", 3000));
        sys.adicionarAluno(new Aluno("Irineuda", "456789", LocalDate.parse("2021-10-11"), "", 0.1, sys.pegarAtividade(0), sys.pegarInstrutor(0)));

        // Iniciando o loop principal da aplicação e instanciando o objeto scanner

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Antes de inicializar o sistema, informe quanto dinheiro há em caixa e qual o custo mensal com materiais.\nCaixa:");
        sys.setCaixa(scan.nextDouble());
        System.out.println("Custo mensal:");
        sys.setGastoMateriais(scan.nextDouble());

        while(continuar) {
            System.out.println("Bem vindo ao menu do sistema!\n\nDigite o número abaixo correspondente ao que você quer fazer.");
            System.out.println("1 - Gerenciar alunos");
            System.out.println("2 - Gerenciar funcionários");
            System.out.println("3 - Gerenciar atividades");
            System.out.println("4 - Gerenciar finanças");
            System.out.println("5 - Encerrar aplicação");

            switch (scan.nextInt()) {
                case 1: gerenciarAlunos(scan, sys); break;
                case 2: gerenciarFuncionarios(scan, sys); break;
                case 3: gerenciarAtividades(scan, sys); break;
                case 4: gerenciarFinancas(scan, sys); break;
                default:
                    System.out.println("Encerrando aplicação...");
                    continuar = false;
            }
        }
    }
}
