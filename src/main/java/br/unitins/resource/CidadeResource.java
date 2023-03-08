package br.unitins.resource;

import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import br.unitins.dto.CidadeDTO;
import br.unitins.dto.CidadeResponseDTO;
import br.unitins.model.Cidade;
import br.unitins.repository.CidadeRepository;
import br.unitins.repository.EstadoRepository;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {

    @Inject //O que faz?
    private CidadeRepository repository;
    @Inject
    private EstadoRepository estadoRepository;

   
    @GET  
    public List<CidadeResponseDTO> getAll(){
        
        // seleciona todos as cidades do BD
        return repository.listAll()
        .stream()
        .map(cidade -> new CidadeResponseDTO(cidade))
        .collect(Collectors.toList());
        
    }
    

    @POST
    @Transactional
    public CidadeResponseDTO insert(CidadeDTO dto) {
        
        Cidade entity = new Cidade();
        entity.setNome(dto.getNome());
        entity.setEstado(estadoRepository.findById(dto.getIdEstado()));

        repository.persist(entity);

        return new CidadeResponseDTO(entity);
    }

    @PUT //
    @Path("/atualizar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Cidade update(@PathParam("id") Long id, Cidade Cidade) {

        Cidade entity = repository.findById(id);

        entity.setNome(Cidade.getNome());
        return entity;
    }

    @GET
    @Path("/count")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    //public Cidade search(@PathParam("nome") String nome) {
    public long count(){
      return repository.count();
    }

    @GET
    @Path("/buscar/{nome}")
    public List<Cidade> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

    @DELETE
    @Path("/deletar/{id}")
    public Cidade delete(@PathParam("id") long id) {

        Cidade cidade = repository.findById(id);
        repository.delete(cidade);
        return cidade;
    }

}
