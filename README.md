# Java-Servlet-REST

- GET     /rest/tag - список тэгов
- POST  /rest/tag?name={name}&mnemonis={mnemonics} - создание тэга
- PUT    /rest/tag/{name}?name={name}&mnemonis={mnemonics} - обновление тэга name. Например /rest/tag/list - обновление тэrа list
- DELETE /rest/tag/{name} - удаление тэга name
- GET   /rest/tag/{name} - получение информации о тэге name
- GET   /rest/tag/search?mnemonics={mnemonics} - поиск тегов по мнемонике
