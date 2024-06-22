package Banco;
public class Teste {

	public static void main(String[] args) {
		Cliente alexandre = new Cliente();
		alexandre.setNome("Alexandre Melo");
		
		Conta contaCorrente = new ContaCorrente(alexandre);
		Conta contaPoupanca = new ContaPoupança(alexandre);
		contaCorrente.imprimirExtrato();
		contaCorrente.depositar(100);
		contaCorrente.transferir(100, contaPoupanca);
		
		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();
	}

}