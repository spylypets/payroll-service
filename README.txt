
Examples of testing the endpoint API with curl:

1. Create employee

curl -d "{\"id\":\"null\", \"name\":\"Test Tester\", \"role\": \"TESTER\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/employees

{"id":1,"name":"Test Tester","role":"TESTER"}

curl -d "{\"id\":\"null\", \"name\":\"John Dow\", \"role\": \"DEVELOPER\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/employees

{"id":2,"name":"John Dow","role":"DEVELOPER"}

2. Update employee

curl -d "{\"id\":\"1\", \"name\":\"Test Tester\", \"role\": \"DEVELOPER\"}" -H "Content-Type: application/json" -X PUT http://localhost:8080/employees

{"id":1,"name":"Test Tester","role":"DEVELOPER"}

3. Get all employees

curl http://localhost:8080/employees

[{"id":1,"name":"Test Tester","role":"DEVELOPER"},{"id":2,"name":"John Dow","role":"DEVELOPER"}]

4. Find an employee by ID

curl http://localhost:8080/employees/1

{"id":1,"name":"Test Tester","role":"DEVELOPER"}