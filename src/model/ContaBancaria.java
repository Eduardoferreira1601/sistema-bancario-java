package model;

import java.util.ArrayList;

public class ContaBancaria {

    private String nome;
    private double saldo;
    private ArrayList<Transacao> historico;

    public ContaBancaria(String nome) {
        this.nome = nome;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add(new Transacao("Depósito", valor));
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            historico.add(new Transacao("Saque", valor));
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            System.out.println("=== Histórico de Transações ===");
            for (Transacao t : historico) {
                System.out.println(t);
            }
        }
    }

    public String getNome() {
        return nome;
    }
}
