package Usuário;

public class ClearConsole {
    public static void clear() {
        // Limpeza do terminal usando código de escape ANSI
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
