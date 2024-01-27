package ca.ulaval.glo2003;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("")
public class Products {

    @GET
    @Path("/products")
    public Response getProducts(@QueryParam("sort") String sort) {
        System.out.println(sort);
        return Response.ok()
                .header("test", "Choux")
                .build();
    }

    @POST
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postProducts(Product product) {
        System.out.println(product.getAll());
        return Response.ok().build();
    }

    @GET
    @Path("/products/{id}")
    public Response getProductId() {
        return Response.status(444).build();
    }

    public class Simple {
        public String name;
        private static int index = 0;

        public Simple() {
            this.name = "Simple" + index++;
        }
    }

    @GET
    @Path("/simple")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimple() {
        return Response.status(200).entity(new Simple()).build();
    }

    @GET
    @Path("/simpleList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimpleList() {
        List<Simple> simpleList = new ArrayList<>();
        simpleList.add(new Simple());
        simpleList.add(new Simple());
        simpleList.add(new Simple());
        return Response.status(200).entity(simpleList).build();
    }

    public class WithSimples {
        public Simple simple1;
        public Simple simple2;

        public WithSimples() {
            this.simple1 = new Simple();
            this.simple2 = new Simple();
        }
    }

    @GET
    @Path("/withSimplesList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWithSimplesList() {
        List<WithSimples> withSimplesList = new ArrayList<>();
        WithSimples withSimples1 = new WithSimples();
        WithSimples withSimples2 = new WithSimples();
        withSimplesList.add(withSimples1);
        withSimplesList.add(withSimples2);
        return Response.status(200).entity(withSimplesList).build();
    }

    public class Primitifs {
        public int int1;
        public double double1;
        public boolean boolean1;
        public String string1;

        public Primitifs() {
            this.int1 = 1;
            this.double1 = 1.1;
            this.boolean1 = true;
            this.string1 = "string1";
        }
    }

    @GET
    @Path("/primitifs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimitifs() {
        return Response.status(200).entity(new Primitifs()).build();
    }

    public class Complex {
        public Date date = new Date();
        public Optional<String> optional1 = Optional.of("optional");
        public Optional<String> optional2 = Optional.empty();
        public Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();

        public Complex() {}
    }

    @GET
    @Path("/complex")
    @Produces(MediaType.APPLICATION_JSON)
    public Response complex() {
        return Response.status(200).entity(new Complex()).build();
    }
}
