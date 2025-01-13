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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public FenoModel getFeno() {
		return feno;
	}

	public void setFeno(FenoModel feno) {
		this.feno = feno;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getValores() {
		return valores;
	}

	public void setValores(Long valores) {
		this.valores = valores;
	}

	public LocalDate getDataHoraVenda() {
		return dataHoraVenda;
	}

	public void setDataHoraVenda(LocalDate dataHoraVenda) {
		this.dataHoraVenda = dataHoraVenda;
	}

	public UUID getVendedor() {
		return vendedor;
	}

	public void setVendedor(UUID vendedor) {
		this.vendedor = vendedor;
	}

	public UUID getComprador() {
		return comprador;
	}

	public void setComprador(UUID comprador) {
		this.comprador = comprador;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
    
}
