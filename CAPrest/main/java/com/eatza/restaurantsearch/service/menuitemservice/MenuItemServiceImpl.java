package com.eatza.restaurantsearch.service.menuitemservice;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eatza.restaurantsearch.dto.ItemRequestDto;
import com.eatza.restaurantsearch.exception.MenuNotSavedException;
import com.eatza.restaurantsearch.model.Menu;
import com.eatza.restaurantsearch.model.MenuItem;
import com.eatza.restaurantsearch.repository.MenuItemRepository;
import com.eatza.restaurantsearch.service.menuservice.MenuService;


@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuItemServiceImpl.class);

	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private MenuService menuService;



	@Override
	public MenuItem saveMenuItem(ItemRequestDto itemDto) {
		logger.debug("In save menu Item method, calling repo");

		Optional<Menu> menu =  menuService.getMenuById(itemDto.getMenuId());
		if(menu.isPresent()) {
			logger.debug("Found correponding menu, saving menu item");
		MenuItem menuItem = new MenuItem(itemDto.getName(), itemDto.getDescription(), itemDto.getPrice(), menu.get());
		return menuItemRepository.save(menuItem);
		}
		else {
			logger.debug("Crreponding menu not found");
			throw new MenuNotSavedException("Menu not saved, something went wrong");
		}
	}



	@Override
	@Cacheable(value="menuitems")
	public Optional<MenuItem> findById(Long id) {
		return menuItemRepository.findById(id);
	}

	@Override
	@Cacheable(value="menuitemsbymenuid")
	public Page<MenuItem> findByMenuId(Long id, Pageable pageable) {
		logger.debug("In findByMenuId, calling repository");
		return menuItemRepository.findByMenu_id(id, pageable);
	}

}
