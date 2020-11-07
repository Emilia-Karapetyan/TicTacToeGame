package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Controller implements EventHandler<ActionEvent> {
    boolean b = false;
    boolean xo = true;
    static int xScore;
    static int yScore;
    Line line;
    String str = "";
        @FXML
    AnchorPane anchor;
    @FXML
    Label x;
    @FXML
    Label y;
    @FXML
    Button label1, label2, label3, label4, label5, label6, label7, label8, label9;
    Button[] buttons;
    @FXML
    Button start;
    @FXML
    RadioButton radioButton;

    @FXML
    public void run() {
        buttons = new Button[]{label1, label2, label3, label4, label5, label6, label7, label8, label9};
        b = true;
        xo = true;
        for (Button label : buttons) {
            label.setText("");
            label.setOnAction(this);
        }
        anchor.getChildren().remove(line);
    }

    @Override
    public void handle(ActionEvent event) {
        if (b) {
            for (Button button : buttons) {
                if (button == event.getSource() && button.getText().isEmpty()) {
                    if (xo) {
                        button.setText("X");
                        xo = false;
                        if (check()) {
                            b = false;
                            end();
                            if (xScore == 2) {
                                xScore = 0;
                                yScore = 0;
                                x.setText("X _ " + xScore);
                                y.setText("O _ " + yScore);
                                JOptionPane.showMessageDialog(null, "X win", "Win", JOptionPane.WARNING_MESSAGE);
                                for (Button label : buttons) {
                                    label.setText("");
                                    label.setOnAction(this);
                                }
                                anchor.getChildren().remove(line);
                            }
                        }

                    } else {
                        button.setText("O");
                        xo = true;
                        if (check()) {
                            b = false;
                            end();
                            if (yScore == 2) {
                                xScore = 0;
                                yScore = 0;
                                x.setText("X _ " + xScore);
                                y.setText("O _ " + yScore);
                                JOptionPane.showMessageDialog(null, "O win", "Win", JOptionPane.WARNING_MESSAGE);
                                for (Button label : buttons) {
                                    label.setText("");
                                    label.setOnAction(this);
                                }
                                anchor.getChildren().remove(line);
                            }
                        }

                    }
                }
            }
        }
    }

    public boolean check() {
        if (label1.getText().equals(label5.getText()) && label1.getText().equals(label9.getText()) && !label1.getText().isEmpty()) {
            str = label1.getText();
            line = new Line();
            line.setStartX(label1.getLayoutX() + label1.getPrefWidth() / 2);
            line.setStartY(label1.getLayoutY() + label1.getPrefHeight() / 2);
            line.setEndX(label9.getLayoutX() + label9.getPrefWidth() / 2);
            line.setEndY(label9.getLayoutY() + label9.getPrefHeight() / 2);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label1.getLayoutX() + label1.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label1.getLayoutY() + label1.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            anchor.getChildren().add(line);
            return true;
        }
        if (label3.getText().equals(label5.getText()) && label3.getText().equals(label7.getText()) && !label3.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label3.getLayoutX() + label3.getPrefWidth() / 2);
            line.setStartY(label3.getLayoutY() + label3.getPrefHeight() / 2);
            line.setEndX(label7.getLayoutX() + label7.getPrefWidth() / 2);
            line.setEndY(label7.getLayoutY() + label7.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label3.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label3.getLayoutX() + label3.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label3.getLayoutY() + label3.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }
        if (label1.getText().equals(label2.getText()) && label1.getText().equals(label3.getText()) && !label1.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label1.getLayoutX() + label1.getPrefWidth() / 2);
            line.setStartY(label1.getLayoutY() + label1.getPrefHeight() / 2);
            line.setEndX(label3.getLayoutX() + label3.getPrefWidth() / 2);
            line.setEndY(label3.getLayoutY() + label3.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label1.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label1.getLayoutX() + label1.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label1.getLayoutY() + label1.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }
        if (label4.getText().equals(label5.getText()) && label5.getText().equals(label6.getText()) && !label4.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label4.getLayoutX() + label4.getPrefWidth() / 2);
            line.setStartY(label4.getLayoutY() + label4.getPrefHeight() / 2);
            line.setEndX(label6.getLayoutX() + label6.getPrefWidth() / 2);
            line.setEndY(label6.getLayoutY() + label6.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label4.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label4.getLayoutX() + label4.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label4.getLayoutY() + label4.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }
        if (label7.getText().equals(label8.getText()) && label7.getText().equals(label9.getText()) && !label7.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label7.getLayoutX() + label7.getPrefWidth() / 2);
            line.setStartY(label7.getLayoutY() + label7.getPrefHeight() / 2);
            line.setEndX(label9.getLayoutX() + label9.getPrefWidth() / 2);
            line.setEndY(label9.getLayoutY() + label9.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label7.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label7.getLayoutX() + label7.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label7.getLayoutY() + label7.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }
        if (label1.getText().equals(label4.getText()) && label1.getText().equals(label7.getText()) && !label1.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label1.getLayoutX() + label1.getPrefWidth() / 2);
            line.setStartY(label1.getLayoutY() + label1.getPrefHeight() / 2);
            line.setEndX(label7.getLayoutX() + label7.getPrefWidth() / 2);
            line.setEndY(label7.getLayoutY() + label7.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label1.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label1.getLayoutX() + label1.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label1.getLayoutY() + label1.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }
        if (label2.getText().equals(label5.getText()) && label2.getText().equals(label8.getText()) && !label2.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label2.getLayoutX() + label2.getPrefWidth() / 2);
            line.setStartY(label2.getLayoutY() + label2.getPrefHeight() / 2);
            line.setEndX(label8.getLayoutX() + label8.getPrefWidth() / 2);
            line.setEndY(label8.getLayoutY() + label8.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label2.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label2.getLayoutX() + label2.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label2.getLayoutY() + label2.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }
        if (label3.getText().equals(label6.getText()) && label3.getText().equals(label9.getText()) && !label3.getText().isEmpty()) {
            line = new Line();
            line.setStartX(label3.getLayoutX() + label3.getPrefWidth() / 2);
            line.setStartY(label3.getLayoutY() + label3.getPrefHeight() / 2);
            line.setEndX(label9.getLayoutX() + label9.getPrefWidth() / 2);
            line.setEndY(label9.getLayoutY() + label9.getPrefHeight() / 2);
            anchor.getChildren().add(line);
            str = label3.getText();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(line.endXProperty(), label3.getLayoutX() + label3.getPrefWidth() / 2),
                    new KeyValue(line.endYProperty(), label3.getLayoutY() + label3.getPrefHeight() / 2)));
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.play();
            return true;
        }

        return false;
    }

    public void end() {
        if (str.equals("X")) {
            xScore++;
        } else if (str.equals("O")) {
            yScore++;
        }
        x.setText("X _ " + xScore);
        y.setText("O _ " + yScore);
    }


}

