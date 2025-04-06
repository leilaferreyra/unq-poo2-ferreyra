package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado {
    int cantHijos;
    int antiguedad;
    public EmpleadoPermanente(String _nombre, String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, Double _sueldoBasico, int _cantHijos, int _antiguedad) {
        super(_nombre,_direccion,_tieneConyugue,_fechaDeNacimiento,_sueldoBasico);
        this.cantHijos = _cantHijos;
        this.antiguedad = _antiguedad;
    }
    //sueldo bruto
    @Override
    public double sueldoBruto(){
        return sueldoBasico+sueldoFamiliar()+extraAntiguedad();
    }
    private int sueldoFamiliar(){
        return asignacionPorHijo() + asignacionPorConyugue();
    }
    private int asignacionPorHijo(){
        return 150*cantHijos;
    }
    private int asignacionPorConyugue(){
        return tieneConyugue? 100:0;
    }
    private int extraAntiguedad(){
        return 50*antiguedad;
    }
    //retenciones
    @Override
    public double retenciones(){
        return obraSocial()+ aportesJubilatorios();
    }
    @Override
    protected double obraSocial(){
        return super.obraSocial() + 20 * cantHijos;
    }
    @Override
    protected double aportesJubilatorios(){
        return sueldoBruto()%15;
    }
}
