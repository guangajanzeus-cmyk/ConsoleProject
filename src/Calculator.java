import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator
{
    int borderWidth = 360;
    int borderHeight = 540;

    Color customFlint = new Color(95, 99, 104);
    Color customColdGray = new Color(255,255,255,255);
    Color customCharcoalFrost = new Color(60, 64, 67);
    Color customAlexandra = new Color(66, 133, 244);

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculator");
    JPanel DisplayPanel = new JPanel();
    JLabel displayLabel = new JLabel();
    JPanel buttonPanel = new JPanel();

    double num1 = 0;
    double num2 = 0;
    String operator = "";
    boolean newNumber = true;

    Calculator()
    {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(borderWidth, borderHeight);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        displayLabel.setOpaque(true);
        displayLabel.setBackground(customCharcoalFrost);
        displayLabel.setForeground(Color.white);
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setFont(new Font("Arial", Font.PLAIN,80));
        displayLabel.setText("0");

        DisplayPanel.setLayout(new BorderLayout());
        DisplayPanel.add(displayLabel);
        frame.add(DisplayPanel,BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(5,4));
        buttonPanel.setBackground(customCharcoalFrost);
        frame.add(buttonPanel);

        for (int i = 0; i < buttonValues.length; i++)
        {
            JButton button = new JButton();

            String buttonValue = buttonValues[i];

            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customCharcoalFrost));

            if (Arrays.asList(topSymbols).contains(buttonValue))
            {
                button.setBackground(customColdGray);
                button.setForeground(customCharcoalFrost);
            }
            else if (Arrays.asList(rightSymbols).contains(buttonValue))
            {
                button.setBackground(customAlexandra);
                button.setForeground(Color.WHITE);
            }
            else
            {
                button.setBackground(customFlint);
                button.setForeground(Color.WHITE);
            }

            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String value = button.getText();

                    if (value.matches("[0-9]") || value.equals("."))
                    {
                        if (newNumber)
                        {
                            displayLabel.setText(value.equals(".") ? "0." : value);
                            newNumber = false;
                        }
                        else
                        {
                            if (value.equals(".") && displayLabel.getText().contains("."))
                            {
                                return;
                            }

                            displayLabel.setText(displayLabel.getText() + value);
                        }
                    }


                    else if (value.equals("AC"))
                    {
                        displayLabel.setText("0");
                        num1 = 0;
                        num2 = 0;
                        operator = "";
                        newNumber = true;
                    }


                    else if (value.equals("+/-"))
                    {
                        double number = Double.parseDouble(displayLabel.getText());
                        number = number * -1;
                        displayLabel.setText(formatNumber(number));
                    }


                    else if (value.equals("%"))
                    {
                        double number = Double.parseDouble(displayLabel.getText());
                        number = number / 100;
                        displayLabel.setText(formatNumber(number));
                    }


                    else if (value.equals("√"))
                    {
                        double number = Double.parseDouble(displayLabel.getText());

                        if (number >= 0)
                        {
                            double result = Math.sqrt(number);
                            displayLabel.setText(formatNumber(result));
                            newNumber = true;
                        }
                        else
                        {
                            displayLabel.setText("Error");
                            newNumber = true;
                        }
                    }


                    else if (value.equals("+") ||
                            value.equals("-") ||
                            value.equals("×") ||
                            value.equals("÷"))
                    {
                        num1 = Double.parseDouble(displayLabel.getText());
                        operator = value;
                        newNumber = true;
                    }


                    else if (value.equals("="))
                    {
                        if (operator.equals(""))
                        {
                            return;
                        }

                        num2 = Double.parseDouble(displayLabel.getText());

                        double result = 0;

                        switch (operator)
                        {
                            case "+":
                                result = num1 + num2;
                                break;

                            case "-":
                                result = num1 - num2;
                                break;

                            case "×":
                                result = num1 * num2;
                                break;

                            case "÷":
                                if (num2 == 0)
                                {
                                    displayLabel.setText("Error");
                                    operator = "";
                                    newNumber = true;
                                    return;
                                }

                                result = num1 / num2;
                                break;
                        }

                        displayLabel.setText(formatNumber(result));

                        num1 = result;
                        operator = "";
                        newNumber = true;
                    }
                }
            });

            buttonPanel.add(button);
        }
    }

    String formatNumber(double number)
    {
        if (number == (long) number)
        {
            return String.valueOf((long) number);
        }

        return String.valueOf(number);
    }

    public static void main(String[] args)
    {
        new Calculator();
    }
}