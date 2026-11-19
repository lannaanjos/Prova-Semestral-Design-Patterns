public class Solicitacao {
    private String nomeAmbiente;
    private int qtdMaquinas;
    private int qtdGb;

    public Solicitacao(String nomeAmbiente, int qtdMaquinas, int qtdGb){
        this.nomeAmbiente = nomeAmbiente;
        this.qtdMaquinas = qtdMaquinas;
        this.qtdGb = qtdGb;
    }

    public String getNomeAmbiente(){
        return nomeAmbiente;
    }

    public int getQtdMaquinas(){
        return qtdMaquinas;
    }

    public int getQtdGb(){
        return qtdGb;
    }
}
