package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;

public class EmpleadoTemporario extends Empleado{
    private LocalDate fechaFinDesignacion;
    private int cantHorasExtras;


    public EmpleadoTemporario(String _nombre, String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, Double _sueldoBasico,LocalDate _fechaFinDesignacion, int _cantHorasExtras) {
        super(_nombre,_direccion,_tieneConyugue,_fechaDeNacimiento,_sueldoBasico);
        this.fechaFinDesignacion = _fechaFinDesignacion;
        this.cantHorasExtras = _cantHorasExtras;
    }
    
    //sueldo bruto
    @Override
    public double sueldoBruto(){
        return sueldoHorasExtras() + getSueldoBasico();
    }
    private int sueldoHorasExtras(){
        return cantHorasExtras*40;
    }
    //retenciones
    @Override
    protected double retencionAportesJubilatorios(){
        return 10%sueldoBruto()+5*cantHorasExtras;
    }
    @Override
    protected double retencionObraSocial(){
        return super.retencionObraSocial()+extraEdad();

    }
    private int extraEdad(){
        return edad()>50 ? 25:0;
    }
    public LocalDate getFechaFinDesignacion() {
    	return fechaFinDesignacion;
    }
    @Override
    protected void generarDesgloceDeConceptos(){
        getConceptos().add(new Concepto("Sueldo Basico", getSueldoBasico()));
        getConceptos().add(new Concepto("Horas extras",sueldoHorasExtras()));
        getConceptos().add(new Concepto("Descuento obra social",retencionObraSocial()));
        getConceptos().add(new Concepto("Descuento aportes jubilatorios",retencionAportesJubilatorios()));
    }
}