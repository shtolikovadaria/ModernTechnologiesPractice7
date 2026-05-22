@echo off
REM Переносимый запуск Maven для этого учебного репозитория.
REM Использует установленный Maven, если он доступен; иначе скачивает Apache Maven в .mvn\.

setlocal EnableExtensions EnableDelayedExpansion
set "MAVEN_VERSION=3.9.9"
set "BASE_DIR=%~dp0"
set "MAVEN_HOME=%BASE_DIR%.mvn\apache-maven-%MAVEN_VERSION%"
set "MVN_CMD=%MAVEN_HOME%\bin\mvn.cmd"

where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    mvn %*
    exit /b %ERRORLEVEL%
)

if not exist "%MVN_CMD%" (
    echo Maven не найден в PATH. Скачивание Apache Maven %MAVEN_VERSION% в .mvn\...
    powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; $dir='%BASE_DIR%.mvn'; $zip=Join-Path $dir 'apache-maven-%MAVEN_VERSION%-bin.zip'; New-Item -ItemType Directory -Force -Path $dir | Out-Null; Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/%MAVEN_VERSION%/binaries/apache-maven-%MAVEN_VERSION%-bin.zip' -OutFile $zip; Expand-Archive -Path $zip -DestinationPath $dir -Force"
    if %ERRORLEVEL% NEQ 0 (
        echo ОШИБКА: не удалось автоматически скачать Maven.
        echo Установите Maven вручную с https://maven.apache.org/download.cgi и выполните: mvn clean test
        exit /b 1
    )
)

call "%MVN_CMD%" %*
exit /b %ERRORLEVEL%
