package org.iesalixar.amanuelbenallid.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.amanuelbenallid.DAO.TeamDAO;

/**
 * Servlet para borrar los equipos
 * 
 * @author Alberto
 *
 */
@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Login.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer equipo_id = Integer.parseInt(request.getParameter("equipo_id"));
		if (TeamDAO.deleteTeam(equipo_id)) {
			logger.info("Se ha borrado un equipo");
		} else {
			logger.info("No se ha podido eliminar el equipo");
		}

		getServletContext().getRequestDispatcher("/Read").forward(request, response);

	}

}
