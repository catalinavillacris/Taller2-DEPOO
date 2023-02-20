package clases;

public class ProductoMenu implements Producto {
	
	private String nombre;
	private int precioBase;

	public ProductoMenu(String nombre, int precio) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		this.precioBase=precio;
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precioBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

}
