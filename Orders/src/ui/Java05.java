package ui;
import business.Order;
import business.Validation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Java05 extends Application 
{
	//declares the components
	private TextField lastNameField;
	private TextField firstNameField;
	private TextField emailField;
	private TextField creditCardField;
	
	private CheckBox sweatShirtCheckBox;
	private CheckBox tShirtCheckBox;
	private CheckBox ballCapCheckBox;
	private CheckBox coffeeMugCheckBox;
	
	private ComboBox<String> sweatShirtComboBox;
	private ComboBox<String> tShirtComboBox;
	private ComboBox<String> ballCapComboBox;
	private ComboBox<String> coffeeMugComboBox;
	
	private ToggleGroup group = new ToggleGroup();
	RadioButton amerExpressRadioButton;
	RadioButton discoverRadioButton;
	RadioButton masterCardRadioButton;
	RadioButton visaRadioButton;
	
	Button calculateButton;
	
	private ComboBox<String> expireMonthComboBox;
	private ComboBox<String> expireYearComboBox;
	
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("On-Line Order");
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);

        Scene scene = new Scene(grid);
        
      //Instantiates all the components and adds them to the grid                 
        grid.add(new Label("Last Name:"), 0, 1);
        lastNameField = new TextField();
        grid.add(lastNameField, 1, 1);
        
        grid.add(new Label("First Name:"), 2, 1);
        firstNameField = new TextField();
        grid.add(firstNameField, 3, 1);
        
        grid.add(new Label("Email Address:"), 4, 1);
        emailField = new TextField();
        grid.add(emailField, 5, 1);
        
      //A checkbox with a string caption
        sweatShirtCheckBox = new CheckBox("Sweatshirt(39.95)");
        grid.add(sweatShirtCheckBox, 0, 2);
        //sweatShirtCheckBox.setSelected(true);
        
        tShirtCheckBox = new CheckBox("T-Shirt(12.95)");
        grid.add(tShirtCheckBox, 0, 3);
        
        ballCapCheckBox = new CheckBox("Ball Cap(16.95)");
        grid.add(ballCapCheckBox, 0, 4);
        
        coffeeMugCheckBox = new CheckBox("Coffee Mug(7.95)");
        grid.add(coffeeMugCheckBox, 0, 5);
        
        //adds items to the combo box
        sweatShirtComboBox = new ComboBox<String>();
        sweatShirtComboBox.getItems().addAll(
            "1", "2","3","4","5","6","7","8","9","10","11","12","13","14"
            ,"15","16","17","18","19","20");//this needs to go to 20
        grid.add(sweatShirtComboBox, 1, 2);
        
        tShirtComboBox = new ComboBox<String>();
        tShirtComboBox.getItems().addAll(
            "1", "2","3","4","5","6","7","8","9","10","11","12","13","14"
            ,"15","16","17","18","19","20");//this needs to go to 20
        grid.add(tShirtComboBox, 1, 3);
        
        ballCapComboBox = new ComboBox<String>();
        ballCapComboBox.getItems().addAll(
            "1", "2","3","4","5","6","7","8","9","10","11","12","13","14"
            ,"15","16","17","18","19","20");//this needs to go to 20
        grid.add(ballCapComboBox, 1, 4);
        
        coffeeMugComboBox = new ComboBox<String>();
        coffeeMugComboBox.getItems().addAll(
            "1", "2","3","4","5","6","7","8","9","10","11","12","13","14"
            ,"15","16","17","18","19","20");//this needs to go to 20
        grid.add(coffeeMugComboBox, 1, 5);
        
        grid.add(new Label("Credit Card Number:"), 0, 6);
        creditCardField = new TextField();
        grid.add(creditCardField, 1, 6);
        
        //adds the radio button to the group, then selects an option
        amerExpressRadioButton = new RadioButton("American Express");
        amerExpressRadioButton.setToggleGroup(group);
        amerExpressRadioButton.setSelected(true);
        grid.add(amerExpressRadioButton, 2, 2);
        
        discoverRadioButton = new RadioButton("Discover");
        discoverRadioButton.setToggleGroup(group);
        grid.add(discoverRadioButton, 2, 3);
        
        masterCardRadioButton = new RadioButton("Master Card");
        masterCardRadioButton.setToggleGroup(group);
        grid.add(masterCardRadioButton, 2, 4);
        
        visaRadioButton = new RadioButton("VISA");
        visaRadioButton.setToggleGroup(group);
        grid.add(visaRadioButton, 2, 5);
        
        grid.add(new Label("Expiration Month:"), 2, 6);
        grid.add(new Label("Expiration Year:"), 3, 6);
        
        expireMonthComboBox = new ComboBox<String>();
        expireMonthComboBox.getItems().addAll(
            "1", "2","3","4","5","6","7","8","9","10","11","12");
        grid.add(expireMonthComboBox, 2, 7);
        
        expireYearComboBox = new ComboBox<String>();
        expireYearComboBox.getItems().addAll(
            "2018", "2019","2020","2021","2022","2023"
            ,"2024","2025");//this needs to go to 2025
        grid.add(expireYearComboBox, 3, 7);
        
        calculateButton = new Button("Submit Order");
        grid.add(calculateButton, 4, 4);
        //adds an action to the button and calls a method
        calculateButton.setOnAction(event -> calculateButtonClicked());
    	
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	//validate and calculate in this method
	private void calculateButtonClicked() 
	{
	
		
	Validation v = new Validation();
	String errorMessage = "";
	
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	alert.setTitle("Error");
	alert.setHeaderText("Invalid Entry");
	
	Alert Confirm = new Alert(Alert.AlertType.CONFIRMATION);
	
	
	
	
	int item = 0;
	double total = 0;
	String cardType="";
	
	errorMessage += v.isPresent(firstNameField.getText(), "First name");
	
	errorMessage += v.isPresent(lastNameField.getText(), "Last name");
	
	errorMessage += v.isPresent(emailField.getText(), "Email address");
	
	errorMessage += v.isPresent(creditCardField.getText(), "Credit card number");
	
	errorMessage += v.digitCounter(Long.parseLong(creditCardField.getText()), 16, "Credit card number");
	
	errorMessage += v.isLong(creditCardField.getText(), "Credit card number");
	
	
	
	 if (errorMessage.isEmpty()) {
			String fName = firstNameField.getText();
			String lName = lastNameField.getText();
			String email = emailField.getText();
			Long CCN = Long.parseLong(creditCardField.getText());
			
			
			
			
		
	//this determines if the sweat shirt check box has been selected			
		if(sweatShirtCheckBox.isSelected())
		{
			//this parses the item from the combo box
			//you would calculate price of sweatshirt * how many items here
			item = Integer.parseInt(sweatShirtComboBox.getValue());
			total += (item * 39.95);
			System.out.println(item);
		}
	   if(tShirtCheckBox.isSelected()) 
		{
			item = Integer.parseInt(tShirtComboBox.getValue());
			total += (item * 12.95);
			System.out.print(item);
		}
		if (ballCapCheckBox.isSelected())
		{
			item = Integer.parseInt(ballCapComboBox.getValue());
			total += (item * 16.95);
			System.out.print(item);
		}
		if (coffeeMugCheckBox.isSelected()) {
			item = Integer.parseInt(coffeeMugComboBox.getValue());
			total += (item * 7.95);
		}
		
		if (total < 50) {
			total += 7.97;
		}
		
		
		
		if (amerExpressRadioButton.isSelected())
		{
			cardType="American Express card";
		}
		else if (discoverRadioButton.isSelected()) {
			cardType = "Discover card";
		}
		else if (masterCardRadioButton.isSelected()) {
			cardType = "Mastercard";
		}
		else if (visaRadioButton.isSelected()) {
			cardType= "Visa";
		}
		
		
		
		Order o = new Order(lName, fName, email,CCN, total);
		
		
		Confirm.setContentText("Thank you for placing an order;" + "\n"
		+ "when it arives we will notify you by sending an email." + "\n"
		+ o.formatTotal() + " will be charged to your "+ cardType + ".");
		Confirm.showAndWait();
		}
	 	else  {
			alert.setContentText(errorMessage);
			alert.showAndWait();
		}
		
	}	

	public static void main(String[] args) 
	{
		launch(args);
	}
}
