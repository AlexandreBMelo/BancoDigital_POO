
# Projeto Banco Digital POO - Estrutura Básica do Banco

Este projeto implementa uma estrutura básica de banco em Java, focada na criação e gerenciamento de contas bancárias através de classes que representam o banco, tipos de contas e clientes.

## Classes Principais

### Banco (`Banco.java`)

A classe `Banco` é responsável por gerenciar as contas bancárias criadas. Ela possui um nome e uma lista de contas.

#### Atributos:

- `nome`: Nome do banco.
- `contas`: Lista dinâmica que armazena as contas bancárias.

#### Métodos:

- `adicionarConta(Conta conta)`: Adiciona uma nova conta à lista de contas do banco.

### Conta (`Conta.java` - Classe Abstrata)

A classe abstrata `Conta` define o comportamento básico de todas as contas bancárias. Ela possui atributos como agência, número da conta, saldo e informações do cliente associado.

#### Métodos Principais:

- `depositar(double valor)`: Adiciona um valor ao saldo da conta.
- `sacar(double valor)`: Subtrai um valor do saldo da conta.
- `transferir(double valor, Conta contaDestino)`: Transfere um valor para outra conta.

### ContaCorrente (`ContaCorrente.java`) e ContaPoupança (`ContaPoupança.java`)

Estas são subclasses de `Conta` que representam diferentes tipos de contas bancárias com características específicas.

#### Métodos Específicos:

- `imprimirExtrato()`: Exibe detalhes específicos da conta corrente ou poupança.

### Cliente (`Cliente.java`)

A classe `Cliente` armazena informações básicas do cliente, como nome e outros detalhes pessoais.

## Implementação da Interface do Usuário

### InterfaceUsuario (`InterfaceUsuario.java`)

A classe `InterfaceUsuario` permite a interação com o usuário através do terminal.

#### Funcionalidades Implementadas:

- `menuPrincipal()`: Apresenta opções para criar nova conta ou futuramente entrar na conta.
- `mensagemInicio()`, `mensagemCriarConta()`: Exibe mensagens de boas-vindas e instruções.
- `criarConta()`: Permite ao usuário escolher o tipo de conta (poupança ou corrente) e criar uma nova conta bancária, associando-a a um cliente.

### Classe Teste (`Teste.java`)

A classe `Teste` contém um método `main` que demonstra operações básicas em contas bancárias, como depósito, transferência e impressão de extrato.

#### Funcionalidades Demonstradas:

- Criação de um cliente (`Cliente`) com nome "Alexandre Melo".
- Criação de uma conta corrente (`ContaCorrente`) e uma conta poupança (`ContaPoupança`) associadas ao cliente.
- Realização de operações:
  - Impressão do extrato da conta corrente.
  - Depósito de 100 unidades na conta corrente.
  - Transferência de 100 unidades da conta corrente para a conta poupança.
  - Impressão dos extratos atualizados das contas corrente e poupança.

```java
public class Teste {

    public static void main(String[] args) {
        Cliente alexandre = new Cliente();
        alexandre.setNome("Alexandre Melo");

        Conta contaCorrente = new ContaCorrente(alexandre);
        Conta contaPoupanca = new ContaPoupança(alexandre);
        
        contaCorrente.imprimirExtrato(); // Imprime o extrato inicial da conta corrente
        contaCorrente.depositar(100);    // Deposita 100 unidades na conta corrente
        contaCorrente.transferir(100, contaPoupanca); // Transfere 100 unidades da conta corrente para a conta poupança
        
        contaCorrente.imprimirExtrato(); // Imprime o extrato atualizado da conta corrente
        contaPoupanca.imprimirExtrato(); // Imprime o extrato atualizado da conta poupança
    }

}
```
