package com.unknown.deliveryserver.domain.menu.option.dao;

import com.unknown.deliveryserver.domain.menu.option.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}