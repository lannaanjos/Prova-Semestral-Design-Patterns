public class ArmazenamentoAzure extends AbsArmazenamento {
    public ArmazenamentoAzure(int numero, int qtdGb){
        super("blob://" + numero, qtdGb);
    }
}
