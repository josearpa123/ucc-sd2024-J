package clases;

public class Vehiculo {
    private String tipo;
    private int velocidad;
    private String marca;
    private String color;
    private String placa;
    private String Combustible;

    public Vehiculo(String tipo, int velocidad, String marca, String color, String placa, String Combustible) {
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.marca = marca;
        this.color = color;
        this.placa = placa;
        this.Combustible = Combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return Combustible;
    }

    public void setCombustible(String combustible) {
        Combustible = combustible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
