import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class View {
    public Set<Integer> ingresarConjunto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa los elementos del conjunto separados por comas: ");
        String input = scanner.nextLine();
        scanner.close();

        Set<Integer> conjunto = new HashSet<>();
        String[] elementos = input.split(",");
        for (String elemento : elementos) {
            conjunto.add(Integer.parseInt(elemento));
        }

        return conjunto;
    }

    public void mostrarConjuntoPotencia(Set<Integer> conjuntoEntrada, Set<Set<Integer>> conjuntoPotencia) {
        System.out.println("Conjunto de entrada: " + conjuntoEntrada);
        System.out.println("Conjunto Resultado: " + conjuntoPotencia);
    }
   
}
   
