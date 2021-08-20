/**
 * Sample Skeleton for 'errorRestaurantAlreadyExists.fxml' Controller Class
 */

package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ErrorRestaurantAlreadyExistsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="framePane"
    private AnchorPane framePane; // Value injected by FXMLLoader

    @FXML // fx:id="imageBackground"
    private ImageView imageBackground; // Value injected by FXMLLoader

    @FXML // fx:id="line2"
    private Line line2; // Value injected by FXMLLoader

    @FXML // fx:id="buttonYES"
    private Button buttonYES; // Value injected by FXMLLoader

    @FXML // fx:id="buttonNO"
    private Button buttonNO; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        buttonNO.setOnAction(actionEvent -> {
            buttonNO.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}
