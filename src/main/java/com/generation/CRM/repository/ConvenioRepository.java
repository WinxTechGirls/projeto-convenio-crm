package com.generation.CRM.repository;

import java.math.BigDecimal;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.CRM.model.Convenio;



public interface ConvenioRepository extends JpaRepository<Convenio, Long> {

	public List<Convenio> findAllByPrecoLessThanEqual(@Param("preco") BigDecimal preco);
	public List <Convenio> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
