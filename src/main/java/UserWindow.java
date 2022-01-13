import javafx.application.Application;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserWindow extends JFrame{

    private JButton acceptInput = new JButton("Добавить значение");
    private JButton inputFromFile = new JButton("Добавить значения из файла");
    private JButton inputFromWEB = new JButton("Добавить значения из Интернета");
    private JButton showOutput = new JButton("Рассчитать ПСС");
    private JButton showChart = new JButton("Показать диаграмму");
    private JLabel labelInput = new JLabel("Введите значение:");

    private final JFileChooser fc = new JFileChooser();

    NumberFormat inputFormat = DecimalFormat.getInstance();
    private JFormattedTextField input = new JFormattedTextField(inputFormat);

    public UserWindow(){

        super("Простое скольязящее среднее");
        this.setBounds(300,300,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Файл txt","txt");
        fc.addChoosableFileFilter(filter);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(labelInput);
        container.add(input);


        acceptInput.addActionListener(new ButtonEventAddData());
        container.add(acceptInput);
        showOutput.addActionListener(new ButtonEventCalculateSMA());
        container.add(showOutput);
        inputFromFile.addActionListener(new ButtonEventDataFromFile());
        container.add(inputFromFile);
        inputFromWEB.addActionListener(new ButtonEventDataFromURL());
        container.add(inputFromWEB);
        showChart.addActionListener(new ButtonEventShowChart());
        container.add(showChart);



    }


    class ButtonEventAddData implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String message = "";
                message += "Добавление значения " + input.getText() + "...\n";
                JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
                double inputNumber = Double.parseDouble(input.getText());
                SimpleMovingAverage.daysInput(inputNumber);
                input.setValue(null);
            }catch (NumberFormatException exp){
                JOptionPane.showMessageDialog(null,"Допускаются только числа!","ОШИБКА",JOptionPane.PLAIN_MESSAGE);
            }
        }

    }
    class  ButtonEventCalculateSMA implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            SimpleMovingAverage.calculateSMA();
            String message = "";
            message += "Введенные данные:" + SimpleMovingAverage.showInput() + "\n" + "Количество элементов: " + SimpleMovingAverage.showInputSize() + "\n" + "Простое скользящее среднее: " + SimpleMovingAverage.calculateSMA() + "\n";
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonEventDataFromFile implements ActionListener {
        public void actionPerformed(ActionEvent e3) {
            try {
                fc.showOpenDialog(UserWindow.this);
                File file = fc.getSelectedFile();
                InputFromFile.inputFromFile(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ButtonEventDataFromURL implements ActionListener {
        public void actionPerformed(ActionEvent e4) {
            URLWindow uwindow = new URLWindow();
            uwindow.setVisible(true);

        }
    }

    class  ButtonEventShowChart implements ActionListener {
        public void actionPerformed(ActionEvent e6) {
            if(SimpleMovingAverage.numbers.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Данные для построения отсутствуют","ОШИБКА",JOptionPane.PLAIN_MESSAGE);
            }
            else{
                Application.launch(Diagram.class, new String[]{});
            }

        }
    }



}
class URLWindow extends JFrame{
    private JButton acceptURL = new JButton("ОК");
    public static JTextField inputLink = new JTextField();
    public  URLWindow() {
        super("Введите ссылку");
        this.setBounds(100,100,350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(inputLink);
        acceptURL.addActionListener(new ButtonEventAcceptURL());

        container.add(acceptURL);

    }

    class ButtonEventAcceptURL implements  ActionListener {
        public void actionPerformed(ActionEvent e5) {
            try {
                InputFromWEB.inputFromURL(inputLink.getText());
                setVisible(false);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
