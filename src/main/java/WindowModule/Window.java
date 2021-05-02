package WindowModule;

import LanguageModule.Language;
import StairsModules.Stairs;
import StairsModules.StairsParameters;
import TextFormatterModule.TextFormatter;
import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Window extends JFrame implements ActionListener, KeyListener {
    static DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.US);
    static DecimalFormat format = new DecimalFormat("0.00", symbol);
    static JFormattedTextField tHeight = new JFormattedTextField(format);
    static JFormattedTextField tMaxHeight = new JFormattedTextField(format);
    static JTextField tStepHeight = new JTextField();
    static JTextField tStepNumber = new JTextField();
    static JButton bCalculate = new JButton();
    static Language language;

    public Window(Language language)
    {
        this.language = language;

        setSize(450,230);
        setTitle(language.get("TITLE").toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel lHeight = new JLabel(language.get("HEIGHT").toString()+":", SwingConstants.RIGHT);
        JLabel lMaxHeight = new JLabel(language.get("MAX_HEIGHT").toString()+":", SwingConstants.RIGHT);
        JLabel lStepHeight = new JLabel(language.get("STEP_HEIGHT").toString()+":", SwingConstants.RIGHT);
        JLabel lStepNumber = new JLabel(language.get("STEPS_NUMBER").toString()+":", SwingConstants.RIGHT);

        lHeight.setBounds(10, 10, 180, 25);
        add(lHeight);

        tHeight.setBounds(200, 10, 50, 25);
        tHeight.addKeyListener(this);
        add(tHeight);

        lMaxHeight.setBounds(10, 40, 180, 25);
        tMaxHeight.addKeyListener(this);
        add(lMaxHeight);

        tMaxHeight.setBounds(200, 40, 50, 25);
        add(tMaxHeight);

        lStepHeight.setBounds(10, 70, 180, 25);
        add(lStepHeight);

        tStepHeight.setBounds(200, 70, 50, 25);
        tStepHeight.setEditable(false);
        add(tStepHeight);

        lStepNumber.setBounds(10, 100, 180, 25);
        add(lStepNumber);

        tStepNumber.setBounds(200, 100, 50, 25);
        tStepNumber.setEditable(false);
        add(tStepNumber);

        bCalculate.setText(language.get("CALCULATE").toString());
        bCalculate.setBounds(150, 130, 100, 25);
        bCalculate.addActionListener(this);
        add(bCalculate);

        MarvinImagePanel imagePanel = new MarvinImagePanel();
        imagePanel.setBounds(280, 10, 100, 100);
        add(imagePanel);

        MarvinImage image = MarvinImageIO.loadImage("stairs.png");
        imagePanel.setImage(image);

        setVisible(true);
    }

    public void showErrorMessage()
    {
        JOptionPane.showMessageDialog(null,
                language.get("INCORRECT_DATA").toString(),
                language.get("INCORRECT_DATA").toString(),
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bCalculate)
        {
            try {
                if(Double.parseDouble((tHeight.getText()))<=0||Double.parseDouble((tMaxHeight.getText()))<=0)
                    throw new NumberFormatException();
                BigDecimal height = new BigDecimal(tHeight.getText());
                BigDecimal maxHeightOfStep = new BigDecimal(tMaxHeight.getText());

                Stairs stairs = new Stairs(height, maxHeightOfStep);
                StairsParameters stairsParameters = new StairsParameters(stairs);

                tStepHeight.setText(stairsParameters.getStepHeight().toString());
                tStepNumber.setText(stairsParameters.getStepsNumber().toString());
            }
            catch(NumberFormatException exception)
            {
                showErrorMessage();
            }
            catch(ArithmeticException exception)
            {
                showErrorMessage();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==10)
            bCalculate.doClick();

        int tHeightCaretPosition=tHeight.getCaretPosition();
        int tMaxHeightCaretPosition=tMaxHeight.getCaretPosition();

        tHeight.setText(TextFormatter.formatText(tHeight.getText()));
        tMaxHeight.setText(TextFormatter.formatText(tMaxHeight.getText()));

        tHeight.setCaretPosition(tHeightCaretPosition);
        tMaxHeight.setCaretPosition(tMaxHeightCaretPosition);
    }
}