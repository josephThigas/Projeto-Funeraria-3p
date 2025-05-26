import java.util.Scanner;

public class Funeraria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean conectado = false;
        while (!conectado) {
            limparTerminal();
            // System.out.println("Tentando realizar login no servidor MySQL. Informe usuário e senha.");
            // System.out.print("Usuário: ");
            // String usuarioMysql = scanner.nextLine();
            // System.out.print("Senha: ");
            // String senhaMysql = scanner.nextLine();
            try {
                util.ConnectionFactory.getConnection("root", "123456");
                System.out.println("Conexão bem-sucedida!");
                conectado = true;
            } catch (Exception e) {
                System.out.println("Erro ao tentar conectar: " + e.getMessage());
                System.out.println("Aperte 1 para tentar novamente.");
                String opcao = scanner.nextLine();
                if (!"1".equals(opcao)) {
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                }
            }
        }
        // Menu de autenticação de usuário do sistema
        boolean autenticado = false;
        String usuarioSistema = null;
        String perfil = null;
        while (!autenticado) {
            limparTerminal();
            System.out.println("Login no sistema Funerária");
            System.out.print("Usuário: ");
            usuarioSistema = scanner.nextLine();
            System.out.print("Senha: ");
            String senhaSistema = scanner.nextLine();
            if (util.Credenciais.autenticar(usuarioSistema, senhaSistema)) {
                perfil = util.Credenciais.getPerfil(usuarioSistema);
                System.out.println("Bem-vindo, " + usuarioSistema + "! Perfil: " + perfil);
                autenticado = true;
            } else {
                System.out.println("Usuário ou senha inválidos. Aperte 1 para tentar novamente ou qualquer outra tecla para sair.");
                String opcao = scanner.nextLine();
                if (!"1".equals(opcao)) {
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                }
            }
        }
        // Exemplo de menu restrito por perfil
        boolean sairMenu = false;
        while (!sairMenu) {
            // limparTerminal();
            if ("Administrador".equals(perfil)) {
                String opcao = null;
                System.out.println("Menu de Administrador:");
                System.out.println("1 - Tabela Cliente");
                System.out.println("2 - Tabela Produto");
                System.out.println("3 - Tabela Endereco");
                System.out.println("4 - Tabela Falecido");
                System.out.println("5 - Tabela Agendamento");
                System.out.println("6 - Tabela Funcionario");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextLine();
                switch (opcao) {
                    case "1":
                        submenuCliente(scanner);
                        break;
                    case "2":
                        submenuProduto(scanner);
                        break;
                    case "3":
                        submenuEndereco(scanner);
                        break;
                    case "4":
                        submenuFalecido(scanner);
                        break;
                    case "5":
                        submenuAgendamento(scanner);
                        break;
                    case "6":
                        submenuFuncionario(scanner);
                        break;
                    case "0":
                        sairMenu = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        System.out.println("Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                }
            } else if ("Funcionario".equals(perfil)) {
                System.out.println("Menu de Funcionário:");
                System.out.println("1 - Tabela Cliente");
                System.out.println("2 - Tabela Produto");
                System.out.println("3 - Tabela Endereco");
                System.out.println("4 - Tabela Falecido");
                System.out.println("5 - Tabela Agendamento");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                String opcao = scanner.nextLine();
                switch (opcao) {
                    case "1":
                        submenuCliente(scanner);
                        break;
                    case "2":
                        submenuProduto(scanner);
                        break;
                    case "3":
                        submenuEndereco(scanner);
                        break;
                    case "4":
                        submenuFalecido(scanner);
                        break;
                    case "5":
                        submenuAgendamento(scanner);
                        break;
                    case "0":
                        sairMenu = true;
                        break;
                    case "6":
                        System.out.println("Acesso negado à tabela de Funcionário!");
                        System.out.println("Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        System.out.println("Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                }
            }
        }
        scanner.close();
    }

    // Submenus CRUD para cada tabela
    private static void submenuCliente(Scanner scanner) {
        dao.ClienteDAO dao = new dao.ClienteDAO();
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- CRUD Cliente ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("CEP: ");
                        String cep = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String tel = scanner.nextLine();
                        dao.inserir(new model.Cliente(nome, cpf, cep, tel));
                        System.out.println("Cliente inserido!");
                        voltar = true;
                        break;
                    case "2":
                        System.out.print("CodCliente a atualizar: ");
                        int codCliente = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Novo CPF: ");
                        cpf = scanner.nextLine();
                        System.out.print("Novo CEP: ");
                        cep = scanner.nextLine();
                        System.out.print("Novo Telefone: ");
                        tel = scanner.nextLine();
                        model.Cliente clienteAtualizar = new model.Cliente(nome, cpf, cep, tel);
                        clienteAtualizar.setCodCliente(codCliente);
                        dao.atualizar(clienteAtualizar);
                        System.out.println("Cliente atualizado!");
                        break;
                    case "3":
                        System.out.print("CodCliente a remover: ");
                        int cod = Integer.parseInt(scanner.nextLine());
                        dao.remover(cod);
                        System.out.println("Cliente removido!");
                        break;
                    case "4":
                        System.out.println("Lista de clientes:");
                        for (model.Cliente c : dao.listar()) {
                            System.out.println("Cod: " + c.getCodCliente() + ", Nome: " + c.getNome() + ", CPF: " + c.getCpf() + ", CEP: " + c.getCep() + ", Tel: " + c.getTelefone());
                        }
                        break;
                    case "0":
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            if (!voltar) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
                voltar = true;
            }
        }
    }

    private static void submenuProduto(Scanner scanner) {
        dao.ProdutoDAO dao = new dao.ProdutoDAO();
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- CRUD Produto ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        System.out.print("CodProduto: ");
                        int cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        dao.inserir(new model.Produto(cod, nome, preco));
                        System.out.println("Produto inserido!");
                        break;
                    case "2":
                        System.out.print("CodProduto a atualizar: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Novo preço: ");
                        preco = Double.parseDouble(scanner.nextLine());
                        dao.atualizar(new model.Produto(cod, nome, preco));
                        System.out.println("Produto atualizado!");
                        break;
                    case "3":
                        System.out.print("CodProduto a remover: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        dao.remover(cod);
                        System.out.println("Produto removido!");
                        break;
                    case "4":
                        System.out.println("Lista de produtos:");
                        for (model.Produto p : dao.listar()) {
                            System.out.println("Cod: " + p.getCodProduto() + ", Nome: " + p.getNome() + ", Preço: " + p.getPreco());
                        }
                        break;
                    case "0":
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            if (!voltar) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void submenuEndereco(Scanner scanner) {
        dao.EnderecoDAO dao = new dao.EnderecoDAO();
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- CRUD Endereco ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        System.out.print("CEP: ");
                        String cep = scanner.nextLine();
                        System.out.print("Bairro: ");
                        String bairro = scanner.nextLine();
                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();
                        System.out.print("Rua: ");
                        String rua = scanner.nextLine();
                        System.out.print("Número: ");
                        String numero = scanner.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();
                        dao.inserir(new model.Endereco(bairro, estado, cep, rua, numero, cidade));
                        System.out.println("Endereço inserido!");
                        break;
                    case "2":
                        System.out.print("CEP do endereço a atualizar: ");
                        cep = scanner.nextLine();
                        System.out.print("Novo bairro: ");
                        bairro = scanner.nextLine();
                        System.out.print("Novo estado: ");
                        estado = scanner.nextLine();
                        System.out.print("Nova rua: ");
                        rua = scanner.nextLine();
                        System.out.print("Novo número: ");
                        numero = scanner.nextLine();
                        System.out.print("Nova cidade: ");
                        cidade = scanner.nextLine();
                        dao.atualizar(new model.Endereco(bairro, estado, cep, rua, numero, cidade));
                        System.out.println("Endereço atualizado!");
                        break;
                    case "3":
                        System.out.print("CEP do endereço a remover: ");
                        cep = scanner.nextLine();
                        dao.remover(cep);
                        System.out.println("Endereço removido!");
                        break;
                    case "4":
                        System.out.println("Lista de endereços:");
                        for (model.Endereco e : dao.listar()) {
                            System.out.println("CEP: " + e.getCep() + ", Bairro: " + e.getBairro() + ", Estado: " + e.getEstado() + ", Rua: " + e.getRua() + ", Número: " + e.getNumero() + ", Cidade: " + e.getCidade());
                        }
                        break;
                    case "0":
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            if (!voltar) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void submenuFalecido(Scanner scanner) {
        dao.FalecidoDAO dao = new dao.FalecidoDAO();
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- CRUD Falecido ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        System.out.print("CodFalecido: ");
                        int cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Data Falecimento (yyyy-mm-dd): ");
                        java.sql.Date data = java.sql.Date.valueOf(scanner.nextLine());
                        System.out.print("CodCliente: ");
                        int codCliente = Integer.parseInt(scanner.nextLine());
                        dao.inserir(new model.Falecido(cod, nome, data, codCliente));
                        System.out.println("Falecido inserido!");
                        break;
                    case "2":
                        System.out.print("CodFalecido a atualizar: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Nova data (yyyy-mm-dd): ");
                        data = java.sql.Date.valueOf(scanner.nextLine());
                        System.out.print("Novo CodCliente: ");
                        codCliente = Integer.parseInt(scanner.nextLine());
                        dao.atualizar(new model.Falecido(cod, nome, data, codCliente));
                        System.out.println("Falecido atualizado!");
                        break;
                    case "3":
                        System.out.print("CodFalecido a remover: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        dao.remover(cod);
                        System.out.println("Falecido removido!");
                        break;
                    case "4":
                        System.out.println("Lista de falecidos:");
                        for (model.Falecido f : dao.listar()) {
                            System.out.println("Cod: " + f.getCodFalecido() + ", Nome: " + f.getNome() + ", Data: " + f.getDataFalecimento() + ", CodCliente: " + f.getCodCliente());
                        }
                        break;
                    case "0":
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            if (!voltar) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void submenuAgendamento(Scanner scanner) {
        dao.AgendamentoDAO dao = new dao.AgendamentoDAO();
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- CRUD Agendamento ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        System.out.print("CodAgendamento: ");
                        int cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Data (yyyy-mm-dd): ");
                        java.sql.Date data = java.sql.Date.valueOf(scanner.nextLine());
                        System.out.print("Hora (apenas número): ");
                        int hora = Integer.parseInt(scanner.nextLine());
                        System.out.print("CodFuncionario: ");
                        int codFunc = Integer.parseInt(scanner.nextLine());
                        dao.inserir(new model.Agendamento(cod, data, hora, codFunc));
                        System.out.println("Agendamento inserido!");
                        break;
                    case "2":
                        System.out.print("CodAgendamento a atualizar: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nova data (yyyy-mm-dd): ");
                        data = java.sql.Date.valueOf(scanner.nextLine());
                        System.out.print("Nova hora: ");
                        hora = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo CodFuncionario: ");
                        codFunc = Integer.parseInt(scanner.nextLine());
                        dao.atualizar(new model.Agendamento(cod, data, hora, codFunc));
                        System.out.println("Agendamento atualizado!");
                        break;
                    case "3":
                        System.out.print("CodAgendamento a remover: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        dao.remover(cod);
                        System.out.println("Agendamento removido!");
                        break;
                    case "4":
                        System.out.println("Lista de agendamentos:");
                        for (model.Agendamento a : dao.listar()) {
                            System.out.println("Cod: " + a.getCodAgendamento() + ", Data: " + a.getDataAgendamento() + ", Hora: " + a.getHora() + ", CodFuncionario: " + a.getCodFuncionario());
                        }
                        break;
                    case "0":
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            if (!voltar) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void submenuFuncionario(Scanner scanner) {
        dao.FuncionarioDAO dao = new dao.FuncionarioDAO();
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- CRUD Funcionario ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        System.out.print("CodFuncionario: ");
                        int cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        dao.inserir(new model.Funcionario(cod, nome));
                        System.out.println("Funcionário inserido!");
                        break;
                    case "2":
                        System.out.print("CodFuncionario a atualizar: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo nome: ");
                        nome = scanner.nextLine();
                        dao.atualizar(new model.Funcionario(cod, nome));
                        System.out.println("Funcionário atualizado!");
                        break;
                    case "3":
                        System.out.print("CodFuncionario a remover: ");
                        cod = Integer.parseInt(scanner.nextLine());
                        dao.remover(cod);
                        System.out.println("Funcionário removido!");
                        break;
                    case "4":
                        System.out.println("Lista de funcionários:");
                        for (model.Funcionario f : dao.listar()) {
                            System.out.println("Cod: " + f.getCodFuncionario() + ", Nome: " + f.getNome());
                        }
                        break;
                    case "0":
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            if (!voltar) {
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void limparTerminal() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Ignora se não conseguir limpar
        }
    }
}
