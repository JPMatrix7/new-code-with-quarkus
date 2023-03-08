package br.unitins.resource;

import javax.ws.rs.Path;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import br.unitins.model.Estado;
import br.unitins.repository.EstadoRepository;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject //O que faz?
    private EstadoRepository repository;

    @Path("/buscarTodos")
    @GET
    public List<Estado> getAll(){
        
        return repository.listAll();//Substitui o findAll().list();
        
    }
    
    @POST
    @Transactional
    public Estado insert(Estado estado) {

        repository.persist(estado);

        return estado;
    }

    @PUT //
    @Path("/atualizar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Estado update(@PathParam("id") Long id, Estado Estado) {

        Estado entity = repository.findById(id);

        entity.setNome(Estado.getNome());
        entity.setSigla(Estado.getSigla());
        return entity;
    }

    @GET
    @Path("/count")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    //public Estado search(@PathParam("nome") String nome) {
    public long count(){
      return repository.count();
    }

    @GET
    @Path("/buscar/{nome}")
    public List<Estado> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

    @DELETE
    @Path("/deletar/{id}")
    public Estado delete(@PathParam("id") long id) {

        Estado estado = repository.findById(id);
        repository.delete(estado);
        return estado;
    }

}
