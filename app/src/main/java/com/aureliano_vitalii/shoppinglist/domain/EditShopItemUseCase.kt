package com.aureliano_vitalii.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository:ShopListRepository) {

    fun editShopItem(shopItem:ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}