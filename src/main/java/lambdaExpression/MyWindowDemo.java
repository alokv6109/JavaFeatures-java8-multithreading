package lambdaExpression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowDemo {
    public static void main(String[] args) {
        //ths is a thing with the swing appliactoion and learning the lambda expression here
        //window: object of jframe
        JFrame frame= new JFrame("My window");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        //creata a button
        JButton button  = new JButton("Click Me");
        frame.add(button);

        //uisng anonymous class
//        button.addActionListener(new ActionListener() {  //using anonymous class implementaion
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button clicked");
//                JOptionPane.showMessageDialog(null, "Button clicked");
//            }
//        });

        ActionListener actionListener  = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
//                System.out.println(e.getActionCommand());
                JOptionPane.showMessageDialog(null, "Button clicked");
            }
        };
        button.addActionListener(actionListener); //baiscally just pasing in the object of the interface is required and hence you've don ejust that
        //using anonymous class and ht eLambda expression

        //using kambda expresssion
//        button.addActionListener((e)->{
//            System.out.println("Button clicked");
//                JOptionPane.showMessageDialog(null, "Button clicked");
//        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //actionListerner is a functional interface
    }
}
