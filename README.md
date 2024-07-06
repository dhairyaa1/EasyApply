This project is based on microservices architecture. It is only backend project, which comprises of the following features:

1) It has API gateway, which ensures that no unauthorised request is routed to the apis.
2) It has a single repository, which has methods using which we can call stored procedure, use hibernate queries, etc.
3) It has factory , which helps us select database connection based on need.
4) It has user service, using which we can get data about users.
5) It has Application service through which users can apply to any job. It also have some async methods to get the whole application detail parallelly.
6) It has a company details service, to add/update/delete new company.
7) Added validations for invalid input to api.
ToDos:

1)Use Centralized configuration from git repo insted of adding in seperate microservices(Achived using spring cloud config).
