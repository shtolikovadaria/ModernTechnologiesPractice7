#!/usr/bin/env sh
# Переносимый запуск Maven для этого учебного репозитория.
# Использует установленный Maven, если он доступен; иначе скачивает Apache Maven в .mvn/.

set -eu

MAVEN_VERSION="3.9.9"
BASE_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
MAVEN_HOME="$BASE_DIR/.mvn/apache-maven-$MAVEN_VERSION"
MVN_BIN="$MAVEN_HOME/bin/mvn"

if command -v mvn >/dev/null 2>&1; then
  exec mvn "$@"
fi

if [ ! -x "$MVN_BIN" ]; then
  echo "Maven не найден в PATH. Скачивание Apache Maven $MAVEN_VERSION в .mvn/..."
  mkdir -p "$BASE_DIR/.mvn"
  ARCHIVE="$BASE_DIR/.mvn/apache-maven-$MAVEN_VERSION-bin.tar.gz"
  URL="https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz"

  if command -v curl >/dev/null 2>&1; then
    curl -L "$URL" -o "$ARCHIVE"
  elif command -v wget >/dev/null 2>&1; then
    wget -O "$ARCHIVE" "$URL"
  else
    echo "ОШИБКА: Maven не установлен, а curl и wget недоступны."
    echo "Установите Maven вручную с https://maven.apache.org/download.cgi или установите curl/wget."
    exit 1
  fi

  tar -xzf "$ARCHIVE" -C "$BASE_DIR/.mvn"
fi

exec "$MVN_BIN" "$@"
