package com.shoory.framework.starter.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
	<S extends T> S save(S entity);
}
