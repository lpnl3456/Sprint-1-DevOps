package com.keyin.rest.Gate;

import com.keyin.rest.City.City;
import com.keyin.rest.TakeOff.TakeOffRepository;
import com.keyin.rest.TakeOff.TakeOffService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GateServiceTest {
    @Mock
    private GateRepository gateRepository;
    @InjectMocks
    private GateService gateService;

    @Test
    public void testFindGateByGateName(){
        Gate gate = new Gate (1, "gate A");

        when(gateRepository.findByGateName("gate A")).thenReturn(gate);

        Gate gateResponse = gateService.findGateByGateName("gate A");

        Assertions.assertNotNull(gateResponse);
    }

    @Test
    public void testGetGateByID(){
        Gate gate = new Gate (1, "gate A");

        when(gateRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(gate));

        Gate gateResponse = gateService.getGateById(1);

        Assertions.assertNotNull(gateResponse);
    }
}
