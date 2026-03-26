public class PacienteVIP extends Paciente {

    private int aniosFidelidad;

    public PacienteVIP(String nombre, int documento, double costoconsulta, int aniosFidelidad) {
        super(nombre, documento, costoconsulta);
        this.aniosFidelidad = aniosFidelidad;
    }

    @Override
    public double calcularCostoFinal() {

        double porcentaje;

        if (aniosFidelidad >= 10) {
            porcentaje = 0.40;
        } else if (aniosFidelidad >= 5) {
            porcentaje = 0.30;
        } else {
            porcentaje = 0.20;
        }

        double total = aplicarDescuento(porcentaje);

        if (total > 300000) {
            total = 300000;
        }

        return total;
    }
}
