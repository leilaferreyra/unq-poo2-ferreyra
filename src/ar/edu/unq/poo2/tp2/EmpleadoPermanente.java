package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado {
    private int cantHijos;
    private int antiguedad;

    public EmpleadoPermanente(String _nombre, String _direccion, Boolean _tieneConyugue, LocalDate _fechaDeNacimiento, double _sueldoBasico, int _cantHijos, int _antiguedad) {
        super(_nombre, _direccion, _tieneConyugue, _fechaDeNacimiento, _sueldoBasico);
        this.cantHijos = _cantHijos;
        this.antiguedad = _antiguedad;
    }
    //sueldo bruto
    @Override
    public double sueldoBruto() {
        return getSueldoBasico() + sueldoFamiliar() + extraAntiguedad();
    }

    private double sueldoFamiliar() {
        return asignacionPorHijo() + asignacionPorConyugue();
    }

    private double asignacionPorHijo() {
        return 150 * cantHijos;
    }

    private double asignacionPorConyugue() {
        return getTieneConyugue() ? 100 : 0;
    }

    private double extraAntiguedad() {
        return 50 * antiguedad;
    }

    //retenciones
    @Override
    protected double retencionObraSocial() {
        return super.retencionObraSocial() + 20 * cantHijos;
    }

    @Override
    protected double retencionAportesJubilatorios() {
        return sueldoBruto() % 15;
    }

    @Override
    protected void generarDesgloceDeConceptos() {
        getConceptos().add(new Concepto("Sueldo Basico", getSueldoBasico()));
        getConceptos().add(new Concepto("Sueldo Familiar", sueldoFamiliar()));
        getConceptos().add(new Concepto("Asignacion por hijo", asignacionPorHijo()));
        getConceptos().add(new Concepto("Asignacion por conyugue", asignacionPorConyugue()));
        getConceptos().add(new Concepto("Antiguedad", extraAntiguedad()));
        getConceptos().add(new Concepto("Descuento obra social", retencionObraSocial()));
        getConceptos().add(new Concepto("Descuento aportes jubilatorios", retencionAportesJubilatorios()));
    }
}

