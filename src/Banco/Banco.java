package Banco;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    // atributos

    private String nome;
    private List<Conta> contas; // getters e setters

    public Banco(String nomeString) {
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome; 
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }


}
