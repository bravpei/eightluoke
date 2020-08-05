package eightluoke;

import javafx.scene.control.TextField;

import java.io.*;

public class Utils {
    public static int one=0;
    public static int two=0;
    public static int three=0;
    public static int four=0;
    public static int five=0;
    public  Utils(){
        config();
    }
    public static void numOnly(TextField textField){
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
    public  void config(){
        File conf=new File("./eightluokeConfig");
        if(!conf.exists()){
            try {
                conf.createNewFile();
                FileWriter fw=new FileWriter(conf,true);
                fw.write(String.valueOf(one));
                fw.write(System.lineSeparator());
                fw.write(String.valueOf(two));
                fw.write(System.lineSeparator());
                fw.write(String.valueOf(three));
                fw.write(System.lineSeparator());
                fw.write(String.valueOf(four));
                fw.write(System.lineSeparator());
                fw.write(String.valueOf(five));
                fw.close();
                System.out.println("创建文件完毕");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            String[] arr=new String[6];
            try {
                BufferedReader br=new BufferedReader(new FileReader(conf));
                int i=0;
                while((arr[i]=br.readLine())!=null){
                    i++;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert arr[0] != null;
            one=Integer.parseInt(arr[0]);
            two=Integer.parseInt(arr[1]);
            three=Integer.parseInt(arr[2]);
            four=Integer.parseInt(arr[3]);
            five=Integer.parseInt(arr[4]);
        }
    }
    public static void setConfig(){
        File conf=new File("./eightluokeConfig");
        FileWriter fw= null;
        try {
            fw=new FileWriter(conf);
            fw.write("");
            fw.flush();
            fw.close();
            fw = new FileWriter(conf,true);
            fw.write(String.valueOf(one));
            fw.write(System.lineSeparator());
            fw.write(String.valueOf(two));
            fw.write(System.lineSeparator());
            fw.write(String.valueOf(three));
            fw.write(System.lineSeparator());
            fw.write(String.valueOf(four));
            fw.write(System.lineSeparator());
            fw.write(String.valueOf(five));
            fw.close();
            System.out.println("更新文件完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
