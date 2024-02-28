package br.com.projeto.fenoSell.venda;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  IVendaRepository extends JpaRepository<VendaModel, UUID>{
    VendaModel findByComprador(String username);

    VendaModel findById(String username);

}
