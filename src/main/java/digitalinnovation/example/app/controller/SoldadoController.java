package digitalinnovation.example.app.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import digitalinnovation.example.app.dto.Soldado;
import digitalinnovation.example.app.service.SoldadoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {
    private ObjectMapper objectMapper;
    @Value("${meuvalor}")
    private String meuValor;

    private SoldadoService soldadoService;

    public SoldadoController(ObjectMapper objectMapper, SoldadoService soldadoService) {
        this.objectMapper = objectMapper;
        this.soldadoService = soldadoService;
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        System.out.println("Entrou no post");
        soldadoService.salvarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity editarSoldado(@RequestBody Soldado soldado) {
        System.out.println("Entrou no Put");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soldado> buscarSoldados(@PathVariable() Long id) {
        String testeProperties = meuValor;
        Soldado soldado = soldadoService.getSoldado();
        return ResponseEntity.ok(soldado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Soldado> deletar(@PathVariable() Long id) {
        return ResponseEntity.ok().build();
    }
}
