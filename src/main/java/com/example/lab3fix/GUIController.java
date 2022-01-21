package com.example.lab3fix;

import functions.Input;
import functions.InputFromFile;
import functions.InputFromWEB;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import functions.Calculator;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class GUIController {
    public Input input = new Input();
    public TextField value;
    public Label periodLabel;
    public TextField periodInput;
    public TextField urlText;
    public LineChart chart;
    Calculator calculator = new Calculator();
    public Label sma;
    public Label mft;

    @FXML
    protected void BuildDiagram(){
        chart.getData().clear();
        XYChart.Series<Number,Number> smaSeries = new XYChart.Series();
        smaSeries.setName("SMA");
        for (int i = 0; i < calculator.getSMA(input.getData()).size(); i++) {
            smaSeries.getData().add(new XYChart.Data(String.valueOf(i),calculator.getSMA(input.getData()).get(i)));
        }
        XYChart.Series<Number,Number> mftSeries = new XYChart.Series<>();
        mftSeries.setName("MFT");
        for (int i = 0; i < calculator.useMedianFilter(input).size(); i++) {
            mftSeries.getData().add(new XYChart.Data(String.valueOf(i),calculator.useMedianFilter(input).get(i)));
        }
        chart.getData().addAll(smaSeries,mftSeries);
    }

    @FXML
    protected void setFormat(){
        Pattern pattern = Pattern.compile("\\d*|\\d+\\.\\d+");
        TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> pattern.matcher(change.getControlNewText()).matches() ? change : null);
        value.setTextFormatter(formatter);
    }

    @FXML
    protected void addData(){
        input.addToData(Double.parseDouble(value.getText()));
        value.setText("");
    }

    @FXML
    protected void onSMAButtonClick() {
        System.out.println(input.getData()+"test");
        sma.setText("ПСС: " + calculator.getSMA(input.getData()).toString());
    }

    @FXML
    protected void onMFTButtonClick() {
        mft.setText("Медианный фильтр: " + calculator.useMedianFilter(input).toString());
    }

    @FXML
    protected void locateFile() throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(sma.getScene().getWindow());
        InputFromFile.inputFromFile(file,input);
        System.out.println(input.getData());
    }

    @FXML
    protected void setPeriod() {
        calculator.setPeriod(Integer.parseInt(periodInput.getText()));
        if(Integer.parseInt(periodInput.getText()) == 0){
            periodLabel.setText("Период не может быть меньше 1. Установлено значение по умолчанию - 3");
        }else periodLabel.setText("Период:" + periodInput.getText());
        periodInput.setText("");
    }

    @FXML
    protected void inputURL() {
        try {
            InputFromWEB.inputFromURL(urlText.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlText.setText("");
    }
}