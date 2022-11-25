package Actividad5.java.Evidencia;

public class Paciente {
    private Integer id;
    private String name;

    public Paciente(){
    }

    public Paciente(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
