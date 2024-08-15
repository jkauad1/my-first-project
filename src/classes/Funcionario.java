package classes;

import interfaces.RegistroFisico;

import javax.swing.*;
import java.util.ArrayList; /* Importação da biblioteca ArrayList que é usada nesse programa para
                             armazenar os objetos criados no menu*/
import java.util.List;

public class Funcionario extends Pessoa implements RegistroFisico<Funcionario> {
    private String dataAdmissao; //Dia em que o funcionario foi contratado
    private double salario;
    private String cracha;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>(); /* A ArrayList permite que os objetos criados possam
                                                                        ser removidos ou adicionados mais facilmente que
                                                                        um Array construído. */

    public Funcionario(){}

    @Override
    public Funcionario cadastrar() {
        Funcionario funcionario = new Funcionario(); /* Função que cria um novo objeto funcionário que define os atributos
        e retorna o objeto para a ArrayList funcionários. */
        funcionario.setNome(JOptionPane.showInputDialog("Nome: "));
        funcionario.setCpf(JOptionPane.showInputDialog("CPF: "));
        funcionario.setIdade(JOptionPane.showInputDialog("Idade: "));
        funcionario.setCracha(JOptionPane.showInputDialog("Crachá: "));
        funcionario.contato.setTelefone(JOptionPane.showInputDialog("Telefone: "));
        /*funcionario.contato.setEmail(JOptionPane.showInputDialog("Email: "));
        funcionario.endereco.setEstado(JOptionPane.showInputDialog("Estado: "));
        funcionario.endereco.setCidade(JOptionPane.showInputDialog("Cidade: "));
        funcionario.endereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
        funcionario.endereco.setRua(JOptionPane.showInputDialog("Rua: "));
        funcionario.endereco.setNumero(JOptionPane.showInputDialog("Numero: "));
         */
        funcionario.setDataAdmissao(JOptionPane.showInputDialog("Informe o dia em que o funcionário está sendo contratado"));
        return funcionario;
    }

    public void listarTodosFuncionarios() {
        List<Funcionario> todosFuncionarios = listarPessoas();
        for (Funcionario funcionario : todosFuncionarios) {
            JOptionPane.showMessageDialog(null,"Nome: " + funcionario.getNome() + ", CPF: " + funcionario.getCpf());
        }
    }

    //Polimorfismo de sobrescrita do método da interface.
    @Override
    public Funcionario procurarPessoa(String cpf){
        for (Funcionario f : funcionarios){
            if (f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }


    // polimorfismo de sobrecarga do método procurarFuncionario para buscar por nome
    public Funcionario procurar(String nome, boolean isNome){
        for (Funcionario f : funcionarios){
            if (f.getNome().equalsIgnoreCase(nome)){
                return f;
            }
        }
        return null;
    }

    public Funcionario procurarCracha(String cracha){
        for (Funcionario f : funcionarios){
            if (f.getCracha().equals(cracha)){
                return f;
            }
        }
        return null;
    }

    public void removerFuncionario() {
        Funcionario f;
        String cpf = JOptionPane.showInputDialog("Informe o cpf do funcionário para remove-lo do sistema: ");
        f = procurarPessoa(cpf);
        if (f != null) {
            JOptionPane.showMessageDialog(null, "Funcionário: " + f.getNome() +
                    " removido do sistema.");
            removerPessoa(cpf);
        }
        else {
            JOptionPane.showMessageDialog(null, "O funcionário informado não foi encotrado.");
        }
    }

    public Funcionario(String dataAdmissao, String cracha, double salario){
        this.dataAdmissao = dataAdmissao;
        this.cracha = cracha;
        this.salario = salario;
    }

    @Override
    public void imprimirPessoa(){  //Polimorfismo de sobreposição.
        System.out.println(this.dataAdmissao);
        System.out.println(this.salario);
    }


    //Polimorfismo de sobrescrita do métido da interface.
    @Override
    public void mostrarPessoas() {
        String opcao = JOptionPane.showInputDialog("Deseja buscar o funcionário por:\n1 - CPF\n2 - Nome \n3 Mostrar todos os funcionários");
        Funcionario f = null;
        if ("1".equals(opcao)) {
            String cpf = JOptionPane.showInputDialog("CPF do funcionário que deseja buscar: ");
            f = procurarPessoa(cpf);
        }
        else if ("2".equals(opcao)) {
            String nome = JOptionPane.showInputDialog("Nome do funcionário que deseja buscar: ");
            f = procurar(nome, true);
        }
        else if ("3".equals(opcao)){
            listarTodosFuncionarios();
            return;
        }
        if (f != null) {
            JOptionPane.showMessageDialog(null, "Nome: " + f.getNome() +
                    "\nCPF: " + f.getCpf() +
                    "\nIdade: " + f.getIdade() +
                    "\nContato: " + f.contato.getTelefone() +
                    "\nData de admissão: " + f.getDataAdmissao());
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
        }
    }

        //Polimorfismo de sobrescrita do métido da interface.
    @Override
    public List<Funcionario> listarPessoas() {
        return new ArrayList<>(funcionarios);
    }

    //Polimorfismo de sobrescrita do método da interface.
    @Override
    public void adicionarPessoa(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    //Polimorfismo de sobrescrita do método da interface.
    @Override
    public void removerPessoa(String cpf){
        Funcionario funcionario = procurarPessoa(cpf);
        if (funcionario != null){
            funcionarios.remove(funcionario);
        }
    }

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return getNome();
    }

}
