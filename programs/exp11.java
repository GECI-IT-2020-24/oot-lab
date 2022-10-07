
/* Experiment 11:
 * Develop a Java program that stimulates a traffic light using AWT.
 * The program let's the user select one of the 3 lights red,yellow,green with radio button,
 * on selecting a button an appropriate message with stop,ready or go 
 * should appear above the button in a selected colour,
 * initially there is no message shown.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

enum TrafficState {
    Red,
    Yellow,
    Green
}

class TrafficSignal
        extends JFrame implements ItemListener {
    JRadioButton jr1, jr2, jr3;
    JTextField j1 = new JTextField(10);
    ButtonGroup b = new ButtonGroup();
    String msg = " ";
    TrafficState state;

    public TrafficSignal(String msg) {
        super(msg);
        setLayout(new FlowLayout());
        jr1 = new JRadioButton("Red");
        jr2 = new JRadioButton("Yellow");
        jr3 = new JRadioButton("Green");
        jr1.addItemListener(this);
        jr2.addItemListener(this);
        jr3.addItemListener(this);
        add(jr1);
        add(jr2);
        add(jr3);
        b.add(jr1);
        b.add(jr2);
        b.add(jr3);
        add(j1);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void itemStateChanged(ItemEvent ie) {
        msg = "";
        if (ie.getSource() == jr1) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                msg = "Stop!";
                this.state = TrafficState.Red;
                repaint();
            }
        }
        if (ie.getSource() == jr2) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                msg = "Get Ready to go!";
                this.state = TrafficState.Yellow;
                repaint();
            }
        }
        if (ie.getSource() == jr3) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                msg = "Go!!";
                this.state = TrafficState.Green;
                repaint();
            }
        }
        j1.setText(msg);
    }

    public void paint(Graphics g) {
        g.drawRect(100, 105, 110, 270);
        g.drawOval(120, 150, 60, 60);
        g.drawOval(120, 230, 60, 60);
        g.drawOval(120, 300, 60, 60);
        if (this.state == TrafficState.Red) {
            g.setColor(Color.RED);
            g.fillOval(120, 150, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 230, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 300, 60, 60);
        }
        if (this.state == TrafficState.Yellow) {
            g.setColor(Color.WHITE);
            g.fillOval(120, 150, 60, 60);
            g.setColor(Color.YELLOW);
            g.fillOval(120, 230, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 300, 60, 60);
        }
        if (this.state == TrafficState.Green) {
            g.setColor(Color.WHITE);
            g.fillOval(120, 150, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 230, 60, 60);
            g.setColor(Color.GREEN);
            g.fillOval(120, 300, 60, 60);
        }
    }

    public static void main(String args[]) {
        JFrame jf = new TrafficSignal("Traffic Light");
        jf.setSize(500, 500);
        jf.setVisible(true);
    }
}