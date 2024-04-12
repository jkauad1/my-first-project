package main;

import java.io.Serializable;

import dominio.*;
import javax.swing.*;

public class Principal implements Serializable {
    public static void main(String[] args){
        menu();
    }
    
    public static void menu(){
        int sair = 1;
        //1 - Cadastrar Funcionario
        //2 - Cadastrar Cliente
        //3 - Mostrar Funcionario
        //4 - Mostrar Cliente
        //5 - Gravar Dados
        //6 - Ler Dados
        //9 - Sair

        while(sair != 0){
            int menu = Integer.parseInt(JOptionPane.showInputDialog("MENU " +
                    "\n1 - Cadastrar Funcionário \n2 - Cadastrar Cliente \n3 - Mostrar Funcionário  " +
                    "\n4 - Mostrar Cliente  \n5 - Gravar Dados \n6 - Ler Dados \n7 - Realizar Compra " +
                    "\n9 - Sair \nDigite a opcao desejada:  "));
            switch (menu){
                case 1:
                    cadastrarFuncionario();
                case 2:


            }
        }

    }

    private static void cadastrarFuncionario(){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(JOptionPane.showInputDialog("Nome: "));
        funcionario.setCpf(JOptionPane.showInputDialog("Cpf: "));
        funcionario.setIdade(JOptionPane.showInputDialog("Idade: "));
        funcionario.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        funcionario.contato.setEmail(JOptionPane.showInputDialog("Email: "));
        funcionario.endereco.setEstado(JOptionPane.showInputDialog("Estado: "));
        funcionario.endereco.setCidade(JOptionPane.showInputDialog("Cidade: "));
        funcionario.endereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
        funcionario.endereco.setRua(JOptionPane.showInputDialog("Rua: "));
        funcionario.endereco.setNumero(JOptionPane.showInputDialog("Número"));
        funcionario.adicionarFuncionario(funcionario);
    }

    //aplicar a mesma logica de funcionarios
    private static void cadastrarCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome(JOptionPane.showInputDialog("Nome: "));
        cliente.setCpf(JOptionPane.showInputDialog("Cpf: "));
        cliente.setIdade(JOptionPane.showInputDialog("Idade: "));
//        return cliente;
    }
}
