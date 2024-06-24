package Usuário;

import Banco.Banco;

public class User extends InterfaceUsuario{
    public static void main(String[] args) {
        Banco banco = new Banco("XBANK");
        menuPrincipal(banco);

    }
}
