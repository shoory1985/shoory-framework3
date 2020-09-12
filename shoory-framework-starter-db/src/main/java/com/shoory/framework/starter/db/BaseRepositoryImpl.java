package com.shoory.framework.starter.db;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
	}

	@Override
	public <S extends T> S save(S entity) {
		if (entity instanceof Insertable) {
			((Insertable) entity).setCreatedTime(System.currentTimeMillis());
		}
		if (entity instanceof Updatable) {
			((Updatable) entity).setUpdatedTime(System.currentTimeMillis());
		}
		return super.save(entity);
	}
	
	@Override
	public void delete(T entity) {
		if (entity instanceof Deletable) {
			((Deletable) entity).setDeletedTime(System.currentTimeMillis());
			super.save(entity);
		} else {
			super.delete(entity);
		}
	}
	
	@Override
	public Optional<T> findById(ID id) {
		return super.findById(id)
				.filter(entity -> !(entity instanceof Deletable && ((Deletable) entity).getDeletedTime() > 0));
	}
}