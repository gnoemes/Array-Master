package com.gnoemes.ArrayMaster;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    public static final int WIDTH = 720;
    public static final int HEIGHT = WIDTH / 16 * 9;
    private ComponentManager c = new ComponentManager();
    private MyArray array;
    private GridBagConstraints gc = new GridBagConstraints();
    private JPanel controlPanel;
    private JPanel infoPanel;
    private JPanel optionalContainer;
    private JPanel mainContainer;
    private JDialog newDialog = new JDialog();

    public Window() {
        initListeners();
        initWindow();
        updateInfo();
    }

    private void initListeners() {
        c.getBtnReverse().addActionListener(e -> {
            if (array != null) {
                array.reverse();
                updateScreen();
                updateInfo();
                optionalContainer.validate();
            }
        });
        c.getBtnShuffle().addActionListener(e -> {
            if (array != null) {
                array.shuffle();
                updateScreen();
                updateInfo();
                optionalContainer.validate();
            }
        });
        c.getBtnSelectionSort().addActionListener(e -> {
            if (array != null) {
                array.selectionSort();
                updateScreen();
                updateInfo();
                optionalContainer.validate();
            }
        });
        c.getBtnInsertionSort().addActionListener(e -> {
            if (array != null) {
                array.insertionSort();
                updateScreen();
                updateInfo();
                optionalContainer.validate();
            }
        });
        c.getBtnQuickSort().addActionListener(e -> {
            if (array != null) {
                array.quickSort();
                updateScreen();
                updateInfo();
                optionalContainer.validate();
            }
        });
        c.getBtnBinarySearch().addActionListener(e -> {
            try {
                int n = Integer.parseInt(c.getTextField().getText());
                if (array != null && array.isSorted()) {
                    int ind = array.binarySearch(n);
                    if (ind != -1) c.getIndexSearchLabel().setText("Index: " + ind);
                    else {
                        JOptionPane.showMessageDialog(null, new JLabel("<html>Can't find " + n + "</html>", JLabel.CENTER));
                        c.getIndexSearchLabel().setText("Index: NULL");
                    }
                } else
                if (!array.isSorted() && array != null) JOptionPane.showMessageDialog(null, new JLabel("<html>Sort array first</html>", JLabel.CENTER));
                else JOptionPane.showMessageDialog(null, new JLabel("<html>Create array first</html>", JLabel.CENTER));
            } catch (NumberFormatException exsep) {
                JOptionPane.showMessageDialog(null, new JLabel("<html>Invalid number</html>", JLabel.CENTER));
            }
            updateScreen();
            updateInfo();
            optionalContainer.validate();
        });
        c.getBtnRemoveElement().addActionListener(e -> {
            try {
                int k = Integer.parseInt(array.getSize()) - 1;
                try {
                    int n = Integer.parseInt(c.getTextField().getText());
                    if (array != null && k >= 0) {
                        if (array.linearSearch(n) == -1)
                            JOptionPane.showMessageDialog(null, new JLabel("<html>Can't find number " + n + "</html>", JLabel.CENTER));
                        else array.removeElem(array.linearSearch(n));
                        updateInfo();
                        updateScreen();
                    } else
                        JOptionPane.showMessageDialog(null, new JLabel("<html>Create array first</html>", JLabel.CENTER));
                } catch (NumberFormatException exsep) {
                    if (array != null && k >= 0)
                        array.removeElem(k);
                    updateInfo();
                    updateScreen();
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, new JLabel("<html>No elements to remove</html>", JLabel.CENTER));
            }
        });
        c.getBtnAddElement().addActionListener(e -> {
            try {
                int n = Integer.parseInt(c.getTextField().getText());
                if (array != null) {
                    array.addElem(n);
                    updateInfo();
                    updateScreen();
                }
                else JOptionPane.showMessageDialog(null, new JLabel("<html>Create array first</html>",JLabel.CENTER));
            }  catch (NumberFormatException exsep) {
                JOptionPane.showMessageDialog(null, new JLabel("<html>Invalid number</html>",JLabel.CENTER));
            }
        });
        c.getTextDialogField().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!(c.getTextDialogField().getText().isEmpty())) {
                    c.getTextDialogField().setForeground(Color.black);
                    c.getTextDialogField().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (c.getTextDialogField().getText().isEmpty()) {
                    c.getTextDialogField().setForeground(Color.DARK_GRAY);
                    c.getTextDialogField().setText("1 - 3000");
                }
            }
        });
        c.getBtnBubbleSort().addActionListener(e -> {
            if (array != null) {
                array.bubbleSort();
                updateScreen();
                updateInfo();
                optionalContainer.validate();
            }
        });
        c.getBtnLinearSearch().addActionListener(e -> {
            try {
                int n = Integer.parseInt(c.getTextField().getText());
                if (array != null ) {
                    int ind = array.linearSearch(n);
                    if (ind != -1) c.getIndexSearchLabel().setText("Index: " + ind);
                    else {
                        JOptionPane.showMessageDialog(null, new JLabel("<html>Can't find " + n + "</html>",JLabel.CENTER));
                        c.getIndexSearchLabel().setText("Index: NULL");
                    }
                }
                else JOptionPane.showMessageDialog(null, new JLabel("<html>Create array first</html>",JLabel.CENTER));
            }  catch (NumberFormatException exsep) {
                JOptionPane.showMessageDialog(null, new JLabel("<html>Invalid number</html>",JLabel.CENTER));
            }
            updateScreen();
            updateInfo();
            optionalContainer.validate();
        });
        c.getBtnNew().addActionListener(e -> initDialog());
        c.getBtnDel().addActionListener(e -> {
            array = null;
            updateScreen();
            updateInfo();
        });
        c.getBtnOkDialog().addActionListener(e -> {
            try {
                int n = Integer.parseInt(c.getTextDialogField().getText());
                if (n == 0 || n > 3000)
                    JOptionPane.showMessageDialog(null, new JLabel("<html>The size of array must go in to the range 1-1000</html>"));
                else {
                    array = null;
                    array = new MyArray(Integer.parseInt(c.getTextDialogField().getText()));
                    if (c.getCheckBoxFill().isSelected()) {
                        array.fillArray();
                        updateScreen();
                    }
                    else c.setText("Add elements");
                    updateInfo();
                    optionalContainer.validate();
                    newDialog.dispose();
                    c.getTextDialogField().setText("");
                }
            }
            catch (NumberFormatException exsep) {
                JOptionPane.showMessageDialog(null, new JLabel("<html>The size of array must be a number</html>"));
            }

        });
        c.getBtnCancelDialog().addActionListener(e -> newDialog.dispose());
    }

    private void updateScreen() {
        if (array == null)
            c.setText("Press \"New Array\" button");
            else
                c.setText(array.toString());
    }

    private void updateInfo() {
        if (array != null && Integer.parseInt(array.getSize()) > 0) {
            c.getArraySizeLabel().setText("Size: " + array.getSize());
            c.getMinElementLabel().setText("Min: " + array.getMin());
            c.getMaxElementLabel().setText("Max: " + array.getMax());
            c.getIsSortedLabel().setText("Sorted: " + array.isSorted());
            c.getFirstElementLabel().setText("First: " + array.getFirst());
            c.getLastElementLabel().setText("Last: " + array.getLast());
            c.getSortTimeLabel().setText("Sort (mills): " + array.getTimeSortConsumed());
            c.getSearchTimeLabel().setText("Search (mills): " + array.getTimeSearchConsumed());
            c.getSortTypeLabel().setText("Last sort: " + array.getLastSortType());
            c.getSearchTypeLabel().setText("Last search: " + array.getLastSearchType());
        }
        else {
            c.getArraySizeLabel().setText("Size: NULL");
            c.getMinElementLabel().setText("Min: NULL");
            c.getMaxElementLabel().setText("Max: NULL");
            c.getIsSortedLabel().setText("Sorted: false");
            c.getFirstElementLabel().setText("First: NULL");
            c.getLastElementLabel().setText("Last: NULL");
            c.getSortTimeLabel().setText("Sort (mills): 0");
            c.getSearchTimeLabel().setText("Search (mills): 0");
            c.getSortTypeLabel().setText("Last sort: NULL");
            c.getSearchTypeLabel().setText("Last search: NULL");
            c.getIndexSearchLabel().setText("Index: NULL");
        }
    }

    private void initDialog() {
        newDialog.setSize(400,120);
        newDialog.setLayout(new GridBagLayout());

        c.getTextDialogField().setText("1 - 3000");
        c.getTextDialogField().setForeground(Color.LIGHT_GRAY);
        c.getCheckBoxFill().setSelected(true);

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets.set(10,20,20,20);
        newDialog.add(c.getCheckBoxFill(),gc);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets.set(10,20,20,20);
        newDialog.add(c.getTextDialogField(),gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.ipadx = 0;
        gc.insets.set(10,20,20,20);
        newDialog.add(c.getBtnOkDialog(),gc);
        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets.set(10,20,20,20);
        newDialog.add(c.getBtnCancelDialog(),gc);

        newDialog.setLocationRelativeTo(null);
        newDialog.setResizable(false);
        newDialog.pack();
        newDialog.setVisible(true);
    }

    private void fillInfoContainer() {
        JPanel topInfoPanel = new JPanel();
        JPanel bottomInfoPanel = new JPanel();
        topInfoPanel.setLayout(new GridLayout(2,6));
        bottomInfoPanel.setLayout(new GridLayout(2,3));

        topInfoPanel.add(c.getArraySizeLabel());
        topInfoPanel.add(c.getMinElementLabel());
        topInfoPanel.add(c.getMaxElementLabel());
        topInfoPanel.add(c.getIsSortedLabel());
        topInfoPanel.add(c.getFirstElementLabel());
        topInfoPanel.add(c.getLastElementLabel());

        bottomInfoPanel.add(c.getSortTimeLabel());
        bottomInfoPanel.add(c.getSearchTimeLabel());
        bottomInfoPanel.add(c.getIndexSearchLabel());
        bottomInfoPanel.add(c.getSortTypeLabel());
        bottomInfoPanel.add(c.getSearchTypeLabel());

        infoPanel.add(topInfoPanel);
        infoPanel.add(bottomInfoPanel);
    }

    private void fillControlContainer() {
        controlPanel = new JPanel();
        JPanel sortPanel = new JPanel();
        JPanel searchPanel = new JPanel();
        JPanel arrayTools = new JPanel();
        JPanel arrayOption = new JPanel();

        controlPanel.setBorder(new TitledBorder("Options"));
        controlPanel.setLayout(new GridLayout(4,1));
        searchPanel.setLayout(new GridBagLayout());
        arrayTools.setLayout(new GridBagLayout());
        arrayOption.setLayout(new GridBagLayout());
        sortPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets.set(0,0,5,5);
        sortPanel.add(c.getSortLabel(),gc);
        gc.gridy = 1;
        gc.gridx = 0;
        sortPanel.add(c.getBtnBubbleSort(),gc);
        gc.gridy = 1;
        gc.gridx = 1;
        sortPanel.add(c.getBtnQuickSort(),gc);
        gc.gridy = 2;
        gc.gridx = 0;
        sortPanel.add(c.getBtnInsertionSort(),gc);
        gc.gridy = 2;
        gc.gridx = 1;
        sortPanel.add(c.getBtnSelectionSort(),gc);

        gc.gridx = 0;
        gc.gridy = 0;
        searchPanel.add(c.getSearchLabel(),gc);
        gc.gridy = 1;
        searchPanel.add(c.getBtnLinearSearch(),gc);
        gc.gridx = 1;
        searchPanel.add(c.getBtnBinarySearch(),gc);


        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        arrayTools.add(c.getBtnNew(),gc);
        gc.ipadx = 0;
        gc.gridx = 1;
        gc.weightx =1;
        arrayTools.add(c.getBtnDel(),gc);
        gc.gridx = 0;
        gc.gridy = 1;
        arrayTools.add(c.getBtnShuffle(),gc);
        gc.gridy = 1;
        gc.gridx = 1;
        arrayTools.add(c.getBtnReverse(),gc);

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0;
        gc.gridwidth = 2;
        arrayOption.add(c.getTextField(),gc);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth =1;
        arrayOption.add(c.getBtnAddElement(),gc);
        gc.gridy = 1;
        gc.gridx = 1;
        arrayOption.add(c.getBtnRemoveElement(),gc);

        controlPanel.add(arrayTools);
        controlPanel.add(sortPanel);
        controlPanel.add(searchPanel);
        controlPanel.add(arrayOption);
    }

    private void fillMainContainer() {
        mainContainer = new JPanel();
        infoPanel = new JPanel();
        JPanel screenPanel = new JPanel();
        optionalContainer = new JPanel();
        JScrollPane screenScroll = new JScrollPane(c.getArrLabel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainContainer.setLayout(new BorderLayout());
        infoPanel.setLayout(new GridLayout(2,1));
        infoPanel.setBorder(new TitledBorder("Info"));
        screenPanel.setLayout(new BorderLayout());
        optionalContainer.setLayout(new GridLayout(2,1));
        screenScroll.setBorder(new TitledBorder("Array"));

        screenPanel.add(screenScroll);
        fillInfoContainer();

        optionalContainer.add(screenPanel);
        optionalContainer.add(infoPanel);

        mainContainer.add(optionalContainer);
        mainContainer.add(controlPanel,BorderLayout.EAST);

    }

    private void initWindow() {
        JFrame frame = new JFrame("Array Master");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(new BorderLayout());
        fillControlContainer();
        fillMainContainer();
        frame.add(mainContainer);
        frame.setVisible(true);
    }

}
