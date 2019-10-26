package otp.junctionx.atm.finder.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Row {

    public List<Element> elements;

}
