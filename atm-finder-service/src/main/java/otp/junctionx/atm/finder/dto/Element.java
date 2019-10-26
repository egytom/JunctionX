package otp.junctionx.atm.finder.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Element {

    public Distance distance;
    public Duration duration;
    public String status;

}
