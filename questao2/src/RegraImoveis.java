public class RegraImoveis implements RegraComissao {
    private static final double PERCENTUAL = 0.03;
    private static final double VALOR_FIXO = 1500.00;

    @Override
    public double calcular(double valorVenda){
        return valorVenda * PERCENTUAL + VALOR_FIXO;
    }

    @Override
    public String descrever(){
        return "Imóveis, 3% + R$ 1.500,00";
    }
}
