package ferrando.alejandro.justveganproject.model;

public class Restaurant {
    String nombre;
    String descripcion;
    int img;
    String color;

    public Restaurant(String nombre, String descripcion, int img, String color) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.color = color;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
