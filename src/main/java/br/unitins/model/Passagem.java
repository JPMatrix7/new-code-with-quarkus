package br.unitins.model;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

    @Entity
    public class Passagem extends PanacheEntity{
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
