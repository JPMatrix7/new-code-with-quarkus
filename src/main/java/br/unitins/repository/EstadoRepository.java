package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import br.unitins.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped //quem gerencia o scopo é o quarkus
public class EstadoRepository implements PanacheRepository<Estado>{ //generics, tecnologia java

    public List<Estado> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

}
