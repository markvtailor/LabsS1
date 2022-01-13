import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AuthorsHistogram extends Application {
    static List<Float> mailAmount = new ArrayList<>(Authors.authors.values());
    static List<String> authorsName = new ArrayList<>(Authors.authors.keySet());
    @Override
    public void start(Stage s) throws Exception {
        s.setTitle("Гистограмма отправителей");
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Отправитель");
        NumberAxis y = new NumberAxis();
        y.setLabel("Количество писем");
        BarChart barChart = new BarChart(x,y);

        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < authorsName.size(); i++) {
            series.getData().add(new XYChart.Data(authorsName.get(i),mailAmount.get(i)));
        }
        barChart.getData().add(series);
        VBox vBox = new VBox(barChart);
        Scene scene = new Scene(vBox,400,300);
        s.setScene(scene);
        s.setHeight(600);
        s.setWidth(1200);
        s.show();



    }

}
