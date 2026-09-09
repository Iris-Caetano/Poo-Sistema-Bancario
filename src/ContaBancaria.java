
public abstract class ContaBancaria {

    private String numeroConta;
    private String titular;
    private float saldo;

    //Construtor

    public ContaBancaria(String numeroConta,String titular){
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(float valor){
        if (valor > 0){
            this.saldo += valor;
            IO.println("Deposito R$ " + valor + " realizado com sucesso!");
        }else {
            IO.println("Depósito inválido. O valor deve ser maior que zero");
        }
    }

    protected void debitar(float valor){
        this.saldo -= valor;
    }

    public float getSaldo(){
        return this.saldo;
    }

    public void exibirSaldo(){
        IO.println("Conta: " + numeroConta + "|" + " Titular: " + titular + "|" + "Saldo em conta: " + saldo);
    }

    public abstract boolean sacar(float valor);
}
