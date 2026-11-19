import java.util.ArrayList;
import java.util.List;

public class Lote extends AbsObservado {
    private static final double INCREMENTO_MINIMO = 1.05;

    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido = false;
    private List<Lance> lances = new ArrayList<>();
    private RegraComissao regraComissao;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao){
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public void receberLance(Lance lance, AbsObservador autor){
        if (!aberto){
            System.out.printf("\nLance de %s recusado: o lote %s já foi encerrado.", lance.getNomeParticipante(), nome);
            return;
        }
        double minimo = lanceAtual * INCREMENTO_MINIMO;
        if (lance.getValor() < minimo){
            System.out.printf("\nLance de %s (R$ %.2f) recusado no lote %s: precisa ser de pelo menos 5%% acima do lance atual (R$ %.2f).",
                lance.getNomeParticipante(), lance.getValor(), nome, minimo);
            return;
        }
        lances.add(lance);
        lanceAtual = lance.getValor();
        System.out.printf("\nLance de %s (R$ %.2f) aceito no lote %s.", lance.getNomeParticipante(), lance.getValor(), nome);
        notificarTodos(lance, autor);
    }

    private void notificarTodos(Lance lance, AbsObservador autor){
        for (AbsObservador observador : this.listaObservadores){
            if (observador != autor){
                observador.atualizar(this, lance);
            }
        }
    }

    public void encerrar(){
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido){
            System.out.printf("\n\n>> Lote %s VENDIDO por R$ %.2f.", nome, lanceAtual);
        } else {
            System.out.printf("\n\n>> Lote %s NÃO VENDIDO (maior lance R$ %.2f, reserva R$ %.2f).", nome, lanceAtual, precoReserva);
        }
    }

    public void setRegraComissao(RegraComissao regraComissao){
        this.regraComissao = regraComissao;
    }

    public void imprimirAcerto(){
        System.out.printf("\n\n>>> Acerto do vendedor: %s (%s)", nome, categoria);
        if (!vendido){
            System.out.print("\nLote não vendido: sem comissão");
            return;
        }
        double comissao = regraComissao.calcular(lanceAtual);
        System.out.printf("\nPreço inicial: R$ %.2f", precoInicial);
        System.out.printf("\nValor de venda: R$ %.2f", lanceAtual);
        System.out.printf("\nComissão (%s): R$ %.2f", regraComissao.descrever(), comissao);
        System.out.printf("\nValor líquido ao vendedor: R$ %.2f", lanceAtual - comissao);
    }

    @Override
    public void inscrever(AbsObservador observador){
        listaObservadores.add(observador);
    }

    @Override
    public void remover(AbsObservador observador){
        listaObservadores.remove(observador);
    }

    public String getNome(){
        return nome;
    }

    public double getLanceAtual(){
        return lanceAtual;
    }

    public int getQtdLances(){
        return lances.size();
    }

    public boolean isVendido(){
        return vendido;
    }
}
