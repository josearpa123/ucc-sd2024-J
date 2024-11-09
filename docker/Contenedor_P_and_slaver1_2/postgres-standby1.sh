docker run -d --name postgres-standby1 \
  --network pg_network \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=maindb \
  postgres:latest
