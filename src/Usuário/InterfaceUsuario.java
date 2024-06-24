package Usuário;

import java.util.Locale;
import java.util.Scanner;

import Banco.Banco;
import Banco.Cliente;

import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaPoupança;

public class InterfaceUsuario {

    public static void menuPrincipal(Banco banco) {
        Scanner userInput = new Scanner(System.in).useLocale(Locale.US);
        boolean continuar = true;
        ClearConsole.clear();
        mensagemInicio();

        while (continuar) {
            String menu = userInput.next();
            ClearConsole.clear();
            switch (menu) {

                case "1":
                    System.out.println("===Vamos criar uma conta===");
                    criarConta(banco, userInput);
                    break;
                case "2":
                    System.out.println("==Vamos entrar na sua conta=");
                    loginConta(banco, userInput);
                    break;

                case "3":
                    continuar = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        }
        userInput.close();
    }

    public static void mensagemInicio() {
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("=== Bem vindo ao XBank ===");
        System.out.println("==========================");
        System.out.println("Digite 1: Criar nova conta");
        System.out.println("Digite 2:  Entrar na conta");
        System.out.println("Digite 3:        Para sair");
    }

    public static void criarConta(Banco banco, Scanner userInput) {

        System.out.println("====Por favor digite seu nome:======");
        String nomeCliente = userInput.next();
        System.out.println("====Por favor digite uma senha: (SOMENTE NÚMEROS)======");
        int senha = userInput.nextInt();
        ClearConsole.clear();

        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);

        System.out.println("===Que tipo de conta deseja criar===");
        System.out.println("===Digite 1:       CONTA CORRENTE===");
        System.out.println("===Digite 2:       CONTA POUPANÇA===");
        String conta = userInput.next();
        ClearConsole.clear();

        switch (conta) {

            case "1":

                Conta contaPoupanca = new ContaPoupança(cliente, senha);
                banco.adicionarConta(contaPoupanca);
                System.out.println("====Cadastro Concluído======");
                System.out.println("O número da sua conta é: " + contaPoupanca.getContaNumero());
                break;

            case "2":
                Conta contaCorrente = new ContaCorrente(cliente, senha);
                banco.adicionarConta(contaCorrente);
                System.out.println("====Cadastro Concluído======");
                System.out.println("O número da sua conta é: " + contaCorrente.getContaNumero());
                break;

            default:
                System.out.println("Digite uma opção válida!");
                break;
        }
        aguarde();
        ClearConsole.clear();
        menuPrincipal(banco);
    }

    public static void loginConta(Banco banco, Scanner userInput) {

        System.out.println("===Por favor digite o número da conta:======");
        int contaNumero = userInput.nextInt();
        System.out.println("===Por favor digite sua senha:======");
        int senhaUsuario = userInput.nextInt();
        aguarde();
        ClearConsole.clear();

        Conta conta = banco.procurarContaNomeSenha(contaNumero, senhaUsuario);

        if (conta != null) {
            System.out.println("Login bem-sucedido");
            boolean operar = true;
            while (operar) {
                ClearConsole.clear();
                System.out.println("==O que gostaria de fazer?==");
                System.out.println("==Digite 1.          Sacar==");
                System.out.println("==Digite 2.      Depositar==");
                System.out.println("==Digite 3.     Transferir==");
                System.out.println("==Digite 4.        Extrato==");
                System.out.println("==Digite 0.           Sair==");

                String operacoes = userInput.next();
                aguarde();

                switch (operacoes) {
                    case "1":
                        ClearConsole.clear();
                        System.out.println("Qual valor deseja sacar?");
                        double valor = userInput.nextDouble();
                        conta.sacar(valor);
                        aguarde();
                        ClearConsole.clear();
                        System.out.println(valor + "R$ foram sacados com sucesso");
                        aguarde();
                        break;
                    case "2":
                        ClearConsole.clear();
                        System.out.println("Qual valor deseja depositar?");
                        double deposito = userInput.nextDouble();
                        conta.depositar(deposito);
                        aguarde();
                        ClearConsole.clear();
                        System.out.println(deposito + "R$ foram depositados com sucesso");
                        aguarde();
                        break;
                    case "3":
                        ClearConsole.clear();
                        System.out.println("Transação indisponível no momento!");
                        aguarde();
                        ClearConsole.clear();
                        break;
                    case "4":
                        ClearConsole.clear();
                        conta.imprimirExtrato();

                        System.out.println("Digite qualquer tecla para sair!");
                        String sair = userInput.next();
                        switch (sair) {
                            case "S":
                            System.out.println("Até a próxima!");
                                aguarde();
                                ClearConsole.clear();
                                break;

                            default:
                                aguarde();
                                ClearConsole.clear();
                                break;
                        }
                        break;
                    case "0":
                        operar = false;
                        aguarde();
                        ClearConsole.clear();
                        break;
                    default:
                        break;
                }

            }

        } else {
            System.out.println("Número de conta ou senha incorretos");
        }

    }

    public static void operacoesConta(Conta conta, Scanner userInput) {

    }

    public static void aguarde() {
        System.out.println("Aguarde.");
        sleep(1000);
        System.out.println("Aguarde..");
        sleep(1000);
        System.out.println("Aguarde...");
        sleep(1000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
