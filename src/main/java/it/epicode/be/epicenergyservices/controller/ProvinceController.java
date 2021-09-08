package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.Province;
import it.epicode.be.epicenergyservices.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @GetMapping
    public ResponseEntity<Page<Province>> getAllProvince(Pageable pageable) {
        return  new ResponseEntity<>(provinceService.getAllProvince(pageable), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProvinceById (@PathVariable Long id) {
        return new ResponseEntity<>(provinceService.getProvinceById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProvince (@RequestBody Province province) {
        return new ResponseEntity<>(provinceService.saveProvince(province), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProvince (@PathVariable Long id) {
        provinceService.deleteProvince(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Province> updateProvince(@RequestBody Province newProvince, @PathVariable Long id) {

        return new ResponseEntity<>(provinceService.updateProvince(newProvince, id), HttpStatus.OK);
    }
}
