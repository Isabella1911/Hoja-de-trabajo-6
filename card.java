public class card {

    private String name;
    private String type;
    private int amount;

    /**
     * Construye una nueva card con el name, type y amount dados.
     * @param name el name de la card
     * @param type el type de la card
     * @param amount la amount de la card
     */
    public card(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    /**
     * Devuelve el name de esta card.
     * @return el name
     */
    public String getname() {
        return name;
    }

    /**
     * Establece el name de esta card.
     * @param name el nuevo name
     */
    public void setname(String name) {
        this.name = name;
    }

    /**
     * Devuelve el type de esta card.
     * @return el type
     */
    public String gettype() {
        return type;
    }

    /**
     * Establece el type de esta card.
     * @param type el nuevo type
     */
    public void settype(String type) {
        this.type = type;
    }

    /**
     * Devuelve la amount de esta card.
     * @return la amount
     */
    public int getamount() {
        return amount;
    }

    /**
     * Establece la amount de esta card.
     * @param amount la nueva amount
     */
    public void setamount(int amount) {
        this.amount = amount;
    }

    /**
     * Devuelve una representación en cadena de esta card.
     * @return una cadena que representa esta card
     */
    @Override
    public String toString() {
        return "La card es{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
