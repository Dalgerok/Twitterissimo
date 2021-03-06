package org.twitterissimo.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.twitterissimo.tools.ConnectionMessage;
import org.twitterissimo.tools.LoginInfo;

public class StartSceneController {
    @FXML public TextField loginEmail;
    @FXML public PasswordField loginPassword;
    @FXML public Text textMessage;
    @FXML public Button loginButton;


    @FXML
    public void loginButtonHandler(MouseEvent mouseEvent) {
        ConnectionMessage o = Main.signIn(new LoginInfo(loginEmail.getText(), loginPassword.getText()));
        if(ConnectionMessage.SIGN_IN.equals(o)){
            return;
        }
        System.out.println("LOGIN GOT " + o);
        if(ConnectionMessage.BAD_EMAIL.equals(o)){
            textMessage.setText("This email does not exist!");
            textMessage.setVisible(true);
            return;
        }
        if(ConnectionMessage.BAD_PASSWORD.equals(o)){
            textMessage.setText("Bad password!");
            textMessage.setVisible(true);
            return;
        }
        textMessage.setText("Unable to connect to server!");
        textMessage.setVisible(true);
    }
    @FXML
    public void registerButtonHandler(MouseEvent mouseEvent) {
        Main.setRegisterScene();
    }

}
