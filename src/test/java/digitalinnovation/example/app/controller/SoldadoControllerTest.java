package digitalinnovation.example.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import digitalinnovation.example.app.controller.mock.SoldadoRequest;
import digitalinnovation.example.app.controller.mock.SoldadoResponse;
import digitalinnovation.example.app.dto.Soldado;
import digitalinnovation.example.app.service.SoldadoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SoldadoController.class)
public class SoldadoControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Spy
    private ObjectMapper objectMapper;
    @MockBean
    private SoldadoService soldadoService;

    @Test
    public void chamadaGet() throws Exception {
        Soldado soldado = SoldadoResponse.create();
        String jsonOutString = objectMapper.writerWithView(Soldado.class).writeValueAsString(soldado);
        when(soldadoService.getSoldado()).thenReturn(soldado);

        mockMvc.perform(
                get("/v1/soldado/1")
                        .header("meu_header", "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonOutString))
        .andExpect(header().string("Content-Type","application/json;charset=UTF-8"));
    }

    @Test
    public void chamadaPost() throws Exception {
        Soldado soldado = SoldadoRequest.create();
        String jsonInString = objectMapper.writerWithView(Soldado.class).writeValueAsString(soldado);
        doNothing().when(soldadoService).salvarSoldado(any());

        mockMvc.perform(
                post("/v1/soldado")
                        .header("meu_header", "")
                        .content(jsonInString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void chamadaPut() throws Exception {
        Soldado soldado = SoldadoRequest.create();
        String jsonInString = objectMapper.writerWithView(Soldado.class).writeValueAsString(soldado);
        mockMvc.perform(
                put("/v1/soldado")
                        .header("meu_header", "")
                        .content(jsonInString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void chamadaDelete() throws Exception {
        mockMvc.perform(
                delete("/v1/soldado/1")
                        .header("meu_header", "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
