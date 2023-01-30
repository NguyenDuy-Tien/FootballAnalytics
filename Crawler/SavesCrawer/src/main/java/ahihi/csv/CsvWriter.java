package ahihi.csv;

import ahihi.model.ICsvRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class CsvWriter {
    public static <T extends ICsvRecord> void write(String fileName, T record) throws IOException {
        CSVFormat format;
        if(! fileExist(fileName)) {
            format = CSVFormat.DEFAULT.builder().setHeader(record.getHeaders()).build();
        } else {
            format = CSVFormat.DEFAULT;
        }

        FileWriter out = new FileWriter(fileName, true);
        try (CSVPrinter printer = new CSVPrinter(out, format)) {
            printer.printRecord(record.getObjects());
        }
    }

    public static <T extends ICsvRecord> void write(String fileName, Collection<T> records) throws IOException {
        if (records.isEmpty()) {
            return;
        }
        CSVFormat format;
        if(! fileExist(fileName)) {
            format = CSVFormat.DEFAULT.builder().setHeader(records.stream().findAny().get().getHeaders()).build();
        } else {
            format = CSVFormat.DEFAULT;
        }

        FileWriter out = new FileWriter(fileName, true);
        try (CSVPrinter printer = new CSVPrinter(out, format)) {
            for(ICsvRecord record : records){
                printer.printRecord(record.getObjects());
            }
        }
    }

    private static boolean fileExist(String fileName) {
        File f = new File(fileName);
        return f.exists() && !f.isDirectory();
    }
}
