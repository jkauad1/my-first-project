package dominio;

import java.util.ArrayList;

public class Veiculo {
    private String cor, placa, modelo, ano, tipo;

    public Veiculo() {
    }

    public Veiculo(String cor, String placa, String modelo, String ano, String tipo) {
        this.cor = cor;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.tipo = tipo;
    }

    private ArrayList<Veiculo> funcionarios = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo){
        this.funcionarios.add(veiculo);
    }
}
