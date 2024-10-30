package com.partiutech.apichatbot.whatsapp.repository;

import com.partiutech.apichatbot.whatsapp.dto.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemDTO, Long> {

}
