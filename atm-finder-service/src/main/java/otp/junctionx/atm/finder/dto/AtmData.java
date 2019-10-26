package otp.junctionx.atm.finder.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtmData {

    public String id;
    public String date;
    public String day;
    public Boolean deposit;
    public Address address;
    public Coord coord;
    public List<Integer> sections;

}
