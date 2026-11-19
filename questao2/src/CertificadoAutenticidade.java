public class CertificadoAutenticidade extends AbsServicoAdicional {
    private static final double CUSTO = 300.00;

    public CertificadoAutenticidade(AbsFatura fatura){
        super(fatura);
    }

    @Override
    public String descrever(){
        return "Certificado de autenticidade";
    }

    @Override
    public double getCusto(){
        return CUSTO;
    }
}
