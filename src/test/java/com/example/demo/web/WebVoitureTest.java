package com.example.demo.web;

import com.example.demo.data.Voiture;

import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class WebVoitureTest {

	@MockBean
	Statistique statistique;

	@Autowired
	MockMvc mockMvc;

	@Test
	void testZeroVoiture() throws Exception {
		mockMvc.perform(get("/statistique")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	void ajouterVoiture() throws Exception {
		mockMvc.perform(post("/voiture")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{ \"id\": 4, \"marque\": \"Audi\", \"prix\": 10000 }")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	public void getStatistiques() throws Exception {
    doNothing().when(statistique).ajouter(new Voiture("Kia", 15000));
		when(statistique.prixMoyen()).thenReturn(new Echantillon(1, 15000));
		mockMvc.perform(get("/statistique"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nombreDeVoitures").value("1"))
			.andExpect(jsonPath("$.prixMoyen").value("15000"))
			.andReturn();
	}

}