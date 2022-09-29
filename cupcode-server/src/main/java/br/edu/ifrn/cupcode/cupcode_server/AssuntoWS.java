package br.edu.ifrn.cupcode.cupcode_server;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifrn.cupcode.data.AssuntoDAO;
import br.edu.ifrn.cupcode.domain.Assunto;

@Path("assunto")
public class AssuntoWS {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarTodos")
	public List<Assunto> buscarTodos() {
		
		AssuntoDAO assuntoDAO = new AssuntoDAO();
		return assuntoDAO.buscarTodos();
		
	}
	
	@GET
	@Path("/buscarAssunto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Assunto buscarAssunto(@PathParam("id") int  id) {
		
		AssuntoDAO assuntoDAO = new AssuntoDAO();
		return assuntoDAO.buscarAssunto(id);
	}

}
