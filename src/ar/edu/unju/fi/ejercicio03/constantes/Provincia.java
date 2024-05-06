package ar.edu.unju.fi.ejercicio03.constantes;


public enum Provincia {
	/*Los valores en las provincias representan los valores iniciales para
	la cantidad de población y la superficie en el enum*/
	JUJUY(1500000, 68212.5),
    SALTA(2000000, 59123.7),
    TUCUMAN(2500000, 67890.0),
    CATAMARCA(600000, 45678.9),
    LA_RIOJA(700000, 34567.8),
    SANTIAGO_DEL_ESTERO(5000000, 78901.2);

    private long cantidadPoblacion;
    //la superficie esta en km2
    private double superficie;

    private Provincia(long cantidadPoblacion, double superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public long getCantidadPoblacion() {
        return this.cantidadPoblacion;
    }
 
    public void setCantidadPoblacion(long cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public double getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return this.cantidadPoblacion / this.superficie;
    }
}


