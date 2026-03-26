public class Paciente {

    protected String nombre;
    protected int documento;
    protected double costoconsulta;

    public Paciente(String nombre, int documento, double costoconsulta){
        this.nombre = nombre;
        this.documento = documento;
        this.costoconsulta = costoconsulta;
    }

    public double calcularCostoFinal(){
        return costoconsulta;
    }

    public double aplicarDescuento(double porcentaje){
        double descuento = costoconsulta * porcentaje;
        return costoconsulta - descuento;
    }

    public double aplicarRecargo(double porcentaje){
        double recargo = costoconsulta * porcentaje;
        return costoconsulta + recargo;
    }

    public boolean esConsultaCostosa(){
        return costoconsulta > 300000;
    }

    public void mostrarDatos(double costoFinal){
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Costo consulta: " + costoconsulta);
        System.out.println("Costo final: " + costoFinal);
        System.out.println("---------------------------");
    }
}
