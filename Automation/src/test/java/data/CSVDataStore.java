package data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CSVDataStore {
    public List<UserDetails> readCsvFile(String path) {
        List<UserDetails> userlist = new ArrayList<>();
        Reader reader = null;
        CSVParser csvParser;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord csvRecord : csvParser) {
            UserDetails user = new UserDetails(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3), csvRecord.get(4), csvRecord.get(5), csvRecord.get(6), csvRecord.get(7));
            userlist.add(user);
        }
        return userlist;
    }

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("config.properties"));
        prop.getProperty("url");
    }
}
