package kz.flicktest.network.model

data class Photos(val page:Int, val pages: Int, val perpage: Int, val total: Int, val photo: List<Photo>)