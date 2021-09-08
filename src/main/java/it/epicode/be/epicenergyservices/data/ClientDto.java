package it.epicode.be.epicenergyservices.data;

import it.epicode.be.epicenergyservices.model.Address;
import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.model.ClientType;
import it.epicode.be.epicenergyservices.model.Municipality;
import it.epicode.be.epicenergyservices.service.IMunicipalityService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private String businessName;
    private String vatNumber;
    private String email;
    private LocalDateTime insertionDate;
    private LocalDateTime lastContatctDate;
    private BigDecimal annualRevenue;
    private String pec;
    private String phone;
    private String contactEmail;
    private String contactName;
    private String contactSurname;
    private String contactPhone;
    private AddressDto registeredOffice;
    private AddressDto operationalHeadquarters;
    private ClientType type;

    public static ClientDto fromClient(Client c) {

        AddressDto address1 = new AddressDto();
        AddressDto address2 = new AddressDto();

        address1.setStreet(c.getRegisteredOffice().getStreet());
        address1.setCivic(c.getRegisteredOffice().getCivic());
        address1.setLocality(c.getRegisteredOffice().getLocality());
        address1.setPostalCode(c.getRegisteredOffice().getPostalCode());
        address1.setMunicipality(c.getRegisteredOffice().getMunicipality().getName());

        address2.setStreet(c.getOperationalHeadquarters().getStreet());
        address2.setCivic(c.getOperationalHeadquarters().getCivic());
        address2.setLocality(c.getOperationalHeadquarters().getLocality());
        address2.setPostalCode(c.getOperationalHeadquarters().getPostalCode());
        address2.setMunicipality(c.getOperationalHeadquarters().getMunicipality().getName());

        return new ClientDto(c.getId(), c.getBusinessName(), c.getVatNumber(), c.getEmail(), c.getInsertionDate(),
                c.getLastContatctDate(), c.getAnnualRevenue(), c.getPec(), c.getPhone(), c.getContactEmail(),
                c.getContactName(), c.getContactSurname(), c.getContactPhone(), address1, address2,
                c.getType());
    }

    public Client toClient(IMunicipalityService comServ) throws EntityNotFoundException {

        Client c = new Client();

        if (registeredOffice != null) {

            Address ad = new Address();
            ad.setStreet(registeredOffice.getStreet());
            ad.setCivic(registeredOffice.getCivic());
            ad.setPostalCode(registeredOffice.getPostalCode());
            ad.setLocality(registeredOffice.getLocality());
            Optional<Municipality> comAd = comServ.findByName(registeredOffice.getMunicipality());
            comAd.ifPresent(ad::setMunicipality);
            c.setRegisteredOffice(ad);

        }

        if (operationalHeadquarters != null) {
            Address so = new Address();
            so.setStreet(operationalHeadquarters.getStreet());
            so.setCivic(operationalHeadquarters.getCivic());
            so.setPostalCode(operationalHeadquarters.getPostalCode());
            so.setLocality(operationalHeadquarters.getLocality());
            Optional<Municipality> comSo = comServ.findByName(operationalHeadquarters.getMunicipality());
            comSo.ifPresent(so::setMunicipality);
            c.setOperationalHeadquarters(so);
        }

        c.setId(id);
        c.setBusinessName(businessName);
        c.setVatNumber(vatNumber);
        c.setEmail(email);
        c.setInsertionDate(insertionDate);
        c.setLastContatctDate(lastContatctDate);
        c.setAnnualRevenue(annualRevenue);
        c.setPec(pec);
        c.setPhone(phone);
        c.setContactEmail(contactEmail);
        c.setContactName(contactName);
        c.setContactSurname(contactSurname);
        c.setContactPhone(contactPhone);
        c.setType(type);

        return c;
    }
}
