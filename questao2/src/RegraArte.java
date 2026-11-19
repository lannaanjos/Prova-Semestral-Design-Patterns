public class RegraArte implements RegraComissao {
    private static final double PERCENTUAL = 0.20;

    @Override
    public double calcular(double valorVenda){
        return valorVenda * PERCENTUAL;
    }

    @Override
    public String descrever(){
        return "Arte, 20%";
    }
}
