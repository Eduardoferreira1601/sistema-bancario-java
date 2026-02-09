package service;

import model.ContaBancaria;
import java.util.ArrayList;

public class BancoService {

    private ArrayList<ContaBancaria> contas;

    public BancoService() {
        this.contas = new ArrayList<>();
    }

    public ContaBancaria criarConta(String nome) {
        ContaBancaria conta = new ContaBancaria(nome);
        contas.add(conta);
        return conta;
    }

    public ContaBancaria buscarConta(String nome) {
        for (ContaBancaria conta : contas) {
            if (conta.getNome().equalsIgnoreCase(nome)) {
                return conta;
            }
        }
        return null;
    }
}
