public class FilaAws extends AbsFila {
    public FilaAws(int numero){
        super("sqs-" + numero);
    }
}
