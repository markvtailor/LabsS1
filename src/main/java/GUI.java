import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private JButton numberRoot = new JButton("Рассчитать корень");
    private JLabel labelInput = new JLabel("Введите значение:");
    private JFormattedTextField input = new JFormattedTextField();


    public GUI(){

        super("Итерационная формула Герона");
        this.setBounds(300,300,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(labelInput);
        container.add(input);

        numberRoot.addActionListener(new ButtonEventCalculate());
        container.add(numberRoot);

    }

    class ButtonEventCalculate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double inputNumber = Double.parseDouble(input.getText());
                String message = "";
                message += Heron.HeronRoot(inputNumber);
                JOptionPane.showMessageDialog(null, message, "Результат", JOptionPane.PLAIN_MESSAGE);

                input.setValue(null);
            }catch (NumberFormatException exp){
                JOptionPane.showMessageDialog(null,"Допускаются только числа!","ОШИБКА",JOptionPane.PLAIN_MESSAGE);
            }
        }
}
}