package br.unitins.resource;

import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.unitins.model.Passagem;

@Path("/passagens")
public class PassagemResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Passagem> getAll() {
        // retorna todas as Passagems da tabela Passagem
        return Passagem.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Passagem insert(Passagem Passagem) {
        Passagem.persist();

        return Passagem;
    }

    @PUT //
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Passagem update(@PathParam("id") Long id, Passagem passagem){
        
        Passagem entity = Passagem.findById(id);

        entity.setNome(passagem.getNome());
        entity.setOrigem(passagem.getOrigem());
        entity.setDestinoFinal(passagem.getDestinoFinal());
        return entity;
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Passagem search(@PathParam("id") Long id) {

        Passagem entity = Passagem.findById(id);

        return entity;
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Passagem delete(@PathParam("id") Long id) {

        Passagem entity = Passagem.findById(id);
        entity.delete();
        return entity;
    }

}
