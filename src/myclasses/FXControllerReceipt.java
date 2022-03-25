package myclasses;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXControllerReceipt {
    
    private SneakerFacade sneakerFacade;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddSneaker;

    @FXML
    private Button btnReload;

    @FXML
    private ListView<Sneaker> lsViewSneaker;

    @FXML
    private Text txtFieldInfo;

    @FXML
    private TextField txtFieldQuantity;

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
    void changeScreenButtonPushedEditingUser(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/myclasses/sampleEditingUser.fxml"));
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
    
    public FXControllerReceipt(){
    sneakerFacade = new SneakerFacade(Sneaker.class);
    }
    
    @FXML
    void initialize() {
        txtFieldInfo.setVisible(false);
        
        txtFieldQuantity.textProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue.matches("\\d*")) return;
        txtFieldQuantity.setText(newValue.replaceAll("[^\\d]", ""));  
        });
        
        btnReload.setOnAction((event) -> {
            lsViewSneaker.getItems().clear();
            List<Sneaker> sneakers = sneakerFacade.findAll();
            for (int i = 0; i < sneakers.size(); i++) {
                lsViewSneaker.getItems().addAll(sneakers.get(i));
            }
            btnReload.setVisible(false);
            txtFieldInfo.setVisible(false);
            txtFieldQuantity.setText("");
        });
        
        btnAddSneaker.setOnAction((event) -> {
            try {    
            long num= lsViewSneaker.getSelectionModel().getSelectedItem().getId();
            Sneaker sneaker = sneakerFacade.find(num);
            int add=Integer.parseInt(txtFieldQuantity.getText());
            sneaker.setSneakerQuantity(sneaker.getSneakerQuantity()+add);
            sneakerFacade.edit(sneaker);
            txtFieldInfo.setVisible(true);
            txtFieldInfo.setText("Поступление добавленно!");
            btnReload.setVisible(true);
            } catch (Exception e) {
                txtFieldInfo.setVisible(true);
                txtFieldInfo.setText("Ошибка!");
            }
        });
    }

}

