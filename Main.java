public class Main {
    public static void main(String[] args) {
        // 1. Cria os componentes do MVC
        controller.FinanceiroController controller = new controller.FinanceiroController();
        view.TelaFinanceira view = new view.TelaFinanceira();

        // 2. Loop principal do programa
        boolean executando = true;
        while (executando) {
            view.mostrarMenu(); // View mostra o menu
            int opcao = view.lerOpcao(); // View lê a opção

            try {
                switch (opcao) {
                    case 1:
                        // Solicita dados da View e envia ao Controller
                        double valor = view.pedirValor();
                        String tipo = view.pedirTipo();
                        controller.adicionarTransacao(valor, tipo);
                        view.mostrarMensagem("Transação adicionada com sucesso!");
                        break;

                    case 2:
                        // Controller fornece os dados, View mostra
                        view.mostrarTransacoes(controller.obterTransacoes());
                        break;

                    case 3:
                        // Controller calcula, View mostra
                        double saldo = controller.calcularSaldo();
                        view.mostrarMensagem("Saldo atual: R$" + String.format("%.2f", saldo));
                        break;

                    case 0:
                        executando = false;
                        view.mostrarMensagem("Saindo...");
                        break;

                    default:
                        view.mostrarMensagem("Opção inválida!");
                }
            } catch (Exception e) {
                view.mostrarMensagem("Erro: " + e.getMessage());
            }
        }

        // 3. Fecha recursos
        view.fechar();
    }
}    