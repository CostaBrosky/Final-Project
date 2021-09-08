package it.epicode.be.epicenergyservices.data;

import it.epicode.be.epicenergyservices.model.Municipality;
import it.epicode.be.epicenergyservices.model.Province;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MunicipalityDto {

    private Long id;
    private String name;
    private Long provinceId;
    private String provinceName;

    public static MunicipalityDto fromMunicipality(Municipality m) {
        return new MunicipalityDto(m.getId(),m.getIdMunicipality(),m.getProvince().getId(),m.getProvince().getName());
    }

    public Municipality toMunicipality() {
        Municipality m = new Municipality();
        m.setId(id);
        m.setName(name);
        Province p = new Province();
        p.setId(provinceId);
        p.setName(provinceName);
        m.setProvince(p);

        return m;
    }
}
