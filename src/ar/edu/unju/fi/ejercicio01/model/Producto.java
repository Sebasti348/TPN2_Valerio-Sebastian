package ar.edu.unju.fi.ejercicio01.model;


public class Producto {
	private String codigo;
	private String desc;
	private Double pu;
	private Origen origen;
	private Categoria categoria;
	
	// Enum del Origen del Producto
	public enum Origen {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	//Enum del Categoria del Producto
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}
	//Metodos Accesores
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPu() {
		return pu;
	}
	public void setPu(Double pu) {
		this.pu = pu;
	}
	public Origen getOrigen() {
		return origen;
	}
	public void setOrigen(Origen origen) {
		this.origen = origen;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Constructor por defecto
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	//Constructor Parametrizado
	
	public Producto(String codigo, String desc, Double pu, Origen origen, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.desc = desc;
		this.pu = pu;
		this.origen = origen;
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", desc=" + desc + ", pu=" + pu + ", origen=" + origen + ", categoria="
				+ categoria + "]";
	}
	
	
	
}
