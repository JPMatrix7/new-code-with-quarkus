package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import br.unitins.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped //quem gerencia o scopo é o quarkus
public class EstadoRepository implements PanacheRepository<Estado>{ //generics, tecnologia java
    
    public Estado findByNome(String nome){
        return find("nome", nome).firstResult();
    }

    @PersistenceContext
    EntityManager li;
    public List<Estado> pesquisarNome(String nome){
        Query query = li.createQuery("SELECT e FROM Estado e WHERE e.nome LIKE:nome");
        query.setParameter("nome", "%" + nome + "%");
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
