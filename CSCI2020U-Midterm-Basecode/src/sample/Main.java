package midterm2021;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.awt.*;
import javafx.scene.canvas.Canvas;
public class Main<mainScene, btApp3, btApp2, btApp1> extends Application {
    private int frameWidth = 35;
    private int frameHeight = 50;
    private int numFrames = 6;
    private int sourceHeightOffset = 90;
    private int sourceWidthOffset = 95;
    private int frameIndex = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        //        Create Canvas object and add it into the scene
        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);

        primaryStage.setTitle("Graphics - midterm");
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(root);
    }
    private void draw(Group root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        Drawing first A
        gc.setStroke(Color.RED);
        gc.strokeLine(370, 150, 330, 300);
        gc.strokeLine(370, 150, 410, 300);
        gc.strokeLine(350, 220, 390, 220);
        //dot
        gc.fillOval(300, 295, 390, 220);
        //Drawing second A
        gc.strokeLine(370, 150, 330, 300);
        gc.strokeLine(370, 150, 410, 300);
        gc.strokeLine(350, 220, 390, 220);
    }

        primaryStage.setTitle("CSCI2020U - Midterm");

    GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


    //      Creating the menu buttons
    Button btApp1 = new Button("Animation");
        btApp1.setPrefWidth(200);
    Button btApp2 = new Button("2D Graphics");
        btApp2.setPrefWidth(200);
    Button btApp3 = new Button("About");
        btApp3.setPrefWidth(200);


        btApp1.setOnAction(new EventHandler<ActionEvent>() {

    }
        private void drawAnimation(Group root) {
            Image image = new Image(getClass().getClassLoader().getResource("midterm2021/ducks.png").toString());
            Timeline timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent actionEvent) {
            gc.setFill(Color.BLACK);
            gc.fillRect(200, 50, frameWidth, frameHeight);
            gc.drawImage(image, sourceWidthOffset, sourceHeightOffset, frameWidth, frameHeight, 200, 50, frameWidth, frameHeight);
            frameIndex = (frameIndex+1) % numFrames;
            sourceHeightOffset = frameHeight*frameIndex;
        }
            }));

            timeline.playFromStart();
        }
        btApp2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                    Display the "2D Drawing" in the CENTER,
//                    and a "Back to Main" on the TOP
        }
    });

        btApp3.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                    Display the "About" in the CENTER,
//                    and a "Back to Main" on the TOP
            System.out.println("Clicked on About button");
        }
    });

//        Add the menu buttons to the grid
        grid.add(btApp1, 0,1);
        grid.add(btApp2, 0,2);
        grid.add(btApp3, 0,3);

    // main App Scene
    Scene mainScene = new Scene(grid, 300, 275);

        primaryStage.setScene(mainScene);
        primaryStage.show();
}

    public static void main(String[] args) {
        private void XMLFFileReader () {
            try {
                File fXmlFilefile = new File("resources/info.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                document.getDocumentElement().normalize();

                NodeList itemNodes = doc.getElementsByTagName("student");

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());


                for (int i = 0; i < itemNodes.getLength(); i++) {

                    Element itemElement = (Element) itemNodes.item(i);

                    String id = getTagValue("id", itemElement);
                    String name = getTagValue("name", itemElement);
                    String email = getTagValue("email", itemElement);
                    String description = getTagValue("Description", itemElement);

                    System.out.printf("[%s] %s (%s,%s): %s student\n", id, name, email);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public String getTagValue (String tagName, Element elem){

            NodeList tags = elem.getElementsByTagName(tagName);
            if (tags.getLength() > 0) {
                return tags.item(0).getTextContent();
            }
            return null;
        }
    }




