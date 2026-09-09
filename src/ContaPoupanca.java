public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular) {
        super(numeroConta, titular);
    }

    @Override
    public boolean sacar(float valor) {
        if (valor > 0 && valor <= getSaldo()){
            this.debitar(valor);
            IO.println("Saque realizado com sucesso!");
            return true;
        }else {
            IO.println("Saque recusado!");
            return false;
        }

    }
}
