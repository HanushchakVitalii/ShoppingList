package com.aureliano_vitalii.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aureliano_vitalii.shoppinglist.data.ShopListRepositoryImpl
import com.aureliano_vitalii.shoppinglist.domain.DeleteShopItemUseCase
import com.aureliano_vitalii.shoppinglist.domain.EditShopItemUseCase
import com.aureliano_vitalii.shoppinglist.domain.GetShopListUseCase
import com.aureliano_vitalii.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeShopItem(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }



}