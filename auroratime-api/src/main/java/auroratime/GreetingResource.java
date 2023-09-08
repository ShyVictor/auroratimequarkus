package auroratime;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

@Path("/info")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getInfo() {
        Map<String, String> info = Map.of("project_name", "Aurora Time Project", "project_desc", "My personagel project");
        return info;
    }
}
