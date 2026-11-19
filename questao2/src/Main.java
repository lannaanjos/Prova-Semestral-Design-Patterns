public class Main {
    public static void main(String[] args){
        Lote quadro = new Lote("O Grito", "Arte", 10000.00, 15000.00, new RegraArte());
        Lote carro = new Lote("Camaro Z28 1970", "Veículos", 75000.00, 80000.00, new RegraVeiculos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        quadro.inscrever(ana);
        quadro.inscrever(bruno);
        quadro.inscrever(carla);
        quadro.inscrever(painel);
        quadro.inscrever(auditor);

        carro.inscrever(bruno);
        carro.inscrever(carla);
        carro.inscrever(painel);
        carro.inscrever(auditor);

        // quadro
        System.out.print("LEILÃO QUADRO\n");
        ana.darLance(quadro, 11000.00);
        bruno.darLance(quadro, 11900.00);// é p recusar
        bruno.darLance(quadro, 12000.00);

        quadro.remover(carla);
        ana.darLance(quadro, 16000.00);

        quadro.setRegraComissao(new RegraEletronicos());
        quadro.encerrar();
        quadro.imprimirAcerto();

        System.out.println();
        System.out.println();

        // carro
        System.out.print("LEILÃO CARRO\n");
        bruno.darLance(carro, 85000.00);
        carla.darLance(carro, 92000.00);    

        
        carro.encerrar();
        bruno.darLance(carro, 70000.00); //recusa

        
        carro.imprimirAcerto();

        AbsFatura fatura = new Fatura(quadro.getNome(), quadro.getLanceAtual());
        fatura = new SeguroTransporte(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        fatura.imprimir();

        auditor.imprimirRegistros();
        System.out.println();
    }
}
