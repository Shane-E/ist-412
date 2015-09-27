package controller.listener;

import controller.Main;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class ChooseJDKLocationListener extends ChooseLocationListener {

    public ChooseJDKLocationListener(Main main, JTextField textField) {
        super(main, textField);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setJavaVersionDirectory(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        //Will throw nullPointer due to MainMenu Lines 37-38.
        getTextField().setText(getMain().getSettings().getJavaVersionDirectory().getPath());
    }
    
    @Override
    public void setFileType() {
        getMain().getFileController().setFileType(JFileChooser.DIRECTORIES_ONLY);
    }  

}
