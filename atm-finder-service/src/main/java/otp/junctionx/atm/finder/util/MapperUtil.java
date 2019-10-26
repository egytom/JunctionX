package otp.junctionx.atm.finder.util;

import otp.junctionx.atm.finder.dto.AtmData;
import otp.junctionx.atm.finder.dto.AtmLocationResponse;

import java.util.ArrayList;
import java.util.List;

public class MapperUtil {

    private MapperUtil() {
    }

    public static List<AtmLocationResponse> mapAtmDataListToAtmLocationResponseList(List<AtmData> atmDataList) {
        List<AtmLocationResponse> atmLocationResponseList = new ArrayList<>();
        for (AtmData atmData : atmDataList) {
            atmLocationResponseList.add(
                    AtmLocationResponse.builder()
                            .coord(atmData.coord)
                            .id(atmData.id)
                            .isDepositAvailable(atmData.deposit)
                            .build()
            );
        }
        return atmLocationResponseList;
    }

}
