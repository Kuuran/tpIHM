package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class Controller {

    private Mode mode;
    private final ToggleGroup tg = new ToggleGroup();

    @FXML private javafx.scene.control.Button cloneB;
    @FXML private javafx.scene.control.Button deleteB;

    @FXML private javafx.scene.control.RadioButton select;
    @FXML private javafx.scene.control.RadioButton ellipse;
    @FXML private javafx.scene.control.RadioButton rectangle;
    @FXML private javafx.scene.control.RadioButton line;

    @FXML public void initialize(){
        mode = null;

        select.setToggleGroup(tg);
        ellipse.setToggleGroup(tg);
        rectangle.setToggleGroup(tg);
        line.setToggleGroup(tg);
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
        cloneB.setDisable(false);
        deleteB.setDisable(false);


    }

    public void EllipseRadio(ActionEvent actionEvent) {
        mode = Mode.ELLIPSE;
        cloneB.setDisable(true);
        deleteB.setDisable(true);
    }

    public void RectangleRadio(ActionEvent actionEvent) {
        mode = Mode.RECTANGLE;
        cloneB.setDisable(true);
        deleteB.setDisable(true);
    }

    public void LineRadio(ActionEvent actionEvent) {
        mode = Mode.LINE;
        cloneB.setDisable(true);
        deleteB.setDisable(true);
    }

    public void CLickPane(MouseEvent mouseEvent) {
        double pos_x = mouseEvent.getX();
        double pos_y = mouseEvent.getY();

        switch (mode){
            case RECTANGLE:
                Rectangle rectangle = new Rectangle(pos_x, pos_y, 30, 15);
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
