package myclasses;

import entity.Brand;
import entity.Sneaker;
import facade.SneakerFacade;
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

public class FXControllerEditingSneaker {
    
    private SneakerFacade sneakerFacade;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton EditPrice;

    @FXML
    private RadioButton EditQuantity;

    @FXML
    private RadioButton EditSize;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnReload;

    @FXML
    private AnchorPane dropDownEmpty;

    @FXML
    private RadioButton editFirm;

    @FXML
    private RadioButton editModel;

    @FXML
    private ListView<Sneaker> lsViewSneaker;

    @FXML
    private TextField txtFieldData;

    @FXML
    private Text txtFieldInfo;

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
    void changeScreenButtonPushedEditingUser(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleEditingUser.fxml"));
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

    public FXControllerEditingSneaker(){
    sneakerFacade = new SneakerFacade(Sneaker.class);
}
    int choice =0;
    
    @FXML
    void initialize() {
        txtFieldInfo.setVisible(false);
        ToggleGroup tg = new ToggleGroup();
        editFirm.setToggleGroup(tg);editModel.setToggleGroup(tg);
        EditPrice.setToggleGroup(tg);EditQuantity.setToggleGroup(tg);
        EditSize.setToggleGroup(tg);
        
        editFirm.setOnAction((event) -> {
          choice=1;  
        });
        editModel.setOnAction((event) -> {
          choice=2;  
        });
        EditSize.setOnAction((event) -> {
          choice=3;  
        });
        EditPrice.setOnAction((event) -> {
          choice=4;  
        });
        EditQuantity.setOnAction((event) -> {
          choice=5;  
        });
        
        btnReload.setOnAction((event) -> {
            lsViewSneaker.getItems().clear();
            List<Sneaker> sneakers = sneakerFacade.findAll();
            for (int i = 0; i < sneakers.size(); i++) {
                lsViewSneaker.getItems().addAll(sneakers.get(i));
            }
            btnReload.setVisible(false);
            txtFieldInfo.setVisible(false);
            txtFieldData.setText("");
        });
        
        btnEdit.setOnAction((event) -> {
            try {  
            long numsneaker=lsViewSneaker.getSelectionModel().getSelectedItem().getId();
            Sneaker sneakers= sneakerFacade.find(numsneaker);
            int numchange= choice;
            switch(numchange){
                case 1:
                    System.out.print("Заглушка");
                    break;
                case 2:
                    sneakers.setSneakerModel(txtFieldData.getText());
                    sneakerFacade.edit(sneakers);
                    btnReload.setVisible(true);
                    txtFieldInfo.setText("Вы изменили данные!");
                    txtFieldInfo.setVisible(true);
                    break;
                case 3:
                    sneakers.setSneakerSize(Integer.parseInt(txtFieldData.getText()));
                    sneakerFacade.edit(sneakers);
                    btnReload.setVisible(true);
                    txtFieldInfo.setText("Вы изменили данные!");
                    txtFieldInfo.setVisible(true);
                    break;
                case 4:
                    sneakers.setSneakerPrice(Integer.parseInt(txtFieldData.getText()));
                    sneakerFacade.edit(sneakers);
                    btnReload.setVisible(true);
                    txtFieldInfo.setText("Вы изменили данные!");
                    txtFieldInfo.setVisible(true);
                    break;
                case 5:                  
                    sneakers.setSneakerQuantity(Integer.parseInt(txtFieldData.getText()));
                    sneakerFacade.edit(sneakers);
                    btnReload.setVisible(true);
                    txtFieldInfo.setText("Вы изменили данные!");
                    txtFieldInfo.setVisible(true);
                    break;
                default:
                    break;
            }
            } catch (Exception e) {
                txtFieldInfo.setText("Некоректный ввод данных или выберите фирму!");
                 txtFieldInfo.setVisible(true);
            }
        });
    }

}
