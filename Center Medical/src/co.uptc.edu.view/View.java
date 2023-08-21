import java.util.Scanner;

public class View {
    
        private Presenter presenter;
    
        public View(Presenter presenter2) {
        }
    
        public void start() {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("1. Agregar paciente");
                    System.out.println("2. Tratar paciente");
                    System.out.println("3. Salir");
                    System.out.print("Seleccione una opción: ");
                    int choice = scanner.nextInt();
   
                    switch (choice) {
                        case 1:
                            System.out.print("Nombre del paciente: ");
                            scanner.nextLine(); 
                            String name = scanner.nextLine();
                            System.out.print("Nivel de gravedad: ");
                            int severity = scanner.nextInt();
                            presenter.addPatient(name, severity);
                            break;
                        case 2:
                            presenter.treatNextPatient();
                            break;
                        case 3:
                            System.out.println("Saliendo del programa.");
                            return;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                }
            }
        }
    
        public void displayMessage(String message) {
            System.out.println(message);
        }
    }

