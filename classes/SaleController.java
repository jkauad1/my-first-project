package classes;

import javax.swing.*;

public class SaleController {
    private Veiculo carro;
    private Client comprador;
    private Funcionario vendedor;

    public SaleController(){}

    public SaleController(Veiculo carro, Client comprador, Funcionario vendedor){
        this.carro = carro;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }

    public void vende(Veiculo carro, Client comprador) {
        String placa = JOptionPane.showInputDialog(null,"Informe a placa do carro comprado: ");
        Veiculo carroEncontrado = carro.procurarCarro(placa);

        if (carroEncontrado != null){
            String cpf = JOptionPane.showInputDialog(null,"Informe o cpf do cliente que realizou a compra: ");
            Client compradorEncontrado = comprador.procurarPessoa(cpf);
            if (compradorEncontrado != null){
                compradorEncontrado.setCarro(carroEncontrado);

                boolean confirmar = comprador.confirmaCompra();
                if (confirmar){
                    JOptionPane.showMessageDialog(null,"O carro " + carroEncontrado.getMarca() +
                            " " + carroEncontrado.getModelo() + " foi comprado pelo cliente: " + compradorEncontrado.getNome());
                    carro.removerCarro(placa);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Compra cancelada.");
                }

            }
            else {
                JOptionPane.showMessageDialog(null, "O comprador não foi encontrado.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "O carro informado não foi encontrado.");
        }
    }

    public Veiculo getCarro() {
        return carro;
    }

    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }

    public Client getComprador() {
        return comprador;
    }

    public void setComprador(Client comprador) {
        this.comprador = comprador;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }
}