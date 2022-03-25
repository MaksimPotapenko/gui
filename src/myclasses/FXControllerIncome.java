package myclasses;

import entity.Brand;
import entity.Buyer;
import entity.History;
import entity.Sneaker;
import facade.BrandFacade;
import facade.BuyerFacade;
import facade.HistoryFacade;
import facade.SneakerFacade;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXControllerIncome {
    private HistoryFacade historyFacade;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void changeScreenButtonPushedBuy(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleBuy.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void changeScreenButtonPushedEditingSneaker(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleEditingSneaker.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void changeScreenButtonPushedEditingUser(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleEditingUser.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void changeScreenButtonPushedMoney(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleMoney.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void changeScreenButtonPushedReceipt(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleReceipt.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void changeScreenButtonPushedUser(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleUser.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    
    @FXML
    private RadioButton allTime;

    @FXML
    private RadioButton apr;

    @FXML
    private RadioButton august;

    @FXML
    private Button btnShowInc;

    @FXML
    private RadioButton dec;

    @FXML
    private AnchorPane dropDownEmpty;

    @FXML
    private RadioButton feb;

    @FXML
    private RadioButton jan;

    @FXML
    private RadioButton july;

    @FXML
    private RadioButton june;

    @FXML
    private RadioButton mar;

    @FXML
    private RadioButton may;

    @FXML
    private RadioButton nov;
    
    @FXML
    private Text txt;

    @FXML
    private RadioButton oct;

    @FXML
    private RadioButton sep;

    @FXML
    private Text txtInfoInc;

    @FXML
    private TextField year;
    
    int choice=0;
    
    public FXControllerIncome(){
      historyFacade = new HistoryFacade(History.class);
    }  

    @FXML
    void initialize() { 
        year.setPromptText("Введите год!");
        txt.setVisible(false);
        year.textProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue.matches("\\d*")) return;
        year.setText(newValue.replaceAll("[^\\d]", ""));
        });
        
        ToggleGroup tg = new ToggleGroup();
        jan.setToggleGroup(tg);feb.setToggleGroup(tg);mar.setToggleGroup(tg);
        apr.setToggleGroup(tg);may.setToggleGroup(tg);june.setToggleGroup(tg);
        july.setToggleGroup(tg);august.setToggleGroup(tg);sep.setToggleGroup(tg);
        oct.setToggleGroup(tg);nov.setToggleGroup(tg);dec.setToggleGroup(tg);
        allTime.setToggleGroup(tg);
        jan.setOnAction((event) -> {
            choice=1;
            year.setEditable(true);
        });
        feb.setOnAction((event) -> {
            choice=2;
            year.setEditable(true);
        });
        mar.setOnAction((event) -> {
            choice=3;
            year.setEditable(true);
        });
        apr.setOnAction((event) -> {
            choice=4;
            year.setEditable(true);
        });
        may.setOnAction((event) -> {
            choice=5;
            year.setEditable(true);
        });
        june.setOnAction((event) -> {
            choice=6;
            year.setEditable(true);
        });
        july.setOnAction((event) -> {
            choice=7;
            year.setEditable(true);
        });
        august.setOnAction((event) -> {
            choice=8;
            year.setEditable(true);
        });
        sep.setOnAction((event) -> {
            choice=9;
            year.setEditable(true);
        });
        oct.setOnAction((event) -> {
            choice=10;
            year.setEditable(true);
        });
        nov.setOnAction((event) -> {
            choice=11;
            year.setEditable(true);
        });
        dec.setOnAction((event) -> {
            choice=12;
            year.setEditable(true);
        });
        allTime.setOnAction((event) -> {
            choice=13;
            year.setText("");
            year.setEditable(false);
        });
        btnShowInc.setOnAction((event) -> {
        if(txtInfoInc.getText()!=null){
        try {
            double income = 0;
            List<History> histories= historyFacade.findAll();
            int choicemonth=choice;
            switch(choicemonth){
                case 13:
                   income();
                   break;
                default:      
            int years=Integer.parseInt(year.getText());
            for (int i = 0; i < histories.size(); i++) {
                Date date = histories.get(i).getGivenSneaker();
                boolean toSum = summator(date, choicemonth-1, years);
                if (histories.get(i)!=null & toSum) {
                   income+=histories.get(i).getSneaker().getSneakerPrice();
                }

            }
            String income1=Double.toString(income);
            txt.setVisible(true);
            txtInfoInc.setText(income1);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }  
        }
            });
    }
        

        private boolean summator(Date date, int choicemonth, int years) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            if(month==choicemonth && year==years){
                return true;
        }
            return false;
        }
        private void income(){
        double income = 0;
        List<History> histories = historyFacade.findAll();
        System.out.println("*ОБЩИЙ ДОХОД*");
        for (int i = 0; i < histories.size(); i++) {
            Date date = histories.get(i).getGivenSneaker();
            if (histories.get(i)!=null) {
               income+=histories.get(i).getSneaker().getSneakerPrice();
            }

        }
        String income1=Double.toString(income);
        txt.setVisible(true);
        txtInfoInc.setText(income1);
        
}
}
