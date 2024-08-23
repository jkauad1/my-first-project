package classes;

import javax.swing.*;

public class MenuController {
    static Client clientes = new Client();  /* Criamos as instâncias que irão armazenar os objetos criados
    durante o programa. */
    static Funcionario funcionarios = new Funcionario();
    static Veiculo carros = new Veiculo();
    static SaleController vendas = new SaleController();

    public static void menu() {
        int sair = 1;  /* A condição de parada do menu é o 0 para sair do laço. Todos a lógica que seria
        usada com o Scanner e o System.out.print é substítuida pelas funções da biblioteca javax.*/

        while (sair != 0) {
            int menu = Integer.parseInt(JOptionPane.showInputDialog("MENU " +
                    "\n1 - Cadastrar Funcionário \n2 - Cadastrar Cliente \n3 - Mostrar Funcionário  " +
                    "\n4 - Mostrar Cliente  \n5 - Adicionar Carro \n6 - Carros Disponíveis \n7 - Confirmar Compra " +
                    "\n8 - Designar funcionário  \n9 - Mostrar Designação \n10 - Remover Cliente \n11 - Remover Funcionário " +
                    "\n12 - Encerrar programa \nDigite a opção desejada:  "));
            switch (menu) {
                case 1:
                    funcionarios.adicionarPessoa(funcionarios.cadastrar());
                    break;
                case 2:
                    clientes.adicionarPessoa(clientes.cadastrar());
                    break;
                case 3:
                    funcionarios.mostrarPessoas();
                    break;
                case 4:
                    clientes.mostrarPessoas();
                    break;
                case 5:
                    carros.adicionarCarro(carros.registrarCarro());
                    break;
                case 6:
                    carros.mostraCarro();
                    break;
                case 7:
                    vendas.vende(carros, clientes);
                    break;
                case 8:
                    associarFuncionario();
                    break;
                case 9:
                    mostraAssociação();
                    break;
                case 10:
                    clientes.removerCliente();
                    break;
                case 11:
                    funcionarios.removerFuncionario();
                    break;
                case 12:
                    sair = 0;
                    break;
            }
        }
    }

    public static void associarFuncionario() {
        // Função pra associar um cliente a um funcionário.
        String cpfC = JOptionPane.showInputDialog("Insira o cpf do cliente que será designado: ");
        Client c;
        c = clientes.procurarPessoa(cpfC);

        if (c != null) {

            String cracha = JOptionPane.showInputDialog("Insira o crachá do funcionário para designar-lo ao cliente: ");
            Funcionario f;
            f = funcionarios.procurarCracha(cracha);
            if (f != null) {
                c.defFuncionarioPadrao(f);
            } else {
                JOptionPane.showMessageDialog(null, "O funcionário não foi encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O cliente não foi encontrado.");
        }
    }

    private static void mostraAssociação() {
        // Função pra mostrar quais clientes o funcionário está encarregado.
        Client c;
        String cpf = JOptionPane.showInputDialog("Informe o cpf do cliente para ver qual funcionário está encarregado de seu atendimento: ");
        c = clientes.procurarPessoa(cpf);
        if (c != null) {
            if (c.getCrachaFuncPadrao() != null)
                JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome() +
                        "\nFuncionário Responsável" +
                        ": " + c.getCrachaFuncPadrao());
            else {
                JOptionPane.showMessageDialog(null, "Nenhum funcionário foi designado a este cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O cliente não foi encontrado.");
        }
    }
}
