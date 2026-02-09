import model.ContaBancaria;
import service.BancoService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BancoService banco = new BancoService();
        ContaBancaria conta = null;

        int opcao;

        do {
            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Acessar conta");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Depositar");
            System.out.println("5 - Sacar");
            System.out.println("6 - Ver histórico");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String nome = sc.nextLine();
                    conta = banco.criarConta(nome);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do titular: ");
                    nome = sc.nextLine();
                    conta = banco.buscarConta(nome);
                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.println("Conta acessada com sucesso!");
                    }
                    break;

                case 3:
                    if (conta != null) {
                        conta.consultarSaldo();
                    } else {
                        System.out.println("Acesse uma conta primeiro.");
                    }
                    break;

                case 4:
                    if (conta != null) {
                        System.out.print("Valor do depósito: ");
                        conta.depositar(sc.nextDouble());
                    } else {
                        System.out.println("Acesse uma conta primeiro.");
                    }
                    break;

                case 5:
                    if (conta != null) {
                        System.out.print("Valor do saque: ");
                        conta.sacar(sc.nextDouble());
                    } else {
                        System.out.println("Acesse uma conta primeiro.");
                    }
                    break;

                case 6:
                    if (conta != null) {
                        conta.mostrarHistorico();
                    } else {
                        System.out.println("Acesse uma conta primeiro.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
