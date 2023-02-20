package clases;

public class Combo implements Producto{
	
	private double descuento;
	private String nombreCombo;

	public Combo(String nombre, double descuento) {
		// TODO Auto-generated constructor stub
		this.descuento= descuento;
		this.nombreCombo=nombre;
	}
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		
		
		return 0;
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
