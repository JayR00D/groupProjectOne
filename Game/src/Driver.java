import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/*
 * 
 * Driver Class
 * Basic Run File for the game
 * Created 10/20/18
 * 
 */

public class Driver extends Application {
	static Player player;
	static Stage myStage;
	private ImageView imageView;
	public static void main(String[] args) throws FileNotFoundException {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		myStage = stage;
		
		File playerOne = new File("src/player1.txt");
		File playerTwo = new File("src/player2.txt");
		
		Random rand = new Random();
		
		Scanner scan;
		
		if(rand.nextInt() % 2 == 0) {
			scan = new Scanner(playerOne);
		}else {
			scan = new Scanner(playerTwo);
		}
		
		String imgURL = scan.nextLine();
		imgURL = "file:" + imgURL;
		System.out.println(imgURL);
		
		Image img = new Image(imgURL);
		int speed = scan.nextInt();
		int health = scan.nextInt();
		
		player = new Player(10, 10, speed, health, img);
		
		System.out.println(speed);
		System.out.println(health);
		
		scan.close();

		imageView = new ImageView(new Image(imgURL));
		
		imageView.setX(player.getX());
		imageView.setY(player.getY());
		imageView.setFitWidth(39);
		imageView.setFitHeight(65);
		
	    Group root = new Group(imageView);  
	      
	    Scene scene = new Scene(root, 600, 500);  
	      
	     
	    myStage.setTitle("Loading an image");  
	    myStage.setScene(scene);
	    myStage.show(); 
	    
	    scene.setOnKeyPressed(this::listenUp);
	}


	public void listenUp(KeyEvent event)
	{
		KeyCode myCode = event.getCode();
		
		if(myCode == KeyCode.A)
		{
			player.moveLeft();
		}
		else if(myCode == KeyCode.D)
		{
			player.moveRight();
		}
		else if(myCode == KeyCode.S)
		{
			player.moveDown();
		}
		else if(myCode == KeyCode.W)
		{
			player.moveUp();
		}
	

		imageView.setX(player.getX());
		imageView.setY(player.getY());
		
		
	}
}
