package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.address.DataAddress;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String publicPlace;
    private String neighborhood;
    private String cep;
    private String number;
    private String complement;
    private String city;
    private String uf;

    public Address(DataAddress address) {
        this.publicPlace = address.publicPlace();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.number = address.number();
        this.complement = address.complement();
        this.city = address.city();
        this.uf = address.uf();
    }

    public void update (@Valid DataAddress address) {
        if (address.publicPlace() != null) this.publicPlace = address.publicPlace();
        if (address.neighborhood() != null) this.neighborhood = address.neighborhood();
        if (address.cep() != null) this.cep = address.cep();
        if (address.number() != null) this.number = address.number();
        if (address.complement() != null) this.complement = address.complement();
        if (address.city() != null) this.city = address.city();
        if (address.uf() != null) this.uf = address.uf();
    }
}
