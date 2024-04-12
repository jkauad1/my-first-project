package dominio;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(){}

    public Cliente(String nome, String cpf, String idade){
        super(nome, cpf, idade);
    }

    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }




}
