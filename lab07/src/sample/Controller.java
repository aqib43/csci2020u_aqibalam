package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;

public class Controller {

    private HashMap<String, Integer> warningsByType = new HashMap<>();
    private static Color[] colors = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON
    };

    @FXML Canvas mainCanvas;
    @FXML GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        countWarnings("weatherwarnings-2015.csv");
        drawPieG();
    }

    private void countWarnings(String fileName) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String warningType = columns[5];

                if (warningsByType.containsKey(warningType)) {
                    int oldValue = warningsByType.get(warningType);
                    warningsByType.replace(warningType, oldValue + 1);
                } else {

                    warningsByType.put(warningType, 1);
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawPieG() {
        int numOfWarningTypes = warningsByType.keySet().size();

        double[] angle = new double[numOfWarningTypes];


        int total = 0;
        for (String warningType : warningsByType.keySet()) {
            total += warningsByType.get(warningType);
        }

        int i = 0;

        for (String warningType : warningsByType.keySet()) {
            angle[i] = ((double) warningsByType.get(warningType) / (double) total) * 360;
            i++;
        }


        double x = 100;
        double y = 0.0;
        double startAngle = 0.0;
        i = 0;
        for (String warningType : warningsByType.keySet()) {
            gc.setFill(colors[i]);

            gc.fillRect(x, y, 50, 30);

            gc.fillText(warningType, x + 60, y + 20);
            y += 40;


            gc.fillArc(400,0.0,250,250,startAngle,angle[i], ArcType.ROUND);
            startAngle += angle[i];
            i++;
        }
    }

}
