package otp.junctionx.atm.finder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtmLocationResponse {

    public String id;
    public Coord coord;
    public boolean isDepositAvailable;

}
