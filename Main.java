import java.util.Map;
public class Main {
    public static void main(String[] args) {
        // Seleccionar la implementación del mapa
        System.out.print("\n¿Que tipo de mapa va a usar? ");
        String tipoMapa = Functions.readEntry();; 
        Map<String, Card> mapa = MapFactory.crearMapa(tipoMapa); 
        Reader lector = new Reader();
        Map<String, String> CardsSistema = lector.leerArchivo("cards_desc.txt");
        Deck DeckUsuario = new Deck(mapa);

       
        Interface interfaz = new Interface(DeckUsuario);
        interfaz.mostrarMenu(CardsSistema);
    }
}  

