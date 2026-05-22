# Запуск в Windows PowerShell

Откройте терминал в корне проекта — в папке, где находятся `pom.xml` и `mvnw.cmd`.

Проверьте текущую папку:

```powershell
dir pom.xml, mvnw.cmd
```

Запустите тесты:

```powershell
.\mvnw.cmd clean test
```

Запустите приложение:

```powershell
.\mvnw.cmd spring-boot:run
```

Затем откройте:

```text
http://localhost:8080/students
```

Логины:

```text
admin / password
user / password
```

Если `mvnw.cmd` не смог скачать Maven автоматически, установите Maven вручную:

```text
https://maven.apache.org/download.cgi
```

После установки Maven можно запускать:

```powershell
mvn clean test
mvn spring-boot:run
```
