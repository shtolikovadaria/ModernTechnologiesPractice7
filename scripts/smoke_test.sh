#!/usr/bin/env bash
set -euo pipefail

./mvnw clean test
./mvnw spring-boot:run &
APP_PID=$!
trap 'kill "$APP_PID" 2>/dev/null || true' EXIT

for i in {1..40}; do
  if curl -fsS http://localhost:8080/api/greet/World >/tmp/practice7_greet.txt; then
    break
  fi
  sleep 2
done

echo "Greeting endpoint:"
cat /tmp/practice7_greet.txt

echo "Students endpoint:"
curl -fsS -u user:password http://localhost:8080/api/students

echo "Create student endpoint:"
curl -fsS -u admin:password -X POST http://localhost:8080/api/students   -H 'Content-Type: application/json'   -d '{"name":"Sash","surname":"Brown"}'
