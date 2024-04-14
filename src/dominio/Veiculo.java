package dominio;

import java.util.ArrayList;

public class Veiculo {
    private String cor, placa, modelo, ano, tipo, marca;
    private ArrayList<Veiculo> carros = new ArrayList<>(); //Array de carros para organizar os carros criados no menu.

    public Veiculo() {
    }

    public Veiculo(String cor, String placa, String modelo, String ano, String tipo, String marca) {
        this.cor = cor;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.tipo = tipo;
        this.marca = marca;
    }

    public void adicionarCarro(Veiculo carro){
        this.carros.add(carro);
    }

    public Veiculo procurarCarro(String placa){
        for (Veiculo carro : carros){
            if (carro.placa.equals(placa)){
                return carro;
            }
        }
        return null;
    }

    public Veiculo retirarCarro(String placa){
        for (Veiculo carro : carros){
            if (carro.placa.equals(placa)){
                carros.remove(carro);
                return carro;
            }
        }
        return null;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Veiculo> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Veiculo> carros) {
        this.carros = carros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}