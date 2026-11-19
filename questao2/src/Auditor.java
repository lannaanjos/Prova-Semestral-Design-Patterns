import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor extends AbsObservador {
    private List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance){
        String dataHora = lance.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        registros.add(String.format("[%s] %s | %s | R$ %.2f", dataHora, lote.getNome(), lance.getNomeParticipante(), lance.getValor()));
    }

    public void imprimirRegistros(){
        System.out.print("\n\n<= Registros do auditor =>");
        for (String registro : registros){
            System.out.print("\n" + registro);
        }
    }
}
