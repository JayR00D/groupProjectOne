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

/***
 * *NOOOOOOOO!!
 * Driver Class
 * Basic Run File for the game
 * Created 10/20/18
 * 
 */

public class Driver extends Application {
	private Player player;
	private Enemy enemy;
	private Collectable collect1;
	private Collectable collect2;
	private Collectable collect3;
	private Collectable collect4;
	private Collectable collect5;
	private Stage myStage;
	private ImageView imageView;
	private ImageView enemyImageView;
	private ImageView collectView1;
	private ImageView collectView2;
	private ImageView collectView3;
	private ImageView collectView4;
	private ImageView collectView5;
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
		Scanner enemyScan;
		
		if(rand.nextInt() % 2 == 0) {
			scan = new Scanner(playerOne);
			enemyScan = new Scanner(playerTwo);
		}else {
			scan = new Scanner(playerTwo);
			enemyScan = new Scanner(playerOne);
		}
		
		String imgURL = scan.nextLine();
		imgURL = "file:" + imgURL;
		System.out.println(imgURL);
		
		Image img = new Image(imgURL);
		int speed = scan.nextInt();
		int health = scan.nextInt();
		
		player = new Player(10, 10, speed, health, img);
		
		String enemyimgURL = enemyScan.nextLine();
		enemyimgURL = "file:" + enemyimgURL;
		Image enemyimg = new Image(enemyimgURL);
		

		Image collectimg = new Image("file:/Game/src/Collectable.jpg");
		
		enemy = new Enemy(500, 400, 39, 65, 1, enemyimg);
		

		collect1 = new Collectable(rand.nextInt(500)+1, rand.nextInt(600)+1, 10, 10, 5, collectimg);
		collect2 = new Collectable(rand.nextInt(500)+1, rand.nextInt(600)+1, 10, 10, 5, collectimg);
		collect3 = new Collectable(rand.nextInt(500)+1, rand.nextInt(600)+1, 10, 10, 5, collectimg);
		collect4 = new Collectable(rand.nextInt(500)+1, rand.nextInt(600)+1, 10, 10, 5, collectimg);
		collect5 = new Collectable(rand.nextInt(500)+1, rand.nextInt(600)+1, 10, 10, 5, collectimg);
		
		System.out.println(speed);
		System.out.println(health);
		
		scan.close();
		enemyScan.close();

		imageView = new ImageView(new Image(imgURL));
		enemyImageView = new ImageView(new Image(enemyimgURL));
		collectView1 = new ImageView(collectimg);
		collectView2 = new ImageView(collectimg);
		collectView3 = new ImageView(collectimg);
		collectView4 = new ImageView(collectimg);
		collectView5 = new ImageView(collectimg);
		
		
		
		imageView.setX(player.getX());
		imageView.setY(player.getY());
		imageView.setFitWidth(39);
		imageView.setFitHeight(65);
		
		enemyImageView.setX(enemy.getX());
		enemyImageView.setY(enemy.getY());
		enemyImageView.setFitWidth(39);
		enemyImageView.setFitHeight(65);
		
		
		
	    Group root = new Group(imageView, enemyImageView, collect1, collect2, collect3, collect4, collect5);  
	      
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
			if(player.getX() < 10) {
				player.moveRight();
			}
		}
		else if(myCode == KeyCode.D)
		{
			player.moveRight();
			if(player.getX() > 560) {
				player.moveLeft();
			}
		}
		else if(myCode == KeyCode.S)
		{
			player.moveDown();
			if(player.getY() > 440) {
				player.moveUp();
			}
			
		}
		else if(myCode == KeyCode.W)
		{
			player.moveUp();
			if(player.getY() < 10) {
				player.moveDown();
			}
		}
	
	

		imageView.setX(player.getX());
		imageView.setY(player.getY());
		
		enemy.calcDirection(player.getX(), player.getY());
	    
	    enemyImageView.setX(enemy.getX());
	    enemyImageView.setY(enemy.getY());
		
		
	}
}
