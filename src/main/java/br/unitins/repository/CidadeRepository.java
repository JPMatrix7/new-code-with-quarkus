package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import br.unitins.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    
    public List<Cidade> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

    /* PESQUISA USANDO O LIKE 
    @PersistenceContext
    EntityManager li;
    public List<Cidade> pesquisarNome(String nome){
        Query query = li.createQuery("SELECT e FROM Cidade e WHERE e.nome LIKE:nome");
        query.setParameter("nome", "%" + nome + "%");
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }*/

}
