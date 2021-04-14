
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "fl1.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Universitate", "Profesie","Hobby"));
        ) {
            csvPrinter.printRecord("1", "Andronic Roman♥", "USM", "student","jocuri");
            csvPrinter.printRecord("2", "Spinu Dan♥", "USM", "student","jocuri");
            csvPrinter.printRecord("3", "Barbos Oleg♥", "USM", "student","jocuri");

            csvPrinter.printRecord(Arrays.asList("5", "Diminet Ion", "USM", "student","jocuri"));

            csvPrinter.flush();
        }
    }
}
