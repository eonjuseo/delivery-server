package com.unknown.deliveryserver.domain.menu.menu.dao;

import com.unknown.deliveryserver.domain.menu.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
