package br.com.seubanco;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = null;

        while (true) {
            System.out.println("\nBem-vindo ao Banco!");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Visualizar Conta");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Saque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner após leitura

            switch (opcao) {
                case 1:
                    // Lógica para cadastrar conta
                    break;
                case 2:
                    // Lógica para visualizar conta
                    break;
                case 3:
                    // Lógica para realizar depósito
                    break;
                case 4:
                    // Lógica para realizar saque
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);  // Encerra o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
