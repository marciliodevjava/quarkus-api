package com.marcilio.zanatta.check;

import com.marcilio.zanatta.client.StarWarsClient;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    StarWarsClient starWarsClient;

    @Override
    public HealthCheckResponse call() {
        if (starWarsClient.getStarShips().contains(StarWarsClient.MSG_ERRO)){
            return HealthCheckResponse.down("ERROR");
        }
        return HealthCheckResponse.up("OK");
    }
}
