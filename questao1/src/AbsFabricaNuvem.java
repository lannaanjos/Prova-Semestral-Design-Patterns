public abstract class AbsFabricaNuvem {
    public abstract String getNomeProvedor();
    public abstract double getCustoHoraMaquina();
    public abstract double getCustoGbMes();
    public abstract double getCustoFixoFila();

    public abstract AbsMaquinaVirtual criaMaquinaVirtual();
    public abstract AbsArmazenamento criaArmazenamento(int qtdGb);
    public abstract AbsFila criaFila();
}
