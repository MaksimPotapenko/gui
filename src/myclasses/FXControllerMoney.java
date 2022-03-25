package myclasses;

import entity.Buyer;
import facade.BuyerFacade;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXControllerMoney {
    private BuyerFacade buyerFacade;
    
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
    void changeScreenButtonPushedIncome(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleIncome.fxml"));
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
    private Button btnAddUser;

    @FXML
    private Button btnReload;

    @FXML
    private AnchorPane dropDownEmpty;

    @FXML
    private ListView<Buyer> lsViewUser;

    @FXML
    private Text txtFieldAddSneakerInfo;

    @FXML
    private TextField txtFieldMoney;
    
    public FXControllerMoney(){
      buyerFacade = new BuyerFacade(Buyer.class);
    }
    
    @FXML
    void initialize() {
        txtFieldAddSneakerInfo.setVisible(false);
        btnReload.setOnAction((event) -> {
            txtFieldAddSneakerInfo.setVisible(false);
            lsViewUser.getItems().clear();
            btnReload.setVisible(false);
            List<Buyer> buyers = buyerFacade.findAll();
            for (int i = 0; i < buyers.size(); i++) {
            lsViewUser.getItems().addAll(buyers.get(i));
            }
        });
        btnAddUser.setOnAction((event) -> {
            try {    
            long choice=lsViewUser.getSelectionModel().getSelectedItem().getId();
            Buyer buyer = buyerFacade.find(choice);
            double add=Double.parseDouble(txtFieldMoney.getText());
            buyer.setBuyerMoney(buyer.getBuyerMoney()+add);
            buyerFacade.edit(buyer);
            btnReload.setVisible(true);
            txtFieldAddSneakerInfo.setVisible(true);
            txtFieldAddSneakerInfo.setText("Вы добавили деньги покупателю!");
            } catch (Exception e) {
                System.out.println("Ошибка!");
                txtFieldAddSneakerInfo.setVisible(true);
                txtFieldAddSneakerInfo.setText("Что-то пошло не так!");
            }
        });
    }

}
