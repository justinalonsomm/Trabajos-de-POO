class Evento {
    private String tipo;
    private String fecha;
    private String hora;
    private String lugar;
    private String descripcion;

    public Evento(String tipo, String fecha, String hora, String lugar, String descripcion) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public String toString() {
        return "Tipo de Evento: " + tipo + ", Fecha: " + fecha + ", Hora: " + hora + ", Lugar: " + lugar + ", Descripción: " + descripcion;
    }
}