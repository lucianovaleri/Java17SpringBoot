package br.com.projeto.fenoSell.feno;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "TB_FENO")
public class FenoModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String descricao;
    
    @Column(length = 50)
    private String titulo;
    private LocalDateTime dataCorte;
    private Long preço;
    private String local;
    private String telefone;
    private String email;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O campo titulo deve conter até 50 caracteres");
        }
        this.titulo = title;
    }
    
}
