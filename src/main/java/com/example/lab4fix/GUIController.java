package com.example.lab4fix;

import functions.Author;
import functions.DocReader;
import functions.InfoAnalyzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class GUIController {
    public Label probabilityValue;
    public Button readFile;
    public ListView<String> spamersList;
    public BarChart<String,Number> chart;

    @FXML
    protected void loadFileForAnalysis() throws ParseException {
        InfoAnalyzer analyzer = new InfoAnalyzer();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(probabilityValue.getScene().getWindow());
        ArrayList<Author> authors = DocReader.readFromFile(file);

        probabilityValue.setText("Cреднее значение PROBABILITY: " + analyzer.getAverageProbability());

        analyzer.findSpamers(authors);
        ObservableList<String> spamers = FXCollections.observableArrayList(analyzer.getSpamersList());
        spamersList.setItems(spamers);

        chart.getData().clear();
        XYChart.Series<String,Number> authorAndMail = new XYChart.Series();
        authorAndMail.setName("Отправитель/количество писем");
        for (int i = 0; i < authors.size(); i++) {
            authorAndMail.getData().add(new XYChart.Data(authors.get(i).getName(),authors.get(i).getMailAmount()));
        }
        chart.getData().add(authorAndMail);

    }


}