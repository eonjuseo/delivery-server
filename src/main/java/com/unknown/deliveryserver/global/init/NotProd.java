package com.unknown.deliveryserver.global.init;

import com.unknown.deliveryserver.domain.order.order.dao.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Profile("!prod")
@RequiredArgsConstructor
@Configuration
public class NotProd {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final OrderRepository orderRepository;

    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            if (orderRepository.existsById(1L)) {
                System.out.println("Data already exists in the database, skipping insertion.");
                return;
            }
            try {
                jdbcTemplate.execute("CALL InsertOrderData();");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                System.out.println("Data initialized in database at " + now.format(formatter));
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}