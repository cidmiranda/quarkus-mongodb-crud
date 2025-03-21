package com.sibling.resource;

import java.util.List;

import org.bson.types.ObjectId;

import com.sibling.model.Produto;
import com.sibling.repository.ProdutoRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/produtos")
@Consumes("application/json")
@Produces("application/json")
public class ProdutoResource {
	
	@Inject
    ProdutoRepository repository;

    @GET
    public List<Produto> listar() {
        return repository.listAll();
    }

    @POST
    public Response adicionar(Produto produto) {
        repository.persist(produto);
        return Response.status(Response.Status.CREATED).entity(produto).build();
    }

    @GET
    @Path("/{id}")
    public Produto buscar(@PathParam("id") String id) {
        return repository.findById(new ObjectId(id));
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Produto produto) {
        Produto produtoExistente = repository.findById(new ObjectId(id));
        if (produtoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoExistente.nome = produto.nome;
        produtoExistente.preco = produto.preco;
        repository.update(produtoExistente);
        return Response.ok(produtoExistente).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id) {
        boolean deleted = repository.deleteById(new ObjectId(id));
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
