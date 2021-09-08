package it.epicode.be.epicenergyservices.Csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import it.epicode.be.epicenergyservices.model.Province;
import it.epicode.be.epicenergyservices.repository.IProvinceRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvProvince {

    private static final String PATH_FILE_CSV = "/home/costa/Documents/IdeaProjects/Epic-Energy-Services/resource/province-italiane2.csv";

    public static void readProvince(IProvinceRepository repo) throws IOException, CsvException {

        FileReader reader = new FileReader(new File(PATH_FILE_CSV));

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();

        List<String[]> date = csvReader.readAll();

        for (String[] column : date) {
            Province p = new Province();
            p.setAcronyms(column[0]);
            p.setName(column[1]);
            p.setRegion(column[2]);
            repo.save(p);
        }
    }
}
