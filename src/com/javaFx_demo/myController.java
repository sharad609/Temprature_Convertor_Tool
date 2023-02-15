package com.javaFx_demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class myController implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;      //<String>:It will assure the item in choice box is of string type.
	@FXML
	public TextField userInputField;
	@FXML
	public Button calculateBtn;

	private static final String C_TO_F = "Celsius To Fahrenheit";
	private static final String F_TO_C = "Fahrenheit To Celsius";
	private boolean isC_TO_F = true;
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		//adding items to choice box.
		choiceBox.getItems().addAll(C_TO_F ,F_TO_C);

		//setting default value to be displayed in choice box.
		choiceBox.setValue(C_TO_F);

		//click event on choiceBox.
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) ->{
			if(t1.equals(C_TO_F)){   //if user has selected "Celsius To Fahrenheit"
				isC_TO_F = true;
			}else {                                   //if user has selected "Fahrenheit To Celsius"
				isC_TO_F = false;
			}
		});

		//click event on calculateBtn.
		calculateBtn.setOnAction(actionEvent -> {
			convert();
		});
	}
	private void convert(){
		String input = userInputField.getText();     //23.4 => "23.4"

		float enteredTemp = 0.0f;    //making enteredTemp access inside everywhere in convert() method.

		try {
			enteredTemp = Float.parseFloat(input);   //"23.4" => 23.4f
		}catch (Exception ex){
			warnUser();
			return;  //after this no code will get executed i.e. if temperature entered is invalid then it will stop here and does not display the new temperature dialog box.
		}
		float newTemperature = 0.0f;
		if (isC_TO_F){
			newTemperature = (enteredTemp * 9 / 5) + 32;
		}else {
			newTemperature = (enteredTemp - 32) * 5 / 9;
		}
		display(newTemperature);

	}
	public void warnUser(){
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter a Valid Temperature.");
		alert.show();
	}
	public void display(float newTemperature){
		String unit = isC_TO_F? " F" : " C";   //ternary operator

		//to show result in output console
		//System.out.println("The new Temperature is: "+newTemperature + unit);

		//to show result in alert dialog box
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("RESULT");
		alert.setContentText("The New Temperature is: "+newTemperature + unit);
		alert.show();
	}
}
