package tn.cni.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.demo.model.TypeFrais;

public interface TypeFraisRepo extends JpaRepository<TypeFrais, Integer> {


	List<TypeFrais> findByOrderByIdDescCodeAsc() throws Exception;

	TypeFrais findByCode(String code) throws Exception;

}
