package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;
import java.util.List;

public class ReciboHaberes {
    String nombreEmpleado;
    String direccionEmpleado;
    LocalDate fechaEmision;
    double sueldoBruto;
    double sueldoNeto;
   
    List<Concepto> desgloceConceptos;
    public ReciboHaberes(String _nombreEmpleado, String _direccionEmpleado, LocalDate _fechaEmision, double _sueldoBruto, double _sueldoNeto, List <Concepto> _desgloceConceptos) {
        this.nombreEmpleado = _nombreEmpleado;
        this.direccionEmpleado = _direccionEmpleado;
        this.fechaEmision = _fechaEmision;
        this.sueldoBruto = _sueldoBruto;
        this.sueldoNeto = _sueldoNeto;
        this.desgloceConceptos = _desgloceConceptos;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }
    public double getSueldoBruto() {
        return sueldoBruto;
    }
    public double getSueldoNeto() {
        return sueldoNeto;
    }
    public List<Concepto> getDesgloceConceptos() {
        return desgloceConceptos;
    }
}
