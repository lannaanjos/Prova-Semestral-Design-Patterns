public abstract class AbsServicoAdicional extends AbsFatura {
    protected AbsFatura fatura;

    public AbsServicoAdicional(AbsFatura fatura){
        this.fatura = fatura;
    }

    public abstract String descrever();
    public abstract double getCusto();

    @Override
    public String getNomeLote(){
        return fatura.getNomeLote();
    }

    @Override
    public double getValorVenda(){
        return fatura.getValorVenda();
    }

    @Override
    public String getServicos(){
        return fatura.getServicos() + String.format("\n  + %s: R$ %.2f", descrever(), getCusto());
    }

    @Override
    public double getTotal(){
        return fatura.getTotal() + getCusto();
    }
}
