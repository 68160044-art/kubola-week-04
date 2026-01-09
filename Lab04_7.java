import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lab04_7 {
    static int n1, n2, ans;
    static int questionCount = 0;
    static int score = 0;

    public static void main(String[] args) {

        JFrame win = new JFrame("Easy Math Quiz");
        win.setBounds(100, 100, 650, 220);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel subwin = new JPanel();
        subwin.setBackground(Color.pink);

        JLabel label1 = new JLabel();
        JLabel labelOp = new JLabel();
        JLabel label2 = new JLabel();
        JLabel labelEqual = new JLabel(" = ");
        JTextField ansBox = new JTextField(3);
        JButton b1 = new JButton("Check");
        JLabel labelResult = new JLabel();
        JLabel labelCount = new JLabel("Question: 0 / 10");

        Font f40 = new Font("Serif", Font.PLAIN, 40);
        label1.setFont(f40);
        labelOp.setFont(f40);
        label2.setFont(f40);
        labelEqual.setFont(f40);
        ansBox.setFont(f40);
        labelResult.setFont(new Font("Serif", Font.BOLD, 30));
        labelCount.setFont(new Font("Serif", Font.PLAIN, 20));

        subwin.add(label1);
        subwin.add(labelOp);
        subwin.add(label2);
        subwin.add(labelEqual);
        subwin.add(ansBox);
        subwin.add(b1);
        subwin.add(labelResult);
        subwin.add(labelCount);

        newQuestion(label1, labelOp, label2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userAns = Integer.parseInt(ansBox.getText());
                    questionCount++;

                    if (userAns == ans) {
                        score++;
                        labelResult.setForeground(new Color(0, 128, 0));
                        labelResult.setText("Correct!");
                    } else {
                        labelResult.setForeground(Color.RED);
                        labelResult.setText("Wrong!");
                    }

                    labelCount.setText("Question: " + questionCount + " / 10");
                    ansBox.setText("");

                    if (questionCount == 10) {
                        JOptionPane.showMessageDialog(win,
                                "Your score: " + score + " / 10",
                                "Result",
                                JOptionPane.INFORMATION_MESSAGE);
                        b1.setEnabled(false);
                    } else {
                        newQuestion(label1, labelOp, label2);
                    }

                } catch (NumberFormatException ex) {
                    labelResult.setText("Enter Number!");
                }
            }
        });

        win.add(subwin);
        win.setVisible(true);
    }

    static void newQuestion(JLabel l1, JLabel lop, JLabel l2) {
        n1 = (int)(Math.random() * 10);
        n2 = (int)(Math.random() * 10);
        int opType = (int)(Math.random() * 3);

        if (opType == 0) {
            lop.setText(" + ");
            ans = n1 + n2;
        } else if (opType == 1) {
            lop.setText(" - ");
            ans = n1 - n2;
        } else {
            lop.setText(" * ");
            ans = n1 * n2;
        }

        l1.setText("" + n1);
        l2.setText("" + n2);
    }
}
