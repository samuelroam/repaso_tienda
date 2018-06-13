package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repaso_tienda.Producto;
import repaso_tienda.ProductoModelo;

/**
 * Servlet implementation class CambiarProducto
 */
@WebServlet("/CambiarProducto")
public class CambiarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recibir datos
		
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String nombre=request.getParameter("nombre");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date fecha_compra = sdf.parse(request.getParameter("fecha_compra"));
			Double precio = Double.parseDouble(request.getParameter("precio"));
		
		// crear objeto producto
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre(nombre);
		producto.setFecha_compra(fecha_compra);
		producto.setPrecio(precio);
		
		// crear modelo producto
		ProductoModelo productoModelo = new ProductoModelo();
		
		// update(producto)
		productoModelo.update(producto);
		
		// abrir ver producto
		RequestDispatcher rd = request.getRequestDispatcher("VerProducto?="+id);
		rd.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
