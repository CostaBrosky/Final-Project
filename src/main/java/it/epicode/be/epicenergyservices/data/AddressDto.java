package it.epicode.be.epicenergyservices.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String street;
    private String civic;
    private String locality;
    private int postalCode;
    private String municipality;
}
