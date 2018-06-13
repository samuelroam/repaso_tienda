package repaso_tienda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import repaso_tienda.Producto;

public class ProductoModelo extends Conector {

	
	public ArrayList<Producto> selectAll() {

		ArrayList<Producto> productos = new ArrayList<Producto>();
		String sql = "SELECT * FROM productos";
		try {
			Statement stt = super.conexion.createStatement();
			ResultSet rst = stt.executeQuery(sql);
			while (rst.next()) {
				Producto producto = new Producto();
				producto.setId(rst.getInt("id"));
				producto.setNombre(rst.getString("nombre"));
				producto.setFecha_compra(rst.getDate("fecha_compra"));
				producto.setPrecio(rst.getDouble("precio"));
				productos.add(producto);
			}
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	public Producto select(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from productos where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				return producto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
