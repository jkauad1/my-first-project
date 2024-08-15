package classes;

import javax.swing.*;

public class Venda {
    private Veiculo carro;
    private Cliente comprador;
    private Funcionario vendedor;

    public Venda(){}

    public Venda(Veiculo carro, Cliente comprador, Funcionario vendedor){
        this.carro = carro;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }

    public void vende(Veiculo carro, Cliente comprador) {
        String placa = JOptionPane.showInputDialog(null,"Informe a placa do carro comprado: ");
        Veiculo carroEncontrado = carro.procurarCarro(placa);

        if (carroEncontrado != null){
            String cpf = JOptionPane.showInputDialog(null,"Informe o cpf do cliente que realizou a compra: ");
            Cliente compradorEncontrado = comprador.procurarPessoa(cpf);
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

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }
}
