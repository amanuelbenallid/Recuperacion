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
 * Servlet para crear los equipos
 * 
 * @author Alberto
 *
 */
@WebServlet("/CreateTeam")
public class CreateTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Login.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTeam() {
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

		String nombre = request.getParameter("nombre");
		String ciudad = request.getParameter("ciudad");
		String pais = request.getParameter("pais");
		logger.info("Se ha pedido a�adir un nuevo equipo");

		if (TeamDAO.createTeam(nombre, ciudad, pais)) {
			logger.info("Se ha a�adido un nuevo equipo a la base de datos");
		} else {
			logger.info("No se ha podido a�adir el nuevo equipo");
		}

		getServletContext().getRequestDispatcher("/Read").forward(request, response);
	}

}
