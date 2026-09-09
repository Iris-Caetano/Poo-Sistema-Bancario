public class ContaCorrente extends ContaBancaria {

    private float limite;

    public ContaCorrente(String numeroConta, String titular, float limite) {
        super(numeroConta, titular);
        this.limite = limite;
    }

    @Override
    public boolean sacar(float valor) {
        if (valor > 0 && valor <= getSaldo() + limite){
            this.debitar(valor);
            IO.println("Saque realizado com sucesso!");
            return true;
        }else {
            IO.println("Saque recusado!");
            return false;
        }

    }
}
