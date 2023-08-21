import java.util.*;

public class Model {
    public Set<Set<Integer>> generarConjuntoPotencia(Set<Integer> conjunto) {
        Set<Set<Integer>> conjuntoPotencia = new HashSet<>();
        conjuntoPotencia.add(new HashSet<>()); 

        for (Integer elemento : conjunto) {
            Set<Set<Integer>> nuevosSubconjuntos = new HashSet<>();
            
            for (Set<Integer> subconjunto : conjuntoPotencia) {
                Set<Integer> nuevoSubconjunto = new HashSet<>(subconjunto);
                nuevoSubconjunto.add(elemento);
                nuevosSubconjuntos.add(nuevoSubconjunto);
            }
            
            conjuntoPotencia.addAll(nuevosSubconjuntos);
        }
        
        return conjuntoPotencia;
    }
}