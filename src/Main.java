import static java.lang.IO.*;

void main(){
    ContaBancaria poupanca = new ContaPoupanca("001", "José");
    ContaBancaria corrente = new ContaCorrente("002","Jessica", 500);
    ContaBancaria empresarial = new ContaEmpresarial("003","Empresa Y", 1000);

    // ------------ Mostrando o saldo -------------
    println(poupanca.getSaldo());
    println(corrente.getSaldo());
    println(empresarial.getSaldo());

    // ------------ Depositar ------------
    poupanca.depositar(500);
    poupanca.depositar(-500);
    corrente.depositar(400);
    corrente.depositar(0);
    empresarial.depositar(1000);

    println("Saldo poupança: " + poupanca.getSaldo());
    println("Saldo corrente: " + corrente.getSaldo());
    println("Saldo empresarial: " + empresarial.getSaldo());

    // ------------ Sacar ------------
    poupanca.sacar(-50);
    poupanca.sacar(0);
    poupanca.sacar(100);
    poupanca.sacar(10000);
    println("Saldo poupança: " + poupanca.getSaldo());


    corrente.sacar(7000);
    corrente.sacar(700);
    println("Saldo corrente: " + corrente.getSaldo());


    println("Saldo empresarial antes do saque: " + empresarial.getSaldo());
    empresarial.sacar(400);
    println("Saldo empresarial depois do saque (com taxa de R$5 descontada): " + empresarial.getSaldo());


   

}