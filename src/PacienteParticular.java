public class PacienteParticular extends Paciente {

    public PacienteParticular(String nombre, int documento, double costoconsulta) {
        super(nombre, documento, costoconsulta);
    }

    @Override
    public double calcularCostoFinal() {
        double total;

        if (costoconsulta > 400000) {
            total = aplicarDescuento(0.15);
        } else if (costoconsulta > 200000) {
            total = aplicarDescuento(0.10);
        } else if (costoconsulta < 50000) {
            total = aplicarRecargo(0.05);
        } else {
            total = costoconsulta;
        }

        return total;
    }
}