package com.samiu.host.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samiu.host.model.bean.Article
import com.samiu.host.model.http.WanResult
import com.samiu.host.model.repository.WanSystemRepository
import kotlinx.coroutines.launch

/**
 * @author Samiu 2020/3/6
 */
class SystemDisplayViewModel(
    private val systemRepository: WanSystemRepository
) : ViewModel() {

    val mSystemArticles = MutableLiveData<List<Article>>()

    fun getSystemArticles(page: Int, cid: Int) = viewModelScope.launch {
        val data = systemRepository.getSystemDetail(page, cid)
        if (data is WanResult.Success) {
            mSystemArticles.value = data.data.datas
        }
    }
}