package org.mathsena.eventsapi.repositories;

import org.mathsena.eventsapi.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {}
