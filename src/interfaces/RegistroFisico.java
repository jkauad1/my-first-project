package interfaces;

import java.util.List;

public interface RegistroFisico<T> {
    void adicionarPessoa(T t);
    T procurarPessoa(String identificador);
    void removerPessoa(String identificador);
    List<T> listarPessoas();
    void mostrarPessoas();

}