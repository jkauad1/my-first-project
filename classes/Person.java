
package classes;

    /* Classe Pessoa é abstrata pois não sera instanciada, somente herdada pelas classes
       Funcionario e Cliente. */


import java.util.List;

public abstract class Person<T> {
    protected String nome;
    protected String cpf;
    protected String idade;
    protected Contact contato = new Contact();
    protected Address endereco = new Address();

    public Person(){} //Construtor vazio

    public Person(String nome, String cpf, String idade, Contact contato, Address endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.contato = contato;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void imprimirPessoa(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.idade);
        System.out.println(this.contato);
    }

    public abstract T cadastrar();



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

}
