package domain.model.customer;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by DeKi on 2/2/2016.
 */
//Value Object
public class Address {

    private final String street;
    private final String number;
    private final int zip;

    public Address(String street, String number, int zip) {
        Validate.notNull(street, "Street not specified.");
        Validate.notNull(number, "Street Number not specified");
        if(zip < 0) {
            throw new IllegalArgumentException("Zip cannot be negative");
        }
        this.street = street;
        this.number = number;
        this.zip = zip;
    }

    public Address changeStreet(String street) {
        return new Address(street, this.number, this.zip);
    }

    public Address changeStreetNumber(String number) {
        return new Address(this.street, number, this.zip);
    }

    public Address changeZip(int zip) {
        return new Address(this.street, this.number, zip);
    }

    public String getStreet() {
        return street;
    }

    public int getZip() {
        return zip;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return new EqualsBuilder()
                .append(zip, address.zip)
                .append(street, address.street)
                .append(number, address.number)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(street)
                .append(number)
                .append(zip)
                .toHashCode();
    }
}