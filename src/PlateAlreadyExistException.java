/**
 * Created by Tommaso M. Lopedote on 24/07/2021
 * Time: 17:33
 * Project: Restourant-java-prjk
 */
public class PlateAlreadyExistException extends RuntimeException {
    public PlateAlreadyExistException(String message){
        super(message);
    }
}
