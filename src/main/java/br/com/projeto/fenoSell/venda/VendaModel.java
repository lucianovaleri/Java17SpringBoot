package br.com.projeto.fenoSell.venda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.projeto.fenoSell.feno.FenoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="TB_SELLS")
public class VendaModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column
    private FenoModel feno;
    private Long quantidade;
    private Long valores;
    private LocalDate dataHoraVenda;

    private UUID vendedor;
    private UUID comprador;
    
    @CreationTimestamp
    private LocalDateTime createAt;
}
