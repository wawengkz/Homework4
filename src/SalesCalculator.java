//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculator extends JFrame {
    private JTextField phonePriceField, phoneQuantityField, repairPriceField, repairHoursField;
    private JTextArea resultArea;

    public SalesCalculator() {
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2));

        mainPanel.add(new JLabel("Phone Price:"));
        phonePriceField = new JTextField();
        mainPanel.add(phonePriceField);

        mainPanel.add(new JLabel("Phone Quantity:"));
        phoneQuantityField = new JTextField();
        mainPanel.add(phoneQuantityField);

        mainPanel.add(new JLabel("Repair Price per Hour:"));
        repairPriceField = new JTextField();
        mainPanel.add(repairPriceField);

        mainPanel.add(new JLabel("Number of Hours:"));
        repairHoursField = new JTextField();
        mainPanel.add(repairHoursField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSales();
            }
        });
        mainPanel.add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        mainPanel.add(resultArea);

        add(mainPanel);
    }

    private void calculateSales() {
        try {
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
            double repairPrice = Double.parseDouble(repairPriceField.getText());
            int repairHours = Integer.parseInt(repairHoursField.getText());

            double phoneTotalSales = phonePrice * phoneQuantity;
            double repairTotalSales = repairPrice * repairHours;

            String result = String.format("Phone Sales: ₱%.2f%nRepair Sales: ₱%.2f", phoneTotalSales, repairTotalSales);
            resultArea.setText(result);

        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter valid numbers for all fields.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalesCalculator().setVisible(true);
            }
        });
    }
}
