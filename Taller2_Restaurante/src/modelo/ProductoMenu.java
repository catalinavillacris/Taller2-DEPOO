package modelo;

public class ProductoMenu implements Producto {
	
	private String nombre;
	private double precioBase;
	
	public ProductoMenu (String nombre, double precio) {
		this.nombre=nombre;
		this.precioBase=precio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecio(){
		return this.precioBase;
	}
	
	public String generarTextoFactura() {
		String factura="";
		factura+=getNombre()+"		";
		factura+=String.valueOf(getPrecio());
		return factura;
	}

}
