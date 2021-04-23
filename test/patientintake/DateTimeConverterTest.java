package patientintake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeConverterTest {

    @Test
    void convertTodayStringCorrectly() {
        LocalDateTime result = DateTimeConverter.convertStringToDate("today 1:00 pm", LocalDate.of(2021,4,24));
        assertEquals(result,LocalDateTime.of(2021,4,24,13,0));
    }

    @Test
    void convertCorrectPatterntoDateTime(){
        LocalDateTime result = DateTimeConverter.convertStringToDate("4/24/2021 1:00 pm", LocalDate.of(2021,4,24));
        assertEquals(result,LocalDateTime.of(2021,4,24,13,0));


    }
}