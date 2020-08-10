package eightluoke;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Optional;
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
    private long start1;
    private long start2;
    private long start3;
    private long start4;
    private long start5;
    @FXML
    public void onButtonClick1(ActionEvent evet){
        onBUttonCLick(btn1,flag1,startTime1,endTime1,consumptionTime1,otherCunsum1,total1,Utils.one,1);
    }
    @FXML
    public void onButtonClick2(ActionEvent evet){
        onBUttonCLick(btn2,flag2,startTime2,endTime2,consumptionTime2,otherCunsum2,total2,Utils.two,2);
    }
    @FXML
    public void onButtonClick3(ActionEvent evet){
        onBUttonCLick(btn3,flag3,startTime3,endTime3,consumptionTime3,otherCunsum3,total3,Utils.three,3);
    }
    @FXML
    public void onButtonClick4(ActionEvent evet){
        onBUttonCLick(btn4,flag4,startTime4,endTime4,consumptionTime4,otherCunsum4,total4,Utils.four,4);
    }
    @FXML
    public void onButtonClick5(ActionEvent evet){
        onBUttonCLick(btn5,flag5,startTime5,endTime5,consumptionTime5,otherCunsum5,total5,Utils.five,5);
    }
    private void onBUttonCLick(Button btn,Label flag,TextField startTime,TextField endTime,Label consumptionTime,TextField otherCunsum,Label total,int price,int btnNum){
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        if(btn.getText().equals("开始计费")){
            if(confirDialog("张哥哥","是否开始计费?")){
                switch (btnNum){
                    case 1:
                        start1=System.currentTimeMillis();
                        startTime.setText(sdf.format(start1));
                        break;
                    case 2:
                        start2=System.currentTimeMillis();
                        startTime.setText(sdf.format(start2));
                        break;
                    case 3:
                        start3=System.currentTimeMillis();
                        startTime.setText(sdf.format(start3));
                        break;
                    case 4:
                        start4=System.currentTimeMillis();
                        startTime.setText(sdf.format(start4));
                        break;
                    case 5:
                        start5=System.currentTimeMillis();
                        startTime.setText(sdf.format(start5));
                        break;
                    default:break;
                }
                endTime.setText("");
                consumptionTime.setText("");
                flag.setText("正在计费...");
                flag.setStyle("-fx-background-color:red");
                btn.setText("结束计费");
                total.setText("0元");
                otherCunsum.setText("");
            }
        }else {
            if(confirDialog("张哥哥","是否确认结帐?")){
                long end=System.currentTimeMillis();
                endTime.setText(sdf.format(end));
                BigDecimal bd = null;
                switch (btnNum) {
                    case 1 :
                        bd=getConsumptionTime(new BigDecimal(end - start1));
                        break;
                    case 2 :
                        bd=getConsumptionTime(new BigDecimal(end - start2));
                        break;
                    case 3 :
                        bd=getConsumptionTime(new BigDecimal(end - start3));
                        break;
                    case 4 :
                        bd=getConsumptionTime(new BigDecimal(end - start4));
                        break;
                    case 5 :
                        bd=getConsumptionTime(new BigDecimal(end - start5));
                        break;
                    default: break;
                };
                String num=otherCunsum.getText();
                if(num.equals(""))  num="0";
                assert bd != null;
                BigDecimal totalMoney=new BigDecimal(Integer.parseInt(num)).add(bd.multiply(new BigDecimal(price)));
                total.setText(totalMoney.toString()+"元");
                consumptionTime.setText(bd.toString()+"小时");
                flag.setText("空闲中...");
                flag.setStyle("-fx-background-color:greenyellow");
                btn.setText("开始计费");
            }
        }
    }
    private BigDecimal getConsumptionTime(BigDecimal consumptionTime){
        return consumptionTime.divide(new BigDecimal(3600000),2, RoundingMode.UP);
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
        String path=System.getProperty("user.dir");
        URL url=new URL("file:"+path+"/resource/edit.fxml");
        Parent edit = FXMLLoader.load(url);
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
    public boolean confirDialog(String header,String message){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,message,new ButtonType("是", ButtonBar.ButtonData.YES),
                new ButtonType("否", ButtonBar.ButtonData.NO));
        alert.setTitle("提示");
        alert.setHeaderText(header);
        Optional<ButtonType> buttonType=alert.showAndWait();
        return buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES);
    }
}
