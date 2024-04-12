package dominio;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private float descontoMax, credito;

    public Cliente( float descontoMax, float credito) {
        this.descontoMax = descontoMax;
        this.credito = credito;
    }

    private ArrayList<Cliente> clientes = new ArrayList<>();
    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }






}
