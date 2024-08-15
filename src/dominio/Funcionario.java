package dominio;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private String dataAdmissao; //Dia em que o funcionario foi contratado
    private double salario;
    private String cracha;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>(); //Array de funcionarios

    public Funcionario(){}

    public Funcionario(String dataAdmissao, String cracha, double salario){
        this.dataAdmissao = dataAdmissao;
        this.cracha = cracha;
        this.salario = salario;
    }

    public void imprimir(){
        System.out.println(this.dataAdmissao);
        System.out.println(this.salario);
    }
    public  ArrayList<Funcionario> pegarFuncionario(){
        return this.funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    public Funcionario procurarFuncionario(String cpf){
        for (Funcionario f : funcionarios){
            if (f.getCpf().equals(cpf)){
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

}
