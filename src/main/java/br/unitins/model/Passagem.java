package br.unitins.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

    @Entity //declara que a classe é uma tabela, quem cria a tabela no bando de dados é o JPA
    public class Passagem extends PanacheEntity{ //Classes extendidas do PanacheEntity recebem os métodos de acesso por padrão, sem get e set (mas pode sobreescrever e criar o mesmos).
        
        @Column(length = 80) //serve somete para CRIAR meu banco de dados com a especificação setada, não funciona como validação.
        private String nome;
        private String destinoFinal;
        private String origem;
        
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getDestinoFinal() {
            return destinoFinal;
        }
        public void setDestinoFinal(String destinoFinal) {
            this.destinoFinal = destinoFinal;
        }
        public String getOrigem() {
            return origem;
        }
        public void setOrigem(String origem) {
            this.origem = origem;
        }
                
    }
