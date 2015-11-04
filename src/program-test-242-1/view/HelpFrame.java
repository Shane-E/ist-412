package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HelpFrame extends JFrame{
    private HelpTextPanel textPanel;
    private HelpImagePanel imagePanel;
    private HelpButtonPanel buttonPanel;
    
    public HelpFrame(){
        initFrame();
    }
    
    public void initFrame(){
        setSize(800, 600);
        setTitle("Help");
        setLayout(new BorderLayout());
        
        textPanel = new HelpTextPanel();
        imagePanel = new HelpImagePanel();
        buttonPanel = new HelpButtonPanel(textPanel, imagePanel);
        
        add(textPanel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    public HelpTextPanel getTextPanel(){
        return textPanel;
    }
    
    public HelpImagePanel getImagePanel(){
        return imagePanel;
    }
    
    public HelpButtonPanel getButtonPanel(){
        return buttonPanel;
    }
}