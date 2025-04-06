package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
    String nombre;
    String direccion;
    Boolean tieneConyugue;
    LocalDate fechaDeNacimiento;
    Double sueldoBasico;
    public Empleado(String _nombre,String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, Double _sueldoBasico) {
        this.nombre= _nombre;
        this.direccion=_direccion;
        this.tieneConyugue=_tieneConyugue;
        this.fechaDeNacimiento=_fechaDeNacimiento;
        this.sueldoBasico=_sueldoBasico;
    }
    public int edad(){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaDeNacimiento, fechaActual);
        return periodo.getYears();
    }
    public abstract double sueldoBruto();

    public abstract double retenciones();

    protected abstract double aportesJubilatorios();

    public Double sueldoNeto(){
        return sueldoBruto() - retenciones();
    }
    protected double obraSocial(){
        return sueldoBruto()%10;
    }



}
