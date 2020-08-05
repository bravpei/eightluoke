package eightluoke;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private  Label table1;
    @FXML
    private  Label table2;
    @FXML
    private  Label table3;
    @FXML
    private  Label table4;
    @FXML
    private  Label table5;
    @FXML
    private Label flag1;
    @FXML
    private Label flag2;
    @FXML
    private Label flag3;
    @FXML
    private Label flag4;
    @FXML
    private Label flag5;
    @FXML
    private TextField startTime1;
    @FXML
    private TextField startTime2;
    @FXML
    private TextField startTime3;
    @FXML
    private TextField startTime4;
    @FXML
    private TextField startTime5;
    @FXML
    private TextField endTime1;
    @FXML
    private TextField endTime2;
    @FXML
    private TextField endTime3;
    @FXML
    private TextField endTime4;
    @FXML
    private TextField endTime5;
    @FXML
    private Label consumptionTime1;
    @FXML
    private Label consumptionTime2;
    @FXML
    private Label consumptionTime3;
    @FXML
    private Label consumptionTime4;
    @FXML
    private Label consumptionTime5;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private TextField otherCunsum1;
    @FXML
    private TextField otherCunsum2;
    @FXML
    private TextField otherCunsum3;
    @FXML
    private TextField otherCunsum4;
    @FXML
    private TextField otherCunsum5;
    @FXML
    private Label total1;
    @FXML
    private Label total2;
    @FXML
    private Label total3;
    @FXML
    private Label total4;
    @FXML
    private Label total5;
    @FXML
    public void onButtonClick1(ActionEvent evet){
        onBUttonCLick(btn1,flag1,startTime1,endTime1,consumptionTime1,otherCunsum1,total1,Utils.one);
    }
    @FXML
    public void onButtonClick2(ActionEvent evet){
        onBUttonCLick(btn2,flag2,startTime2,endTime2,consumptionTime2,otherCunsum2,total2,Utils.two);
    }
    @FXML
    public void onButtonClick3(ActionEvent evet){
        onBUttonCLick(btn3,flag3,startTime3,endTime3,consumptionTime3,otherCunsum3,total3,Utils.three);
    }
    @FXML
    public void onButtonClick4(ActionEvent evet){
        onBUttonCLick(btn4,flag4,startTime4,endTime4,consumptionTime4,otherCunsum4,total4,Utils.four);
    }
    @FXML
    public void onButtonClick5(ActionEvent evet){
        onBUttonCLick(btn5,flag5,startTime5,endTime5,consumptionTime5,otherCunsum5,total5,Utils.five);
    }
    private void onBUttonCLick(Button btn,Label flag,TextField startTime,TextField endTime,Label consumptionTime,TextField otherCunsum,Label total,int price){
        if(btn.getText().equals("开始计费")){
            startTime.setText(getCurrentTime());
            endTime.setText(" ");
            consumptionTime.setText(" ");
            flag.setText("正在计费...");
            flag.setStyle("-fx-background-color:red");
            btn.setText("结束计费");
            total.setText("0元");
            otherCunsum.setText("");
        }else {
            endTime.setText(getCurrentTime());
            BigDecimal bd=getConsumptionTime(startTime,endTime);
            String num=otherCunsum.getText();
            if(num.equals(""))  num="0";
            BigDecimal abs=bd.multiply(new BigDecimal(price));
            BigDecimal totalMoney=abs.add(new BigDecimal(Integer.parseInt(num)));
            total.setText(totalMoney.toString()+"元");
            consumptionTime.setText(bd.toString()+"小时");
            flag.setText("空闲中...");
            flag.setStyle("-fx-background-color:greenyellow");
            btn.setText("开始计费");
        }
    }
    private String getCurrentTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        Long timemillis=System.currentTimeMillis();
        return sdf.format(timemillis);
    }
    private BigDecimal getConsumptionTime(TextField startTime,TextField endTime){
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        Long consumptionTime=null;
        try{
           consumptionTime=sdf.parse(endTime.getText()).getTime()-sdf.parse(startTime.getText()).getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        Double s=3600000.00;
        return new BigDecimal(consumptionTime/s).setScale(2, RoundingMode.UP);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        flag1.setStyle("-fx-background-color:greenyellow");
        table1.setText("1号桌("+Utils.one+"元/小时)");

        flag2.setStyle("-fx-background-color:greenyellow");
        table2.setText("2号桌("+Utils.two+"元/小时)");

        flag3.setStyle("-fx-background-color:greenyellow");
        table3.setText("3号桌("+Utils.three+"元/小时)");

        flag4.setStyle("-fx-background-color:greenyellow");
        table4.setText("4号桌("+Utils.four+"元/小时)");

        flag5.setStyle("-fx-background-color:greenyellow");
        table5.setText("5号桌("+Utils.five+"元/小时)");
    }
    @FXML
    public void numOnly(){
        Utils.numOnly(otherCunsum1);
        Utils.numOnly(otherCunsum2);
        Utils.numOnly(otherCunsum3);
        Utils.numOnly(otherCunsum4);
        Utils.numOnly(otherCunsum5);
    }
    @FXML
    public void newPage() throws IOException {
        Parent edit = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Stage editStage = new Stage();
        editStage.setTitle("费率修改");
        //关闭最大化和最小化按键
        editStage.initStyle(StageStyle.UTILITY);
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.setScene(new Scene(edit,250,300));
        editStage.showAndWait();
        setTable();
    }
    public  void setTable(){
        table1.setText("1号桌("+Utils.one+"元/小时)");
        table2.setText("2号桌("+Utils.two+"元/小时)");
        table3.setText("3号桌("+Utils.three+"元/小时)");
        table4.setText("4号桌("+Utils.four+"元/小时)");
        table5.setText("5号桌("+Utils.five+"元/小时)");
    }
}
