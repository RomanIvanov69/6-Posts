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
    val copyright: String? = null, // источник материала
    val replyOwnerId: Int, // Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int, // Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean, // 1, если запись была создана с опцией «Только для друзей»
    val isPinned: Boolean, // Информация о том, что запись закреплена
    val markedAsAds: Boolean, // Информация о том, содержит ли запись отметку «реклама» (1 — да, 0 — нет)
    val isFavorite: Boolean, // true, если объект добавлен в закладки у текущего пользователя
    val postponedId: Int?, // Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере
    val likes: Likes? = null, // информация о лайках к записи
    val comments: Comments? = null, // информация о комментариях к записи
    val reposts: Reposts? = null, // информация о репостах к записи
    val views: Views? = null, // информация о просмотрах записи
    val geo: Geo? = null, // местоположение
    val attachment: Attachment? // вложения
)

class Comments(
    val count: Int, // кол-во комментариев
    val canPost: Boolean, //
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

class Likes(
    var count: Int, // число пользователей, которым понравилась запись
    val userLikes: Boolean, // наличие отметки «Мне нравится» от текущего пользователя
    val canLike: Boolean, // информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean, // информация о том, может ли текущий пользователь сделать репост записи
) {
    override fun toString(): String {
        return "\nЧисло пользователей - $count " + ", наличие отметки \"Мне нравится\" - $userLikes" +
                "\nИнформация о том, может ли текущий пользователь поставить отметку \"Мне нравится\" - $canLike" +
                "\nИнформация о том, может ли текущий пользователь сделать репост записи - $canPublish" + "\n"
    }
}
class Reposts(
    val count: Int,
    val userReposted: Boolean
)

class Views(
    val count: Int
)

class Geo(
    val type: String? = null,
    val coordinates: String? = null,
    val place: Place? = null,
)

class Place(
    val id: Int? = null,
    val title: String? = null,
    val address: String? = null
)
class Comment(
    val id: Int, // Идентификатор комментария.
    val fromId: Int, // Идентификатор автора комментария.
    val date: Int, // Дата создания комментария в формате Unixtime.
    val text: String, // Текст комментария.
    val donut: Donut?, // Информация о VK Donut. Объект со следующими полями:
    val replyToUser: Int, // Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val replyToComment: Int, // Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments: Attachment?, // Медиавложения комментария (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
    val parents_stack: Array<Int>?, // Массив идентификаторов родительских комментариев.
    val threadComments: Thread?, // Информация о вложенной ветке комментариев, объект с полями:
)
class Thread(
    val count: Int, // количество комментариев в ветке.
    val items: Array<String>, // массив объектов комментариев к записи (только для метода wall.getComments).
    val canPost: Boolean, // может ли текущий пользователь оставлять комментарии в этой ветке.
    val showReplyButton: Boolean, // нужно ли отображать кнопку «ответить» в ветке.
    val groupsCanPost: Boolean // могут ли сообщества оставлять комментарии в ветке.
)
data class Donut(
    val isDonut: Boolean, // запись доступна только платным подписчикам VK Donut;
    val paidDuration: Int, // время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder: String, // Заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
    val canPublishFreeCopy: Boolean, // можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val editMode: String // Информация о том, какие значения VK Donut можно изменить в записи.
)






