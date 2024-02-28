package br.com.projeto.fenoSell.feno;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFenoRepository extends JpaRepository<FenoModel, UUID> {
    List<FenoModel> findByIdUser (UUID idUser);
}
