package Usuário;

import java.util.Locale;
import java.util.Scanner;

import Banco.Banco;
import Banco.Cliente;

import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaPoupança;

public class InterfaceUsuario {

    public static void menuPrincipal() {
        mensagemInicio();   
        Scanner userInput = new Scanner(System.in).useLocale(Locale.US);

        String menu = userInput.next();
        switch (menu) {

            case "1":
                System.out.println("===Vamos criar uma conta===");
                criarConta();
                break;
            case "2":
                System.out.println("==Vamos entrar na sua conta=");
                break;
            
            default:
                System.out.println("Digite uma opção válida!");
                break;
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
    }
    public static void mensagemCriarConta() {
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("== Qual o tipo de conta? =");
        System.out.println("==========================");
        System.out.println("Digite 1:         Poupança");
        System.out.println("Digite 2:         Corrente");
    }



    public static void criarConta() {
        mensagemCriarConta();
        Scanner userInput = new Scanner(System.in).useLocale(Locale.US);
        String conta = userInput.next();
        Banco banco = new Banco("XBANK");
        Cliente cliente = new Cliente();
        switch (conta) {

            case "1":
                System.out.println("===Vamos criar uma conta poupança===");
                System.out.println("====Por favor digite seu nome:======");
                String nome = userInput.next();
                cliente.setNome(nome);
                Conta contaPoupanca = new ContaPoupança(cliente);
                banco.adicionarConta(contaPoupanca);
                System.out.println("====Cadastro Concluído======");
                break;
            case "2":
                System.out.println("===Vamos criar uma corrente===");
                System.out.println("====Por favor digite seu nome:======");
                String nomeCorrente = userInput.next();
                cliente.setNome(nomeCorrente);
                Conta contaCorrente = new ContaCorrente(cliente);
                banco.adicionarConta(contaCorrente);
                System.out.println("====Cadastro Concluído======");
                break;
            default:
                System.out.println("Digite uma opção válida!");
                break;
        } 
        userInput.close();
    }
    }

