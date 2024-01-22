import javax.swing.*;
import java.awt.*;


public class SalesCalculator extends JFrame {
    private JTextField phonePrice, phoneQuantity, repairPrice, repairHours;
    private JTextArea result;

    public SalesCalculator() {
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(5, 2));

        addRow(mainPanel, "Phone Price:", phonePrice = new JTextField());
        addRow(mainPanel, "Phone Quantity:", phoneQuantity = new JTextField());
        addRow(mainPanel, "Repair Price per Hour:", repairPrice = new JTextField());
        addRow(mainPanel, "Number of Hours:", repairHours = new JTextField());

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> calculateSales());
        mainPanel.add(calculateButton);

        result = new JTextArea();
        result.setEditable(false);
        mainPanel.add(result);

        add(mainPanel);
    }

    private void addRow(JPanel panel, String label, JTextField textField) {
        panel.add(new JLabel(label));
        panel.add(textField);
    }

    private void calculateSales() {
        try {
            double phonePriceValue = Double.parseDouble(phonePrice.getText());
            int phoneQuantityValue = Integer.parseInt(phoneQuantity.getText());
            double repairPriceValue = Double.parseDouble(repairPrice.getText());
            int repairHoursValue = Integer.parseInt(repairHours.getText());

            double phoneTotalSales = phonePriceValue * phoneQuantityValue;
            double repairTotalSales = repairPriceValue * repairHoursValue;

            String resultText = String.format("Phone Sales: ₱%.2f%nRepair Sales: ₱%.2f", phoneTotalSales, repairTotalSales);
            result.setText(resultText);

        } catch (NumberFormatException ex) {
            result.setText("Please enter valid numbers for all fields.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SalesCalculator().setVisible(true));
    }
}
