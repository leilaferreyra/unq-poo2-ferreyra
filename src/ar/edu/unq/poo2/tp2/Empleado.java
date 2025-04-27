package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    private String nombre;
    private String direccion;
    private Boolean tieneConyugue;
    private LocalDate fechaDeNacimiento;
    private double sueldoBasico;
    private List<Concepto> conceptos;

    public Empleado(String _nombre, String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, double _sueldoBasico) {
        this.nombre = _nombre;
        this.direccion = _direccion;
        this.tieneConyugue = _tieneConyugue;
        this.fechaDeNacimiento = _fechaDeNacimiento;
        this.sueldoBasico = _sueldoBasico;
        this.conceptos = new ArrayList<>();
    }

    public int edad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaDeNacimiento, fechaActual);
        return periodo.getYears();
    }

    public abstract double sueldoBruto();

    public double retenciones(){
        return retencionAportesJubilatorios()+retencionObraSocial();
    };

    protected abstract double retencionAportesJubilatorios();

    protected double retencionObraSocial() {
        return sueldoBruto() % 10;
    }
    public double sueldoNeto() {
        return sueldoBruto() - retenciones();
    }


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Boolean getTieneConyugue() {
        return tieneConyugue;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public List<Concepto> getConceptos() {
        generarDesgloceDeConceptos();
        return conceptos;
    }

    protected abstract void generarDesgloceDeConceptos();

}
