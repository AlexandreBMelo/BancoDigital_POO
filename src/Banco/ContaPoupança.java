package Banco;
public class ContaPoupança extends Conta {


    public ContaPoupança(Cliente cliente, int senha) {
        super(cliente, senha);   
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirStatus();
    }

}
