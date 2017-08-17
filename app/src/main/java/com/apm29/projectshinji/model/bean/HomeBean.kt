package com.apm29.projectshinji.model.bean

import com.google.gson.annotations.SerializedName


/**
 * Created by apm29 on 2017/8/15.
 */
data class HomeBean(@SerializedName("ads")val ads: Array<AdBean>?, @SerializedName("isAdON")val isAdON: Int,@SerializedName("recommendWTB") val recommendWTB: Array<WTBBean>?){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
    data class AdBean(val id: Int, val imgUrl: String, val linkType: Int, val linkURL: String, val title: String)
    data class WTBBean(val id: Int, val arrival_place: String, val branch: String, val craft: String, val isExpired: Int, val modified_time: String, val name: String, val status: Int, val weight: String)
}

