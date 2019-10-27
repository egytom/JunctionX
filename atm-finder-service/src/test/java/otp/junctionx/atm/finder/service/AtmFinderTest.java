package otp.junctionx.atm.finder.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import otp.junctionx.atm.finder.dto.AtmResponse;
import otp.junctionx.atm.finder.dto.SearchRequest;
import otp.junctionx.atm.finder.dto.helper.Coord;
import otp.junctionx.atm.finder.model.Atm;
import otp.junctionx.atm.finder.repository.AtmRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmFinderTest {

    @InjectMocks
    private AtmFinderService service;

    @Mock
    private AtmRepository repository;

    @BeforeEach
    void init() {
        this.repository = mock(AtmRepository.class);
        this.service = new AtmFinderService(repository);
    }

    @Test
    public void getAllAtmWithAllInfoDepositTrueTest() {
        SearchRequest searchRequest = SearchRequest.builder()
                .coord(Coord.builder().x(47.4648836).y(19.0228743).build())
                .dayName("SATURDAY")
                .isDepositRequired(true)
                .section(20)
                .build();
        when(repository.findById(anyString())).thenReturn(Optional.of(new Atm("2", 4)));

        List<AtmResponse> result = service.getAllAtmWithAllInfo(searchRequest);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(4L, result.get(0).countOfFutureCustomers.longValue());
        assertEquals(true, result.get(0).isDepositAvailable);
        assert(result.get(0).queueAndTravelTime.contains("min"));
    }

    @Test
    public void getAllAtmWithAllInfoDepositFalseTest() {
        SearchRequest searchRequest = SearchRequest.builder()
                .coord(Coord.builder().x(47.4648836).y(19.0228743).build())
                .dayName("SATURDAY")
                .isDepositRequired(false)
                .section(20)
                .build();
        when(repository.findById(anyString())).thenReturn(Optional.of(new Atm("2", 4)));

        List<AtmResponse> result = service.getAllAtmWithAllInfo(searchRequest);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(4L, result.get(0).countOfFutureCustomers.longValue());
        assertEquals(false, result.get(0).isDepositAvailable);
        assert(result.get(0).queueAndTravelTime.contains("min"));
    }

}
