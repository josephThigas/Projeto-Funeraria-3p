package util;

import java.util.HashMap;
import java.util.Map;

public class Credenciais {
    private static final Map<String, String> usuarios = new HashMap<>();
    private static final Map<String, String> perfis = new HashMap<>();

    static {
        // Usuário: admin, Senha: admin123, Perfil: Administrador
        usuarios.put("admin", "admin123");
        perfis.put("admin", "Administrador");
        // Usuário: func, Senha: func123, Perfil: Funcionario
        usuarios.put("func", "func123");
        perfis.put("func", "Funcionario");
    }

    public static boolean autenticar(String usuario, String senha) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha);
    }

    public static String getPerfil(String usuario) {
        return perfis.get(usuario);
    }
}
