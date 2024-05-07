package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago {
    private double montoPagado;
    private LocalDate fechaPago;

    // Constructor
    public PagoEfectivo(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        this.montoPagado = monto - monto * 0.10;
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}
