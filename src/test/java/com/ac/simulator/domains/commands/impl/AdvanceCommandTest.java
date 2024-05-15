package com.ac.simulator.domains.commands.impl;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.domains.lands.Land;
import com.ac.simulator.exceptions.LandNotFoundException;
import com.ac.simulator.exceptions.ReservedTreeClearingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdvanceCommandTest {

    @Mock
    Bulldozer bulldozer;

    @Mock
    SiteMap siteMap;

    @DisplayName("When 0 steps passed then bulldozer does not advance")
    @Test
    public void whenZeroStepsPassedBulldozerDoesNotMove() throws LandNotFoundException, ReservedTreeClearingException {
        //arrange
        AdvanceCommand advanceCommand = new AdvanceCommand(0);

        //act
        advanceCommand.execute(bulldozer, siteMap);

        //assert
        verify(bulldozer,times(0)).advance(any(), anyBoolean());
    }

    @DisplayName("When multiple steps passed then bulldozer advances multiple times")
    @Test
    public void whenMultipleStepsPassedBulldozerAdvancesMultipleTimes() throws LandNotFoundException, ReservedTreeClearingException {
        //arrange
        AdvanceCommand advanceCommand = new AdvanceCommand(2);
        Land land = mock(Land.class);
        when(siteMap.getLand(anyInt(),anyInt())).thenReturn(land);

        //act
        advanceCommand.execute(bulldozer, siteMap);

        //assert
        verify(bulldozer,times(2)).advance(any(), anyBoolean());
    }

    @DisplayName("When get command type then returns advance type")
    @Test
    public void whenGetCommandTypeThenReturnsAdvanceType() {
        //arrange
        AdvanceCommand advanceCommand = new AdvanceCommand(1);

        //act
        CommandType commandType = advanceCommand.getCommandType();

        //assert
        assertEquals(CommandType.ADVANCE, commandType);
    }
}
