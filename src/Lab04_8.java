import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab04_8 {

    public static void main(String[] args) {

        JFrame win = new JFrame("BMI Calculator");
        win.setSize(450, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 240, 255));
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblWeight = new JLabel("Weight (kg):");
        JLabel lblHeight = new JLabel("Height (cm):");
        JLabel lblBMI = new JLabel("BMI:");
        JLabel lblResult = new JLabel("Result:");

        JTextField txtWeight = new JTextField();
        JTextField txtHeight = new JTextField();
        JLabel lblBMIValue = new JLabel("-");
        JLabel lblInterpret = new JLabel("-");

        JButton btnCalc = new JButton("Calculate BMI");

        Font f = new Font("Serif", Font.PLAIN, 18);
        lblWeight.setFont(f);
        lblHeight.setFont(f);
        lblBMI.setFont(f);
        lblResult.setFont(f);
        txtWeight.setFont(f);
        txtHeight.setFont(f);
        lblBMIValue.setFont(f);
        lblInterpret.setFont(f);
        btnCalc.setFont(f);

        panel.add(lblWeight);
        panel.add(txtWeight);
        panel.add(lblHeight);
        panel.add(txtHeight);
        panel.add(lblBMI);
        panel.add(lblBMIValue);
        panel.add(lblResult);
        panel.add(lblInterpret);
        panel.add(new JLabel());
        panel.add(btnCalc);

        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(txtWeight.getText());
                    double heightCm = Double.parseDouble(txtHeight.getText());
                    double heightM = heightCm / 100;

                    double bmi = weight / (heightM * heightM);
                    lblBMIValue.setText(String.format("%.2f", bmi));

                    if (bmi < 18.5) {
                        lblInterpret.setText("Underweight");
                        lblInterpret.setForeground(Color.BLUE);
                    } else if (bmi < 23) {
                        lblInterpret.setText("Normal");
                        lblInterpret.setForeground(new Color(0, 128, 0));
                    } else if (bmi < 25) {
                        lblInterpret.setText("Overweight");
                        lblInterpret.setForeground(Color.ORANGE);
                    } else if (bmi < 30) {
                        lblInterpret.setText("Obese");
                        lblInterpret.setForeground(Color.RED);
                    } else {
                        lblInterpret.setText("Severely Obese");
                        lblInterpret.setForeground(Color.RED.darker());
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(win,
                            "Please enter valid numbers!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        win.add(panel);
        win.setVisible(true);
    }
}
