import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter {
    private View view;
    private Expressions model;

    public Presenter(View view, Expressions model) {
        this.view = view;
        this.model = model;

        view.addEvaluateListener(new EvaluateListener());
    }

    class EvaluateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = view.getInputExpression();
            model.evaluateExpression(expression);
            double result = model.getFinalResult();
            view.setResultText(String.valueOf(result));
        }
    }
}