package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class ChooseSourceLocationListener implements ActionListener {

    private final FileController fileController;
    private final ApplicationSettings settings;
    private final JTextField textField;

    public ChooseSourceLocationListener(FileController fileController, ApplicationSettings settings, JTextField textField) {
        this.fileController = fileController;
        this.settings = settings;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        settings.setSourceFileDirectory(fileController.getFileFromChooser(JFileChooser.SAVE_DIALOG));
        textField.setText(settings.getSourceFileDirectory().getPath());
    }
}