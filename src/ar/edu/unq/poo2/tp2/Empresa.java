package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
    public String nombre;
    public String CUIT;
    public List<Empleado> empleados;
    public List<ReciboHaberes> recibosDeHaberes;
    
    public Empresa(String _nombre, String _CUIT) {
        this.nombre = _nombre;
        this.CUIT = _CUIT;
        this.empleados = new ArrayList<>();
        this.recibosDeHaberes = new ArrayList<>();
    }

    public void liquidarSueldos() {
        for (Empleado emp : empleados) {
            generarReciboDeHaberes(emp);
        }
    }
    private void generarReciboDeHaberes(Empleado emp) {
        ReciboHaberes recibo = new ReciboHaberes(emp.getNombre(), emp.getDireccion(), LocalDate.now(), emp.sueldoBruto(), emp.sueldoNeto(), emp.getConceptos());
        recibosDeHaberes.add(recibo);
    }
    private void agregarReciboHaberes(ReciboHaberes recibo) {
        this.recibosDeHaberes.add(recibo);
    }

    public double totalSueldosNetos() {
        double total = 0.0;
        for (Empleado empleado : empleados) {
            total += empleado.sueldoNeto();
        }
        return total;
    }

    public double totalSueldosBrutos() {
        double total = 0.0;
        for (Empleado empleado : empleados) {
            total += empleado.sueldoBruto();
        }
        return total;
    }

    public double totalRetenciones() {
        double total = 0.0;
        for (Empleado empleado : empleados) {
            total += empleado.retenciones();
        }
        return total;
    }
}
