public class FabricaAws extends AbsFabricaNuvem {
    private int contadorMaquina = 0;
    private int contadorArmazenamento = 0;
    private int contadorFila = 0;

    @Override
    public String getNomeProvedor(){
        return "Aws";
    }

    @Override
    public double getCustoHoraMaquina(){
        return 0.10;
    }

    @Override
    public double getCustoGbMes(){
        return 0.023;
    }

    @Override
    public double getCustoFixoFila(){
        return 0.40;
    }

    // msm fábrica é usada por threads simultâneas
    @Override
    public synchronized AbsMaquinaVirtual criaMaquinaVirtual(){
        contadorMaquina++;
        return new MaquinaVirtualAws(contadorMaquina);
    }

    @Override
    public synchronized AbsArmazenamento criaArmazenamento(int qtdGb){
        contadorArmazenamento++;
        return new ArmazenamentoAws(contadorArmazenamento, qtdGb);
    }

    @Override
    public synchronized AbsFila criaFila(){
        contadorFila++;
        return new FilaAws(contadorFila);
    }
}
