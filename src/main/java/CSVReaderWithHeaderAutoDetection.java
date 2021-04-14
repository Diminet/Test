
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CSVReaderWithHeaderAutoDetection {
    private static final String SAMPLE_CSV_FILE_PATH = "fl1.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String ID = csvRecord.get("ID");
                String Name = csvRecord.get("Name");
                String Universitate = csvRecord.get("Universitate");
                String Profesie = csvRecord.get("Profesie");
                String hbb = csvRecord.get("Hobby");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + ID);
                System.out.println("Email : " + Name);
                System.out.println("Phone : " + Universitate);
                System.out.println("Country : " + Profesie);
                System.out.println("hbb : " + hbb);
                System.out.println("---------------\n\n");
            }
        }
    }
}
