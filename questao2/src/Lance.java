import java.time.LocalDateTime;

public class Lance {
    private String nomeParticipante;
    private double valor;
    private LocalDateTime dataHora;

    public Lance(String nomeParticipante, double valor){
        this.nomeParticipante = nomeParticipante;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public String getNomeParticipante(){
        return nomeParticipante;
    }

    public double getValor(){
        return valor;
    }

    public LocalDateTime getDataHora(){
        return dataHora;
    }
}
