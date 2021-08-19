/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="framePane"
    private AnchorPane framePane; // Value injected by FXMLLoader

    @FXML // fx:id="imageBackground"
    private ImageView imageBackground; // Value injected by FXMLLoader

    @FXML // fx:id="imageWelcome"
    private ImageView imageWelcome; // Value injected by FXMLLoader

    @FXML // fx:id="buttomNewRestourant"
    private Button buttomNewRestourant; // Value injected by FXMLLoader

    @FXML // fx:id="buttomResume"
    private Button buttomResume; // Value injected by FXMLLoader

    @FXML // fx:id="line2"
    private Line line2; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        buttomNewRestourant.setOnAction(event ->  {
            System.out.println("New Restourant");
        });

    }
}
