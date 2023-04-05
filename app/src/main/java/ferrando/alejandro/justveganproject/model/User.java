package ferrando.alejandro.justveganproject.model;

public class User {
    private String email;
    private String password;
    private int trabajador;
    private int admin;

    public User(String email, String password, int trabajador, int admin){
        this.email = email;
        this.password = password;
        this.trabajador = trabajador;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(int trabajador) {
        this.trabajador = trabajador;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
