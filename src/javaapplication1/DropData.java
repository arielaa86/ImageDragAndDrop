/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author ariel
 */
public class DropData implements DropTargetListener {

    private DropTarget dt;
    private JLabel labelDestino;

    public DropData(JLabel labelDestino) {
        this.labelDestino = labelDestino;
        dt = new DropTarget(labelDestino, this);

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {

        try {

            dtde.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles;

            droppedFiles = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);

            for (File file : droppedFiles) {
              
       
                labelDestino.setText("");
                labelDestino.setIcon(new ImageIcon(new ImageIcon(file.getPath()).getImage().getScaledInstance(labelDestino.getWidth(), labelDestino.getHeight(), Image.SCALE_SMOOTH)));
               
            }

        } catch (UnsupportedFlavorException | IOException ex) {
            Logger.getLogger(DropData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

}
