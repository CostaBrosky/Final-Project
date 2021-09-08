package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.Municipality;
import it.epicode.be.epicenergyservices.model.Province;
import it.epicode.be.epicenergyservices.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {

    @Autowired
    private IMunicipalityService municipalityService;

    @GetMapping
    public ResponseEntity<Page<Municipality>> getAllMunicipality(Pageable pageable) {
        return  new ResponseEntity<>(municipalityService.getAllMunicipality(pageable), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMunicipalityById (@PathVariable Long id) {
        return new ResponseEntity<>(municipalityService.getMunicipalityById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveMunicipality (@RequestBody Municipality muni) {
        return new ResponseEntity<>(municipalityService.saveMunicipality(muni), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMunicipality (@PathVariable Long id) {
        municipalityService.deleteMunicipality(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Municipality> updateProvince(@RequestBody Municipality newMuni, @PathVariable Long id) {

        return new ResponseEntity<>(municipalityService.updateMunicipality(newMuni, id), HttpStatus.OK);
    }
}
