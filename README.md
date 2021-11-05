### Roadmap

backend-service
- biz: submit a form with multi steps, wait for apporoval and edit
- API
  - Excutor
    - (Business) Validator
    - Domain Service
    - Domain Repo
  - Query
    - Store
  - Infra/Dao (Injected implementation)

frontier-bff
- biz: authenticate users
- biz: call multiple apis
- biz: expose hateaos apis
- Endpoints
  - (Data) (Bean)Validator
  - Routes Dispather
  - Application Service
    - Client


Next
- Add 1 more backend service
- Transaction controll between services, auto commit/rollback
- Deploy demo (on k8s)
- Ready for Istio 
- Testing helper