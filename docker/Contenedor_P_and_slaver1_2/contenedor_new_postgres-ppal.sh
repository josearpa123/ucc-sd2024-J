docker network create pg_network  # Crear una red de Docker para comunicación

docker run -d --name postgres-ppal \
  --network pg_network \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=maindb \
  -p 5433:5432 \
  postgres:latest