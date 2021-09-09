package it.epicode.be.epicenergyservices.data;

import it.epicode.be.epicenergyservices.model.Address;
import it.epicode.be.epicenergyservices.service.IAddressService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String street;
    private String civic;
    private String locality;
    private int postalCode;
    private String municipality;

    public static AddressDto fromAddress(Address a) {
        return new AddressDto(a.getId(), a.getStreet(), a.getCivic(), a.getLocality(), a.getPostalCode(), a.getMunicipality().getName());
    }

    public Address toAddress(IAddressService addressService) {
        Address i = new Address();
        i.setStreet(street);
        i.setCivic(civic);
        i.setLocality(locality);
        i.setPostalCode(postalCode);
        return i;

    }

}
