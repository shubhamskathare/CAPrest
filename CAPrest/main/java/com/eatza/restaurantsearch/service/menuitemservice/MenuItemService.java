package com.eatza.restaurantsearch.service.menuitemservice;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eatza.restaurantsearch.dto.ItemRequestDto;
import com.eatza.restaurantsearch.model.MenuItem;



public interface MenuItemService {
	
	MenuItem saveMenuItem(ItemRequestDto itemDto);
	Optional<MenuItem> findById(Long id);
	Page<MenuItem> findByMenuId(Long id , Pageable pageable);

}
