public class Participante extends AbsObservador {
    private String nome;

    public Participante(String nome){
        this.nome = nome;
    }

    public void darLance(Lote lote, double valor){
        lote.receberLance(new Lance(nome, valor), this);
    }

    @Override
    public void atualizar(Lote lote, Lance lance){
        System.out.printf("\n> %s: Novo lance no lote %s de R$ %.2f", nome, lote.getNome(), lance.getValor());
    }

    public String getNome(){
        return nome;
    }
}
