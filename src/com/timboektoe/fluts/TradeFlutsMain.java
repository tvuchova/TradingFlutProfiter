package com.timboektoe.fluts;

import com.timboektoe.fluts.services.FolderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TradeFlutsMain {

    public static void main(String[] args) {

        String fileName = FolderService.selectFile();
        if (fileName == null || fileName.isEmpty()) {
            fileName = "flutsInput.txt";
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), Charset.forName("UTF-8"))) {
            reader.readLine();
            //fileWorkerService.splitEmployeesByProject(DATE_FORMAT, projectsMap, reader);

           // HashMap<EmployeesPair, Long> employeesPairMap = new HashMap<>();
          //  fileWorkerService.combineEmployeePairsByWorkingTime(projectsMap, employeesPairMap);

            printingResult(/*employeesPairMap*/);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printingResult(/*HashMap<EmployeesPair, Long> employeesPairMap*/) {
       /* Optional<Map.Entry<EmployeesPair, Long>> first = employeesPairMap.entrySet().stream()
                .min((k1, k2) -> -k1.getValue().compareTo(k2.getValue()));
        if (first.isPresent()) {
            System.out.println("RESULT PAIR IS :" + first.get().getKey() + " with longest period : " + first.get().getValue());
        } else {
            System.out.println("Cannot retrieve longest period.Please upload correct file!");
        }*/
    }
}
