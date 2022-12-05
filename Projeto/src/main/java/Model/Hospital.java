package Model;

public class Hospital {
    private String Nome;
    private String Endereco;

    public Hospital(String Nome, String Endereco){
        this.Endereco = Endereco;
        this.Nome = Nome;
    }

    public String getNome(){
        return Nome;
    }

    public String getEndereco(){
        return Endereco;
    }
}
