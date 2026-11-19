import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static Auditoria instancia;
    private List<String> registros = new ArrayList<>();

    private Auditoria(){
    }

    public static synchronized Auditoria getInstancia(){
        if (instancia == null){
            instancia = new Auditoria();
        }
        return instancia;
    }

    // pros registros simultâneos não se sobrescreverem
    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado){
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS"));
        registros.add(String.format("[%s] %s | %s | %s", dataHora, nomeAmbiente, provedor, resultado));
    }

    public synchronized void imprimirHistorico(){
        System.out.println("\n\n>> Histórico de auditoria:");
        for (String registro : registros){
            System.out.println(registro);
        }
    }
}
