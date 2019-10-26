package otp.junctionx.atm.finder.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String postalCode;
    private String City;
    private String streetAddress;

}
