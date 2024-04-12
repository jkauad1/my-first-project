package dominio;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private String dataAdmissao; //Dia em que o funcionario foi contratado
    private double salario;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>(); //Array de funcionarios

    public Funcionario(){}

    public Funcionario(String dataAdmissao, double salario){
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public  ArrayList<Funcionario> pegarFuncionario(){
        return this.funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    public Funcionario procurarFuncionario(String cpf){
        for (Funcionario funcionario : funcionarios){
            if (funcionario.getCpf().equals(cpf)){
                return funcionario;
            }
        }
        return null;
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
}
