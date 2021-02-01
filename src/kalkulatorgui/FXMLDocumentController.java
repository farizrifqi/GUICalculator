/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatorgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.fxml.FXML;

/**
 *
 * @author Refri
 */
public class FXMLDocumentController implements Initializable {
    
    private String isiKolomgAngka="";
    private String[] pecah;
    private double hitung1 = 0, hitung2=0, hasilHitung=0;
    private int operate;
    private boolean start=true, operateAble=true, operateLock=false;
    
    @FXML
    private JFXTextField kolomAngka;

    @FXML
    private JFXButton angka1;

    @FXML
    private JFXButton angka2;

    @FXML
    private JFXButton angka3;

    @FXML
    private JFXButton angka4;

    @FXML
    private JFXButton angka5;

    @FXML
    private JFXButton angka6;

    @FXML
    private JFXButton angka7;

    @FXML
    private JFXButton angka8;

    @FXML
    private JFXButton angka9;

    @FXML
    private JFXButton c;

    @FXML
    private JFXButton tambah;

    @FXML
    private JFXButton kurang;

    @FXML
    private JFXButton bagi;

    @FXML
    private JFXButton kali;

    @FXML
    private JFXButton hasil;

    @FXML
    private JFXButton nol;

    @FXML
    private JFXButton koma;
    
    @FXML
    private JFXButton faktorial;
    
    @FXML
    private JFXButton duaNol;
    
    @FXML
    private void aksiKoma(ActionEvent event) {
        isiKolomgAngka += ".";
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
        disableOperateButton(true);       
    }    
    
    @FXML
    private void angka1Aksi(ActionEvent event) {
        isiKolomgAngka += angka1.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
        
    }
    
    @FXML
    private void angka2Aksi(ActionEvent event) {
        isiKolomgAngka += angka2.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();    
    }
    
    @FXML
    private void angka3Aksi(ActionEvent event) {
        isiKolomgAngka += angka3.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck(); 
    }
    
    @FXML
    private void angka4Aksi(ActionEvent event) {
        isiKolomgAngka += angka4.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
    }
    @FXML
    private void angka5Aksi(ActionEvent event) {
        isiKolomgAngka += angka5.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
    }
    @FXML
    private void angka6Aksi(ActionEvent event) {
        isiKolomgAngka += angka6.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck(); 
    }
    @FXML
    private void angka7Aksi(ActionEvent event) {
        isiKolomgAngka += angka7.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck(); 
    }
    @FXML
    private void angka8Aksi(ActionEvent event) {
        isiKolomgAngka += angka8.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
    }
    @FXML
    private void angka9Aksi(ActionEvent event) {
        isiKolomgAngka += angka9.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
    }
    @FXML
    private void aksiC(ActionEvent event) {
        isiKolomgAngka = "";
        hitung1 = 0;
        hitung2 = 0;
        hasilHitung = 0;
        operateAble = false;
        operateLock = false;
        doCheck();
        operateAble = true;
        kolomAngka.setText(isiKolomgAngka);
    }
    @FXML
    private void aksiTambah(ActionEvent event) {        
        isiKolomgAngka += "+";
        kolomAngka.setText(isiKolomgAngka);
        operate=1;
        disableOperateButton(true);
        hasil.setDisable(true);
        operateLock = true;
    }
    @FXML
    private void aksiBagi(ActionEvent event) {
        isiKolomgAngka += "/";
        kolomAngka.setText(isiKolomgAngka);
        operate = 4;
        disableOperateButton(true);
        hasil.setDisable(true);
        operateLock = true;
    }
    @FXML
    private void aksiKali(ActionEvent event) {
        isiKolomgAngka += "x";
        kolomAngka.setText(isiKolomgAngka);
        operate = 3;
        disableOperateButton(true);
        hasil.setDisable(true);
        operateLock = true;
    }
    @FXML
    private void aksiKurang(ActionEvent event) {
        isiKolomgAngka += "-";
        kolomAngka.setText(isiKolomgAngka);
        operate = 2;
        disableOperateButton(true);
        hasil.setDisable(true);
        operateLock = true;
    }
    @FXML
    private void aksiHasil(ActionEvent event) {
        hitung(operate);
        disableOperateButton(false);
        hasil.setDisable(true);
        operateLock = false;
        operateAble = true;
        doCheck();
    }
    
    @FXML
    private void aksiNol(ActionEvent event) {
        isiKolomgAngka += nol.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
    }
    @FXML
    private void aksiDuaNol(ActionEvent event) {
        isiKolomgAngka += duaNol.getText();
        kolomAngka.setText(isiKolomgAngka);
        doCheck();
    }
    @FXML
    private void aksiFaktorial(ActionEvent event){
        isiKolomgAngka = Integer.toString(faktorial(Integer.parseInt(isiKolomgAngka)));
        kolomAngka.setText(isiKolomgAngka);
        disableOperateButton(false);
        hasil.setDisable(true);
        operateLock = false;
        operateAble = true;
        doCheck();
    }
    private void disableOperateButton(boolean x){
        if (x){
            bagi.setDisable(true);
            kali.setDisable(true);
            tambah.setDisable(true);
            kurang.setDisable(true);
            faktorial.setDisable(true);
        }else{
            bagi.setDisable(false);
            kali.setDisable(false);
            tambah.setDisable(false);
            kurang.setDisable(false);
            faktorial.setDisable(false);
        }        
    }
    private void hitung(int x){
        switch(x){
            case 1:
                pecah = isiKolomgAngka.split("\\+");
                hitung1 = Double.parseDouble(pecah[0]);
                hitung2 = Double.parseDouble(pecah[1]);
                hasilHitung = hitung1+hitung2;
                isiKolomgAngka = Double.toString(hasilHitung);
                kolomAngka.setText(isiKolomgAngka);
                break;
            case 2:
                pecah = isiKolomgAngka.split("-"); 
                hitung1 = Double.parseDouble(pecah[0]);
                hitung2 = Double.parseDouble(pecah[1]);
                hasilHitung = hitung1-hitung2;
                isiKolomgAngka = Double.toString(hasilHitung);
                kolomAngka.setText(isiKolomgAngka);
                break;
            case 3:
                pecah = isiKolomgAngka.split("x");  
                hitung1 = Double.parseDouble(pecah[0]);
                hitung2 = Double.parseDouble(pecah[1]);
                hasilHitung = hitung1*hitung2;
                isiKolomgAngka = Double.toString(hasilHitung);
                kolomAngka.setText(isiKolomgAngka);
                break;
            case 4:
                pecah = isiKolomgAngka.split("/");
                hitung1 = Double.parseDouble(pecah[0]);
                hitung2 = Double.parseDouble(pecah[1]);
                hasilHitung = hitung1/hitung2;
                isiKolomgAngka = Double.toString(hasilHitung);
                kolomAngka.setText(isiKolomgAngka);
                break;
                
        }
        XStream xstream = new XStream(new StaxDriver());
    }
    
    private void doCheck(){
        if (!operateLock){
            if(operateAble){
                disableOperateButton(false);
                c.setDisable(false);
                koma.setDisable(false);
            }else{
                disableOperateButton(true);
                koma.setDisable(false);
            }
        }else{
            disableOperateButton(true);
            hasil.setDisable(false);
            
            
        }
    }
    private static int faktorial(int n){    
        if (n == 0) {   
          return 1;   
        }
        else{    
          return(n * faktorial(n-1));    
        }
    }  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
