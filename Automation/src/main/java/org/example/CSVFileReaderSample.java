package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVFileReaderSample
{
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\pwaidande\\Downloads\\bulk_user_import_1.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] attributes = bufferedReader.readLine().split(",");

        Map<String, List<String>> dataMap = new HashMap<>();

    }

}
