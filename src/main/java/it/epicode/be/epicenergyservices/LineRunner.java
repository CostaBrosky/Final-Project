package it.epicode.be.epicenergyservices;

import com.opencsv.exceptions.CsvException;
import it.epicode.be.epicenergyservices.Csv.CsvMunicipality;
import it.epicode.be.epicenergyservices.Csv.CsvProvince;
import it.epicode.be.epicenergyservices.repository.IMunicipalityRepository;
import it.epicode.be.epicenergyservices.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LineRunner implements CommandLineRunner {

    @Autowired
    private IProvinceRepository provRepo;

    @Autowired
    private IMunicipalityRepository munRepo;

    @Override
    public void run(String... args) {
//        try {
////            CsvProvince.readProvince(provRepo);
//            CsvMunicipality.readMunicipality(provRepo,munRepo);
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }
    }
}
