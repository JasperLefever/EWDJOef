package com.springboot.restFruitStart;

import domain.Fruit;
import exceptions.FruitNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import service.FruitService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static utils.InitFormatter.FORMATTER;

@SpringBootTest
class FruitRestMockTest {

    @Mock
    private FruitService mock;

    private FruitRestController controller;
    private MockMvc mockMvc;

    private final int ID = 10;
    private final String NAME = "Test";
    private String expectedFormattedQuality;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        controller = new FruitRestController();
        mockMvc = standaloneSetup(controller).build();
        ReflectionTestUtils.setField(controller, "fruitService", mock);
    }

    private Fruit aFruit(int id, String name, double quality) {
        Fruit fruit = new Fruit(id, name, quality);
        expectedFormattedQuality = FORMATTER.format(quality);
        return fruit;
    }

    private void performRest(String uri) throws Exception {
        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fruit_id").value(ID))
                .andExpect(jsonPath("$.fruit_name").value(NAME))
                .andExpect(jsonPath("$.quality").value(expectedFormattedQuality))
        ;
    }

    @ParameterizedTest
    @CsvSource(value = {"5.21\t5,2", "7\t7", "7.0\t7", "6.38\t6,4"}, delimiter = '\t')
    public void testGetFruit_isOk(double quality, String formattedQuality) throws Exception {
        Mockito.when(mock.getFruitDetail(ID)).thenReturn(aFruit(ID, NAME, quality));
        performRest("/fruit/" + ID);
        assertEquals(formattedQuality, expectedFormattedQuality);
        Mockito.verify(mock).getFruitDetail(ID);
    }

    @Test
    public void testGetFruit_notFound() throws Exception {
        Mockito.when(mock.getFruitDetail(ID)).thenThrow(new FruitNotFoundException(ID));
        Exception exception = assertThrows(Exception.class, () -> {
            mockMvc.perform(get("/fruit/" + ID)).andReturn();
        });
        assertTrue(exception.getCause() instanceof FruitNotFoundException);
        Mockito.verify(mock).getFruitDetail(ID);
    }

    @Test
    public void testGetAllFruit_emptyList() throws Exception {
        Mockito.when(mock.getAllFruits()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/fruit/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());

        Mockito.verify(mock).getAllFruits();
    }

    @Test
    public void testGetAllEmployees_noEmptyList() throws Exception {
        Fruit fruit1 = aFruit(ID, NAME, 5.21);
        String expectedFormattedQuality1 = expectedFormattedQuality;
        Fruit fruit2 = aFruit(5678, "Test2", 8.58);
        String expectedFormattedQuality2 = expectedFormattedQuality;
        List<Fruit> listFruit = List.of(fruit1, fruit2);
        Mockito.when(mock.getAllFruits()).thenReturn(listFruit);

        mockMvc.perform(get("/fruit/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].fruit_id").value(ID))
                .andExpect(jsonPath("$[0].fruit_name").value(NAME))
                .andExpect(jsonPath("$[0].quality").value(expectedFormattedQuality1))
                .andExpect(jsonPath("$[1].fruit_id").value(5678))
                .andExpect(jsonPath("$[1].fruit_name").value("Test2"))
                .andExpect(jsonPath("$[1].quality").value(expectedFormattedQuality2));

        Mockito.verify(mock).getAllFruits();
    }

}
