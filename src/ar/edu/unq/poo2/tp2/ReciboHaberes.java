package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;

public class ReciboHaberes {
    String nombreEmpleado;
    String direccionEmpleado;
    LocalDate fechaEmision;
    double sueldoBruto;
    double sueldoNeto;

    public ReciboHaberes(String _nombreEmpleado, String _direccionEmpleado,LocalDate _fechaEmision,double _sueldoBruto,double _sueldoNeto){
        this.nombreEmpleado = _nombreEmpleado;
        this.direccionEmpleado = _direccionEmpleado;
        this.fechaEmision = _fechaEmision;
        this.sueldoBruto = _sueldoBruto;
        this.sueldoNeto = _sueldoNeto;
    }
}
