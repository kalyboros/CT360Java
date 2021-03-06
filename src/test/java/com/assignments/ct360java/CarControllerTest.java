package com.assignments.ct360java;

import com.assignments.ct360java.task2and3.entities.Car;
import com.assignments.ct360java.task2and3.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createNewCarTest() throws Exception {

        // here we create a new entity that will be written to db, also a condition for comparison
        Car car = Car.builder()
                .brand("Renault")
                .model("Clio")
                .kilometers(3424)
                .build();

        given(carService.saveCar(any(Car.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - action that we are going to perform/test
        ResultActions response = mockMvc.perform(post("/api/cars/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car)));


        // then - verify result
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.brand",
                        is(car.getBrand())))
                .andExpect(jsonPath("$.model",
                        is(car.getModel())))
                .andExpect(jsonPath("$.kilometers",
                        is(car.getKilometers())));
    }

    // expect same list size
    @Test
    public void getAllCarsTest() throws Exception{
        // given precondition for comaprison
        List<Car> listOfCars = new ArrayList<>();
        listOfCars.add(Car.builder().brand("Tesla").model("S").kilometers(110).build());
        listOfCars.add(Car.builder().brand("BMW").model("i3").kilometers(510).build());
        listOfCars.add(Car.builder().brand("Toyota").model("Panda Trueno").kilometers(120).build());
        given(carService.getAllCars()).willReturn(listOfCars);

        // when -  action that we are going test
        ResultActions response = mockMvc.perform(get("/api/cars/get"));

        // then - verify output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfCars.size())));

    }

    // positive scenario - compare our hardcoded data and given id, expect same returned data
    @Test
    public void compareDataThroughValidIdAndDataTest() throws Exception{
        // given - precondition
        Integer carId = 1;
        Car car = Car.builder()
                .brand("Tesla")
                .model("S")
                .kilometers(110)
                .build();
        given(carService.getCarById(carId)).willReturn(Optional.of(car));

        // when -  action that we are going test
        ResultActions response = mockMvc.perform(get("/api/cars/getById/{id}", carId));

        // then - verify output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand", is(car.getBrand())))
                .andExpect(jsonPath("$.model", is(car.getModel())))
                .andExpect(jsonPath("$.kilometers", is(car.getKilometers())));

    }

    // negative scenario, here we provide wrong id
    @Test
    public void compareDataThroughValidIdTestNoData() throws Exception{
        // given - precondition or setup
        Integer carId = 4;
        Car car = Car.builder()
                .brand("Tesla")
                .model("S")
                .kilometers(110)
                .build();
        given(carService.getCarById(carId)).willReturn(Optional.of(car));

        // when -  action that we are going test
        ResultActions response = mockMvc.perform(get("/api/cars/getById/{id}", carId));

        // then - verify output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }

    // positive scenario - we send update data and compare the returned updated data
    @Test
    public void updateCarPositiveScenarioTest() throws Exception{
        // given - precondition or setup
        Integer carId = 1;
        Car savedCar = Car.builder()
                .brand("Tesla")
                .model("S")
                .kilometers(110)
                .build();

        Car updatedCar = Car.builder()
                .brand("Tesla")
                .model("S")
                .kilometers(1213214)
                .build();

        given(carService.getCarById(carId)).willReturn(Optional.of(savedCar));
        given(carService.updateCar(any(Car.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when -  action that we are going test
        ResultActions response = mockMvc.perform(put("/api/cars/updateCar/{id}", carId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCar)));


        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand", is(updatedCar.getBrand())))
                .andExpect(jsonPath("$.model", is(updatedCar.getModel())))
                .andExpect(jsonPath("$.kilometers", is(updatedCar.getKilometers())));
    }

    @Test
    public void updateCarNegativeScenarioTest() throws Exception{
        // given - precondition or setup
        Integer carId = 1;
        Car savedCar = Car.builder()
                .brand("Tesla")
                .model("S")
                .kilometers(110)
                .build();

        Car updatedCar = Car.builder()
                .brand("Tesla")
                .model("S")
                .kilometers(1213214)
                .build();

        given(carService.getCarById(carId)).willReturn(Optional.of(savedCar));
        given(carService.updateCar(any(Car.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when -  action that we are going test
        ResultActions response = mockMvc.perform(put("/api/cars/updateCar/{id}", carId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCar)));


        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void deleteCarTest() throws Exception{
        // given - precondition
        Integer carId = 1;
        willDoNothing().given(carService).deleteCar(carId);

        // when -  action that we are going test
        ResultActions response = mockMvc.perform(delete("/api/cars/delete/{id}", carId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }




}
