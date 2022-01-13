import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.ArrayList;


public class Diagram extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Простое скользящее среднее");
        final NumberAxis x = new NumberAxis();
        final NumberAxis y = new NumberAxis();
        x.setLabel("Номер");
        y.setLabel("Значение");
        final LineChart<Number, Number> lineChart = new LineChart<Number,Number>(x,y);
        lineChart.setTitle("Диаграмма");
        XYChart.Series series = new XYChart.Series();
        series.setName("Простое скользящее среднее");

        addData(series, SimpleMovingAverage.numbers);

        Scene scene  = new Scene(lineChart  ,800,600);
        lineChart.getData().add(series);
        primaryStage.setOnCloseRequest(event -> Platform.exit());
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    public void addData(XYChart.Series series,ArrayList<Double> numbers){
        for (Double number:
                numbers) {
            series.getData().add(new XYChart.Data(numbers.indexOf(number)+1, number ));
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
