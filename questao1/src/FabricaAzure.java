public class FabricaAzure extends AbsFabricaNuvem {
    private int contadorMaquina = 0;
    private int contadorArmazenamento = 0;
    private int contadorFila = 0;

    @Override
    public String getNomeProvedor(){
        return "Azure";
    }

    @Override
    public double getCustoHoraMaquina(){
        return 0.12;
    }

    @Override
    public double getCustoGbMes(){
        return 0.02;
    }

    @Override
    public double getCustoFixoFila(){
        return 0.50;
    }

    @Override
    public synchronized AbsMaquinaVirtual criaMaquinaVirtual(){
        contadorMaquina++;
        return new MaquinaVirtualAzure(contadorMaquina);
    }

    @Override
    public synchronized AbsArmazenamento criaArmazenamento(int qtdGb){
        contadorArmazenamento++;
        return new ArmazenamentoAzure(contadorArmazenamento, qtdGb);
    }

    @Override
    public synchronized AbsFila criaFila(){
        contadorFila++;
        return new FilaAzure(contadorFila);
    }
}
