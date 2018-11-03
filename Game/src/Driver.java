import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

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
	public static void main(String[] args) throws FileNotFoundException {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		myStage = stage;
		/*
		File playerOne = new File("src/player1.txt");
		File playerTwo = new File("src/player2.txt");
		
		Random rand = new Random();
		
		Scanner scan;
		
		if(rand.nextInt() % 2 == 0) {
			scan = new Scanner(playerOne);
		}else {
			scan = new Scanner(playerTwo);
		}
		
		String temp = scan.nextLine();
		temp = "file:" + temp;
		System.out.println(temp);
		
		Image img = new Image(temp);
		int speed = scan.nextInt();
		int health = scan.nextInt();
		
		player = new Player(10, 10, speed, health, img);
		
		System.out.println(speed);
		System.out.println(health);
		
		scan.close();*/
		
		ImageView imageView = new ImageView(new Image("file:src/player1/jpg")); 
		
		imageView.setX(player.getX());
		imageView.setY(player.getY());
		imageView.setFitWidth(600);
		imageView.setFitHeight(330);
		
	    Group root = new Group(imageView);  
	      
	    Scene scene = new Scene(root, 600, 500);  
	      
	     
	    myStage.setTitle("Loading an image");  
	    myStage.setScene(scene);
	    myStage.show(); 
		
	}

}
