public class Main {
    public static void main(String[] args) throws InterruptedException {
        // único ponto que escolhe o provedor concreto
        AbsFabricaNuvem aws = new FabricaAws();
        AbsFabricaNuvem azure = new FabricaAzure();

        Thread producao = new Thread(() ->
            new Provisionador(aws).provisionar(new Solicitacao("Ambiente da Loja", 2, 100)));
        Thread homologacao = new Thread(() ->
            new Provisionador(aws).provisionar(new Solicitacao("Homologacao", 1, 50)));
        Thread analytics = new Thread(() ->
            new Provisionador(azure).provisionar(new Solicitacao("Análises", 3, 200)));
        Thread clusterMl = new Thread(() ->
            new Provisionador(azure).provisionar(new Solicitacao("ML", 32, 1024)));

        producao.start();
        homologacao.start();
        analytics.start();
        clusterMl.start();

        producao.join();
        homologacao.join();
        analytics.join();
        clusterMl.join();

        Auditoria.getInstancia().imprimirHistorico();
    }
}
