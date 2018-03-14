package gui;

import actions.ActionHandler;
import actions.MouseHandler;
import actions.MouseMotionHandler;
import actions.ScrollHandler;
import data.C;
import draw.Draw;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Gui {

    static public JFrame jfNew, jfMain, jfSettings;
    public static JButton[] buttons = new JButton[9];
    public static JButton reset, create, oksettings;

    public static JTextArea[] inputNew = new JTextArea[3];
    public static JLabel[] lblNew = new JLabel[3];


    private Border border = BorderFactory.createLineBorder(Color.BLACK);
    private Border borderActive = BorderFactory.createLineBorder(Color.RED);

    public static int activeButton = 0;

    private final int WIDTH = 1280, HEIGHT = 720;


    public void create() {
        jfMain = new JFrame("Lone World - Mapeditor");
        jfMain.setSize(WIDTH, HEIGHT);
        jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMain.setLocationRelativeTo(null);
        jfMain.addMouseWheelListener(new ScrollHandler());
        jfMain.setResizable(false);
        jfMain.setLayout(null);


        jfNew = new JFrame("New");
        jfNew.setSize(300, 225);
        jfNew.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfNew.setLocationRelativeTo(null);
        jfNew.setResizable(false);
        jfNew.setLayout(null);

        jfSettings = new JFrame("Settings");
        jfSettings.setSize(300, 225);
        jfSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfSettings.setLocationRelativeTo(null);
        jfSettings.setResizable(false);
        jfSettings.setLayout(null);

        JLabel[] lblSettings = new JLabel[3];
        for (int i = 0; i < lblSettings.length; i++) {
            lblSettings[i] = new JLabel();
            lblSettings[i].setBounds(10, 20 +i*30, 250, 20);
            lblSettings[i].setVisible(true);
            jfSettings.add(lblSettings[i]);
        }

        lblSettings[0].setText("Map bewegen:    Rechtsklick");
        lblSettings[1].setText("Zeichnen:            Linksklick");
        lblSettings[2].setText("Löschen:             Shift + Linksklick");

        oksettings = new JButton("Ok");
        oksettings.setBounds(200, 150, 75, 25);
        oksettings.setBackground(C.buttonFill);
        oksettings.setBorder(border);
        oksettings.setBorderPainted(true);
        oksettings.addActionListener(new ActionHandler());
        oksettings.addMouseListener(new MouseHandler());
        oksettings.setFocusPainted(false);
        oksettings.setVisible(true);
        jfSettings.add(oksettings);

        for (int i = 0; i < inputNew.length; i++) {
            inputNew[i] = new JTextArea();
            inputNew[i].setBounds(125, 25 + i * 40, 75, 20);
            inputNew[i].setVisible(true);
            jfNew.add(inputNew[i]);
        }


        for (int i = 0; i < lblNew.length; i++) {
            lblNew[i] = new JLabel();
            lblNew[i].setBounds(20, 25 + i * 40, 75, 20);
            lblNew[i].setVisible(true);
            jfNew.add(lblNew[i]);
        }
        lblNew[0].setText("Kachelgöße");
        lblNew[1].setText("Anzahl x:");
        lblNew[2].setText("Anzahl y:");

        JLabel lblNewPx = new JLabel("px");
        lblNewPx.setBounds(210, 25, 75, 20);
        lblNewPx.setVisible(true);
        jfNew.add(lblNewPx);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBounds((i * 75) + WIDTH / 4 - 15, 7, 60, 60);
            buttons[i].setBackground(C.buttonFill);
            buttons[i].setIcon(new ImageIcon("rsc/icons/" + (i + 1) + ".png"));
            buttons[i].setBorder(border);
            buttons[i].setBorderPainted(true);
            buttons[i].addActionListener(new ActionHandler());
            buttons[i].addMouseListener(new MouseHandler());
            buttons[i].setFocusPainted(false);
            buttons[i].setVisible(true);
            jfMain.add(buttons[i]);
        }

        buttons[0].setToolTipText("Create new Map");
        buttons[1].setToolTipText("Save Map");
        buttons[2].setToolTipText("Open existing Map");
        buttons[3].setToolTipText("Open Tileset");
        buttons[4].setToolTipText("Edit Layer 3");
        buttons[5].setToolTipText("Edit Layer 2");
        buttons[6].setToolTipText("Edit Layer 1");
        buttons[7].setToolTipText("Edit Collision Map");
        buttons[8].setToolTipText("Settings");


        setButtonActive(4);

        reset = new JButton("Reset");
        reset.setBounds(WIDTH - 250, 7, 60, 60);
        reset.setBackground(C.buttonFill);
        reset.setBorder(border);
        reset.setBorderPainted(true);
        reset.addActionListener(new ActionHandler());
        reset.addMouseListener(new MouseHandler());
        reset.setFocusPainted(false);
        reset.setVisible(true);
        reset.setToolTipText("Reset Map position & size");
        jfMain.add(reset);


        create = new JButton("Create");
        create.setBounds(200, 150, 75, 25);
        create.setBackground(C.buttonFill);
        create.setBorder(border);
        create.setBorderPainted(true);
        create.addActionListener(new ActionHandler());
        create.addMouseListener(new MouseHandler());
        create.setFocusPainted(false);
        create.setVisible(true);
        jfNew.add(create);


        Draw d = new Draw();
        d.setSize(getWidth(), getHeight());
        d.setVisible(true);
        d.requestFocus();
        d.addMouseWheelListener(new ScrollHandler());
        d.addMouseListener(new MouseHandler());
        d.addMouseMotionListener(new MouseMotionHandler());
        jfMain.add(d);


        jfMain.requestFocus();
        jfMain.setVisible(true);
    }

    public void setButtonActive(int index) {

        if (index >= 4 && index <= 7) {

            for (JButton b : buttons) {
                b.setBorder(border);
            }

            buttons[index].setBorder(borderActive);
            activeButton = index;
        }

    }

    public int getWidth() {
        return WIDTH - 14;
    }

    public int getHeight() {
        return HEIGHT - 36;
    }

}
