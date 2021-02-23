package com.efhem.binlist.remote.mapper.base

interface RemoteModelMapper<in E, out D> {

    fun mapFromModel(model: E): D

    fun mapFromModelList(models: List<E>): List<D> {
        val list = mutableListOf<D>()
        models.forEach {
            list.add(mapFromModel(it))
        }
        return list
    }
}