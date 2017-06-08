package br.com.jc.agendaws.models.DTO;



public class UsuarioLogadoDTO {
    
    private String nome;
    private String username;
//    private Token token;

    public UsuarioLogadoDTO(String nome, String username) {
        this.nome = nome;
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
