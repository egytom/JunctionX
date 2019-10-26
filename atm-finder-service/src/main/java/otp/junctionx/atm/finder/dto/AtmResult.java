package otp.junctionx.atm.finder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtmResult {

    public String id;
    public int travelSeconds;

}
