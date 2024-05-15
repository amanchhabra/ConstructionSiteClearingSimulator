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

@ExtendWith(MockitoExtension.class)
public class QuitCommandTest {

    @Mock
    Bulldozer bulldozer;

    @Mock
    SiteMap siteMap;

    @DisplayName("When get command type then returns quit type")
    @Test
    public void whenGetCommandTypeThenReturnsQuitType() {
        //arrange
        QuitCommand quitCommand = new QuitCommand();

        //act
        CommandType commandType = quitCommand.getCommandType();

        //assert
        assertEquals(CommandType.QUIT, commandType);
    }
}
