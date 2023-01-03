package tn.mbach.warnMe.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Events {
    @SerializedName("_id")
    @Expose
    internal val id: String? = null

    @SerializedName("title")
    @Expose
    internal val title: String? = null

    @SerializedName("adress")
    @Expose
    internal val adress: String? = null

    @SerializedName("type")
    @Expose
    internal val genre: String? = null

    @SerializedName("cost")
    @Expose
    internal val cost: String? = null

    @SerializedName("description")
    @Expose
    internal val description: String? = null

    @SerializedName("date")
    @Expose
    internal val date: String? = null

    @SerializedName("guest")
    @Expose
    internal val guest: String? = null

    @SerializedName("pAvailable")
    @Expose
    internal val pAvailable: String? = null

    @SerializedName("image")
    @Expose
    internal val image: String? = null

    @SerializedName("message")
    @Expose
    val message : String = ""

}