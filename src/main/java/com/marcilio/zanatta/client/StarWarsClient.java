package com.marcilio.zanatta.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api")
public interface StarWarsClient {

    public static final String MSG_ERRO = "Fallback";
    @GET
    @Path("/starships")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 3000L)
    @Fallback(fallbackMethod = "getStarShipsFallBack")
    String getStarShips();

    @CircuitBreaker(
            requestVolumeThreshold = 2, // Quantidade mínima de requisições para o Circuit Breaker começar a calcular falhas.
            failureRatio = 0.5,  // Porcentagem de falhas dentro do volume definido que faz o circuito ABRIR.
            delay = 3000L, // Tempo (em ms) que o Circuit Breaker fica em OPEN antes de ir para HALF_OPEN.
            successThreshold = 2 // Quantidade de chamadas bem-sucedidas consecutivas necessárias no estado HALF_OPEN para o circuito fechar novamente (CLOSED).
    )
    default String getStarShipsFallBack() {
        return MSG_ERRO;
    }
}
