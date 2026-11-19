public class MaquinaVirtualAzure extends AbsMaquinaVirtual {
    public MaquinaVirtualAzure(int numero){
        super("vm-" + numero);
    }
}
