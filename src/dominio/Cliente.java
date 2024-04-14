package dominio;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Funcionario crachaFuncPadrao; //Funcionário que atenderá o cliente.

    public Cliente(){}


    public void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public Cliente procurarCliente(String cpf){
        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
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
