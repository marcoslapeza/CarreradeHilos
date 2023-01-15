package com.example.carreradehilos;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Carrera extends Thread{

    private ProgressBar progressBar;
    private Slider slider;
    private Double progreso;
    public Carrera(ProgressBar progressBar, Slider slider){
        this.progressBar = progressBar;
        this.slider = slider;
        progreso = 0.0;
    }

    @Override
    public void run() {
        do{
            this.setPriority((int)slider.getValue());
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(progreso);
                }
            });
            getPrimos(1000000);
            progreso = BigDecimal.valueOf(progreso + 0.01).setScale(3, RoundingMode.HALF_UP).doubleValue();
        }while(progreso<1000);
    }

    public void getPrimos(int hasta){
        for(int i=1; i < hasta; i++){
            if(esPrimo(i)){
            }
        }
    }

    public boolean esPrimo(int a){
        boolean res = true;
        for(int i=2;i <= Math.sqrt(a) && res;i++){
            if(a%i == 0){
                res = false;
            }
        }
        return res;
    }
}
