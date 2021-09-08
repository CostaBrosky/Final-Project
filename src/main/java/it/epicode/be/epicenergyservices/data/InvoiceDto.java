package it.epicode.be.epicenergyservices.data;

import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import it.epicode.be.epicenergyservices.model.Invoices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceDto {

    private Long id;
    private Integer year;
    private LocalDateTime date;
    private BigDecimal amount;
    private Long number;
    private String status;
    private Long clientId;

    public static InvoiceDto fromInvoice(Invoices invoice) {
        return new InvoiceDto(invoice.getId(),invoice.getYear(),invoice.getDate(),invoice.getAmount(),invoice.getStatus().getId(),
                invoice.getStatus().getStatus(),invoice.getClient().getId());
    }

    public Invoices toInvoices() {

        Invoices invo = new Invoices();
        invo.setId(id);
        invo.setYear(year);
        invo.setDate(date);
        invo.setAmount(amount);

        InvoiceStatus s = new InvoiceStatus();
        s.setId(number);
        s.setStatus(status);
        invo.setStatus(s);

        Client c = new Client();
        c.setId(clientId);
        invo.setClient(c);

        return invo;
    }
}
