import java.util.Scanner;
public class Functions {
    private static Scanner scanner = new Scanner(System.in);
  
    /** 
     * @param mensaje
     */
    public static void showMessage(String mensaje) {
        System.out.println(mensaje);
    }
    
    /** 
     * @return String
     */
    public static String readEntry() {
        return scanner.nextLine();
    }
    
    /** 
     * @return int
     */
    public static int readDigit() throws NumberFormatException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("\nIngrese un numero entero");
        }
    }

    /** 
     * @param entrada
     * @return boolean
     */
    public static boolean testEntries(String entrada) {
        return entrada.equalsIgnoreCase("si") || entrada.equalsIgnoreCase("no");
    }

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J"); //ANSI "escape code" de acuerdo con Google
        System.out.flush();
    }

}
    