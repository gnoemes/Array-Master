package com.gnoemes.ArrayMaster;

import javax.swing.*;

public class ComponentManager  {
    private JLabel arrLabel = new JLabel("Press \"New Array\" button");
    private JLabel sortLabel = new JLabel("Sort: ");
    private JLabel searchLabel = new JLabel("Search: ");
    private JLabel arraySizeLabel = new JLabel("Array size: ");
    private JButton btnNew = new JButton("New Array");
    private JButton btnDel = new JButton("Delete Array");
    private JButton btnBubbleSort = new JButton("Bubble sort");
    private JButton btnInsertionSort = new JButton("Insertion sort");
    private JButton btnSelectionSort = new JButton("Selection sort");
    private JButton btnQuickSort = new JButton("Quick sort");
    private JButton btnLinearSearch = new JButton("Linear search");
    private JButton btnBinarySearch = new JButton("Binary search");
    private JButton btnAddElement = new JButton("Add");
    private JButton btnRemoveElement = new JButton("Remove");
    private JTextField textField = new JTextField();
    private JTextField textDialogField = new JTextField();
    private JLabel dialogLabel = new JLabel("<html>The size of array must go in to the range 1-1000</html>");
    private JButton btnOkDialog = new JButton("OK");
    private JButton btnCancelDialog = new JButton("Cancel");
    private JCheckBox checkBoxFill = new JCheckBox("Auto-fill");
    private JLabel maxElementLabel = new JLabel("Max: ");
    private JLabel minElementLabel = new JLabel("Min: ");
    private JLabel isSortedLabel = new JLabel("Sorted: ");
    private JLabel firstElementLabel = new JLabel();
    private JLabel lastElementLabel = new JLabel("Last: ");
    private JLabel sortTimeLabel = new JLabel();
    private JLabel searchTimeLabel = new JLabel();
    private JLabel sortTypeLabel = new JLabel();
    private JLabel searchTypeLabel = new JLabel();
    private JLabel indexSearchLabel = new JLabel();
    private JButton btnShuffle = new JButton("Shuffle");
    private JButton btnReverse = new JButton("Reverse");


    public ComponentManager() {
        arrLabel.setHorizontalAlignment(SwingConstants.LEFT);
        arrLabel.setVerticalAlignment(SwingConstants.TOP);
        textDialogField.setHorizontalAlignment(SwingConstants.CENTER);
        dialogLabel.setVerticalAlignment(SwingConstants.CENTER);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setText(String text) {
        String html1 = "<html><body style='width: ";
        String html2 = "px'>";
        arrLabel.setText(html1 + "350" + html2 + text);
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public JButton getBtnDel() {
        return btnDel;
    }

    public JButton getBtnReverse() {
        return btnReverse;
    }

    public JButton getBtnShuffle() {
        return btnShuffle;
    }

    public JLabel getIndexSearchLabel() {
        return indexSearchLabel;
    }

    public JLabel getSortTypeLabel() {
        return sortTypeLabel;
    }

    public JLabel getSearchTypeLabel() {
        return searchTypeLabel;
    }

    public JLabel getSortTimeLabel() {
        return sortTimeLabel;
    }

    public JLabel getSearchTimeLabel() {
        return searchTimeLabel;
    }

    public JLabel getFirstElementLabel() {
        return firstElementLabel;
    }

    public JLabel getLastElementLabel() {
        return lastElementLabel;
    }

    public JLabel getMinElementLabel() {
        return minElementLabel;
    }

    public JLabel getIsSortedLabel() {
        return isSortedLabel;
    }

    public JLabel getMaxElementLabel() {
        return maxElementLabel;
    }

    public JButton getBtnCancelDialog() {
        return btnCancelDialog;
    }

    public JCheckBox getCheckBoxFill() {
        return checkBoxFill;
    }

    public JTextField getTextDialogField() {
        return textDialogField;
    }

    public JButton getBtnOkDialog() {
        return btnOkDialog;
    }

    public JLabel getArraySizeLabel() {
        return arraySizeLabel;
    }

    public JLabel getSortLabel() {
        return sortLabel;
    }

    public JButton getBtnLinearSearch() {
        return btnLinearSearch;
    }

    public JButton getBtnBinarySearch() {
        return btnBinarySearch;
    }

    public JButton getBtnAddElement() {
        return btnAddElement;
    }

    public JButton getBtnRemoveElement() {
        return btnRemoveElement;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JLabel getSearchLabel() {
        return searchLabel;
    }

    public JLabel getArrLabel() {
        return arrLabel;
    }

    public JButton getBtnBubbleSort() {
        return btnBubbleSort;
    }

    public JButton getBtnInsertionSort() {
        return btnInsertionSort;
    }

    public JButton getBtnSelectionSort() {
        return btnSelectionSort;
    }

    public JButton getBtnQuickSort() {
        return btnQuickSort;
    }
}
