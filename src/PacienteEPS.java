public class PacienteEPS extends Paciente {

    private String nombreEPS;

    public PacienteEPS(String nombre, int documento, double costoconsulta, String nombreEPS) {
        super(nombre, documento, costoconsulta);
        this.nombreEPS = nombreEPS;
    }

    @Override
    public double calcularCostoFinal() {

        double porcentaje;

        if (costoconsulta > 300000) {
            porcentaje = 0.25;
        } else if (costoconsulta > 80000) {
            porcentaje = 0.20;
        } else {
            porcentaje = 0.30;
        }

        double copago = costoconsulta * porcentaje;

        if (esConsultaCostosa()) {
            copago = copago - (copago * 0.05);
        }

        return copago;
    }
}