package org.ban;

import org.ban.OptionGUI.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class Main implements ActionListener{


        public  File Cfile;// = new File("");
         public File Xfile;// = new File("");
   private JLabel csvFound;
   private JLabel exFound;
    //NEXT !
    private    JButton go_to = new JButton("Next");
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public Main() {




        JButton impcsv = new JButton("Import CSV File");
        JButton impxlsx = new JButton("Import XLSX File");
        /**
         * Labels: excel file and csv file
         */
        csvFound = new JLabel("CSV: ");
        exFound = new JLabel("Workbook: ");

        JFileChooser choosecsv = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        JFileChooser choosexlsx = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        /**
         * @brief Sets File Type for csv and xlsx and only allows files not directories
         */
        choosecsv.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter Cfilter = new FileNameExtensionFilter("CSV File", "csv");
       choosecsv.setFileFilter(Cfilter);


        choosexlsx.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter Xfilter = new FileNameExtensionFilter("Spreadsheet File", "xlsx");
        choosexlsx.setFileFilter(Xfilter);


        impcsv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("import csv clicked!");
                int cstatus = choosecsv.showOpenDialog(null);
                try {
                if (cstatus == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = choosecsv.getSelectedFile();
                    System.out.println(selectedFile.getParent());
                    System.out.println(selectedFile.getName());
                    Cfile = new File(selectedFile.getAbsolutePath());
                    System.out.println("CSV ab Path: " + Cfile);
                    if(Cfile != null) {
                        csvFound.setText("CSV Selected: "+Cfile.toString());
                    }

                } else if(cstatus == JFileChooser.CANCEL_OPTION) {
                    System.out.println("calceled");

                }
            } catch (Exception i){
                    System.out.println("CSV Selection Gone Horribly Wrong!");
                    i.printStackTrace();
                }
            }
        });




        impxlsx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("import xlsx clicked!");
                int xstatus = choosexlsx.showOpenDialog(null);
                try {
                    if (xstatus == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = choosecsv.getSelectedFile();
                        //   System.out.println(selectedFile.getParent());
                        //     System.out.println(selectedFile.getName());
                        Xfile = new File(selectedFile.getAbsolutePath());
                        System.out.println("XLSX ab Path: " + Xfile);
                        if(Xfile != null) {
                            exFound.setText("Spreadsheet Selected: "+Xfile.toString());

                        }

                    } else if (xstatus == JFileChooser.CANCEL_OPTION) {
                        System.out.println("canceled");

                    }
                } catch (Exception i){
                    System.out.println("XLSX Selection Gone Horribly Wrong!");
                    i.printStackTrace();
                }
            }
        });



        frame.setSize(500,150);
        panel.setBorder(BorderFactory.createEmptyBorder(30,150,120,350));
        panel.setLayout(new GridLayout(5, 3,1,1));

        panel.add(impcsv);
        panel.add(impxlsx);
        panel.add(csvFound);
        panel.add(exFound);

        panel.add(go_to);
        frame.add(panel, BorderLayout.WEST);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CSV into XLSX");
        frame.pack();

        frame.setVisible(true);









    }


    public static void main(String[] args) {


    Main t =  new  Main();


        t.go_to.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("next button clicked!");
                //  int xstatus = choosexlsx.showOpenDialog(null);
                try {

                    System.out.println(t.Cfile);
                    System.out.println(t.Xfile);
                    //once CSV and Spreadsheet Files are known, close this window and go option the options gui.
                    if(t.Cfile != null && t.Xfile != null){
                        t.frame.setVisible(false);
                        Options getOption = new Options();
                        getOption.optionGui(t.Xfile);

                    }

                } catch (Exception i){
                    System.out.println("XLSX Selection Gone Horribly Wrong!");
                    i.printStackTrace();
                }
            }
        });




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(Cfile != null) {
             csvFound.setText(Cfile.toString());

        }
        if(Xfile != null) {
             exFound.setText("Book: "+Xfile.toString());

        }
    }
}
