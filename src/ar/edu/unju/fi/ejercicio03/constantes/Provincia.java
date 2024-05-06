package ar.edu.unju.fi.ejercicio03.constantes;


public enum Provincia {
	/*Los valores en las provincias representan los valores iniciales para
	la cantidad de población y la superficie en el enum*/
	JUJUY(811611, 53.219),
    SALTA(1441351, 155.488),
    TUCUMAN(1678305, 22.524),
    CATAMARCA(429562, 102.602),
    LA_RIOJA(38386, 89.680),
    SANTIAGO_DEL_ESTERO(896461, 136.351);

    private  long cantidadPoblacion;
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


