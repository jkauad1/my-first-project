package classes;

public class Contact {
    private String telefone;
    private String email;

    public Contact(){}

    public Contact(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;

    }

    public String getTelefone(){
        return this.telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}