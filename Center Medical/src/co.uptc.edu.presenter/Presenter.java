import java.util.PriorityQueue;

public class Presenter {
        private View view;
        private PriorityQueue<Patient> queue;
    
        public Presenter() {
            this.view = view;
            this.queue = new PriorityQueue<>();
        }
    
        public void setView(View view) {
            this.view = view;
        }

        public void addPatient(String name, int severity) {
            Patient patient = new Patient(name, severity);
            queue.add(patient);
            view.displayMessage("Paciente agregado a la cola.");
        }
    
        public void treatNextPatient() {
            if (!queue.isEmpty()) {
                Patient patient = queue.poll();
                view.displayMessage("Tratando al paciente: " + patient.getName());
            } else {
                view.displayMessage("No hay pacientes en espera.");
            }
        }
    }
    
   
    

