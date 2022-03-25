package myclasses;

import entity.Buyer;
import entity.Sneaker;
import facade.BuyerFacade;
import facade.SneakerFacade;
import facade.UserFacade;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXControllerEditingUser {
    
    private BuyerFacade buyerFacade;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton EditMoney;

    @FXML
    private RadioButton EditPhone;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnReload;

    @FXML
    private AnchorPane dropPhone;

    @FXML
    private RadioButton editLast;

    @FXML
    private RadioButton editName;

    @FXML
    private ListView<Buyer> lsViewUser;

    @FXML
    private TextField txtFieldData;

    @FXML
    private Text txtFieldInfo;
    
    public FXControllerEditingUser(){
    buyerFacade = new BuyerFacade(Buyer.class);
}

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
    void changeScreenButtonPushedIncome(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleIncome.fxml"));
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

    int choice=0;
    
    @FXML
    void initialize() {
        txtFieldInfo.setVisible(false);
        btnReload.setOnAction((event) -> {
            lsViewUser.getItems().clear();
            List<Buyer> buyers = buyerFacade.findAll();
            for (int i = 0; i < buyers.size(); i++) {
                lsViewUser.getItems().addAll(buyers.get(i));
            }
            btnReload.setVisible(false);
            txtFieldData.setText("");
            txtFieldInfo.setVisible(false);
        });
        
        ToggleGroup tg = new ToggleGroup();
        editName.setToggleGroup(tg);editLast.setToggleGroup(tg);
        EditMoney.setToggleGroup(tg);EditPhone.setToggleGroup(tg);
        
        editName.setOnAction((event) -> {
          choice=1;  
        });
        editLast.setOnAction((event) -> {
          choice=2;  
        });
        EditPhone.setOnAction((event) -> {
          choice=3;  
        });
        EditMoney.setOnAction((event) -> {
          choice=4;  
        });
       
        btnEdit.setOnAction((event) -> {
            try {
                long num=lsViewUser.getSelectionModel().getSelectedItem().getId();
                Buyer buyers = buyerFacade.find(num);
                int numchange=choice;
                switch(numchange){
                    case 1:
                        buyers.setBuyerFirstName(txtFieldData.getText());
                        buyerFacade.edit(buyers);
                        txtFieldInfo.setVisible(true);
                        txtFieldInfo.setText("Вы изменили данные!");
                        btnReload.setVisible(true);
                        break;
                    case 2:
                        buyers.setBuyerLastName(txtFieldData.getText());
                        buyerFacade.edit(buyers);
                        txtFieldInfo.setVisible(true);
                        txtFieldInfo.setText("Вы изменили данные!");
                        btnReload.setVisible(true);
                        break;
                    case 3:
                        buyers.setBuyerPhone(txtFieldData.getText());
                        buyerFacade.edit(buyers);
                        txtFieldInfo.setVisible(true);
                        txtFieldInfo.setText("Вы изменили данные!");
                        btnReload.setVisible(true);
                        break;
                    case 4:
                        buyers.setBuyerMoney(Double.parseDouble(txtFieldData.getText()));
                        buyerFacade.edit(buyers);
                        txtFieldInfo.setVisible(true);
                        txtFieldInfo.setText("Вы изменили данные!");
                        btnReload.setVisible(true);
                        break;
                    default:
                        System.out.println("Ошибка, выберите номер из списка!");
                        break;
                }
            } catch (Exception e) {
                txtFieldInfo.setVisible(true);
                txtFieldInfo.setText("Неверный ввод данных или выберите покупателя!");
            }
        });
    }

}
