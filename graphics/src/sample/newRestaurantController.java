/**
 * Sample Skeleton for 'newRestaurant.fxml' Controller Class
 */

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class newRestaurantController {

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

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert framePane != null : "fx:id=\"framePane\" was not injected: check your FXML file 'newRestaurant.fxml'.";
        assert imageBackground != null : "fx:id=\"imageBackground\" was not injected: check your FXML file 'newRestaurant.fxml'.";
        assert line2 != null : "fx:id=\"line2\" was not injected: check your FXML file 'newRestaurant.fxml'.";

    }
}
