package controller.listener;

import controller.Main;
import java.io.File;
import javax.swing.JTextField;

public class ChooseTestLocationListener extends ChooseLocationListener {

    public ChooseTestLocationListener(Main main, JTextField textField) {
        super(main, textField);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setTestCaseDirectory(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        getTextField().setText(getMain().getSettings().getTestCaseDirectory().getPath());
    }
}
