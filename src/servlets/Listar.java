package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repaso_tienda.*;


@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// consegior los productos de la bbdd
		ProductoModelo productoModelo = new ProductoModelo();
			
			ArrayList<Producto> productos = productoModelo.selectAll();
		// enviarlos a la vista de listado.jsp
		request.setAttribute("productos", productos);
		
		RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
