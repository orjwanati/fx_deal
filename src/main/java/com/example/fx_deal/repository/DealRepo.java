package com.example.fx_deal.repository;
import com.example.fx_deal.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DealRepo extends JpaRepository<Deal, Long> {
    boolean existsByDealUniqueId(String id);
    Deal findDealByDealUniqueId(String id);

}

