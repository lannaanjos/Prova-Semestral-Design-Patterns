public class ArmazenamentoAws extends AbsArmazenamento {
    public ArmazenamentoAws(int numero, int qtdGb){
        super("s3://" + numero, qtdGb);
    }
}
