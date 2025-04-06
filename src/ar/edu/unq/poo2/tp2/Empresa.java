package ar.edu.unq.poo2.tp2;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
    public String nombre;
    public String CUIT;
    public List<Empleado> empleados;
    public List <ReciboHaberes> recibosDeHaberes;
    public Empresa(String _nombre, String _CUIT){
        this.nombre = _nombre;
        this.CUIT = _CUIT;
        this.empleados = new ArrayList<>();
        this.recibosDeHaberes = new ArrayList<>();
    }
    public void liquidar(){
        for (Empleado emp: empleados){
        ReciboHaberes recibo= new ReciboHaberes(emp.nombre,emp.direccion,LocalDate.now(),emp.sueldoBruto(),emp.sueldoNeto());
        recibosDeHaberes.add(recibo);
        }
    }

    public double totalSueldosNetos(){
        double total=0.0;
        for (Empleado empleado:empleados){
            total+=empleado.sueldoNeto();
        }
        return total;
    }
    public double totalSueldosBrutos(){
        double total=0.0;
        for (Empleado empleado:empleados){
            total+=empleado.sueldoBruto();
        }
        return total;
    }
    public double totalRetenciones(){
        double total=0.0;
        for (Empleado empleado:empleados){
            total+=empleado.retenciones();
        }
        return total;
    }
}
