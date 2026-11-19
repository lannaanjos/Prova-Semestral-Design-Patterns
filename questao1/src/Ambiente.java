import java.util.List;

public class Ambiente {
    private String nome;
    private String provedor;
    private String regiao;
    private List<AbsMaquinaVirtual> maquinas;
    private AbsArmazenamento armazenamento;
    private AbsFila fila;
    private double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<AbsMaquinaVirtual> maquinas,
                    AbsArmazenamento armazenamento, AbsFila fila, double custoMensal){
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public void imprimirResumo(){
        // monta o resumo p threads simultaneas n misturarem
        StringBuilder resumo = new StringBuilder();
        resumo.append("\n<-=-= Ambiente: ").append(nome).append(" =-=->");
        resumo.append("\nProvedor: ").append(provedor);
        resumo.append("\nRegião: ").append(regiao);
        resumo.append("\nMáquinas virtuais:");
        for (AbsMaquinaVirtual maquina : maquinas){
            resumo.append(" ").append(maquina.getId());
        }
        resumo.append("\nArmazenamento: ").append(armazenamento.getId())
              .append(" (").append(armazenamento.getQtdGb()).append(" GB)");
        resumo.append("\nFila: ").append(fila.getId());
        resumo.append(String.format("\nCusto mensal estimado: R$ %.2f", custoMensal));
        System.out.println(resumo);
    }
}
