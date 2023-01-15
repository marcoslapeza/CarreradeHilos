package com.example.carreradehilos;

import javafx.application.Platform;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HelloController {


    @FXML
    private ProgressBar progresoHilo1;
    @FXML
    private Slider pHilo1;
    @FXML
    private ProgressBar progresoHilo2;
    @FXML
    private Slider pHijo2;
    @FXML
    private ProgressBar progresoHilo3;
    @FXML
    private Slider pHilo3;

    public void initialize(){
        pHilo1.setShowTickLabels(true);
        pHilo1.setMin(1);
        pHilo1.setMax(10);
        pHilo1.setMajorTickUnit(1);
        pHilo1.valueProperty().addListener((obs,oldVal,newVal)->{
            pHilo1.setValue(Math.round(newVal.doubleValue()));
        });

        pHijo2.setShowTickLabels(true);
        pHijo2.setMin(1);
        pHijo2.setMax(10);
        pHijo2.setMajorTickUnit(1);
        pHijo2.valueProperty().addListener((obs,oldVal,newVal)->{
            pHijo2.setValue(Math.round(newVal.doubleValue()));
        });

        pHilo3.setShowTickLabels(true);
        pHilo3.setMin(1);
        pHilo3.setMax(10);
        pHilo3.setMajorTickUnit(1);
        pHilo3.valueProperty().addListener((obs,oldVal,newVal)->{
            pHilo3.setValue(Math.round(newVal.doubleValue()));
        });

        progresoHilo1.setProgress(0);
        progresoHilo2.setProgress(0);
        progresoHilo3.setProgress(0);

        bindProgressToField(progresoHilo1);
        bindProgressToField(progresoHilo2);
        bindProgressToField(progresoHilo3);
    }

    private void bindProgressToField(ProgressBar bar){
        IntegerProperty h1 = new SimpleIntegerProperty();
        h1.bind(bar.progressProperty().multiply(100));

    }

    public void iniciar(ActionEvent event) {
        Carrera c1 = new Carrera(progresoHilo1,pHilo1);
        Carrera c2 = new Carrera(progresoHilo2,pHijo2);
        Carrera c3 = new Carrera(progresoHilo3,pHilo3);

        c3.start();
        c2.start();
        c1.start();
    }
}