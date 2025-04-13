package game.gui;

import java.util.ArrayList;

import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.AbnormalTitan;
import game.engine.titans.ArmoredTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;
import game.engine.weapons.Weapon;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



public class View extends Application {
    private Stage stage,stage2;
    private Scene scene ,scene1, scene2,scene3,scene4,scene7;
    private Label scoreLabel,resourcesLabel,turnLabel,phaseLabel,lanesLabel,wl1,wl2,wl3,wl4,wl5,dl1,dl2,dl3,dl4,dl5;
    private Button passTurn;
    private int x = 1800;
    private Battle easy;
    private Battle hard;
    private AnchorPane mainRoot;
    Rectangle rectangle1,rectangle2,rectangle3,rectangle4,rectangle5;
    ArrayList <ImageView> addedImages = new ArrayList<>();
    ArrayList<Label>titanLabels = new ArrayList<>();
    private AnchorPane ap1,ap2,ap3,ap4,ap5;
    Label pc1,pc2,pc3,pc4,pc5,sc1,sc2,sc3,sc4,sc5,vsc1,vsc2,vsc3,vsc4,vsc5,trp1,trp2,trp3,trp4,trp5;

    
	
    
    
 

    @Override
    public void start(Stage stage) throws Exception {
    	
        this.stage = stage;
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.getIcons().add(new Image("download.png"));
        stage.setTitle("Attack On Titans Utopia");

        try {
        	stage.setWidth(1920);
        	stage.setHeight(1080);
           
            

            
            Image image = new Image("STARTSS.jpg");
            

            
            ImageView imageView = new ImageView(image);
           
            imageView.setFitWidth(stage.getWidth());
            imageView.setFitHeight(stage.getHeight());

          
            StackPane root = new StackPane();
            root.getChildren().add(imageView);

          
            Button b1 = new Button("PLAY");
            b1.setPrefSize(200, 50);

            
            Button b2 = new Button("INSTRUCTIONS");
            b2.setPrefSize(200, 50);

            
            VBox vbox = new VBox(10); 
            vbox.setAlignment(Pos.CENTER_LEFT);
            vbox.getChildren().addAll(b1, b2);
          b1.setTranslateX(190);
          b2.setTranslateX(190);
          b1.setTranslateY(220);
          b2.setTranslateY(260);
          b1.setStyle("-fx-background-color: maroon; -fx-border-width: 0;");
          b2.setStyle("-fx-background-color: maroon; -fx-border-width: 0;");
          b1.setTextFill(Color.WHEAT);
          b2.setTextFill(Color.WHEAT);
          b1.setFont(Font.font("Impact", FontWeight.THIN, 30));
          b2.setFont(Font.font("Impact", FontWeight.THIN, 20));
         

       
            root.getChildren().add(vbox);

            
            scene = new Scene(root);

            
            stage.setScene(scene);

           
            b1.setOnAction(e -> switchToScene2());

          
            b2.setOnAction(e -> switchToInstructions());

            
            
            stage.setFullScreen(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void switchToScene2() {
        // Initialize the root StackPane and set it to scene3
        StackPane root = new StackPane();
        scene3 = new Scene(root, stage.getWidth(), stage.getHeight());
        
        // Load the background image
        Image image = new Image("3.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(stage.getWidth());
        imageView.setFitHeight(stage.getHeight());

        // Initialize the buttons
        Button b1 = new Button("Back");
        Button b2 = new Button("EASY");
        Button b3 = new Button("HARD");

        // Style the buttons
        b1.setTextFill(Color.BLACK);
        b2.setTextFill(Color.BLACK);
        b3.setTextFill(Color.BLACK);
        b1.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 40));
        b2.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 40));
        b3.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 40));
        b3.setTranslateY(30);

        // Set button actions
        b1.setOnAction(e -> switchToScene1());
        b2.setOnAction(e -> {
            try {
                easy = new Battle(1, 0, x, 3, 250);
                switchToSceneEasy(easy);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        b3.setOnAction(e -> {
            try {
                hard = new Battle(1, 0, x, 5, 125);
                switchToSceneHard(hard);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        // Create a VBox for the buttons and center it
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(b2, b3);

        // Add the ImageView and VBox to the root StackPane
        root.getChildren().addAll(imageView, vbox);

        // Set the new scene on the stage
        stage.setScene(scene3);
        stage.setFullScreen(true);

    }

    public void switchToInstructions() {
        try {
            

            StackPane root = new StackPane();
            scene3 = new Scene(root);
           
            Image image = new Image("2.jpg");
            ImageView imageView = new ImageView(image);

           
            imageView.setFitWidth(stage.getWidth());
            imageView.setFitHeight(stage.getHeight());

            
            Text instructions = new Text();
            instructions.setText("Attack on Titan: Utopia is an endless tower defense game inspired by the anime Attack on Titan.\n"
                + "The story of the anime revolves around how titans, gigantic humanoid creatures, emerged one day and wiped out most of humanity.\n"
                + "The few surviving humans fled and hid behind three great walls that provided safe haven from the titan threats.\n"
                + "Wall Maria is the outer wall, Wall Rose is the middle wall, and Wall Sina is the inside wall.\n"
                + "This game takes place in an imaginary scenario where the titans breached their way throughout Wall Maria and reached the northern border of Wall Rose at the Utopia District.\n"
                + "The human forces stationed in Utopia engage the titans in battle for one last hope of preventing the titans from breaching Wall Rose.\n"
                + "The humans fight by deploying different types of Anti-Titan weapons in order to stop the Titan’s onslaught and keep Utopia’s (and Wall Rose’s) walls safe.");
            instructions.setWrappingWidth(600); // Set the wrapping width for the text
            instructions.setTextAlignment(TextAlignment.CENTER); // Align text to center
            instructions.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 19)); // Set font, size, and weight
            instructions.setFill(Color.BLACK); // Set text color to white

            
            VBox vbox = new VBox(20); 
            vbox.setAlignment(Pos.CENTER); 
            vbox.getChildren().addAll(instructions);

            
            Button b1 = new Button("Return");
            b1.setOnAction(e -> switchToScene1());

         
            vbox.getChildren().add(b1);

            
            StackPane.setAlignment(vbox, Pos.CENTER);

            
            root.getChildren().addAll(imageView, vbox);

           
         
            stage.setScene(scene3);
            stage.setFullScreen(true);

         
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    	private void switchToScene1() {
    		stage.setScene(scene);
    		 //
    		stage.setFullScreen(true);
    		stage.show();
    	}
 	
	private void switchToSceneEasy(Battle battle) {
		
		   wl1= new Label(""+battle.getOriginalLanes().get(0).getLaneWall().getBaseHealth());
		   wl2= new Label(""+battle.getOriginalLanes().get(1).getLaneWall().getBaseHealth());
		   wl3= new Label(""+battle.getOriginalLanes().get(2).getLaneWall().getBaseHealth());
			
		   dl1=new Label("DL: "+battle.getOriginalLanes().get(0).getDangerLevel());
		   dl2=new Label("DL: "+battle.getOriginalLanes().get(1).getDangerLevel());
		   dl3=new Label("DL: "+battle.getOriginalLanes().get(2).getDangerLevel());
		   
		   pc1 = new Label("0");
		    pc2 = new Label("0");
		    pc3 = new Label("0");
		    

		    sc1 = new Label("0");
		    sc2 = new Label("0");
		    sc3 = new Label("0");
		    

		    vsc1 = new Label("0");
		    vsc2 = new Label("0");
		    vsc3 = new Label("0");
		   

		    trp1 = new Label("0");
		    trp2 = new Label("0");
		    trp3 = new Label("0");
			
    	    mainRoot = new AnchorPane();
    	    passTurn = new Button("Pass Turn");	
			passTurn.setStyle("-fx-background-color: transparent;");
    	    passTurn.setOnMouseEntered(e -> passTurn.setStyle("-fx-background-color: #D3D3D3;"));
    	    passTurn.setOnMouseExited(e -> passTurn.setStyle("-fx-background-color: transparent;"));
    	    passTurn.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));
    	    passTurn.setTextFill(Color.MIDNIGHTBLUE);
    	    
    	    HBox hb=new HBox();
    	    HBox hb1 = new HBox();
    	    
    	    Image image = new Image("4.jpg");
    	    ImageView imageView = new ImageView(image);
    	    ImageView W1 = wallImg();
    	    ImageView W2 = wallImg();
    	    ImageView W3 = wallImg();
    	    
    	    ap1 = new AnchorPane();
    	    ap1.setLayoutX(639);
    	    ap1.setLayoutY(220);
    	    ap2 = new AnchorPane();
    	    ap2.setLayoutX(639);
    	    ap2.setLayoutY(220);
    	    ap3 = new AnchorPane();
    	    ap3.setLayoutX(639);
    	    ap3.setLayoutY(220);

    	    
    	    
    	    Button b2= new Button("Weapon Shop");
    	    b2.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));
    	    b2.setTextFill(Color.MIDNIGHTBLUE);
    	    
    	
			b2.setStyle("-fx-background-color: transparent;");
    	    b2.setOnMouseEntered(e -> b2.setStyle("-fx-background-color: #D3D3D3;"));
    	    b2.setOnMouseExited(e -> b2.setStyle("-fx-background-color: transparent;"));
    	    
    	    hb1.setSpacing(250);
    	    hb1.getChildren().addAll(b2,passTurn);
    	    
    	    AnchorPane.setTopAnchor(hb1, 80.0);
    	    AnchorPane.setLeftAnchor(hb1, 600.0);
    	    mainRoot.getChildren().addAll(imageView,hb1);
    	    b2.setOnAction(e -> {
    	       
    	        stage2 = new Stage();
    	        stage2.setTitle("New Stage");

 
    	        AnchorPane root1 = new AnchorPane(); 
    	        Scene scene2 = new Scene(root1,1000,1000); 

    	        
    	        GridPane g = new GridPane();
    	       
    	        Button b1 = new Button("BUY");
    	        Button b5 = new Button("BUY");
    	        Button b3 = new Button("BUY");
    	        Button b4 = new Button("BUY");
    	        
    	      
    	        g.add(b1, 0, 0);
    	        g.add(b5, 0, 5);
    	        g.add(b3, 0, 7);
    	        g.add(b4, 0, 10);
    	     

    	        Image img1 = new Image("pc.png");
                ImageView view1 = new ImageView(img1);
                Image img2 = new Image("vsc.png");
                ImageView view2 = new ImageView(img2);
                Image img3 = new Image("sc.png");
                ImageView view3 = new ImageView(img3);
                Image img4 = new Image("trapp.png");
                ImageView view4 = new ImageView(img4);

                b1.setGraphic(view1);
                b5.setGraphic(view2);
                b3.setGraphic(view3);
                b4.setGraphic(view4);
                
                double buttonsize=230;
                view2.setFitWidth(300); 
                view1.setFitWidth(300); 
                view3.setFitWidth(300); 
                view4.setFitWidth(300); 
                view1.setFitHeight(buttonsize);
                view2.setFitHeight(buttonsize);
                view3.setFitHeight(buttonsize);
                view4.setFitHeight(buttonsize);
                
                Text Text1 = new Text("Name: Anti-Titan Shell \n"
                		+"Price: 25 \n"
                		+"Damage: 10 \n"
                		+"Type: Piercing Cannon  \n");
                Text1.setWrappingWidth(600); // Set the wrapping width for the text
                Text1.setTextAlignment(TextAlignment.CENTER); // Align text to center
                Text1.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
                Text1.setFill(Color.BLACK);
                Text1.setTranslateX(300);
              

                Text Text2 = new Text("Name: Long Range Spear \n"
                		+"Price: 25 \n"
                		+"Damage: 35 \n"
                		+"Type: Sniper Cannon  \n");
                Text2.setWrappingWidth(600); // Set the wrapping width for the text
                Text2.setTextAlignment(TextAlignment.CENTER); // Align text to center
                Text2.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
                Text2.setFill(Color.BLACK);
                Text2.setTranslateX(300);
                Text2.setTranslateY(240);
                
                Text Text3 = new Text("Name: Wall Spread Cannon \n"
                		+"Price: 100 \n"
                		+"Damage: 5 \n"
                		+"Type: Volley Spread Cannon  \n");
                Text3.setWrappingWidth(600); // Set the wrapping width for the text
                Text3.setTextAlignment(TextAlignment.CENTER); // Align text to center
                Text3.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
                Text3.setFill(Color.BLACK);
                Text3.setTranslateX(300);
                Text3.setTranslateY(470);
                
                Text Text4 = new Text("Name: Proximity Trap \n"
                		+"Price: 75 \n"
                		+"Damage: 100 \n"
                		+"Type: Wall Trap  \n");
                Text4.setWrappingWidth(600); // Set the wrapping width for the text
                Text4.setTextAlignment(TextAlignment.CENTER); // Align text to center
                Text4.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
                Text4.setFill(Color.BLACK);
                g.getChildren().addAll(Text1,Text2,Text3,Text4);
                Text4.setTranslateX(300);
                Text4.setTranslateY(730);
                
                

    	        root1.getChildren().add(g); 
    	        stage2.setScene(scene2);
    	        stage2.initOwner(stage);
    	        stage2.show();
    	        b1.setOnAction(j->{
    	        	Stage Stage1 = null;
    				try {
    					Stage1 = newStage(3,1,battle,mainRoot);
    					
    				} catch(InvalidLaneException u){
    					Text txt = new Text(u.getMessage());
    		        	mainRoot.getChildren().add(txt);
    		        }catch(InsufficientResourcesException f){
    		        	Text txt = new Text(f.getMessage());
    		        	mainRoot.getChildren().add(txt);
    		        	
    		        }
                	Stage1.show();
            	    Stage1.toFront();
                });
                b5.setOnAction(j->{
                	Stage Stage1 = null;
    				try {
    					Stage1 = newStage(3,2,battle,mainRoot);	
    				} catch(InvalidLaneException u){
    					Text txt = new Text(u.getMessage());
    		        	mainRoot.getChildren().add(txt);
    		        }catch(InsufficientResourcesException f){
    		        	Text txt = new Text(f.getMessage());
    		        	mainRoot.getChildren().add(txt);
    		        	
    		        }
                	Stage1.show();
            	    Stage1.toFront();

                	

                
                });
                b3.setOnAction(j->{
                	Stage Stage1 = null;
    				try {
    					Stage1 = newStage(3,3,battle,mainRoot);
    					
    				} catch(InvalidLaneException u){
    					Text txt = new Text(u.getMessage());
    		        	mainRoot.getChildren().add(txt);
    		        }catch(InsufficientResourcesException f){
    		        	Text txt = new Text(f.getMessage());
    		        	root1.getChildren().addAll(txt);
    		        	
    		        }
                	Stage1.show();
            	    Stage1.toFront();

                	

                
                });
                b4.setOnAction(j->{
                	Stage Stage1 = stage2;
    				try {
    					Stage1 = newStage(3,4,battle,mainRoot);
    					
    				} catch(InvalidLaneException u){
    		        	Button bu= new Button("return");
    		        	Text txt = new Text(u.getMessage());
    		        	root1.getChildren().addAll(b1,txt);
    		        }catch(InsufficientResourcesException f){
    		        	Button bu= new Button("return");
    		        	Text txt = new Text(f.getMessage());
    		        	root1.getChildren().addAll(b1,txt);
    		        	
    		        }
                	Stage1.show();
            	    Stage1.toFront();
            	   

                
                });
    	    });
    	   

    	    imageView.setFitWidth(stage.getWidth());
    	    imageView.setFitHeight(stage.getHeight());
    	    
    	    
    	    
    	    rectangle1 = new Rectangle(1700, 50,Color.TRANSPARENT);
    	    rectangle2 = new Rectangle(1700, 50,Color.TRANSPARENT);
    	    rectangle3 = new Rectangle(1700, 50,Color.TRANSPARENT);
    	   
    	    
    	    
    	  

    	    double y = 450;
    	    AnchorPane.setTopAnchor(rectangle1,y  );
    	    AnchorPane.setTopAnchor(rectangle2,y + 150  );
    	    AnchorPane.setTopAnchor(rectangle3,y + 300 );
    	    AnchorPane.setLeftAnchor(rectangle1, (double) 225);
    	    AnchorPane.setLeftAnchor(rectangle2, (double) 225);
    	    AnchorPane.setLeftAnchor(rectangle3, (double) 225);
    	    
    	    
    	   
    	    
    	   
    	   	
    	    
     	    AnchorPane.setRightAnchor(W1, (double) 1650);
    	   	AnchorPane.setTopAnchor(W1, y-90);
    	   	
    	   	AnchorPane.setRightAnchor(W2, (double) 1650);
    	   	AnchorPane.setTopAnchor(W2, y + 150-90);
    	   	
    	   	AnchorPane.setRightAnchor(W3, (double) 1650);
    	   	AnchorPane.setTopAnchor(W3, y + 300-90);
    	   	
     	   	
   
    	    scoreLabel = new Label("Score is: " + battle.getScore());
    	    scoreLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
    	    scoreLabel.setTextFill(Color.MIDNIGHTBLUE);
    	    
    	    resourcesLabel = new Label(" | Resources: " + battle.getResourcesGathered());
    	    resourcesLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style    	
    	    resourcesLabel.setTextFill(Color.MIDNIGHTBLUE);
    	    
    	    turnLabel = new Label(" | Turn: " + battle.getNumberOfTurns());
    	    turnLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
    	    turnLabel.setTextFill(Color.MIDNIGHTBLUE);

    	    
    	    
    	    phaseLabel = new Label(" | Current Phase : " + battle.getBattlePhase());
    	    phaseLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
    	    phaseLabel.setTextFill(Color.MIDNIGHTBLUE);
    	    
    	    lanesLabel = new Label(" | Lanes: " + battle.getLanes().size());
    	    lanesLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
    	  
    	    lanesLabel.setTextFill(Color.MIDNIGHTBLUE);


    	   
    	    
    	    
    	    hb.getChildren().addAll(scoreLabel,resourcesLabel,turnLabel,phaseLabel,lanesLabel);
    	    mainRoot.setPadding(new Insets(10,10,10,10));
    	    mainRoot.getChildren().add(hb);
    	    
    	    
    	    passTurn.setOnAction(e->{
    	    	battle.passTurn();
    	    	processTurnEasy(mainRoot, battle);
    	    	updateBattle1(battle);
    	    	if(battle.isGameOver()){
    	    		GameOverButton(battle.getScore());
    	    	}
    	    });
    	    BorderPane g1 = newBorderPane(pc1, sc1, trp1, vsc1);
    	    BorderPane g2 = newBorderPane(pc2, sc2, trp2, vsc2);
    	    BorderPane g3 = newBorderPane(pc3, sc3, trp3, vsc3);
    	
    	    
    	   
    	    
    	    g1.setTranslateY(350);
    	    g2.setTranslateY(500);
    	    g3.setTranslateY(640);
    	   
    	    g1.setScaleX(0.9);
    	    g2.setScaleX(0.9);
    	    g3.setScaleX(0.9);
    	 
    	    g1.setScaleY(0.5);
    	    g2.setScaleY(0.5);
    	    g3.setScaleY(0.5);
    	    
    	    AnchorPane.setRightAnchor(wl1, (double) 1680);
    	   	AnchorPane.setTopAnchor(wl1, y-100);
    	   	
    	   	AnchorPane.setRightAnchor(wl2, (double) 1680);
    	   	AnchorPane.setTopAnchor(wl2, y + 150-100);
    	   	
    	   	AnchorPane.setRightAnchor(wl3, (double) 1680);
    	   	AnchorPane.setTopAnchor(wl3, y + 300-100);
    	   	
    	  
    	   	wl1.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
    	   	wl2.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
    	   	wl3.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
    	  
    	   	wl1.setTextFill(Color.YELLOW);
    	   	wl2.setTextFill(Color.YELLOW);
    	   	wl3.setTextFill(Color.YELLOW);
    	   	
    	    AnchorPane.setRightAnchor(dl1, (double) 1690);
    	   	AnchorPane.setTopAnchor(dl1, y+60-100);
    	   	
    	   	AnchorPane.setRightAnchor(dl2, (double) 1690);
    	   	AnchorPane.setTopAnchor(dl2, y + 200-100);
    	   	
    	   	AnchorPane.setRightAnchor(dl3, (double) 1690);
    	   	AnchorPane.setTopAnchor(dl3, y + 360-100);
    
    	   	dl1.setFont(Font.font("Impact", FontWeight.BOLD, 22));
    	   	dl2.setFont(Font.font("Impact", FontWeight.BOLD, 22));
    	   	dl3.setFont(Font.font("Impact", FontWeight.BOLD, 22));
    	
    	   	dl1.setTextFill(Color.GREENYELLOW);
    	   	dl2.setTextFill(Color.GREENYELLOW);
    	   	dl3.setTextFill(Color.GREENYELLOW);
   
    	   	
    	   
    	   	
    	   	
    
    	   	
    	    
			mainRoot.getChildren().addAll(rectangle1,rectangle2,rectangle3,W1,W2,W3,g1,g2,g3,wl1,wl2,wl3,dl1,dl2,dl3);

    	    scene4 = new Scene(mainRoot);
    	    stage.setScene(scene4);
    	    stage.setFullScreen(true);
    	    stage.show();
     	   	
    	    }
	
	
	private void switchToSceneHard(Battle battle) {
		
		   wl1= new Label(""+battle.getOriginalLanes().get(0).getLaneWall().getBaseHealth());
		   wl2= new Label(""+battle.getOriginalLanes().get(1).getLaneWall().getBaseHealth());
		   wl3= new Label(""+battle.getOriginalLanes().get(2).getLaneWall().getBaseHealth());
			
		   wl4= new Label(""+battle.getOriginalLanes().get(3).getLaneWall().getBaseHealth());
		   wl5= new Label(""+battle.getOriginalLanes().get(4).getLaneWall().getBaseHealth());
		 
		   dl1=new Label("DL: "+battle.getOriginalLanes().get(0).getDangerLevel());
		   dl2=new Label("DL: "+battle.getOriginalLanes().get(1).getDangerLevel());
		   dl3=new Label("DL: "+battle.getOriginalLanes().get(2).getDangerLevel());
		   dl4=new Label("DL: "+battle.getOriginalLanes().get(3).getDangerLevel());
		   dl5=new Label("DL: "+battle.getOriginalLanes().get(4).getDangerLevel());
		   
	 	pc1 = new Label("0");
	    pc2 = new Label("0");
	    pc3 = new Label("0");
	    pc4 = new Label("0");
	    pc5 = new Label("0");
	    

	    sc1 = new Label("0");
	    sc2 = new Label("0");
	    sc3 = new Label("0");
	    sc4 = new Label("0");
	    sc5 = new Label("0");


	    

	    vsc1 = new Label("0");
	    vsc2 = new Label("0");
	    vsc3 = new Label("0");
	    vsc4 = new Label("0");
	    vsc5 = new Label("0");



	    trp1 = new Label("0");
	    trp2 = new Label("0");
	    trp3 = new Label("0");
	    trp4 = new Label("0");
	    trp5 = new Label("0");

		
	    mainRoot = new AnchorPane();
	    passTurn = new Button("Pass Turn");	
		passTurn.setStyle("-fx-background-color: transparent;");
	    passTurn.setOnMouseEntered(e -> passTurn.setStyle("-fx-background-color: #D3D3D3;"));
	    passTurn.setOnMouseExited(e -> passTurn.setStyle("-fx-background-color: transparent;"));
	    passTurn.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));
	    passTurn.setTextFill(Color.MIDNIGHTBLUE);
	    HBox hb=new HBox();
	    HBox hb1 = new HBox();
	    VBox vb = new VBox();
	    
	   
	   
	   
	    
	    scene4 = new Scene(mainRoot);

	    Image image = new Image("78.jpg");
	    ImageView imageView = new ImageView(image);
	 
	   
	    Button b2= new Button("Weapon Shop");
	    b2.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));
	    b2.setTextFill(Color.MIDNIGHTBLUE);
	    //b2.setStyle("-fx-background-color: transparent;");
	
		b2.setStyle("-fx-background-color: transparent;");
	    b2.setOnMouseEntered(e -> b2.setStyle("-fx-background-color: #D3D3D3;"));
	    b2.setOnMouseExited(e -> b2.setStyle("-fx-background-color: transparent;"));
	    hb1.setSpacing(250);
	    hb1.getChildren().addAll(b2,passTurn);
	    
	    AnchorPane.setTopAnchor(hb1, 80.0);
	    AnchorPane.setLeftAnchor(hb1, 600.0);
	    

	    mainRoot.getChildren().addAll(imageView,hb1);
	    b2.setOnAction(e -> {
	       
	        stage2 = new Stage();
	        stage2.setTitle("New Stage");


	        AnchorPane root1 = new AnchorPane(); 
	        Scene scene2 = new Scene(root1,1000,1000); 

	        
	        GridPane g = new GridPane();
	       
	        Button b1 = new Button("BUY");
	        Button b5 = new Button("BUY");
	        Button b3 = new Button("BUY");
	        Button b4 = new Button("BUY");
	        
	        g.add(b1, 0, 0);
	        g.add(b5, 0, 5);
	        g.add(b3, 0, 7);
	        g.add(b4, 0, 10);
	     

	        Image img1 = new Image("pc.png");
            ImageView view1 = new ImageView(img1);
            Image img2 = new Image("vsc.png");
            ImageView view2 = new ImageView(img2);
            Image img3 = new Image("sc.png");
            ImageView view3 = new ImageView(img3);
            Image img4 = new Image("trapp.png");
            ImageView view4 = new ImageView(img4);

            b1.setGraphic(view1);
            b5.setGraphic(view2);
            b3.setGraphic(view3);
            b4.setGraphic(view4);
            
            double buttonsize=230;
            view2.setFitWidth(300); 
            view1.setFitWidth(300); 
            view3.setFitWidth(300); 
            view4.setFitWidth(300); 
            view1.setFitHeight(buttonsize);
            view2.setFitHeight(buttonsize);
            view3.setFitHeight(buttonsize);
            view4.setFitHeight(buttonsize);
            
            Text Text1 = new Text("Name: Anti-Titan Shell \n"
            		+"Price: 25 \n"
            		+"Damage: 10 \n"
            		+"Type: Piercing Cannon  \n");
            Text1.setWrappingWidth(600); // Set the wrapping width for the text
            Text1.setTextAlignment(TextAlignment.CENTER); // Align text to center
            Text1.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
            Text1.setFill(Color.BLACK);
            Text1.setTranslateX(300);
          

            Text Text2 = new Text("Name: Long Range Spear \n"
            		+"Price: 25 \n"
            		+"Damage: 35 \n"
            		+"Type: Sniper Cannon  \n");
            Text2.setWrappingWidth(600); // Set the wrapping width for the text
            Text2.setTextAlignment(TextAlignment.CENTER); // Align text to center
            Text2.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
            Text2.setFill(Color.BLACK);
            Text2.setTranslateX(300);
            Text2.setTranslateY(240);
            
            Text Text3 = new Text("Name: Wall Spread Cannon \n"
            		+"Price: 100 \n"
            		+"Damage: 5 \n"
            		+"Type: Volley Spread Cannon  \n");
            Text3.setWrappingWidth(600); // Set the wrapping width for the text
            Text3.setTextAlignment(TextAlignment.CENTER); // Align text to center
            Text3.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
            Text3.setFill(Color.BLACK);
            Text3.setTranslateX(300);
            Text3.setTranslateY(470);
            
            Text Text4 = new Text("Name: Proximity Trap \n"
            		+"Price: 75 \n"
            		+"Damage: 100 \n"
            		+"Type: Wall Trap  \n");
            Text4.setWrappingWidth(600); // Set the wrapping width for the text
            Text4.setTextAlignment(TextAlignment.CENTER); // Align text to center
            Text4.setFont(Font.font("Futura", FontWeight.EXTRA_BOLD, 25)); // Set font, size, and weight
            Text4.setFill(Color.BLACK);
            g.getChildren().addAll(Text1,Text2,Text3,Text4);
            Text4.setTranslateX(300);
            Text4.setTranslateY(730);

            
         

	        root1.getChildren().add(g); 
	        

	   
	        stage2.setScene(scene2);
	        stage2.initOwner(stage);
	        stage2.show();
	        b1.setOnAction(j->{
            	Stage Stage1 = null;
				try {
					Stage1 = newStage(5,1,battle,mainRoot);
					
				} catch(InvalidLaneException u){
		        	Text txt = new Text(u.getMessage());
		        	mainRoot.getChildren().addAll(txt);
		        }catch(InsufficientResourcesException f){
		        	Text txt = new Text(f.getMessage());
		        	mainRoot.getChildren().addAll(txt);
		        	
		        }
            	Stage1.show();
        	    Stage1.toFront();


            	

            
            });
            b5.setOnAction(j->{
            	Stage Stage1 = null;
				try {
					Stage1 = newStage(5,2,battle,mainRoot);
					
				} catch(InvalidLaneException u){
					Text txt = new Text(u.getMessage());
		        	mainRoot.getChildren().add(txt);
		        	mainRoot.getChildren().addAll(txt);
		        }catch(InsufficientResourcesException f){
		        	Text txt = new Text(f.getMessage());
		        	mainRoot.getChildren().add(txt);
		        	mainRoot.getChildren().addAll(txt);
		        	
		        }
            	Stage1.show();
        	    Stage1.toFront();

            	

            
            });
            b3.setOnAction(j->{
            	Stage Stage1 = null;
				try {
					Stage1 = newStage(5,3,battle,mainRoot);
				
				} catch(InvalidLaneException u){
					Text txt = new Text(u.getMessage());
		        	mainRoot.getChildren().add(txt);
		        }catch(InsufficientResourcesException f){
		        	Text txt = new Text(f.getMessage());
		        	mainRoot.getChildren().add(txt);
		        	
		        }
            	Stage1.show();
        	    Stage1.toFront();

            	

            
            });
            b4.setOnAction(j->{
            	Stage Stage1 = null;
				try {
					Stage1 = newStage(5,4,battle,mainRoot);
			
				} catch(InvalidLaneException u){
		       
		        	Text txt = new Text(u.getMessage());
		        	mainRoot.getChildren().add(txt);
		        }catch(InsufficientResourcesException f){
		        	Text txt = new Text(f.getMessage());
		        	mainRoot.getChildren().addAll(txt);
		        	
		        }
            	Stage1.show();
        	    Stage1.toFront();
        	   

            
            });
	    });

	    imageView.setFitWidth(stage.getWidth());
	    imageView.setFitHeight(stage.getHeight());
	    
	    
	    
	    rectangle1 = new Rectangle(1700, 50,Color.TRANSPARENT);
	    rectangle2 = new Rectangle(1700, 50,Color.TRANSPARENT);
	    rectangle3 = new Rectangle(1700, 50,Color.TRANSPARENT);
	    rectangle4 = new Rectangle(1700, 50,Color.TRANSPARENT);
	    rectangle5 = new Rectangle(1700, 50,Color.TRANSPARENT);
	    
 
	    double y = 380;

	    AnchorPane.setTopAnchor(rectangle1,y);
	    AnchorPane.setTopAnchor(rectangle2,y + 120  );
	    AnchorPane.setTopAnchor(rectangle3,y + 240 );
	    AnchorPane.setTopAnchor(rectangle4,y + 360 );
	    AnchorPane.setTopAnchor(rectangle5,y + 480 );
	    AnchorPane.setLeftAnchor(rectangle1, (double) 225);
	    AnchorPane.setLeftAnchor(rectangle2, (double) 225);
	    AnchorPane.setLeftAnchor(rectangle3, (double) 225);
	    AnchorPane.setLeftAnchor(rectangle4, (double) 225);
	    AnchorPane.setLeftAnchor(rectangle5, (double) 225);
	   
	    
	    
	    ImageView W1 = wallImg();
	    ImageView W2 = wallImg();
	    ImageView W3 = wallImg();
	    ImageView W4 = wallImg();
	    ImageView W5 = wallImg();

 	    AnchorPane.setRightAnchor(W1, (double) 1650);
	   	AnchorPane.setTopAnchor(W1, y-90);
	   	
	   	AnchorPane.setRightAnchor(W2, (double) 1650);
	   	AnchorPane.setTopAnchor(W2, y + 120-90);
	   	
	   	AnchorPane.setRightAnchor(W3, (double) 1650);
	   	AnchorPane.setTopAnchor(W3, y + 240-90);
	   	
	   	AnchorPane.setRightAnchor(W4, (double) 1650);
	   	AnchorPane.setTopAnchor(W4, y + 360-90);
	   	
	   	AnchorPane.setRightAnchor(W5, (double) 1650);
	   	AnchorPane.setTopAnchor(W5, y + 480-90);
	   	
	    AnchorPane.setRightAnchor(wl1, (double) 1680);
	   	AnchorPane.setTopAnchor(wl1, y-100);
	   	
	   	AnchorPane.setRightAnchor(wl2, (double) 1680);
	   	AnchorPane.setTopAnchor(wl2, y + 120-100);
	   	
	   	AnchorPane.setRightAnchor(wl3, (double) 1680);
	   	AnchorPane.setTopAnchor(wl3, y + 240-100);
	   	
	   	AnchorPane.setRightAnchor(wl4, (double) 1680);
	   	AnchorPane.setTopAnchor(wl4, y + 360-100);
	   	
	   	AnchorPane.setRightAnchor(wl5, (double) 1680);
	   	AnchorPane.setTopAnchor(wl5, y + 480-100);
	   	wl1.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
	   	wl2.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
	   	wl3.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
	   	wl4.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
	   	wl5.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 27));
	   	wl1.setTextFill(Color.YELLOW);
	   	wl2.setTextFill(Color.YELLOW);
	   	wl3.setTextFill(Color.YELLOW);
	   	wl4.setTextFill(Color.YELLOW);
	   	wl5.setTextFill(Color.YELLOW);
	   	
	   	
	   	
	    AnchorPane.setRightAnchor(dl1, (double) 1690);
	   	AnchorPane.setTopAnchor(dl1, y-38);
	   	
	   	AnchorPane.setRightAnchor(dl2, (double) 1690);
	   	AnchorPane.setTopAnchor(dl2, y + 120-38);
	   	
	   	AnchorPane.setRightAnchor(dl3, (double) 1690);
	   	AnchorPane.setTopAnchor(dl3, y + 240-38);
	   	
	   	AnchorPane.setRightAnchor(dl4, (double) 1690);
	   	AnchorPane.setTopAnchor(dl4, y + 360-38);
	   	
	   	AnchorPane.setRightAnchor(dl5, (double) 1690);
	   	AnchorPane.setTopAnchor(dl5, y + 480-38);
	   	dl1.setFont(Font.font("Impact", FontWeight.BOLD, 22));
	   	dl2.setFont(Font.font("Impact", FontWeight.BOLD, 22));
	   	dl3.setFont(Font.font("Impact", FontWeight.BOLD, 22));
	   	dl4.setFont(Font.font("Impact", FontWeight.BOLD, 22));
	   	dl5.setFont(Font.font("Impact", FontWeight.BOLD, 22));
	   	dl1.setTextFill(Color.GREENYELLOW);
	   	dl2.setTextFill(Color.GREENYELLOW);
	   	dl3.setTextFill(Color.GREENYELLOW);
	   	dl4.setTextFill(Color.GREENYELLOW);
	   	dl5.setTextFill(Color.GREENYELLOW);
	   	
	   	
	   	
 	   	mainRoot.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,W1,W2,W3,W4,W5,wl1,wl2,wl3,wl4,wl5,dl1,dl2,dl3,dl4,dl5);
 	   	

	    scoreLabel = new Label("Score is: " + battle.getScore());
	    scoreLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
	    scoreLabel.setTextFill(Color.MIDNIGHTBLUE);
	    
	    resourcesLabel = new Label(" | Resources: " + battle.getResourcesGathered());
	    resourcesLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style    	
	    resourcesLabel.setTextFill(Color.MIDNIGHTBLUE);
	    turnLabel = new Label(" | Turn: " + battle.getNumberOfTurns());
	    turnLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
	    turnLabel.setTextFill(Color.MIDNIGHTBLUE);

	    
	    
	    phaseLabel = new Label(" | Current Phase : " + battle.getBattlePhase());
	    phaseLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
	    phaseLabel.setTextFill(Color.MIDNIGHTBLUE);
	    
	    lanesLabel = new Label(" | Lanes: " + battle.getLanes().size());
	    lanesLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 40));// Set font size and style
	    
	    lanesLabel.setTextFill(Color.MIDNIGHTBLUE);


	   
	    
	    
	    hb.getChildren().addAll(scoreLabel,resourcesLabel,turnLabel,phaseLabel,lanesLabel);
	    mainRoot.setPadding(new Insets(10,10,10,10));
	    mainRoot.getChildren().add(hb);
 	   	
 	   	
 	   	
 	   
	    
	    passTurn.setOnAction(e->{
	    	battle.passTurn();
	    	processTurnHard(mainRoot,battle);
	    	if(battle.isGameOver()){
	    		GameOverButton(battle.getScore());
	    	}
	    });
	    
	    BorderPane g1 = newBorderPane(pc1, sc1, trp1, vsc1);
	    BorderPane g2 = newBorderPane(pc2, sc2, trp2, vsc2);
	    BorderPane g3 = newBorderPane(pc3, sc3, trp3, vsc3);
	    BorderPane g4 = newBorderPane(pc4, sc4, trp4, vsc4);
	    BorderPane g5 = newBorderPane(pc5, sc5, trp5, vsc5);
	    
	   
	    
	    g1.setTranslateY(280);
	    g2.setTranslateY(400);
	    g3.setTranslateY(530);
	    g4.setTranslateY(640);
	    g5.setTranslateY(750);
	    g1.setScaleX(0.9);
	    g2.setScaleX(0.9);
	    g3.setScaleX(0.9);
	    g4.setScaleX(0.9);
	    g5.setScaleX(0.9);
	    g1.setScaleY(0.5);
	    g2.setScaleY(0.5);
	    g3.setScaleY(0.5);
	    g4.setScaleY(0.5);
	    g5.setScaleY(0.5);
	    
	    updateBattle1(battle);
	    mainRoot.getChildren().addAll(vb,g1,g2,g3,g4,g5);
	    stage.setScene(scene4);
	    stage.setFullScreen(true);
	    stage.show();
	    }
	

	
	private ImageView ColossalImg(){

	    Image image2=new Image("Colossal23.png");
	    ImageView imageView2 = new ImageView(image2);
	    imageView2.setFitHeight(190);
	    imageView2.setFitWidth(70);
	    imageView2.setScaleX(-1);
	    return imageView2;
	}
	private ImageView wallImg(){
		ImageView img2 = new ImageView(new Image("towerr.png"));
	    img2.setFitHeight(170.5);
	    img2.setFitWidth(130.5);
	    return img2;
	}
	private ImageView trapImg(){
		ImageView img = new ImageView(new Image("trapp.png"));
	    img.setFitHeight(70.5);
	    img.setFitWidth(70.5);
	    return img;
	}
	private ImageView PureImg(){
		Image img= new Image("Colossal.png");
		ImageView imageView = new ImageView(img);
		imageView.setFitHeight(130);
		imageView.setFitWidth(70);
		imageView.setScaleX(-1);
		return imageView;
	}
	private ImageView AbnormalImg(){
		Image img= new Image("Abnormal.png");
		ImageView imageView = new ImageView(img);
		imageView.setFitHeight(115);
		imageView.setFitWidth(70);
		imageView.setScaleX(-1);
		return imageView;
	}
	
	private ImageView ArmoredImg(){
		Image img= new Image("Titan5.gif");
		ImageView imageView = new ImageView(img);
		imageView.setFitHeight(130);
		imageView.setFitWidth(70);
		imageView.setScaleX(-1);
		return imageView;
	}
	private void titansSpawner(ImageView img, double z, int p){
		if(p == 0){
			AnchorPane.setTopAnchor(img, z);
		}
		else if(p==1){
			AnchorPane.setTopAnchor(img, z+105);
		}
		else if(p==2){
			AnchorPane.setTopAnchor(img, z+210);
		}
		
		else if(p==3){
			AnchorPane.setTopAnchor(img, z+335);
		}
		else{
			AnchorPane.setTopAnchor(img, z+480);
		}
	
	}
	private void labelSpawnerHard(Label img, double z, int p){
		if(p == 0){
			AnchorPane.setTopAnchor(img, z);
		}
		else if(p==1){
			AnchorPane.setTopAnchor(img, z+105);
		}
		else if(p==2){
			AnchorPane.setTopAnchor(img, z+210);
		}
		
		else if(p==3){
			AnchorPane.setTopAnchor(img, z+335);
		}
		else{
			AnchorPane.setTopAnchor(img, z+480);
		}
	
	}
	private void labelSpawnerEasy(Label img, double z, int p){
		if(p == 0){
			AnchorPane.setTopAnchor(img, z-59);
		}
		else if(p==1){
			AnchorPane.setTopAnchor(img, z+120-30);
		}
		else {
			AnchorPane.setTopAnchor(img, z+240-15);
		}
	
	}
	
	private void titansSpawnerEasy(ImageView img, double z, int p){
		if(p == 0){
			AnchorPane.setTopAnchor(img, z-100);
		}
		else if(p==1){
			AnchorPane.setTopAnchor(img, z+150-100);
		}
		else {
			AnchorPane.setTopAnchor(img, z+300-100);
		}
	
	}
	
	
	private Stage newStage(int n, int weaponCode, Battle x,AnchorPane ap) throws InsufficientResourcesException,InvalidLaneException {
	    Stage stage = new Stage();
	    AnchorPane root = new AnchorPane();
	    Scene scene = new Scene(root, 600, 500); 
	    int buttonWidth = 100; 
	    int horizontalGap = 20; 
	    GridPane root2= new GridPane();
	    Scene scene18=new Scene(root2,600,500);


	    for (int i = 1; i <= n; i++) {
	        int laneIndex = i; // Store the current lane index

	        Button button = new Button("Lane " + laneIndex);
	        button.setLayoutX((buttonWidth + horizontalGap) * (i - 1));
	        String g = button.getText();
	        root.getChildren().add(button); 
	        button.setOnAction(event ->{
	        try{
	        	x.purchaseWeapon(weaponCode, x.getOriginalLanes().get(laneIndex - 1));
	        	updateLabel(resourcesLabel, "|  Resources: "+ x.getResourcesGathered());
	        	if(weaponCode==1 && laneIndex ==1){
	        	}
	        	if(x.getOriginalLanes().size()==3){
	        		processTurnEasy(mainRoot,x);
	        		updateWeaponNumber(x.getOriginalLanes().get(laneIndex-1),laneIndex-1);
	     
	        		updateBattle1(x);
	        		stage.close();
	        		stage2.close();
	        	}
	        	else
	        		processTurnHard(mainRoot,x);
	        		updateWeaponNumber(x.getOriginalLanes().get(laneIndex-1),laneIndex-1);
	        		
	        		updateBattle1(x);
	        		stage2.close();
	        		stage.close();
	        		
	        }catch(InvalidLaneException e){
	        	Text txt = new Text(e.getMessage());
	        	Button r= new Button("Return");
	        	root2.add(r, 400, 1500);
	        	root2.add(txt, 0, 20);
	        	stage.setScene(scene18);
	        	r.setOnAction(k->{
	        		stage.setScene(scene);
	        	});
	        	stage.setScene(scene18);
	    	    stage.show();
	    	    stage.toFront();
	    	    stage.setAlwaysOnTop(true);
	        }catch(InsufficientResourcesException f){
	        	Text txt = new Text(f.getMessage());
	        	Button r= new Button("Return");
	        	root2.add(r, 400, 1500);
	        	root2.add(txt, 0, 20);
	        	stage.setScene(scene18);
	        	r.setOnAction(k->{
	        		stage.close();
	        	});
	        	stage.setScene(scene18);
	    	    stage.show();
	    	    stage.toFront();
	    	    stage.setAlwaysOnTop(true);
	        	
	        }
	        });
	      

	    

	    stage.setScene(scene);
	    stage.show();
	    stage.toFront();
	    stage.setAlwaysOnTop(true);
	    }

	    return stage;
	}
	public void updateLabel(Label label, String newValue) {
	    if(label != null)
	    label.setText(newValue);
	}
	
	public void updateBattle1(Battle battle){
	
		  scoreLabel.setText("Score is: " + battle.getScore());
		  resourcesLabel.setText(" | Resources: " + battle.getResourcesGathered());
		  turnLabel.setText(" | Turn: " + battle.getNumberOfTurns());
		  phaseLabel.setText(" | Current Phase : " + battle.getBattlePhase());
		  lanesLabel.setText(" | Lanes: " + battle.getLanes().size());
		  wl1.setText(""+battle.getOriginalLanes().get(0).getLaneWall().getCurrentHealth());
		  wl2.setText(""+battle.getOriginalLanes().get(1).getLaneWall().getCurrentHealth());
		  wl3.setText(""+battle.getOriginalLanes().get(2).getLaneWall().getCurrentHealth());
		  dl1.setText("DL: "+battle.getOriginalLanes().get(0).getDangerLevel());
		  dl2.setText("DL: "+battle.getOriginalLanes().get(1).getDangerLevel());
		  dl3.setText("DL: "+battle.getOriginalLanes().get(2).getDangerLevel());
		  if(battle.getOriginalLanes().size()==5){
			  wl4.setText(""+battle.getOriginalLanes().get(3).getLaneWall().getCurrentHealth());
			  wl5.setText(""+battle.getOriginalLanes().get(4).getLaneWall().getCurrentHealth());
			  dl4.setText("DL: "+battle.getOriginalLanes().get(3).getDangerLevel());
			  dl5.setText("DL: "+battle.getOriginalLanes().get(4).getDangerLevel());
		  }

		

	}
	
	
	
	
	
	public void processTurnEasy(AnchorPane root, Battle battle) {
	    
	    for (ImageView img : addedImages) {
	        if (img != null) {
	            root.getChildren().remove(img);
	        }
	    }
	    for (Label c : titanLabels) {
	        if (c != null) {
	            root.getChildren().remove(c);
	        }
	    }
	    titanLabels.clear();
	    addedImages.clear();

	    for (Lane a : battle.getOriginalLanes()) {
	        int p = battle.getOriginalLanes().indexOf(a);
	        if (a.isLaneLost()) {
	            if (p == 0) {
	                if (rectangle1 != null) {
	                    rectangle1.setFill(Color.RED);
	                    if (!mainRoot.getChildren().contains(rectangle1)) {
	                        mainRoot.getChildren().add(rectangle1);
	                    }
	                } 
	            } else if (p == 1) {
	                if (rectangle2 != null) {
	                    rectangle2.setFill(Color.RED);
	                    if (!mainRoot.getChildren().contains(rectangle2)) {
	                        mainRoot.getChildren().add(rectangle2);
	                    }
	                } 
	            } else {
	                if (rectangle3 != null) {
	                    rectangle3.setFill(Color.RED);
	                    if (!mainRoot.getChildren().contains(rectangle3)) {
	                        mainRoot.getChildren().add(rectangle3);
	                    }
	                } 
	            }
	        } else {
	            for (Titan b : a.getTitans()) {
	                ImageView img = null;
	                Label healthLabel = null;

	                if (b instanceof PureTitan) {
	                    img = PureImg();
	                } else if (b instanceof ColossalTitan) {
	                    img = ColossalImg();
	                } else if (b instanceof ArmoredTitan) {
	                    img = ArmoredImg();
	                } else {
	                    img = AbnormalImg();
	                }

	                if (img != null) {
	                	int s = b.getSpeed()*9;
	                	int k =0;
	                	if(b.getDistance()-s<220){
	                		b.setDistance(0);
	                		AnchorPane.setLeftAnchor(img, 220.0);
	                		k = 220;
	                	}
	                	else{
	                		b.setDistance(b.getDistance()-s);
	                		AnchorPane.setLeftAnchor(img, (double)b.getDistance());
	                		k = b.getDistance();

	                	}
	                    titansSpawnerEasy(img, 450, p);
	                    root.getChildren().add(img);
	                    addedImages.add(img);

	                    // Create and add health label
	                    healthLabel = new Label("  Health: " + b.getCurrentHealth());
	                    healthLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 19));
	                    healthLabel.setTextFill(Color.BLACK);
	                    labelSpawnerEasy(healthLabel, 400, p);
	                    AnchorPane.setLeftAnchor(healthLabel, (double) k);
	                    root.getChildren().add(healthLabel);
	                    titanLabels.add(healthLabel);
	                } else {
	                    System.out.println("Image for titan " + b + " is null");
	                }
	            }
	        }
	    }
	}

	
	
	
	public void processTurnHard(AnchorPane root, Battle battle) {
	    
	    for (ImageView img : addedImages) {
	        root.getChildren().remove(img);
	    }
	    for (Label c : titanLabels) {
	        root.getChildren().remove(c);
	    }
	    titanLabels.clear();
	    addedImages.clear();
	    
	    
	    for (Lane a : battle.getOriginalLanes()) {
	        int p = battle.getOriginalLanes().indexOf(a);
	        if (!a.isLaneLost()) {
	            for (Titan b : a.getTitans()) {
	                ImageView img = null;
	                Label healthLabel = new Label("  Health: " + b.getCurrentHealth());
	                healthLabel.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 19));
	                healthLabel.setTextFill(Color.BLACK);

	                if (b instanceof PureTitan) {
	                    img = PureImg();
	                } else if (b instanceof ColossalTitan) {
	                    img = ColossalImg();
	                } else if (b instanceof ArmoredTitan) {
	                    img = ArmoredImg();
	                } else if (b instanceof AbnormalTitan) {
	                    img = AbnormalImg();
	                }

	                if (img != null) {
	                	int s = b.getSpeed()*9;
	                	int k =0;
	                	if(b.getDistance()-s<220){
	                		b.setDistance(0);
	                		AnchorPane.setLeftAnchor(img, 220.0);
	                		k = 220;
	                	}
	                	else{
	                		b.setDistance(b.getDistance()-s);
	                		AnchorPane.setLeftAnchor(img, (double)b.getDistance());
	                		k = b.getDistance();

	                	}
	                    titansSpawner(img, 300, p);
	                    root.getChildren().add(img);
	                    addedImages.add(img);

	                    labelSpawnerHard(healthLabel, 280, p);
	                    AnchorPane.setLeftAnchor(healthLabel, (double)k);
	                    root.getChildren().add(healthLabel);
	                    titanLabels.add(healthLabel);
	                }
	            }
	        } else {
	         
	            switch (p) {
	                case 0:
	                    rectangle1.setFill(Color.RED);
	                    break;
	                case 1:
	                    rectangle2.setFill(Color.RED);
	                    break;
	                case 2:
	                    rectangle3.setFill(Color.RED);
	                    break;
	                case 3:
	                    rectangle4.setFill(Color.RED);
	                    break;
	                case 4:
	                    rectangle5.setFill(Color.RED);
	                    break;
	                default:
	                    break;
	            }
	        }
	    }
	    
	    

	 
	    updateBattle1(battle);
	}
	public void updateWeaponNumber(Lane a,int index){
		int pc = 0;
		int sc = 0;
		int vsc = 0;
		int trp = 0;
		for(Weapon p : a.getWeapons()){
			if(p instanceof PiercingCannon)
				pc++;
			else if(p instanceof SniperCannon)
				sc++;
			else if(p instanceof VolleySpreadCannon)
				vsc++;
			else if(p instanceof WallTrap)
				trp++;
		}
		if(index ==0){
		updateLabel(pc1,""+ pc);
		updateLabel(sc1,""+ sc);
		updateLabel(vsc1,""+ vsc);
		updateLabel(trp1,""+ trp);
		}
		if(index ==1){
			updateLabel(pc2,""+ pc);
			updateLabel(sc2,""+ sc);
			updateLabel(vsc2,""+ vsc);
			updateLabel(trp2,""+ trp);
			}
		if(index ==2){
			updateLabel(pc3,""+ pc);
			updateLabel(sc3,""+ sc);
			updateLabel(vsc3,""+ vsc);
			updateLabel(trp3,""+ trp);
			}
		if(index ==3){
			updateLabel(pc4,""+ pc);
			updateLabel(sc4,""+ sc);
			updateLabel(vsc4,""+ vsc);
			updateLabel(trp4,""+ trp);
			}
		if(index ==4){
			updateLabel(pc5,""+ pc);
			updateLabel(sc5,""+ sc);
			updateLabel(vsc5,""+ vsc);
			updateLabel(trp5,""+ trp);
			}
	}
	
	private BorderPane newBorderPane(Label pc,Label vsc, Label trp,Label sc){
	BorderPane root4 = new BorderPane();
		GridPane jk = new GridPane();
     jk.setHgap(10); 
     jk.setVgap(10); 
     jk.setPadding(new Insets(10)); 

     Image img11 = new Image("pc.png");
     ImageView view11 = new ImageView(img11);
     view11.setFitWidth(50); 
     view11.setFitHeight(50); 
    
     jk.add(view11, 0, 0);
     jk.add(pc, 0, 1);

     Image img22 = new Image("vsc.png");
     ImageView view22 = new ImageView(img22);
     view22.setFitWidth(50); 
     view22.setFitHeight(50); 
     
     jk.add(view22, 1, 0);
     jk.add(vsc, 1, 1);

     Image img33 = new Image("sc.png");
     ImageView view33 = new ImageView(img33);
     view33.setFitWidth(50); 
     view33.setFitHeight(50); 
  
     jk.add(view33, 0, 2);
     jk.add(sc, 0, 3);

     Image img44 = new Image("trapp.png");
     ImageView view44 = new ImageView(img44);
     view44.setFitWidth(50); 
     view44.setFitHeight(50); 
    
     jk.add(view44, 1, 2);
     jk.add(trp, 1, 3);
     

   
     root4.setCenter(jk); 
     jk.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

      return root4;
	}
	
	public void GameOverButton(int score) {
	    Image img = new Image("gameover.jpg");
	    ImageView imgv = new ImageView(img);
	    imgv.setFitWidth(1920);
	    imgv.setFitHeight(1080);
	    imgv.setPreserveRatio(true);
	    
	    VBox v = new VBox();
	    v.setSpacing(40.0);
	    v.setAlignment(Pos.CENTER); 
	    Button bb = new Button("Return To Main Menu");
	    Label scoreover = new Label("Your Score: " + score);
	    v.getChildren().addAll(scoreover, bb); 
	    scoreover.setFont(Font.font("Impact", FontWeight.BOLD, 30));
	    bb.setTextFill(Color.BLACK);
	    bb.setFont(Font.font("Impact", FontWeight.LIGHT, 25));
	    bb.setTranslateY(55);
	    StackPane spp = new StackPane();    
	    spp.getChildren().addAll(imgv, v);
	    StackPane.setAlignment(v, Pos.CENTER); 

	    bb.setOnAction(e -> {
	        stage.setScene(scene);
	    });

	    Scene go = new Scene(spp, 1920, 1080);
	    stage.setScene(go);
	    stage.setFullScreen(true);
	}

	   
	
	
    public static void main(String[] args) {
        launch(args);
    }
}
    	      