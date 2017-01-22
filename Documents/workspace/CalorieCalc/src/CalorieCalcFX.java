
import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
	import javafx.scene.Scene;
	import javafx.scene.control.*;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;
	
	
	
public class CalorieCalcFX extends Application{
	private String [] excercise = {"Sedentary", "Light Activity", "Moderate Activity", "Heavy Activity", 
	"Very Heavy Activity"};
	
	@Override
	public void start(Stage stage){
		CalorieCalc A = new CalorieCalc();
		
		Group root = new Group();
        Scene scene = new Scene(root, 900, 500);
        stage.setScene(scene);
        stage.setTitle("Calorie Calculator v2.0 GUI");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setVgap(5);
        grid.setHgap(5);

        scene.setRoot(grid);

        final TextField gender = new TextField();
        gender.setPromptText("Enter your gender");
        gender.setPrefColumnCount(7);
        GridPane.setConstraints(gender, 0, 0);
        grid.getChildren().add(gender);

        final TextField weight = new TextField();
        weight.setPromptText("Weight (in Lbs)");
        weight.setPrefColumnCount(5);
        GridPane.setConstraints(weight, 0, 1);
        grid.getChildren().add(weight);

        final TextField height = new TextField();
        height.setPrefColumnCount(5);
        height.setPromptText("Height (inches)");
        GridPane.setConstraints(height, 0, 2);
        grid.getChildren().add(height);
        
        final TextField age = new TextField();
        age.setPrefColumnCount(5);
        age.setPromptText("Age (in years)");
        GridPane.setConstraints(age, 0, 3);
        grid.getChildren().add(age);

        Button submit = new Button("CALCULATE");
        GridPane.setConstraints(submit, 0, 4);
        grid.getChildren().add(submit);

        Button clear = new Button("CLEAR");
        GridPane.setConstraints(clear, 1, 4);
        grid.getChildren().add(clear);
        
        Button exit = new Button("CANCEL");
        GridPane.setConstraints(exit, 2, 4);
        grid.getChildren().add(exit);
        
        final Label label1 = new Label();
        label1.setText("BMR and BMI information");
        GridPane.setConstraints(label1, 0, 5);
        GridPane.setColumnSpan(label1, 2);
        grid.getChildren().add(label1);
        
        final Label exerType = new Label();
        exerType.setText("Please select excercise amount");
        GridPane.setConstraints(exerType, 1, 0);
        GridPane.setColumnSpan(exerType, 2);
        grid.getChildren().add(exerType);

        final TextArea label = new TextArea();
        GridPane.setConstraints(label, 0, 6);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);
        
        final Label company = new Label();
        company.setText("Dexterasoft Research, LLC Copyright 2013");
        GridPane.setConstraints(company, 1, 8);
        GridPane.setColumnSpan(company, 2);
        grid.getChildren().add(company);
        
        final TextArea tdee = new TextArea();
        GridPane.setConstraints(tdee, 0, 7);
        GridPane.setColumnSpan(tdee, 2);
        grid.getChildren().add(tdee);
        
        final ComboBox<String> exerBox = new ComboBox<>();
        exerBox.getItems().addAll(excercise);
        GridPane.setConstraints(exerBox, 1, 1);
        grid.getChildren().add(exerBox);
        
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	String input;
            	
            	input = gender.getText();
            	A.setGender(input);
            	
            	input = height.getText();
            	double D = Double.parseDouble(input);
            	A.setHeight(D);
            	
            	input = weight.getText();
            	double B = Double.parseDouble(input);
            	A.setWeight(B);
            	
            	input = age.getText();
            	int C = Integer.parseInt(input);
            	A.setAge(C);
                
            	label.setText(A.toString());
            	
            	
            	//input = JOptionPane.showInputDialog("Please select your current activity level."
        				//+"\n1. Sedentary (no excercise)"
        				//+"\n2. Light Activity "
        				//+"\n3. Moderate Activity"
        				//+"\n4. Heavy Activity"
        			//	+"\n5. Very Heavy Activity");
        		//int E = Integer.parseInt(input);
        		//A.setTDEE(E);
        		
        		//tdee.setText("Hello " + A.toTDEE());
        		
        		
            }
        });
        
        exerBox.setPromptText("Daily Activity Level");
        exerBox.setEditable(true);
        exerBox.setOnAction(new EventHandler <ActionEvent>() {
        	@Override
        	public void handle (ActionEvent e) {
        	String address =  exerBox.getSelectionModel().getSelectedItem().toString();
        	A.setTDEE(address);
        	tdee.setText(A.toTDEE());
        	}	
        	
        });
       

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                height.clear();
                weight.clear();
                age.clear();
                gender.clear();
                label.setText(null);
                tdee.setText(null);
            }
        });
        
        exit.setOnAction(new EventHandler<ActionEvent> (){ 
        	@Override
        	public void  handle(ActionEvent e){
        		System.exit(0);
        	}
        });

        stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
