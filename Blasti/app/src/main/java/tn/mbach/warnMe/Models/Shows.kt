package tn.mbach.warnMe.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Shows {
    @SerializedName("_id")
    @Expose
    internal val id: String? = null

    @SerializedName("title")
    @Expose
    internal val title: String? = null

    @SerializedName("date")
    @Expose
    internal val date: String? = null

    @SerializedName("genre")
    @Expose
    internal val genre: String? = null

    @SerializedName("description")
    @Expose
    internal val description: String? = null

    @SerializedName("image")
    @Expose
    internal val image: String? = null

    @SerializedName("place")
    @Expose
    internal val place: String? = null

    @SerializedName("actors")
    @Expose
    internal val actor: String? = null

    @SerializedName("message")
    @Expose
    val message : String = ""
}