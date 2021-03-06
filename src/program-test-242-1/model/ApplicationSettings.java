package model;

import controller.FileController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSettings {
    
    private final File settingsFile = new File("Settings.txt");
    
    private File outputFileDirectory = new File("testResults.txt");
    private File sourceFileDirectory = FileController.emptyFile;
    private File testCaseDirectory = FileController.emptyFile;
    private File javaVersionDirectory = FileController.emptyFile;
   
    public File getOutputFileDirectory() {
        return outputFileDirectory;
    }

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
    }
    
    public void setOutputFileDirectory(File directory) {
        outputFileDirectory = directory;
		writeDataToSettingsFile();
    }

    public void setSourceFileDirectory(File directory) {
        sourceFileDirectory = directory;
		writeDataToSettingsFile();
    }

    public void setTestCaseDirectory(File directory) {
        testCaseDirectory = directory;
		writeDataToSettingsFile();
    }
	
    public void writeDataToSettingsFile(){
        try (PrintWriter out = new PrintWriter(settingsFile)) {
            
            if(outputFileDirectory != null){
                out.println("Output File Directory: " + outputFileDirectory.getPath());
            }
            
            if(sourceFileDirectory != null){
                out.println("Source File Directory: " + sourceFileDirectory.getPath());
            }

            if(testCaseDirectory != null){
                out.println("Test Case Directory: " + testCaseDirectory.getPath());
            }

            if(javaVersionDirectory != null){
                out.println("Java Version Directory: " + javaVersionDirectory.getPath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readDataFromSettingsFile(){
        Scanner inFile = null;
        try {
            // Create a new settings file if it does not exsit.
            settingsFile.createNewFile();
            
            inFile = new Scanner(settingsFile);

            while(inFile.hasNextLine()){
                String setting = inFile.nextLine();
                
                if(setting.startsWith("Output File Directory: ")){
                    outputFileDirectory = new File(setting.substring("Output File Directory: ".length()));
                }
                if(setting.startsWith("Source File Directory: ")){
                    sourceFileDirectory = new File(setting.substring("Source File Directory: ".length()));
                }
                else if(setting.startsWith("Test Case Directory: ")){
                    testCaseDirectory = new File(setting.substring("Test Case Directory: ".length()));
                }
                else if(setting.startsWith("Java Version Directory: ")){
                    javaVersionDirectory = new File(setting.substring("Java Version Directory: ".length()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationSettings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            inFile.close();
        }
    }
    
    @Override
    public String toString() {
        String string = "Settings: \n\n";
        
        string += "Output file: " + outputFileDirectory + "\n";
        string += "Source file: " + sourceFileDirectory + "\n";
        string += "Test directory: " + testCaseDirectory + "\n";
        string += "Java directory: " + javaVersionDirectory + "\n";
                
        return string;
    }
}
