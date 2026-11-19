public class PainelLeiloeiro extends AbsObservador {
    @Override
    public void atualizar(Lote lote, Lance lance){
        System.out.printf("\n[ Painel ]\n <<< %s | maior lance: R$ %.2f | total de lances: %d >>>",
            lote.getNome(), lote.getLanceAtual(), lote.getQtdLances());
    }
}
