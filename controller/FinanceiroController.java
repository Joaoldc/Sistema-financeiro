package controller

import model.Transacao;
import java.util.ArrayList;
import java.util.List;

// Classe que controla a lógica do sistema (Controller)
public class FinanceiroController {
    // Lista que armazena todas as transações (Model em ação!)
    private List<Transacao> transacoes = new ArrayList<>();

    // Adiciona uma nova transação
    public void adicionarTransacao(double valor, String tipo) {
        // Validação simples
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }
        if (!tipo.equals("entrada") && !tipo.equals("saida")) {
            throw new IllegalArgumentException("Tipo deve ser 'entrada' ou 'saida'.");
        }

        // Cria uma nova transação e adiciona à lista
        Transacao novaTransacao = new Transacao(valor, tipo);
        transacoes.add(novaTransacao);
    }

    // Retorna a lista de transações
    public List<Transacao> obterTransacoes() {
        return new ArrayList<>(transacoes); // retorna uma cópia para segurança
    }

    // Calcula o saldo total
    public double calcularSaldo() {
        double saldo = 0.0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equals("entrada")) {
                saldo += t.getValor();
            } else if (t.getTipo().equals("saida")) {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }
}