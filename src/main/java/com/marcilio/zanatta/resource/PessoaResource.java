package com.marcilio.zanatta.resource;

import com.marcilio.zanatta.model.Pessoa;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    public List<Pessoa> getPessoa() {
        return Pessoa.listAll();
    }

    @GET
    @Path("/{anoNascimento}")
    public List<Pessoa> findByAnoNascimento(@PathParam("anoNascimento") int anoNascimento) {
        return Pessoa.findByAnoNascimento(anoNascimento);
    }

    @POST
    @Transactional
    public Pessoa addPessoa(Pessoa pessoa){
        pessoa.id = null;
        pessoa.persist();
        return pessoa;
    }

    @PUT
    @Transactional
    public Pessoa updatePessoa(Pessoa pessoa){
        Pessoa p = Pessoa.findById(pessoa.id);
        p.name = pessoa.name;
        p.anoNascimento = pessoa.anoNascimento;
        return p;
    }

    @DELETE
    @Transactional
    public void deletePessoa(Pessoa pessoa){
        Pessoa.findById(pessoa.id).delete();
    }
}
