public class ContaEmpresarial extends ContaBancaria {
    private float limite;
    private float taxa;

    public ContaEmpresarial(String numeroConta, String titular, float limite) {
        super(numeroConta, titular);
        this.limite = limite;
        this.taxa = 5;
    }

    @Override
    public boolean sacar(float valor) {
        if (valor > 0 && valor + taxa <= getSaldo() + limite ){
            this.debitar(valor + taxa);
            IO.println("Saque realizado com sucesso!");
            return true;
        }else {
            IO.println("Saque recusado!");
            return false;
        }

    }
}
