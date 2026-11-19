public class Fatura extends AbsFatura {
    private String nomeLote;
    private double valorVenda;

    public Fatura(String nomeLote, double valorVenda){
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String getNomeLote(){
        return nomeLote;
    }

    @Override
    public double getValorVenda(){
        return valorVenda;
    }

    @Override
    public String getServicos(){
        return "";
    }

    @Override
    public double getTotal(){
        return valorVenda;
    }
}
