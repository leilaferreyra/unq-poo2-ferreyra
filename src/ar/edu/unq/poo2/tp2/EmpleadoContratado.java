package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;

public class EmpleadoContratado extends Empleado {
    private int numeroContrato;
    private String medioDePago;

    public EmpleadoContratado(String _nombre, String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, double _sueldoBasico, int numeroContrato, String medioDePago) {
        super(_nombre, _direccion, _tieneConyugue, _fechaDeNacimiento, _sueldoBasico);
        this.numeroContrato = numeroContrato;
        this.medioDePago = medioDePago;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }
    @Override
    public double sueldoBruto() {
        return getSueldoBasico();
    }
    @Override
    public double retenciones(){
        return super.retenciones()+retencionGastosAdministrativos();
    }
    private int retencionGastosAdministrativos() {
        return 50;
    }
    @Override
    protected double retencionAportesJubilatorios(){
        return 0;
    }
    @Override
    protected double retencionObraSocial(){
        return 0;
    }
    @Override
    protected void generarDesgloceDeConceptos() {
        getConceptos().add(new Concepto ("Sueldo básico", this.getSueldoBasico()));
        getConceptos().add(new Concepto("Gastos Administrativos", this.retencionGastosAdministrativos()));
        getConceptos().add(new Concepto ("Descuento Obra social", this.retencionObraSocial()));
        getConceptos().add(new Concepto ("Descuento Jubilación", this.retencionAportesJubilatorios()));
    }
}
