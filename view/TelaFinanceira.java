package View;

import java.util.List;
import java.util.Scanner;

// Classe que cuida da interface com o usuário (View)
public class TelaFinanceira {
    private Scanner scanner; // para ler entradas do teclado

    // Construtor: cria o scanner
    public TelaFinanceira() {
        this.scanner = new Scanner(System.in);
    }

    // Mostra o menu principal
    public void mostrarMenu() {
        System.out.println("\n=== Sistema Financeiro ===");
        System.out.println("1. Adicionar transação");
        System.out.println("2. Listar transações");
        System.out.println("3. Ver saldo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção escolhida pelo usuário
    public int lerOpcao() {
        return scanner.nextInt(); // lê um número inteiro
    }

    // Pede ao usuário o valor da transação
    public double pedirValor() {
        System.out.print("Digite o valor: R$ ");
        return scanner.nextDouble();
    }

    // Pede ao usuário o tipo da transação
    public String pedirTipo() {
        System.out.print("Digite o tipo (entrada/saida): ");
        return scanner.next().toLowerCase(); // converte para minúsculas
    }

    // Mostra uma mensagem na tela
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Mostra todas as transações
    public void mostrarTransacoes(List<model.Transacao> transacoes) {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            System.out.println("\n--- Transações ---");
            for (model.Transacao t : transacoes) {
                System.out.println(t); // usa o toString() da classe Transacao
            }
        }
    }

    // Fecha o scanner (boa prática)
    public void fechar() {
        scanner.close();
    }
}
