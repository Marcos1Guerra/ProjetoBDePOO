package Model;

public class Quarto {
    private int Numero;
    private String Prioridade;

    public Quarto(int Numero, String Prioridade){
        this.Numero = Numero;
        this.Prioridade = Prioridade;
    }

    public int getNumero(){
        return this.Numero;
    }

    public String getPrioridade(){
        return this.Prioridade;
    }
}
