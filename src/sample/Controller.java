package sample;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    private Mode mode;

    public Controller(){
        mode = null;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void ButtonClone(ActionEvent actionEvent) {
    }

    public void ButtonDelete(ActionEvent actionEvent) {
    }

    public void ComboBox(ActionEvent actionEvent) {
    }

    public void SelectRadio(ActionEvent actionEvent) {
        mode = Mode.SELECT;
    }

    public void EllipseRadio(ActionEvent actionEvent) {
        mode = Mode.ELLIPSE;
    }

    public void RectangleRadio(ActionEvent actionEvent) {
        mode = Mode.RECTANGLE;
    }

    public void LineRadio(ActionEvent actionEvent) {
        mode = Mode.LINE;
    }

    public void CLickPane(MouseEvent mouseEvent) {
        switch (mode){
            case RECTANGLE:
                break;
            case ELLIPSE:
                break;
            case LINE:
                break;
            case SELECT:
                break;
                default:
                    break;
        }
    }

    public void DragPane(MouseEvent mouseEvent) {
    }
}
