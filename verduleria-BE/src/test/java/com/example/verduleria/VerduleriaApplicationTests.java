package com.example.verduleria;

import com.example.verduleria.Controllers.EncuestaController;
import com.example.verduleria.DTOs.EncuestaEstadistica;
import com.example.verduleria.DTOs.PreguntaDto;
import com.example.verduleria.DTOs.EncuestaDto;
import com.example.verduleria.DTOs.EncuestaSinPregDto;
import com.example.verduleria.Entities.EncuestaEntity;
import com.example.verduleria.Entities.PreguntaEntity;
import com.example.verduleria.Respositories.EncuestaRepository;
import com.example.verduleria.Services.EncuestaServiceImpl;

//importaciones que debo tener para los test

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatObject;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@WebMvcTest(EncuestaEntity.class)
@AutoConfigureMockMvc
class EncuestaControllerIntegrationTest {

	@Autowired private MockMvc mockMvc;
	@Autowired private EncuestaRepository encuestaRepo;





}


