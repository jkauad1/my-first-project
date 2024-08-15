package classes;

import interfaces.RegistroFisico;
import interfaces.RegistroProduto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Veiculo implements RegistroProduto {
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

    @Override
    public void consorcio() {

    }

    public Veiculo registrarCarro() {
        // Função para registrar um novo carro.
        Veiculo carro = new Veiculo();
        carro.setMarca(JOptionPane.showInputDialog("Marca: "));
        carro.setModelo(JOptionPane.showInputDialog("Modelo: "));
        carro.setAno(JOptionPane.showInputDialog("Ano: "));
        carro.setTipo(JOptionPane.showInputDialog("Tipo: "));
        carro.setCor(JOptionPane.showInputDialog("Cor: "));
        carro.setPlaca(JOptionPane.showInputDialog("Placa: "));
        return carro;
    }

    public void listarTodosCarros() {
        List<Veiculo> todosCarros = listarCarros();
        for (Veiculo veiculo : todosCarros) {
            JOptionPane.showMessageDialog(null, "Marca: " + veiculo.getMarca() +
                    "\nModelo: " + veiculo.getModelo() +
                    "\nAno: " + veiculo.getAno() +
                    "\nTipo: " + veiculo.getTipo() +
                    "\nCor: " + veiculo.getCor() +
                    "\nPlaca: " + veiculo.getPlaca());
        }
    }

    @Override
    public void mostraCarro() {
        // Função usada pra procurar um carro específico atráves de metodos da classe Veiculo.
        String opcao = JOptionPane.showInputDialog("1 - Procurar carro pela placa. " +
                                                   "\n 2 - Mostrar todos os carros. ");
        if ("1".equals(opcao)){
            String placa;
        Veiculo c;
        placa = JOptionPane.showInputDialog("Informe a placa do carro que deseja procurar: ");
        c = procurarCarro(placa);
        if (c != null) {
            JOptionPane.showMessageDialog(null, "Marca: " + c.getMarca() +
                    "\nModelo: " + c.getModelo() +
                    "\nAno: " + c.getAno() +
                    "\nTipo: " + c.getTipo() +
                    "\nCor: " + c.getCor() +
                    "\nPlaca: " + c.getPlaca());
        } else {
            JOptionPane.showMessageDialog(null, "O carro não está no estoque.");
        }
        }
        else {
            listarTodosCarros();
            return;
        }
    }

    @Override
    public void adicionarCarro(Veiculo carro){
        this.carros.add(carro);
    }

    @Override
    public Veiculo procurarCarro(String placa){
        for (Veiculo carro : carros){
            if (carro.placa.equals(placa)){
                return carro;
            }
            }
        JOptionPane.showMessageDialog(null, "O carro não foi encontrado.");
        return null;
    }

    @Override
    public void removerCarro(String placa){
        for (Veiculo carro : carros){
            if (carro.placa.equals(placa)){
                carros.remove(carro);
                break;
            }
        }
    }

    @Override
    public void imprimir() {
        System.out.println();
    }

    @Override
    public List<Veiculo> listarCarros() {
        return new ArrayList<>(carros);
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