package main;

import dominio.Cliente;
import dominio.Funcionario;
import dominio.Veiculo;

import javax.swing.*;

public class Principal {
    static Cliente clientes = new Cliente();
    static Funcionario funcionarios = new Funcionario();
    static Veiculo carros = new Veiculo();
    public static void main(String args[]){
        menu();

    }
    public static void menu(){
        int sair = 1;
        //1 - Cadastrar Funcionário
        //2 - Cadastrar Cliente
        //3 - Mostrar Funcionário
        //4 - Mostrar Cliente
        //5 - Carros Disponíveis
        //6 - Adicionar Carro
        //7 - Confirmar Compra
        //8 -
        //9 - Sair
        while(sair != 0){
            int menu = Integer.parseInt(JOptionPane.showInputDialog("MENU " +
                    "\n1 - Cadastrar Funcionário \n2 - Cadastrar Cliente \n3 - Mostrar Funcionário  " +
                    "\n4 - Mostrar Cliente  \n5 - Adicionar Carro \n6 - Carros Disponíveis \n7 - Confirmar Compra " +
                    "\n8 - Designar funcionário  \n9 - Mostrar Designação \n10 - Sair\nDigite a opcao desejada:  "));
            switch(menu){
                case 1:
                    funcionarios.adicionarFuncionario(cadastrarFuncionario());
                    break;
                case 2:
                    clientes.adicionarCliente(cadastrarCliente());
                    break;
                case 3:
                    mostraFuncionario();
                    break;
                case 4:
                    mostraCliente();
                    break;
                case 5:
                    carros.adicionarCarro(registrarCarro());
                    break;
                case 6:
                    mostraCarro();
                    break;
                case 7:
                    comprarCarro();
                    break;
                case 8:
                    associarFuncionario();
                    break;
                case 9:
                    mostraAssociação();
                    break;
                case 10:
                    sair = 0;
                    break;
            }
        }
    }
    private static Cliente cadastrarCliente(){
        Cliente cliente = new Cliente();

        cliente.setNome(JOptionPane.showInputDialog("Nome: "));
        cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
        cliente.setIdade(JOptionPane.showInputDialog("Idade: "));
        cliente.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        return cliente;
    }
    private static Funcionario cadastrarFuncionario(){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(JOptionPane.showInputDialog("Nome: "));
        funcionario.setCpf(JOptionPane.showInputDialog("CPF: "));
        funcionario.setIdade(JOptionPane.showInputDialog("Idade: "));
        funcionario.setCracha(JOptionPane.showInputDialog("Crachá: "));
        funcionario.contato.setEmail(JOptionPane.showInputDialog("Email: "));
        funcionario.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        funcionario.endereco.setEstado(JOptionPane.showInputDialog("Estado: "));
        funcionario.endereco.setCidade(JOptionPane.showInputDialog("Cidade: "));
        funcionario.endereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
        funcionario.endereco.setRua(JOptionPane.showInputDialog("Rua: "));
        funcionario.endereco.setNumero(JOptionPane.showInputDialog("Numero: "));
        funcionario.setDataAdmissao(JOptionPane.showInputDialog("Informe o dia em que ele está sendo contratado"));
        return funcionario;
    }

    //Falta um if pra caso nao encontre o cpf do Funcionario e Cliente também
    private static void mostraFuncionario(){
        String cpf;
        Funcionario f;
        cpf = JOptionPane.showInputDialog("CPF do funcionário que deseja buscar: ");
        f = funcionarios.procurarFuncionario(cpf);
        if (f != null) {
            JOptionPane.showMessageDialog(null, "Nome: " + f.getNome() +
                    "\nCPF: " + f.getCpf() +
                    "\nIdade: " + f.getIdade() +
                    "\nContato: " + f.contato.getTelefone() +
                    "\nData de admissão: " + f.getDataAdmissao());
        }
        else{
            JOptionPane.showMessageDialog(null,"Funcionário não encontrado.");
        }
    }
    private static void mostraCliente(){
        String cpf;
        Cliente c;
        cpf = JOptionPane.showInputDialog("CPF do cliente que deseja buscar: ");
        c = clientes.procurarCliente(cpf);
        if (c != null) {
            JOptionPane.showMessageDialog(null, "Nome: " + c.getNome() +
                    "\nCPF: " + c.getCpf() +
                    "\nIdade: " + c.getIdade() +
                    "\nContato: " + c.contato.getTelefone());
        }
        else{
            JOptionPane.showMessageDialog(null,"Cliente não encontrado");
        }
    }

    public static Veiculo registrarCarro(){
        Veiculo carro = new Veiculo();
        carro.setMarca(JOptionPane.showInputDialog("Marca: "));
        carro.setModelo(JOptionPane.showInputDialog("Modelo: "));
        carro.setAno(JOptionPane.showInputDialog("Ano: "));
        carro.setTipo(JOptionPane.showInputDialog("Tipo: "));
        carro.setCor(JOptionPane.showInputDialog("Cor: "));
        carro.setPlaca(JOptionPane.showInputDialog("Placa: "));
        return carro;
    }

    public static Veiculo comprarCarro(){
        String placa = JOptionPane.showInputDialog("Informe a placa do carro que foi comprado.");
        Veiculo c;
        c = carros.procurarCarro(placa);
        if ( c != null){
            JOptionPane.showMessageDialog(null,"O carro " + c.getMarca() + " " + c.getModelo() +
                    " " + c.getAno() +
                    "\nCor: " +c.getCor() +
                    "\nPlaca: " + c.getPlaca() +
                    " foi retirado do estoque. ");
            carros.retirarCarro(placa);
        }
        else {
            JOptionPane.showMessageDialog(null,"Placa não encontrada.");
        }
        return c;
    }

    public static void mostraCarro(){
        String placa;
        Veiculo c;
        placa = JOptionPane.showInputDialog("Informe a placa do carro que deseja procurar: ");
        c = carros.procurarCarro(placa);
        if (c != null){
            JOptionPane.showMessageDialog(null, "Marca: " + c.getMarca() +
                    "\nModelo: " + c.getModelo() +
                    "\nAno: " + c.getAno() +
                    "\nTipo: " + c.getTipo() +
                    "\nCor: " + c.getCor() +
                    "\nPlaca: " + c.getPlaca());
        }
        else{
            JOptionPane.showMessageDialog(null,"O carro não está no estoque.");
        }
    }

    private static Cliente associarFuncionario(){
        String cpfC = JOptionPane.showInputDialog("Insira o cpf do cliente que será designado: ");
        Cliente c;
        c = clientes.procurarCliente(cpfC);

        if (c != null){

            String cracha = JOptionPane.showInputDialog("Insira o crachá do funcionário para designar-lo ao cliente: ");
            Funcionario f;
            f = funcionarios.procurarCracha(cracha);
            if (f != null) {
                c.defFuncionarioPadrao(f);
            }
            else {
                JOptionPane.showMessageDialog(null, "O funcionário não foi encontrado.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"O cliente não foi encontrado.");
        }

        return clientes;
    }

    private static void mostraAssociação(){
        Cliente c;
        String cpf = JOptionPane.showInputDialog("Informe o cpf do cliente para ver qual funcionário está encarregado de seu atendimento: ");
        c = clientes.procurarCliente(cpf);
        if (c.getCrachaFuncPadrao() != null){
            JOptionPane.showMessageDialog(null,"Cliente: " + c.getNome() +
                    "\nFuncionário Responsável: " + c.getCrachaFuncPadrao());
        }
        else {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário foi designado a este cliente.");
        }
    }
}