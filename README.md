## Задача №1. Посты
### Что нужно получить:
- Data-класс Post (и другие классы, которые могут быть вложены в Post).
- Объект WallService, который хранит посты в массиве.

## Задача №2. Wall
- fun add(post: Post): Post
- fun update(post: Post): Boolean

## Задача №3. Wall Tests
Следующая задача – написать автотесты на ваши методы:

1) на add – всего один, который проверяет, что после добавления поста id стал отличным от 0.
2) на update – целых два:
- изменяем пост с существующим id, возвращается true;
- изменяем пост с несуществующим id, возвращается false.
    
