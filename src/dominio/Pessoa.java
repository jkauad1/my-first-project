package dominio;


public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String idade;
    public Contato contato = new Contato();
    public Endereco endereco = new Endereco();

    public Pessoa(){} //Construtor vazio

    public Pessoa(String nome, String cpf, String idade, Contato contato, Endereco endereco){
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

    public void imprimir(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.idade);
        System.out.println(this.contato);
    }


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
