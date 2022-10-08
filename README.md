## Market - Приложение демонстрации решения Spring Cloud

### Установка приложения
1. Установить docker 
2. Установить git 
3. Склонировать репозиторий 
4. Выполнить в корне репозитория команду _docker-compose up_

### Запуск приложения
1. Фронтальная часть: http://localhost
2. API Gateway: http://localhost:8080/
   * Сервис продукты: /api/product 

### Авторизация
Для целей тестирования созданы пользователи
1. Администратор:
   * логин:a
   * пароль:a
   * jwt:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhIiwiUk9MRSI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NjI5OTYwMH0.qzCCmNZGJrZRXQMOpzh-erfShFEl1cqn8MfVOm_HkrfcL5fMKTprCRo1oHKUAd3UD0EddBf4SCyIjwS5h4F1Ow
2. Пользователь:
   * логин:u
   * пароль:u
   * jwt:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1IiwiUk9MRSI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NjI5OTYwMH0.5ELSPJEuWy_khOYj8urMFHOUSy_UqAnm-tU_j4I-3RUzLVX-3zilvqwmAZzZQK8Ow-czec10Lg9Lg1tdCtMjXA

### Подключение к админке базы данных
1. Ввести адрес http://localhost:8760
2. Указать параметры:
   * движок: PostgeSQL
   * сервер: db 
   * имя пользователя: postgres
   * пароль: 1987
   * база данных: 
      * product
      * market

### Ресурсы для локальной разработки
* База данных: http://localhost:5432
* API Gateway: http://localhost:8080
* Discovery server: http://localhost:8761/eureka/

### Полезные команды для работы с docker образами
* остановка всех контейнеров _docker stop $(docker ps -q)_
* удаление всех контейнеров _docker rm $(docker ps -aq)_
* увдление всех образов _docker rmi $(docker images -q)_