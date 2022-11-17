import Likes

data class Post(
    var id: Int, // идентификатор записи
    var ownerId: Int, // идентификатор владельца стены
    var fromId: Int? = null, // идентификатор автора записи (от чьего имени опубликована запись)
    var createdBy: Int? = null, // идентификатор администратора, который опубликовал запись
    var date: Int? = null, // время публикации записи
    val text: String? = null, // текст записи
    val postType: String? = null, // тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
    val canPin: Boolean? = null, // информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может)
    val canDelete: Boolean? = null, // информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean? = null, // информация о том, может ли текущий пользователь редактировать запись
    val likes: Likes? = null // информация о лайках к записи
)


