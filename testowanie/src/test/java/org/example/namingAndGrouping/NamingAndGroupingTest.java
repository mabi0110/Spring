package org.example.namingAndGrouping;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NamingAndGroupingTest {

    @Nested
    class Calculator{
        @DisplayName("2 + 2 = 4")
        @Test
        public void shouldAdd2to2AndReturn4(){

        }
    }

    @DisplayName("naming tests")
    @Nested
    class Mails{
        @DisplayName("emails only to subscribers")
        @Test
        public void shouldSendEmailToSubscriber(){

        }
    }


}
