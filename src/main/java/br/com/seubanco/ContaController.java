package br.com.seubanco;

import io.micronaut.http.annotation.*;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/contas")
public class ContaController {

    private final ContaServico contaServico;

    @Inject
    public ContaController(ContaServico contaServico) {
        this.contaServico = contaServico;
    }

    @Get
    public List<Conta> listarContas() {
        return contaServico.getContas();
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Conta criarConta(@Body Conta conta) {
        return contaServico.criarConta(conta);
    }

    @Delete("/{titular}")
    @Status(HttpStatus.NO_CONTENT)
    public void excluirConta(@PathVariable String titular) {
        contaServico.excluirConta(titular);
    }
}
