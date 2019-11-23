package digitalinnovation.example.app.controller.mock;

import digitalinnovation.example.app.dto.Soldado;

public class SoldadoRequest {
    public static Soldado create(){
        Soldado soldado = new Soldado();
        soldado.setArma("Machado");
        soldado.setIdade(23);
        soldado.setNome("Glauber");
        soldado.setRaca("humano");
        soldado.setStatus("vivo");
        return soldado;
    }
}
