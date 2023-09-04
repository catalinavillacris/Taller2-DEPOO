package modelo;

public class ProductoMenu implements Producto {
	
	private String nombre;
	private double precioBase;
	private int calorias;
	
	public ProductoMenu (String nombre, double precio,int calorias) {
		this.nombre=nombre;
		this.precioBase=precio;
		this.calorias=calorias;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecio(){
		return this.precioBase;
	}
	
	public int getCalorias() {
		return this.calorias;
	}
	
	public String generarTextoFactura() {
		String factura="";
		factura+=getNombre()+"		";
		factura+=String.valueOf(getPrecio());
		return factura;
	}

}
