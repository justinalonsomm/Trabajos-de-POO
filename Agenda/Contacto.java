class Contacto {
    private String nombre;
    private String numero;
    private String relacion;

    public Contacto(String nombre, String numero, String relacion) {
        this.nombre = nombre;
        this.numero = numero;
        this.relacion = relacion;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Número Telefónico: " + numero + ", Relación: " + relacion;
    }
}