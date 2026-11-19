import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
    private static Configuracao instancia;
    private String regiaoPadrao;
    private double orcamentoMaximo;

    private Configuracao(){
        Properties propriedades = new Properties();
        try (FileInputStream arquivo = new FileInputStream("config.properties")){
            propriedades.load(arquivo);
        } catch (IOException e){
            throw new RuntimeException("Não foi possível ler o arquivo config.properties", e);
        }
        this.regiaoPadrao = propriedades.getProperty("regiao.padrao");
        this.orcamentoMaximo = Double.parseDouble(propriedades.getProperty("orcamento.maximo"));
    }

    // leitura unica em threads simultaneas :))
    public static synchronized Configuracao getInstancia(){
        if (instancia == null){
            instancia = new Configuracao();
        }
        return instancia;
    }

    public String getRegiaoPadrao(){
        return regiaoPadrao;
    }

    public double getOrcamentoMaximo(){
        return orcamentoMaximo;
    }
}
