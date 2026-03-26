import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Paciente> lista = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar paciente particular");
            System.out.println("2. Registrar paciente EPS");
            System.out.println("3. Registrar paciente VIP");
            System.out.println("4. Buscar paciente por documento");
            System.out.println("5. Mostrar todos los pacientes");
            System.out.println("6. Mostrar pacientes por tipo");
            System.out.println("7. Calcular costo de consulta");
            System.out.println("8. Mostrar consultas costosas");
            System.out.println("9. Paciente que más pagó");
            System.out.println("10. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String n1 = sc.next();
                    System.out.print("Documento: ");
                    int d1 = sc.nextInt();
                    System.out.print("Costo: ");
                    double c1 = sc.nextDouble();

                    lista.add(new PacienteParticular(n1, d1, c1));
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String n2 = sc.next();
                    System.out.print("Documento: ");
                    int d2 = sc.nextInt();
                    System.out.print("Costo: ");
                    double c2 = sc.nextDouble();
                    System.out.print("EPS: ");
                    String eps = sc.next();

                    lista.add(new PacienteEPS(n2, d2, c2, eps));
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String n3 = sc.next();
                    System.out.print("Documento: ");
                    int d3 = sc.nextInt();
                    System.out.print("Costo: ");
                    double c3 = sc.nextDouble();
                    System.out.print("Años fidelidad: ");
                    int a = sc.nextInt();

                    lista.add(new PacienteVIP(n3, d3, c3, a));
                    break;

                case 4:
                    System.out.print("Documento: ");
                    int buscar = sc.nextInt();
                    boolean encontrado = false;

                    for (Paciente p : lista) {
                        if (p.documento == buscar) {
                            p.mostrarDatos(p.calcularCostoFinal());
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Paciente no encontrado");
                    }
                    break;

                case 5:
                    for (Paciente p : lista) {
                        p.mostrarDatos(p.calcularCostoFinal());
                    }
                    break;

                case 6:
                    System.out.println("1. Particular  2. EPS  3. VIP");
                    int tipo = sc.nextInt();

                    for (Paciente p : lista) {
                        if ((tipo == 1 && p instanceof PacienteParticular) ||
                                (tipo == 2 && p instanceof PacienteEPS) ||
                                (tipo == 3 && p instanceof PacienteVIP)) {

                            p.mostrarDatos(p.calcularCostoFinal());
                        }
                    }
                    break;

                case 7:
                    System.out.print("Documento: ");
                    int doc = sc.nextInt();

                    for (Paciente p : lista) {
                        if (p.documento == doc) {
                            System.out.println("Costo final: " + p.calcularCostoFinal());
                        }
                    }
                    break;

                case 8:
                    for (Paciente p : lista) {
                        if (p.esConsultaCostosa()) {
                            p.mostrarDatos(p.calcularCostoFinal());
                        }
                    }
                    break;

                case 9:
                    Paciente mayor = null;
                    double max = 0;

                    for (Paciente p : lista) {
                        double costo = p.calcularCostoFinal();

                        if (costo > max) {
                            max = costo;
                            mayor = p;
                        }
                    }

                    if (mayor != null) {
                        System.out.println("Paciente que más pagó:");
                        mayor.mostrarDatos(max);
                    }
                    break;
            }

        } while (opcion != 10);
    }
}