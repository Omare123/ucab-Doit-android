package example.omare.com.doit;

/**
 * Created by Omare on 29-10-2017.
 */

public class Tarea {
    String nombre, descripcion, fechaFinalizar, categoria;
    int completada;

    public Tarea(String nombre, String descripcion, String fechaFinalizar, String categoria, int completada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaFinalizar = fechaFinalizar;
        this.categoria = categoria;
        this.completada = completada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaFinalizar() {
        return fechaFinalizar;
    }

    public void setFechaFinalizar(String fechaFinalizar) {
        this.fechaFinalizar = fechaFinalizar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCompletada() {
        return completada;
    }

    public void setCompletada(int completada) {
        this.completada = completada;
    }
}
