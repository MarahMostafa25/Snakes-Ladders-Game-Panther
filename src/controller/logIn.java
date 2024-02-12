package controller;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

@SuppressWarnings("restriction")
public class logIn implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button enterButton;

    @FXML
    private ImageView backgroundImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the controller here, if necessary.

        // Set the background image
        Image background = new Image("file:../Images/backgroundQuestions.jpg.jpeg");
        backgroundImage.setImage(background);

        // Customize the font
        Font welcomeFont = Font.loadFont(getClass().getResourceAsStream("/fonts/your-font-file.ttf"), 43);
        Font labelFont = Font.loadFont(getClass().getResourceAsStream("/fonts/your-font-file.ttf"), 30);
        Font fieldFont = Font.loadFont(getClass().getResourceAsStream("/fonts/your-font-file.ttf"), 28);

        welcomeLabel.setFont(welcomeFont);
        userNameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        userNameField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        enterButton.setFont(fieldFont);

        // Customize the background gradient
        Stop[] stops = new Stop[] {
                new Stop(0, Color.web("#ffc94f")),
                new Stop(0.35, Color.web("#e78c08")),
                new Stop(1, Color.web("#eec786"))
        };

        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE , stops);
        root.setBackground(new Background(new BackgroundFill(linearGradient, CornerRadii.EMPTY, Insets.EMPTY)));

        // Customize the button effect
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.1);
        enterButton.setEffect(colorAdjust);
    }

    @FXML
    private void enterButtonAction() {
        // Handle the ENTER button action.
    }

    @FXML
    private void backButtonAction() {
        // Handle the back button action.
    }

    public AnchorPane getRoot() {
        return root;
    }

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public Label getUserNameLabel() {
        return userNameLabel;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public TextField getUserNameField() {
        return userNameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getEnterButton() {
        return enterButton;
    }

    public ImageView getBackgroundImage() {
        return backgroundImage;
    }
}