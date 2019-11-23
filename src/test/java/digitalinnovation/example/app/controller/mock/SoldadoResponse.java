package digitalinnovation.example.app.controller.mock;

import digitalinnovation.example.app.dto.Soldado;

public class SoldadoResponse {
    public static Soldado create(){
        Soldado soldado = new Soldado();
        soldado.setArma("Espada");
        soldado.setIdade(24);
        soldado.setNome("João");
        soldado.setRaca("humano");
        soldado.setStatus("vivo");
        return soldado;
    }
}
