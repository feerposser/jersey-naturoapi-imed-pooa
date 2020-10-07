package br.com.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.model.Personagem;

@Path("/personagem")
public class PersonagemREST {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonagens() {
		Personagem personagem = new Personagem(2020, "Narutooo", "Uzumaki");
		ArrayList<Personagem> personagens = new ArrayList();
		personagens.add(personagem);
		personagens.add(personagem);

		return Response.ok(personagens).build();
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonagem(@PathParam("id") int id) {
		ArrayList<Personagem> personagens = new ArrayList();

		Personagem naruto = new Personagem(2020, "Narutooo", "Uzumaki");
		personagens.add(naruto);
		Personagem sasuke = new Personagem(2021, "Sasuke", "Uchiha");
		personagens.add(sasuke);

		return Response.ok(personagens.get(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersonagem(Personagem personagem) {
		try {
			ArrayList<Personagem> personagens = new ArrayList();

			Personagem naruto = new Personagem(2020, "Narutooo", "Uzumaki");
			personagens.add(naruto);

			personagens.add(personagem);

			return Response.status(Response.Status.CREATED).entity(personagem).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletaPersonagem(@PathParam("id") int id) {

		try {
			ArrayList<Personagem> personagens = new ArrayList();

			Personagem naruto = new Personagem(2020, "Narutooo", "Uzumaki");
			personagens.add(naruto);
			Personagem sasuke = new Personagem(2021, "Sasuke", "Uchiha");
			personagens.add(sasuke);
			
			personagens.remove(id);
			
			for (Personagem p: personagens) {
				System.out.println("->> " + p.getNome());
			}

			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}

}
