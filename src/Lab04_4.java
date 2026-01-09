import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab04_4 {
    public static void main(String[] args){
        JFrame f = new JFrame("Grading Program: Ratthapoom Siriaek 68160044 n19");
        f.setSize(500,300);
        f.setLayout(new FlowLayout());


        JTextField midBox = new JTextField(5);
        JTextField finBox = new JTextField(5);
        JTextField hwBox = new JTextField(5);
        JButton b1 =new JButton("Grade");
        JLabel label1 = new JLabel();
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String strMid = midBox.getText().toString();
                String strFin = finBox.getText().toString();
                String strHw = hwBox.getText().toString();
                Double mid = Double.parseDouble(strMid);
                Double fin = Double.parseDouble(strFin);
                Double hw = Double.parseDouble(strHw);
                Double total = mid+fin+hw;
                char grade;
                if (total >=80)
                    grade ='A';
                else if (total >=70)
                    grade ='B';
                else if (total >=60)
                    grade ='C';
                else if (total >=50)
                    grade ='D';
                else grade = 'F';
                label1.setText(""+grade);
            }
        });

        f.add(midBox);
        f.add(finBox);
        f.add(hwBox);
        f.add(b1);
        f.add(label1);




        f.setVisible(true);
    }
}
