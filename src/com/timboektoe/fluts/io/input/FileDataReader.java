package com.timboektoe.fluts.io.input;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FileDataReader implements Reader {
    public static String selectFile() {
        JFileChooser jfc = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile.getAbsolutePath();
        }

        return null;
    }

    public String chooseFile() {
        String fileName = selectFile();
        if (!isNullOrEmpty(fileName)) {
            return fileName;
        }
        fileName = "flutsInput.txt";
        return fileName;
    }

    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    @Override
    public List<List<Integer>> readAllSchuurs(Scanner scanner, int numberSchuurs) {
        throw new IllegalArgumentException("Reqding from file will be developed with nex version!");
    }
}
