package org.iesalixar.amanuelbenallid.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.amanuelbenallid.DAO.PlayerDAO;

/**
 * Servlet para crear los jugadores
 * 
 * @author Alberto
 *
 */
@WebServlet("/CreatePlayer")
public class CreatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Login.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePlayer() {
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
		Long equipo = Long.parseLong(request.getParameter("equipo"));
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellido");
		String direccion = request.getParameter("Direccion");
		String dni = request.getParameter("dni");

		logger.info("Se ha pedido la creaci�n de un nuevo jugador");

		if (PlayerDAO.createPlayer(nombre, apellidos, dni, direccion, equipo)) {
			logger.info("Se ha insertado un nuevo jugador en la base de datos");
		} else {
			logger.info("No se ha podido insertar el jugador");
		}

		response.sendRedirect("./Read");

	}

}
