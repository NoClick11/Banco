package Programa;
    import java.util.Scanner;
    import java.util.ArrayList;

public class Programa {
        static Scanner sc = new Scanner(System.in);
        static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Excluir conta |");
        System.out.println("|   Opção 3 - Depositar     |");
        System.out.println("|   Opção 4 - Sacar         |");
        System.out.println("|   Opção 5 - Transferir    |");
        System.out.println("|   Opção 6 - Listar        |");
        System.out.println("|   Opção 7 - Buscar conta  |");
        System.out.println("|   Opção 8 - Sair          |");

        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                excluirConta();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                transferir();
                break;
            case 6:
                listarContas();
                break;
            case 7:
                buscarContas();
                break;
            case 8:
                System.out.println("Você saiu");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        System.out.println("\nEscreva seu nome: ");
        String nome = sc.next();
        System.out.println("\nEscreva seu CPF: ");
        String cpf = sc.next();
        System.out.println("\nEscreva seu email: ");
        String email = sc.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    public static void excluirConta() {
        System.out.println("\n Qual conta deseja excluir");
        int contaExcluir = sc.nextInt();
        for (Conta contaa : contasBancarias) {
            if (contaa.getNumeroConta() == contaExcluir) {
                contasBancarias.remove(contaExcluir-1);
            }
        }
        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(!contasBancarias.isEmpty()) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                        conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta  = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar: ");
            Double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso: ");
        } else {
            System.out.println("Conta não foi encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta  = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar: ");
            Double valorSaque = sc.nextDouble();

            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não foi encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = sc.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        System.out.println("Número da conta do remetente: ");

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário");
            int  numeroContaDestinatario = sc.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = sc.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);


            }
        }
        operacoes();

    }

    //listar contas
    public static void listarContas() {
        if(!contasBancarias.isEmpty()) {
            for (Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }

    public static void buscarContas() {
        Conta conta = null;
        if(!contasBancarias.isEmpty()) {
            System.out.println("Digite o número da conta");
            int numeroConta = sc.nextInt();
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    System.out.println(contaa);
                }
            }
        } else {
            System.out.println("Esta conta não existe!");
        }
        operacoes();
    }
}