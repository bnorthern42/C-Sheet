package org.ban.OptionGUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Options {



    private static int startRow = 0;
    private static int startColumn = 0;
    private static String sheetName = "Sheet1";
    private static ArrayList<String> sheets;

    public Options(){

    }
    public JFrame frame = new JFrame();
    public JPanel panel = new JPanel();
    public void optionGui(File path){

        /**
         * TODO: add Apache POI to open file and create a spinner for available sheets, then put in setters. and exit window.
         * Probably a good idea just to use another class for all POI operations, like inserting the csv and getting sheets, etc...
         */



        SpinnerNumberModel rowmodel =
                new SpinnerNumberModel(startRow,
                                        0,
                                        250,
                                        1);

        SpinnerNumberModel columnmodel =
                new SpinnerNumberModel(startColumn,
                        0,
                        250,
                        1);


        JLabel subtitle = new JLabel("<html>Setting options for inserting into:<br><b> "+path.toString());
        JLabel rows = new JLabel("Start at row: ");
        JLabel columns = new JLabel("Start at column: ");





        panel.setBorder(BorderFactory.createEmptyBorder(30,100,200,300));
        panel.setLayout(new GridLayout(5, 4,1,1));
        JSpinner Rspinner = new JSpinner(rowmodel);
        JSpinner Cspinner = new JSpinner(columnmodel);
      //  Dimension d = new Dimension(10,5);

        Component CSpinnerEditor = Cspinner.getEditor();
        JFormattedTextField jftf_C = ((JSpinner.DefaultEditor) CSpinnerEditor).getTextField();
        jftf_C.setColumns(3);

        Component XSpinnerEditor = Cspinner.getEditor();
        JFormattedTextField jftf_X = ((JSpinner.DefaultEditor) XSpinnerEditor).getTextField();
        jftf_X.setColumns(3);
        panel.add(subtitle);
        panel.add(rows);
        panel.add(Rspinner);

        panel.add(columns);
        panel.add(Cspinner);

      //  Rspinner.setBounds(6,5,3,5);
       // Cspinner.setBounds(6,5,3,5);


        frame.add(panel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Set Starting points");
        frame.pack();
        frame.setVisible(true);

        //add spinner for sheets




    }
    public static int getStartRow() {
        return startRow;
    }

    public static void setStartRow(int startRow) {
        Options.startRow = startRow;
    }

    public static int getStartColumn() {
        return startColumn;
    }

    public static void setStartColumn(int startColumn) {
        Options.startColumn = startColumn;
    }

    public static String getSheetName() {
        return sheetName;
    }

    public static void setSheetName(String sheetName) {
        Options.sheetName = sheetName;
    }

    public static ArrayList<String> getSheets() {
        return sheets;
    }

    public static void setSheets(ArrayList<String> sheets) {
        Options.sheets = sheets;
    }




}
