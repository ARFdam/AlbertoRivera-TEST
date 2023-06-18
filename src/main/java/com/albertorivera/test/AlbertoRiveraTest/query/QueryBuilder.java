package com.albertorivera.test.AlbertoRiveraTest.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.albertorivera.test.AlbertoRiveraTest.entity.Cliente;
import com.albertorivera.test.AlbertoRiveraTest.entity.Proveedor;

@Component
public class QueryBuilder {

	@Autowired
	private EntityManager entityManager;
	
	public List<Proveedor> buscarProveedoresPorCodigoCliente(String codigoCliente) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Proveedor> query = cb.createQuery(Proveedor.class);
	    Root<Proveedor> root = query.from(Proveedor.class);

	    Join<Proveedor, Cliente> clienteJoin = root.join("cliente");
	    Predicate predicate = cb.equal(clienteJoin.get("codigo"), codigoCliente);

	    query.select(root).where(predicate);

	    return entityManager.createQuery(query).getResultList();
	}
}
