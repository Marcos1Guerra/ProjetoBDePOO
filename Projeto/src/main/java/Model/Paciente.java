package Model;

public class Paciente extends Pessoa {
    private int Idade;

    public String getNome(){
        return this.Nome;
    }

    public int getIdade(){
        return this.Idade;
    }

    public String getCPF(){
        return this.CPF;
    }

    public void setNome( String Nome){
        this.Nome = Nome;
    }

    public void setCPF( String CPF){
        this.CPF = CPF;
    }

    public void setIdade( int Idade){
        this.Idade = Idade;
    }

}
