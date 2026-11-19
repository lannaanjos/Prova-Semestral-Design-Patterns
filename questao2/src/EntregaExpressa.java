public class EntregaExpressa extends AbsServicoAdicional {
    private static final double CUSTO = 450.00;

    public EntregaExpressa(AbsFatura fatura){
        super(fatura);
    }

    @Override
    public String descrever(){
        return "Entrega expressa";
    }

    @Override
    public double getCusto(){
        return CUSTO;
    }
}
