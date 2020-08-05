package eightluoke;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class EditCotroller implements Initializable {
    @FXML
    private TextField tableOne;
    @FXML
    private TextField tableTwo;
    @FXML
    private TextField tableThree;
    @FXML
    private TextField tableFour;
    @FXML
    private TextField tableFive;
    @FXML
    private Button confirm;
    @FXML
    private Button cancle;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        tableOne.setText(String.valueOf(Utils.one));
        tableTwo.setText(String.valueOf(Utils.two));
        tableThree.setText(String.valueOf(Utils.three));
        tableFour.setText(String.valueOf(Utils.four));
        tableFive.setText(String.valueOf(Utils.five));
        Utils.numOnly(tableOne);
        Utils.numOnly(tableTwo);
        Utils.numOnly(tableThree);
        Utils.numOnly(tableFour);
        Utils.numOnly(tableFive);
    }
    @FXML
    public void onClick(ActionEvent event){
        Utils.one=Integer.parseInt(tableOne.getText());
        Utils.two=Integer.parseInt(tableTwo.getText());
        Utils.three=Integer.parseInt(tableThree.getText());
        Utils.four=Integer.parseInt(tableFour.getText());
        Utils.five=Integer.parseInt(tableFive.getText());
        Utils.setConfig();
        Stage stage= (Stage) confirm.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void cancle(ActionEvent event){
        Stage stage= (Stage) cancle.getScene().getWindow();
        stage.close();
    }
}
