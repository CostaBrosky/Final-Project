package it.epicode.be.epicenergyservices.Csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import it.epicode.be.epicenergyservices.model.Municipality;
import it.epicode.be.epicenergyservices.model.Province;
import it.epicode.be.epicenergyservices.repository.IMunicipalityRepository;
import it.epicode.be.epicenergyservices.repository.IProvinceRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvMunicipality {

    private static final String PATH_FILE_CSV = "/home/costa/Documents/IdeaProjects/Epic-Energy-Services/resource/comuni-italiani2.csv";

    public static void readMunicipality(IProvinceRepository repo, IMunicipalityRepository mRepo) throws IOException, CsvException {

        FileReader readerProv = new FileReader(new File(PATH_FILE_CSV));

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(readerProv)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();

        List<String[]> date = csvReader.readAll();

        for (String[] column : date) {
            Municipality m = new Municipality();
            m.setIdMunicipality(column[1]);
            m.setName(column[2]);
//            System.out.println("cerco provincia con name: " + column[3]);
            Province p = repo.findByName(column[3]);
            m.setProvince(p);
            mRepo.save(m);
        }
    }
}
