public class RegraEletronicos implements RegraComissao {
    private static final double PERCENTUAL = 0.12;
    private static final double MINIMO = 50.00;

    @Override
    public double calcular(double valorVenda){
        return Math.max(valorVenda * PERCENTUAL, MINIMO);
    }

    @Override
    public String descrever(){
        return "Eletrônicos, 12% com mínimo de R$ 50,00";
    }
}
