package interfaces;

import classes.Veiculo;

import java.util.List;


public interface RegistroProduto {

    void consorcio();
    Veiculo registrarCarro();
    void mostraCarro();
    void adicionarCarro(Veiculo carro);
    Veiculo procurarCarro(String placa);
    void imprimir();
    void removerCarro(String placa);
    List<Veiculo> listarCarros();
}
