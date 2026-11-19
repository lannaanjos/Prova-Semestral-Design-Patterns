public class RegraVeiculos implements RegraComissao {
    private static final double PERCENTUAL = 0.08;
    private static final double LIMITE = 5000.00;

    @Override
    public double calcular(double valorVenda){
        return Math.min(valorVenda * PERCENTUAL, LIMITE);
    }

    @Override
    public String descrever(){
        return "Veículos, 8% limitada a R$ 5.000,00";
    }
}
