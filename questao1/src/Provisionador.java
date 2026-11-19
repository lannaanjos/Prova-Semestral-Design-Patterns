import java.util.ArrayList;
import java.util.List;

public class Provisionador {
    private AbsFabricaNuvem fabrica;

    public Provisionador(AbsFabricaNuvem fabrica){
        this.fabrica = fabrica;
    }

    public void provisionar(Solicitacao solicitacao){
        Configuracao configuracao = Configuracao.getInstancia();
        Auditoria auditoria = Auditoria.getInstancia();
        double custo = calculaCusto(solicitacao);

        if (custo > configuracao.getOrcamentoMaximo()){
            auditoria.registrar(solicitacao.getNomeAmbiente(), fabrica.getNomeProvedor(),
                String.format("RECUSADO!\nCusto estimado R$ %.2f ultrapassa o orçamento de R$ %.2f",
                    custo, configuracao.getOrcamentoMaximo()));
            return;
        }

        List<AbsMaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.getQtdMaquinas(); i++){
            maquinas.add(fabrica.criaMaquinaVirtual());
        }
        AbsArmazenamento armazenamento = fabrica.criaArmazenamento(solicitacao.getQtdGb());
        AbsFila fila = fabrica.criaFila();

        Ambiente ambiente = new Ambiente(solicitacao.getNomeAmbiente(), fabrica.getNomeProvedor(),
            configuracao.getRegiaoPadrao(), maquinas, armazenamento, fila, custo);
        ambiente.imprimirResumo();
        auditoria.registrar(solicitacao.getNomeAmbiente(), fabrica.getNomeProvedor(), "ACEITO");
    }

    private double calculaCusto(Solicitacao solicitacao){
        double custoMaquinas = solicitacao.getQtdMaquinas() * fabrica.getCustoHoraMaquina() * 730;
        double custoArmazenamento = solicitacao.getQtdGb() * fabrica.getCustoGbMes();
        return custoMaquinas + custoArmazenamento + fabrica.getCustoFixoFila();
    }
}
