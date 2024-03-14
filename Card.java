public class Card {
    private String nombre;
    private String tipo;
    private int cantidad;

    /**
     * Construye una nueva carta con el nombre, tipo y cantidad 
     * @param nombre el nombre de la Card
     * @param tipo el tipo de la Card
     * @param cantidad la cantidad de la Card
     */
    public Card(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    /**
     * Da el nombre de la carta
     * @return el nombre
     */
    public String getName() {
        return nombre;
    }

    /**
     * define el nombre de la carta
     * @param nombre el nuevo nombre
     */
    public void setName(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Da el tipo de carta
     * @return el tipo
     */
    public String getType() {
        return tipo;
    }

    /**
     * define el tipo de carta
     * @param tipo el nuevo tipo
     */
    public void setType(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Da la cantidad de la carta
     * @return la cantidad
     */
    public int getQuantity() {
        return cantidad;
    }

    /**
     * defina la cantidad de la carta
     * @param cantidad la nueva cantidad
     */
    public void setQuantity(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Da la carta con sus atributos
     * @return una cadena que representa esta Card
     */
    @Override
    public String toString() {
        return "Carta:" +
                "Nombre:'" + nombre + '\'' +
                " Tipo:" + tipo + '\'' +
                " Cantidad:" + cantidad;
    }
}


