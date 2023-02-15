package com.javaFx_demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class myMainJava extends Application {

	//main method is optional
	public static void main(String[] args) {
		System.out.println("main method is executed");
		launch(args);
	}

	//Now during the start of an application and shutting an application down there exist few methods that will help us to know in which phase our application actually exists.
	//init(), start() and stop() methods are part of lifecycle of javaFx app.

	@Override
	public void init() throws Exception {
		System.out.println("init method is executed");       //initialize your application and is optional to override.
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {      //start method is part of Application class, it contains Stage(the outermost container of an application)
		//FXMLLoader is used to connect the myMainJava file with fxml file, here it is app_layout.

		System.out.println("Start Method is Executed!");              //starts an application and is compulsory to override.

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();           //loader.load method will load the root node, here it is VBox.

		MenuBar menuBar = createMenu();                //calling createMenu()

		//rootNode.getChildren().addAll(menuBar);       //adding menuBar to rootNode

		rootNode.getChildren().add(0,menuBar);        //adding menuBar to rootNode at index 0

		//creating Scene
		Scene scene = new Scene(rootNode, 400, 250);       //scene is the innermost container of an application which contains layout & widgets. The first parameter will be root node(always).

		primaryStage.setScene(scene);   //it allows to set the scene
		primaryStage.setTitle("Temperature Convertor Tool");         //it allows to set the title

		//primaryStage.setResizable(false);       //it allows to make an application non-resizable

		primaryStage.show();         //it allows us to see the UI of an application
	}
	private MenuBar createMenu(){               //method to create menu

		Menu fileMenu = new Menu("File");    //creating fileMenu menu

		//adding items to File Menu:

		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(actionEvent ->  {   //this is known as lambda expression it makes the code shorter by not repeating same lines for each menu items.

		});

//		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {             //above code is similar to this code
//			@Override
//			public void handle(ActionEvent actionEvent) {
//
//			}
//		});

		MenuItem openMenuItem = new MenuItem("Open");

		openMenuItem.setOnAction(actionEvent -> {

		});

		SeparatorMenuItem smi = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(actionEvent -> Platform.exit());

		fileMenu.getItems().addAll(newMenuItem,openMenuItem,smi,quitMenuItem); //adding all menu items in File Menu

		Menu editMenu = new Menu("Edit");    //creating edit menu

		//adding item to Edit Menu:

		MenuItem cutMenuItem = new MenuItem("Cut");

		cutMenuItem.setOnAction(actionEvent -> {

		});

		MenuItem copyMenuItem = new MenuItem("Copy");

		copyMenuItem.setOnAction(actionEvent -> {

		});

		MenuItem pasteMenuItem = new MenuItem("Paste");

		pasteMenuItem.setOnAction(actionEvent -> {

		});

		editMenu.getItems().addAll(cutMenuItem,copyMenuItem,pasteMenuItem);  //adding all menu items in Edit Menu

		Menu viewMenu = new Menu("View");    //creating view menu

		//adding item to View Menu:

		MenuItem gridMenuItem = new MenuItem("Grid");

		gridMenuItem.setOnAction(actionEvent -> {

		});

		MenuItem listMenuItem = new MenuItem("List");

		listMenuItem.setOnAction(actionEvent -> {

		});

		viewMenu.getItems().addAll(gridMenuItem,listMenuItem);   //adding all menu items in View Menu.

		Menu aboutMenu = new Menu("About");

		//adding item to about menu:

		MenuItem helpMenuItem = new MenuItem("Help");

		helpMenuItem.setOnAction(actionEvent -> aboutApp());

		aboutMenu.getItems().addAll(helpMenuItem);

		MenuBar menuBar = new MenuBar();    //creating Menu Bar
		menuBar.getMenus().addAll(fileMenu,editMenu,viewMenu,aboutMenu);         //adding all menus to menuBar.

		return menuBar;

	}
	public static void aboutApp(){
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Learning JavaFx");
		alertDialog.setHeaderText("My First Desktop App");
		alertDialog.setContentText("I am just a beginner but soon I will be Pro and Start developing awesome Application.");

		//creating button inside alertDialog
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().addAll(yesBtn,noBtn);   //adding all buttons inside alertDialog.

		//alertDialog.show();   it will opens up the new window showing alert dialog box.

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			//Your Code...
			System.out.println("Yes Button Clicked!");
		} else if (clickedBtn.isPresent() && clickedBtn.get() == noBtn) {
			//Your Code...
			System.out.println("No Button Clicked!");
		}


	}
	@Override
	public void stop() throws Exception {
		System.out.println("Stop Method is Executed!");               //called when application is stopped or is shut down, and it is optional to override.
		super.stop();
	}
}
