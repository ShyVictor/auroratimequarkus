package auroratime;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Path("/health")
public class HealthCheckResource {

    @Inject
    DataSource dataSource;
    @GET @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getServicesHealth() throws SQLException {
        String status = "Datasource service valid!";
        try(Connection connection= dataSource.getConnection()){
            if(!connection.isValid(15)) {
                status = "Datasource service invalid!";
            }
        }
        return Map.of("datasource-health-checker", status);
    }
}
