### Roadmap

frontier-bff

- filters + routers: authentication / authorization
- endpoints:
    - (data) validation
    - (data) mapping + transform
    - expose hateaos apis
- clients: connect with upstream(biz or domain) apis

(business system) backend-merchant, backend-order

- apis:
    - (business) validation
    - expose business api
- service:
    - (internal) services: handle the business logic of this context
    - external services: the interface of the services provided by other microservices
- storage: persist data if needed
- infrastructure:
    - repository: store data in db
    - cache: store data in cache
    - client: read/pass data to another systemß

Next

- Transaction control between services, auto commit/rollback
- Deploy demo (on k8s)
- Ready for Istio
- Testing helper
