/**
 * Created by Tommaso M. Lopedote on 21/09/2021
 * Time: 17:02
 * Project: Restourant-java-prjk
 */
public class WrongOrderException extends RuntimeException {
    public WrongOrderException(String message){
            super(message);
    }
}
