package com.ac.simulator.domains.commands.impl;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LeftCommandTest {

    @Mock
    Bulldozer bulldozer;

    @Mock
    SiteMap siteMap;

    @DisplayName("When execute then turn bulldozer left")
    @Test
    public void whenExecuteThenTurnBulldozerLeft() {
        //arrange
        LeftCommand leftCommand = new LeftCommand();

        //act
        leftCommand.execute(bulldozer, siteMap);

        //assert
        verify(bulldozer,times(1)).turnLeft();
    }

    @DisplayName("When get command type then returns left type")
    @Test
    public void whenGetCommandTypeThenReturnsLeftType() {
        //arrange
        LeftCommand leftCommand = new LeftCommand();

        //act
        CommandType commandType = leftCommand.getCommandType();

        //assert
        assertEquals(CommandType.LEFT, commandType);
    }
}
