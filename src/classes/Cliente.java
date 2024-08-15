package classes;

import interfaces.RegistroFisico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects; /* Biblioteca para manipulação de objetos, foi implementada no método
                            confirmaCompra para comparação entre objetos */

public class Cliente extends Pessoa implements RegistroFisico<Cliente> {
    private ArrayList<Cliente> clientes = new ArrayList<>(); /* A ArrayList permite que os objetos criados possam
                                                                        ser removidos ou adicionados mais facilmente que
                                                                        um Array construído. */
    private Funcionario crachaFuncPadrao; //Funcionário que atenderá o cliente.
    private Veiculo carro;

    public Cliente(){}

    @Override
    public Cliente cadastrar() {
        Cliente cliente = new Cliente(); /* Função que cria um novo objeto cliente que define os atributos
        e retorna o objeto para a ArrayList clientes. */
        cliente.setNome(JOptionPane.showInputDialog("Nome: "));
        cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
        cliente.setIdade(JOptionPane.showInputDialog("Idade: "));
        cliente.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        return cliente;
    }


    public void listarTodosClientes() {
        List<Cliente> todosClientes = listarPessoas();
        for (Cliente cliente : todosClientes) {
            JOptionPane.showMessageDialog(null,"Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }
    }


    //Polimorfismo de sobrescrita do método da interface.
    @Override
    public void mostrarPessoas() {
        String opcao = JOptionPane.showInputDialog("Deseja buscar o cliente por:\n1 - CPF\n2 - Nome \n3 - Ver todos os funcionários");
        Cliente c = null;
        if ("1".equals(opcao)) {
            String cpf = JOptionPane.showInputDialog("CPF do cliente que deseja buscar: ");
            c = procurarPessoa(cpf);
        } else if ("2".equals(opcao)) {
            String nome = JOptionPane.showInputDialog("Nome do cliente que deseja buscar: ");
            c = procurarPessoa(nome, true);
        } else if ("3".equals(opcao)) {
            listarTodosClientes();
            return;
        }
        if (c != null) {
            JOptionPane.showMessageDialog(null, "Nome: " + c.getNome() +
                    "\nCPF: " + c.getCpf() +
                    "\nIdade: " + c.getIdade() +
                    "\nContato: " + c.contato.getTelefone());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }

    public void removerCliente() {
        Cliente c;
        String cpf = JOptionPane.showInputDialog("Informe o cpf do cliente para remove-lo do sistema: ");
        c = procurarPessoa(cpf);
        if (c != null) {
            JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome() +
                    " removido do sistema.");
            removerPessoa(cpf);
        } else {
            JOptionPane.showMessageDialog(null, "O cliente informado não foi encotrado.");
        }
    }


    @Override      //Polimorfismo de sobrescrita do método da interface.
    public void adicionarPessoa(Cliente cliente) {
        this.clientes.add(cliente);
    }


    @Override     //Polimorfismo de sobrescrita do método da interface.
    public Cliente procurarPessoa(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    // Polimorfismo de sobrecarga do método procurarPessoa.
    public Cliente procurarPessoa(String nome, boolean isNome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

        //Polimorfismo de sobrescrita do método da interface.
    @Override
    public void removerPessoa(String cpf){
        Cliente cliente = procurarPessoa(cpf);
        if (cliente != null){
            clientes.remove(cliente);
        }
    }

    //Polimorfismo de sobrescrita do método da interface.
    @Override
    public List<Cliente> listarPessoas() {
        return new ArrayList<>(clientes);
    }

    public boolean confirmaCompra(){
        // A biblioteca Objects compara a opção digitada pelo usuário com a String "Sim".

        String opcao = JOptionPane.showInputDialog("Você deseja confirmar a compra? (Sim/Não)");
        if(Objects.equals(opcao, "Sim")){
            JOptionPane.showMessageDialog(null,"A compra foi confirmada, prosseguindo...");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "A compra não foi confirmada. ");
            return false;
        }


    }

    public Veiculo getCarro() {
        return carro;
    }

    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }

    public void defFuncionarioPadrao(Funcionario funcionario){
        this.crachaFuncPadrao = funcionario;
    }

    public Funcionario pegarFuncionarioPadrao(){
        return this.crachaFuncPadrao;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Funcionario getCrachaFuncPadrao() {
        return crachaFuncPadrao;
    }

    public void setCrachaFuncPadrao(Funcionario crachaFuncPadrao) {
        this.crachaFuncPadrao = crachaFuncPadrao;
    }

    public ArrayList<Cliente> pegarCliente(){
        return this.clientes;
    }
}
