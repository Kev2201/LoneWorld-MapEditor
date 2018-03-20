package actions;

import data.C;
import data.Map;
import data.Mouse;
import data.Tools;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("Duplicates")
public class MouseHandler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (SwingUtilities.isRightMouseButton(e)) {
            if (Map.mapActive) {
                MouseMotionHandler.startX = e.getX();
                MouseMotionHandler.startY = e.getY();
            }

            if(Tools.rectVisible){
                Tools.start = null;
                Tools.end = null;
                Tools.rectVisible = false;
            }
        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (Map.mapActive) {
                if (Tools.active == 0) {
                    if (Gui.activeButton == 7) {
                        Map.addCollision(e);
                        Map.removeCollision(e);
                    }
                    Map.setTile(e);

                } else if (Tools.active == 2) {
                    if(!SwingUtilities.isRightMouseButton(e)){
                        if (Mouse.insideMap) {
                            Tools.start = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                            Tools.end = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                            Tools.rectVisible = true;
                        }
                    }


                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if(!SwingUtilities.isRightMouseButton(e)){
                if (Map.mapActive) {
                    if (Mouse.insideMap) {
                        if (Tools.active == 2) {
                            Tools.end = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                            Tools.fillRect(e);

                        }
                    }

                }
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {
                Gui.buttons[i].setBackground(C.buttonHover);
            }
        }
        if (e.getSource().equals(Gui.reset)) {
            Gui.reset.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.create)) {
            Gui.create.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.oksettings)) {
            Gui.oksettings.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.oktileset)) {
            Gui.oktileset.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.opentileset)) {
            Gui.opentileset.setBackground(C.buttonHover);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {
                Gui.buttons[i].setBackground(C.buttonFill);
            }
        }
        if (e.getSource().equals(Gui.reset)) {
            Gui.reset.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.create)) {
            Gui.create.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.oksettings)) {
            Gui.oksettings.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.oktileset)) {
            Gui.oktileset.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.opentileset)) {
            Gui.opentileset.setBackground(C.buttonFill);
        }
    }
}
