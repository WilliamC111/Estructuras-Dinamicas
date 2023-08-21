import java.util.Set;

public class Presenter {
    private Model calculator;
    private View view;

    public Presenter() {
        this.calculator = new Model();
        this.view = new View();
    }

    public void generarConjuntoPotencia() {
        Set<Integer> conjuntoEntrada = view.ingresarConjunto();
        Set<Set<Integer>> conjuntoPotencia = calculator.generarConjuntoPotencia(conjuntoEntrada);
        view.mostrarConjuntoPotencia(conjuntoEntrada, conjuntoPotencia);
    }

   
    }

