package Model;

public abstract class Pessoa {
    protected String CPF;
    protected String Nome;

    public String getCPF(){
        return this.CPF;
    }

    public String getNome(){
        return this.Nome;
    }

    public void setCPF(){
        this.CPF = CPF;
    }

    public void setNome(){
        this.Nome = Nome;
    }
}
