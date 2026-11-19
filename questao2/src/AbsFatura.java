public abstract class AbsFatura {
    public abstract String getNomeLote();
    public abstract double getValorVenda();
    public abstract String getServicos();
    public abstract double getTotal();

    // msm impressão para fatura com ou sem serviços
    public void imprimir(){
        System.out.printf("\n\n ::: Fatura do comprador :::");
        System.out.printf("\n :: Lote: %s", getNomeLote());
        System.out.printf("\n :: Valor de venda: R$ %.2f", getValorVenda());
        System.out.print(getServicos());
        System.out.printf("\n :: Total a pagar: R$ %.2f", getTotal());
    }
}
