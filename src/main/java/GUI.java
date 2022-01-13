import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JButton showInfo = new JButton("Cреднее значение X-DSPAM-Probability");
    private JButton showChart = new JButton("Показать гистограмму отправителей");
    private JButton showSpamers = new JButton("Список потенциальных спамеров");

    public GUI() {

        super("Разбор почты");
        this.setBounds(300, 300, 500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));

        showInfo.addActionListener(new ButtonEventShowInfo());
        showSpamers.addActionListener(new ButtonEventShowSpamers());
        showChart.addActionListener(new ButtonEventShowChart());

        container.add(showInfo);
        container.add(showChart);
        container.add(showSpamers);
    }

    class  ButtonEventShowInfo implements ActionListener {
        public void actionPerformed(ActionEvent e1) {
            String message = "";
            message += "Cреднее значение X-DSPAM-Probability: " + Probability.probabilityAverage;
            JOptionPane.showMessageDialog(null, message, "Результат", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class  ButtonEventShowSpamers implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            String message = "";
            message += "Потенциальные спамеры:\n" + Merging.confidenceAverageHashMap.keySet();
            JOptionPane.showMessageDialog(null, message, "Спамеры", JOptionPane.PLAIN_MESSAGE);
        }
    }
    class  ButtonEventShowChart implements ActionListener {
        public void actionPerformed(ActionEvent e3) {
                Application.launch(AuthorsHistogram.class, new String[]{});
        }
    }
}
