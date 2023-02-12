package br.unitins.resource;
import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import br.unitins.model.Usuario;
    @Path("/usuarios")
    public class UsuarioResource {
    @GET
    @Path("/informacoes")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario test() {
        Usuario user = new Usuario();
        user.setNome("João Pedro");
        user.setOrigem("Palmas");
        user.setDestinoFinal("São Paulo");
        user.setAssento("10F");

        return user;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAll() {
        //retorna todas as Usuarios da tabela Usuario
        return Usuario.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario insert (Usuario Usuario) {
        Usuario.persist();

        return Usuario;
    }
}
    
