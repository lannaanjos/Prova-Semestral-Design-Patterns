public abstract class AbsArmazenamento {
    protected String id;
    protected int qtdGb;

    public AbsArmazenamento(String id, int qtdGb){
        this.id = id;
        this.qtdGb = qtdGb;
    }

    public String getId(){
        return id;
    }

    public int getQtdGb(){
        return qtdGb;
    }
}
