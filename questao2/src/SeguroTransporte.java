public class SeguroTransporte extends AbsServicoAdicional {
    private static final double PERCENTUAL = 0.015;

    public SeguroTransporte(AbsFatura fatura){
        super(fatura);
    }

    @Override
    public String descrever(){
        return "Seguro de transporte (1,5%)";
    }

    @Override
    public double getCusto(){
        return getValorVenda() * PERCENTUAL;
    }
}
