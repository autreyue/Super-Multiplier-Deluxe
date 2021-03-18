import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This program uses javaFX library to show a program that takes 2 numbers, multiplies, and displays results
 * created by Trey Foehner
 * 03.2020
 */

public class Multiplier extends Application{

    //fields
    private TextField num1,
                        num2;
    private Label resultLabel;
    private Label errorMsg;
    protected Image logo;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){

        //import and align logo
        logo = new Image("logo.jpg");
        ImageView viewLogo = new ImageView(logo);
        viewLogo.setFitWidth(300);
        viewLogo.setPreserveRatio(true);
        HBox logoBox = new HBox(viewLogo);
        logoBox.setPadding(new Insets(30));
        logoBox.setAlignment(Pos.TOP_CENTER);

        //create & set options
        Label num1Prompt = new Label("Enter First Number: ");
        Label num2Prompt = new Label("Enter second label: ");
        num1 = new TextField();
        num2 = new TextField();

        //create the action button
        Button button = new Button("Multiply");
        button.setOnAction(new ButtonHandler());
        HBox num1Box = new HBox(10, num1Prompt, num1);
        HBox num2Box = new HBox(10, num2Prompt, num2);

        //retrieve the result and error message labels
        resultLabel = new Label();
        errorMsg = new Label();

        //put all of the boxes into one main vertical box
        VBox mainBox = new VBox(10, logoBox, num1Box, num2Box, resultLabel, errorMsg, button);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(30));

        //put every node contained in mainBox to the scene, set title, and showtime
        Scene scene = new Scene(mainBox);
        stage.setScene(scene);
        stage.setTitle("SUPER MULTIPLIER DELUXE");
        stage.show();
    }

    //this method will perform the operation of multiplication
    class ButtonHandler implements EventHandler<ActionEvent>{

        //must override handle method
        @Override
        public void handle(ActionEvent event){
            //integer placeholders
            int input1 = 0;
            int input2 = 0;

            //try accepting user input
            try {
                input1 = Integer.parseInt(num1.getText());
                input2 = Integer.parseInt(num2.getText());
                //resets error label
                errorMsg.setText("");
            }
            //if input is not an integer:
            catch (NumberFormatException e) {
                //set the error label to default error message, and why
                errorMsg.setText("ERROR: "+e.getMessage()+" - Invalid Integer");
            }

            //multiply, send the result to the resultLabel
            int result = input1 * input2;
            resultLabel.setText("Result: "+result);
        }
    }
}
