package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Controller {

    private Mode mode;
    private final ToggleGroup tg = new ToggleGroup();
    private double posx, posy, transx, transy;

    @FXML private javafx.scene.control.Button cloneB;
    @FXML private javafx.scene.control.Button deleteB;

    @FXML private javafx.scene.control.RadioButton select;
    @FXML private javafx.scene.control.RadioButton ellipse;
    @FXML private javafx.scene.control.RadioButton rectangle;
    @FXML private javafx.scene.control.RadioButton line;
    @FXML private javafx.scene.layout.Pane pane;
    @FXML private javafx.scene.control.ColorPicker color;

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
                rectangle.setFill(color.getValue());
                rectangle.setOnMousePressed(RectPressed);
                rectangle.setOnMouseDragged(RectDragged);
                pane.getChildren().add(rectangle);
                break;
            case ELLIPSE:
                Ellipse ellipse = new Ellipse(pos_x, pos_y, 20, 30);
                ellipse.setFill(color.getValue());
                ellipse.setOnMousePressed(EllipsePressed);
                ellipse.setOnMouseDragged(EllipseDragged);
                pane.getChildren().add(ellipse);
                break;
            case LINE:
                Line line = new Line(pos_x, pos_y, 30, 15);
                line.setFill(color.getValue());
                line.setOnMousePressed(LinePressed);
                line.setOnMouseDragged(LineDragged);
                pane.getChildren().add(line);
                break;
            case SELECT:
                break;
                default:
                    break;
        }
    }


    EventHandler<MouseEvent> RectPressed =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle (MouseEvent t){
                    if(mode == Mode.SELECT) {
                        posx = t.getSceneX();
                        posy = t.getSceneY();
                        transx = ((Rectangle) (t.getSource())).getTranslateX();
                        transy = ((Rectangle) (t.getSource())).getTranslateY();
                    }
                }
            };
    EventHandler<MouseEvent> RectDragged =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    if(mode == Mode.SELECT) {
                        double offsetX = t.getSceneX() - posx;
                        double offsetY = t.getSceneY() - posy;
                        double newTranslateX = transx + offsetX;
                        double newTranslateY = transy + offsetY;

                        ((Rectangle) (t.getSource())).setTranslateX(newTranslateX);
                        ((Rectangle) (t.getSource())).setTranslateY(newTranslateY);
                    }
                }
            };

    EventHandler<MouseEvent> LinePressed =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle (MouseEvent t){
                    if(mode == Mode.SELECT) {
                        posx = t.getSceneX();
                        posy = t.getSceneY();
                        transx = ((Line) (t.getSource())).getTranslateX();
                        transy = ((Line) (t.getSource())).getTranslateY();
                    }
                }
            };
    EventHandler<MouseEvent> LineDragged =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    if(mode == Mode.SELECT) {
                        double offsetX = t.getSceneX() - posx;
                        double offsetY = t.getSceneY() - posy;
                        double newTranslateX = transx + offsetX;
                        double newTranslateY = transy + offsetY;

                        ((Line) (t.getSource())).setTranslateX(newTranslateX);
                        ((Line) (t.getSource())).setTranslateY(newTranslateY);
                    }
                }
            };

    EventHandler<MouseEvent> EllipsePressed =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle (MouseEvent t){
                    if(mode == Mode.SELECT) {
                        posx = t.getSceneX();
                        posy = t.getSceneY();
                        transx = ((Ellipse) (t.getSource())).getTranslateX();
                        transy = ((Ellipse) (t.getSource())).getTranslateY();
                    }
                }
            };
    EventHandler<MouseEvent> EllipseDragged =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    if(mode == Mode.SELECT) {
                        double offsetX = t.getSceneX() - posx;
                        double offsetY = t.getSceneY() - posy;
                        double newTranslateX = transx + offsetX;
                        double newTranslateY = transy + offsetY;

                        ((Ellipse) (t.getSource())).setTranslateX(newTranslateX);
                        ((Ellipse) (t.getSource())).setTranslateY(newTranslateY);
                    }
                }
            };
}

