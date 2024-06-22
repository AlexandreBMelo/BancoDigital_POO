package Banco;

public abstract class Conta implements IConta {

    //atributos 
    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int contaNumero;
    protected double saldo;
    protected Cliente cliente;

   

   
public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.contaNumero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    // Métodos
    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }
    @Override
    public void sacar(double valor) {    
        this.saldo -= valor;
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
           this.sacar(valor);
           contaDestino.depositar(valor);
    }
    protected void imprimirStatus() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Número: %d", this.getContaNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }
  
    // getters e setters
    public int getAgencia() {
        return agencia;
    }
    public int getContaNumero() {
        return contaNumero;
    }
    public double getSaldo() {
        return saldo;
    }
    

    
}
