import java.time.LocalDate;

// Classe que representa UMA transação financeira (Model)
public class Transacao {
    // Atributos = características da transação
    private double valor;        // valor da transação (ex: 100.50)
    private String tipo;         // "entrada" ou "saida"
    private LocalDate data;      // data da transação

    // Construtor: método que cria uma nova transação
    public Transacao(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
        this.data = LocalDate.now(); // data de hoje
    }

    // Métodos "getters": permitem que outras classes leiam os valores
    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    // Método toString: usado para imprimir a transação de forma legível
    @Override
    public String toString() {
        return "Data: " + data + " | Tipo: " + tipo + " | Valor: R$" + String.format("%.2f", valor);
    }
}