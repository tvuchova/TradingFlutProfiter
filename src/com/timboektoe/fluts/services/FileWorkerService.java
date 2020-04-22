package com.timboektoe.fluts.services;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class FileWorkerService {

    public void splitEmployeesByProject(String dateFormat, /*final HashMap<String, List<Employee>> projectList,*/
                                        final BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] parts = line.split(",");
            //putEmployeesInProjectsMap(dateFormat, projectList, parts);
        }
    }


    public String readDateFormat() {
        //TO DO add different dates validation
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //   System.out.println("Enter date format :(by default is  yyyy-MM-dd):");
        //   String dateFormat = br.readLine();
        String dateFormat = "";
        if (dateFormat.isEmpty()) dateFormat = "yyyy-MM-dd";
        return dateFormat;
    }

    public static long getLineCount(File file) throws IOException {
        try (Stream<String> lines = Files.lines(file.toPath())) {
            return lines.count();
        }
    }

}
