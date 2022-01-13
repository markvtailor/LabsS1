

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JButton floor1 = new JButton("Этаж 1");
    private JButton floor2 = new JButton("Этаж 2");
    private JButton floor3 = new JButton("Этаж 3");
    private JButton floor4 = new JButton("Этаж 4");
    private JButton floor5 = new JButton("Этаж 5");
    private JButton floor6 = new JButton("Этаж 6");
    private JButton floor7 = new JButton("Этаж 7");
    private JButton floor8 = new JButton("Этаж 8");
    private JButton showInfo = new JButton("Текущее положение лифтов");

    public GUI() {

        super("Дом, который построил Джек");
        this.setBounds(300, 300, 300, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(9,9,2,2));

        floor1.addActionListener(new ButtonEventFloorOne());
        floor2.addActionListener(new ButtonEventFloorTwo());
        floor3.addActionListener(new ButtonEventFloorThree());
        floor4.addActionListener(new ButtonEventFloorFour());
        floor5.addActionListener(new ButtonEventFloorFive());
        floor6.addActionListener(new ButtonEventFloorSix());
        floor7.addActionListener(new ButtonEventFloorSeven());
        floor8.addActionListener(new ButtonEventFloorEight());
        showInfo.addActionListener(new ButtonEventShowInfo());

        container.add(floor8);
        container.add(floor7);
        container.add(floor6);
        container.add(floor5);
        container.add(floor4);
        container.add(floor3);
        container.add(floor2);
        container.add(floor1);
        container.add(showInfo);
    }
    class  ButtonEventShowInfo implements ActionListener {
        public void actionPerformed(ActionEvent e1) {
            String message = "";
            message += "Лифт 1 - " + "Этаж " + HouseBuilder.elevators.get("Лифт 1") + "\n" +
                    "Лифт 2 - " + "Этаж " + HouseBuilder.elevators.get("Лифт 2") + "\n" +
                    "Лифт 3 - " + "Этаж " + HouseBuilder.elevators.get("Лифт 3") + "\n" +
                    "Лифт 4 - " + "Этаж " + HouseBuilder.elevators.get("Лифт 4") + "\n";
            JOptionPane.showMessageDialog(null, message, "Результат", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class  ButtonEventFloorOne implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(1);
        }
    }
    class  ButtonEventFloorTwo implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(2);
        }
    }
    class  ButtonEventFloorThree implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(3);
        }
    }
    class  ButtonEventFloorFour implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(4);
        }
    }
    class  ButtonEventFloorFive implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(5);
        }
    }
    class  ButtonEventFloorSix implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(6);
        }
    }
    class  ButtonEventFloorSeven implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(7);
        }
    }
    class  ButtonEventFloorEight implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
            ElevatorCall.moveElevator(8);
        }
    }
}


