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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RightCommandTest {

    @Mock
    Bulldozer bulldozer;

    @Mock
    SiteMap siteMap;

    @DisplayName("When execute then turn bulldozer right")
    @Test
    public void whenExecuteThenTurnBulldozerRight(){
        //arrange
        RightCommand rightCommand = new RightCommand();

        //act
        rightCommand.execute(bulldozer, siteMap);

        //assert
        verify(bulldozer,times(1)).turnRight();
    }

    @DisplayName("When get command type then returns right type")
    @Test
    public void whenGetCommandTypeThenReturnsRightType() {
        //arrange
        RightCommand rightCommand = new RightCommand();

        //act
        CommandType commandType = rightCommand.getCommandType();

        //assert
        assertEquals(CommandType.RIGHT, commandType);
    }
}
