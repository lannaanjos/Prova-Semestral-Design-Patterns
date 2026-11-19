public class EmbalagemEspecial extends AbsServicoAdicional {
    private static final double CUSTO = 180.00;

    public EmbalagemEspecial(AbsFatura fatura){
        super(fatura);
    }

    @Override
    public String descrever(){
        return "Embalagem especial";
    }

    @Override
    public double getCusto(){
        return CUSTO;
    }
}
