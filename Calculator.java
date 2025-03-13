import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        //đặt tên cho cửa sổ nhập dữ liệu

        double num1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the first number:","20235691", JOptionPane.PLAIN_MESSAGE));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the second number:", "20235691", JOptionPane.PLAIN_MESSAGE));
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        JOptionPane.showMessageDialog(null, "The sum is: " + sum
                + "\nThe difference is: " + difference
                + "\nThe product is: " + product
                + "\nThe quotient is: " + quotient,
                "20235691", JOptionPane.PLAIN_MESSAGE);
    }
}
