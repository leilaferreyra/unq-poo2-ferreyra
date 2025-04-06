package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;

public class EmpleadoTemporario extends Empleado{
    public LocalDate finDesignacion;
    public int cantHorasExtras;
    public int añosJubilatorios;

    public EmpleadoTemporario(String _nombre, String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, Double _sueldoBasico,LocalDate _finDesignacion, int _cantHorasExtras, int _añosJubilatorios) {
        super(_nombre,_direccion,_tieneConyugue,_fechaDeNacimiento,_sueldoBasico);
        this.finDesignacion = _finDesignacion;
        this.cantHorasExtras = _cantHorasExtras;
        this.añosJubilatorios=_añosJubilatorios;
    }
    //sueldo bruto
    @Override
    public double sueldoBruto(){
        return sueldoHorasExtras() + sueldoBasico;
    }
    private int sueldoHorasExtras(){
        return cantHorasExtras*40;
    }
    //retenciones
    @Override
    public double retenciones(){
        return obraSocial()+ aportesJubilatorios();
    }
    @Override
    protected double aportesJubilatorios(){
        return 10%sueldoBruto()+5*cantHorasExtras;
    }
    @Override
    protected double obraSocial(){
        return super.obraSocial()+extraEdad();

    }
    private int extraEdad(){
        return edad()>50 ? 25:0;
    }
}
