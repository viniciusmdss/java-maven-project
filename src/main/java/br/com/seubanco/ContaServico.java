package br.com.seubanco;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class ContaServico {

    private final List<Conta> contas = new ArrayList<>();

    // Método para listar todas as contas
    public List<Conta> getContas() {
        return contas;
    }

    // Método para criar uma conta
    public Conta criarConta(Conta conta) {
        contas.add(conta);
        return conta;
    }

    // Método para excluir uma conta pelo titular
    public void excluirConta(String titular) {
        // Encontramos a conta com o titular e a removemos da lista
        Optional<Conta> contaOptional = contas.stream()
                .filter(conta -> conta.getTitular().equals(titular))
                .findFirst();

        // Se a conta existir, removemos da lista
        contaOptional.ifPresent(contas::remove);
    }
}
