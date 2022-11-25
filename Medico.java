package Actividad5.java.Evidencia;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private Integer id;
    private String name;
    private String especialista;
    public static List<Medico> medics;

    public Medico(){
    }

    public Medico(Integer id, String name, String especialista) {
        this.id = id;
        this.name = name;
        this.especialista = especialista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecialidad() {
        return especialista;
    }

    public void setEspecialidad(String especialista) {
        this.especialista = especialista;
    }
}
