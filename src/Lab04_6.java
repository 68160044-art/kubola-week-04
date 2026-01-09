import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab04_6 {
    public static void main(String[] args) {

        int n1 = (int)(Math.random() * 10);
        int n2 = (int)(Math.random() * 10);

        int opType = (int)(Math.random() * 3);
        String opSymbol = "";
        int ans = 0;

        if (opType == 0) {
            opSymbol = " + ";
            ans = n1 + n2;
        } else if (opType == 1) {
            opSymbol = " - ";
            ans = n1 - n2;
        } else {
            opSymbol = " * ";
            ans = n1 * n2;
        }

        JFrame win = new JFrame("Easy Math Quiz");
        win.setBounds(100, 100, 650, 200);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel subwin = new JPanel();
        subwin.setBackground(Color.pink);


        JLabel label1 = new JLabel("" + n1);
        label1.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label1);


        JLabel labelOp = new JLabel(opSymbol);
        labelOp.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(labelOp);


        JLabel label2 = new JLabel("" + n2);
        label2.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label2);

        JLabel labelEqual = new JLabel(" = ");
        labelEqual.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(labelEqual);

        JTextField ansBox = new JTextField(3);
        ansBox.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(ansBox);

        JButton b1 = new JButton("Check");
        b1.setFont(new Font("Serif", Font.PLAIN, 20));
        subwin.add(b1);

        JLabel labelResult = new JLabel();
        labelResult.setFont(new Font("Serif", Font.BOLD, 40));
        subwin.add(labelResult);


        final int finalAns = ans;

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String str = ansBox.getText();
                    int userAns = Integer.parseInt(str);
                    if (finalAns == userAns) {
                        labelResult.setForeground(new Color(0, 128, 0)); // สีเขียว
                        labelResult.setText("Excellent!");
                    } else {
                        labelResult.setForeground(Color.RED);
                        labelResult.setText("Try again!");
                    }
                } catch (NumberFormatException ex) {
                    labelResult.setText("Enter Number!");
                }
            }
        });

        win.add(subwin);
        win.setVisible(true);
    }
}