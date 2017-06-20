package br.com.jc.agendaws.models.DTO;



public class UsuarioLogadoDTO {
    
    private String nome;
    private String foto;
    private String profissao;

    public UsuarioLogadoDTO(String nome, String foto, String profissao) {
        this.nome = nome;
        this.foto = foto;
        this.profissao = profissao;
    }

    public UsuarioLogadoDTO(String nome, String profissao) {
        this.nome = nome;
        this.profissao = profissao;
    }
    
    public UsuarioLogadoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
