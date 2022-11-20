interface Attachment {
    val type: String
}

class Video(
    val id: Int, // Идентификатор видеозаписи
    val ownerId: Int, // Идентификатор владельца видеозаписи
    val title: String, // Название видеозаписи
    val description: String, // Текст описания видеозаписи
    val duration: Int, // Длительность ролика в секундах
    val date: Int, // Дата создания видеозаписи в формате Unixtime
    val addingDate: Int, // Дата добавления видеозаписи пользователем или группой в формате Unixtime
    val views: Int, // Количество просмотров видеозаписи
    val localViews: Int, // Если видео внешнее, количество просмотров в ВК
    val comments: Int, // Количество комментариев к видеозаписи
    val player: String, // URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере
    val platform: String, // Название платформы (для видеозаписей, добавленных с внешних сайтов)
    val canAdd: Boolean, // Может ли пользователь добавить видеозапись к себе. 0 — Не может добавить. 1 — Может добавить
    val isPrivate: Boolean, // Поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1
    val accessKey: String, // Ключ доступа к данным access_key
    val processing: Boolean, // Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1
    val isFavorite: Boolean, // Если объект добавлен в закладки у текущего пользователя
    val canComment: Boolean, // Может ли пользователь комментировать видео. 0 — Не может комментировать. 1 — Может комментировать.
    val canEdit: Boolean, // Может ли пользователь редактировать видео. 0 — Не может редактировать. 1 — Может редактировать.
    val canLike: Boolean, // Может ли пользователь добавить видео в список <<Мне нравится>>. 0 — Не может добавить. 1 — Может добавить.
    val canRepost: Boolean, // Может ли пользователь сделать репост видео. 0 — Не может сделать репост. 1 — Может сделать репост.
    val canSubscribe: Boolean, // Может ли пользователь подписаться на автора видео. 0 — Не может подписаться. 1 — Может подписаться.
    val canAddToFaves: Boolean, // Может ли пользователь добавить видео в избранное. 0 — Не может добавить. 1 — Может добавить.
    val canAttachLink: Boolean, // Может ли пользователь прикрепить кнопку действия к видео. 0 — Не может прикрепить. 1 — Может прикрепить.
    val width: Int, // Ширина видео.
    val height: Int, // Высота видео.
    val userId: Int, // идентификатор пользователя, загрузившего видео, если оно было загружено в группу одним из участников.
    val converting: Boolean, // Конвертируется ли видео. 0 — Не конвертируется. 1 — Конвертируется.
    val added: Boolean, // Добавлено ли видео в альбомы пользователя. 0 — Не добавлено. 1 — Добавлено.
    val isSubscribed: Boolean, // Подписан ли пользователь на автора видео. 0 — Не подписан. 1 — Подписан.
    val repeat: Boolean, // поле возвращается в том случае, если видео зациклено, всегда содержит 1
    val type: String, // Тип видеозаписи. Может принимать значения: "video", "music_video", "movie".
    val balance: Int, // Баланс Донатов в прямой трансляции.
    val liveStatus: String, // Статус прямой трансляции. Может принимать значения: "waiting", "started", "finished", "failed", "upcoming".
    val live: Boolean, // Поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1. Обратите внимание, в этом случае в поле duration содержится значение 0.
    val upcoming: Int, // Поле свидетельствует о том, что трансляция скоро начнётся.
    val spectators: Int, // Количество зрителей прямой трансляции.
    val likes: Likes, // Содержит объект отметки <<Мне нравится>>.
    val reposts: Reposts // Содержит объект репоста.
)

class VideoAttachment(
    val video: Video
) : Attachment {
    override val type: String = "video"
}

class Audio(
    val id: Int, // Идентификатор аудиозаписи.
    val ownerId: Int, // Идентификатор владельца аудиозаписи.
    val artist: String, // Исполнитель.
    val title: String, // Название композиции.
    val duration: Int, // Длительность аудиозаписи в секундах.
    val url: String, // Ссылка на mp3.
    val lyricsId: Int, // Идентификатор текста аудиозаписи (если доступно).
    val albumId: Int, // Идентификатор альбома, в котором находится аудиозапись (если присвоен).
    val genreId: Int, // Идентификатор жанра из списка аудио жанров.
    val date: Int, // Дата добавления.
    val noSearch: Boolean, // Если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается.
    val isHq: Boolean // Если аудио в высоком качестве
)

class AudioAttachment(
    val audio: Audio
) : Attachment {
    override val type: String = "audio"
}

class Photo(
    val id: Int, // Идентификатор фотографии.
    val albumId: Int, // Идентификатор альбома, в котором находится фотография.
    val ownerId: Int, // Идентификатор владельца фотографии.
    val userId: Int, // Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе). Для фотографий, размещенных от имени сообщества, user_id = 100.
    val text: String, // Текст описания фотографии.
    val date: Int, // Дата добавления в формате Unixtime.
    val sizesOfPhoto: SizesOfPhoto, // Массив с копиями изображения в разных размерах. Каждый объект массива содержит следующие поля:
    val width: Int, // Ширина оригинала фотографии в пикселах.
    val height: Int // Высота оригинала фотографии в пикселах
)

class SizesOfPhoto(
    val type: String, // Формат описания размеров фотографии.
    val url: String, // URL копии.
    val width: Int, // высота в px.
    val height: Int // ширина в px.
)

data class PhotoAttachment(
    val photo: Photo
) : Attachment {
    override val type: String = "photo"
}

class Note(
    val id: Int, // Идентификатор заметки.
    val ownerId: Int, // Идентификатор владельца заметки.
    val title: String, // Заголовок заметки.
    val text: String, // Текст заметки.
    val date: Int, // Дата создания заметки в формате Unixtime.
    val comments: Int, // Количество комментариев.
    val readComments: Int, // Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
    val viewUrl: String, // URL страницы для отображения заметки.
    val privacyView: String, // Настройки приватности просмотра заметки
    val privacyComment: String, // Настройки приватности комментирования заметки
    val canComment: Boolean, // Есть ли возможность оставлять комментарии
    val textWiki: String // Тэги ссылок на wiki
)

class NoteAttachment(
    val note: Note
) : Attachment {
    override val type: String = "note"
}

class Sticker(
    val productId: Int, // Идентификатор набора.
    val stickerId: Int, // Идентификатор стикера.
    val animationUrl: String, // URL анимации стикер
    val isAllowed: Boolean, // Информация о том, доступен ли стикер
    val Images: Images // Изображения для стикера
)

class Images(
    val url: String, // URL копии изображения
    val width: Int, // ширина копии в px
    val height: Int // высота копии в px
)

class StickerAttachment(
    val sticker: Sticker
) : Attachment {
    override val type: String = "sticker"
}


