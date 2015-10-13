package example;
import com.sun.net.httpserver.HttpServer;
//import com.sun.jersey.api.container.httpserver.HttpServerFactory;  // jersey api not current at 2-2 in Intellij.  Back to Jersey 1.12.
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by Student on 10/12/2015.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }


    // The Java method will process HTTP GET requests, like: http://localhost:9998/helloworld/id/Fred
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Path("name/{username}")
    public String getWithParamName(@PathParam("username") String userName) {
        // Return some passed textual content
        return "Hello" + userName;
    }

    // The Java method will process HTTP GET requests, like: http://localhost:9998/helloworld/name/Dave
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Path("id/{username}")
    public String getWithParamId(@PathParam("username") String userName) {
        // Return some passed textual content
        return "Hello" + userName;
    }

    // The Java method will process HTTP GET requests, like: http://localhost:9998/helloworld/html/Dave
    @GET
    // The Java method will produce content identified by the MIME Media type "json"
    @Produces("text/html")
    @Path("html/{username}")
    public String getReturnJSON(@PathParam("username") String userName) {
        // Return some passed textual content
        return "<html><body><h1>Hello " + userName + "</h1></body></html>";
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");  // instead of running on Tomcat
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
