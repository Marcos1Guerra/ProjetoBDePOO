package Model;

public class Medico extends Pessoa {
    private int CRM;
    private String Funcao;

    public int getCRM(){
        return this.CRM;
    }

    public String getNome(){
        return this.Nome;
    }

    public String getFuncao(){
        return this.Funcao;
    }

    public void setNome( String Nome){
        this.Nome = Nome;
    }

    public void setCRM( int CRM){
        this.CRM = CRM;
    }

    public void setFuncao( String Funcao){
        this.Funcao = Funcao;
    }
}
