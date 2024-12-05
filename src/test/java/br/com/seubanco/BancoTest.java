// src/test/java/br/com/seubanco/ContaControllerTest.java
package br.com.seubanco;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import io.micronaut.http.HttpResponse;

@MicronautTest
public class BancoTest {

    @Inject
    @Client("/contas")
    HttpClient client;

    @Test
    void testCriarEListarContas() {
        // Criar uma nova conta
        Conta novaConta = new Conta();
        novaConta.setTitular("João Silva");

        HttpResponse<Conta> resposta = client.toBlocking()
                .exchange(HttpRequest.POST("", novaConta), Conta.class);

        // Verificar se a conta foi criada com sucesso
        assertEquals(201, resposta.getStatus().getCode());
        Conta contaCriada = resposta.getBody().orElseThrow();
        assertEquals("João Silva", contaCriada.getTitular());

        // Listar todas as contas
        Conta[] contas = client.toBlocking().retrieve(HttpRequest.GET("/"), Conta[].class);
        assertEquals(1, contas.length);
        assertEquals("João Silva", contas[0].getTitular());
    }
}
