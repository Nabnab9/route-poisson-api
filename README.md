# Back end spring boot la route du poisson

## Déploiement docker
- `mvn clean package`
- `docker run -p8081:8080 nabnab9/route-poisson-api`

## Nouvelle version
- `docker build --tag=nabnab9/route-poisson-api:${TAG} .`
- `docker push nabnab9/route-poisson-api:${TAG}`
