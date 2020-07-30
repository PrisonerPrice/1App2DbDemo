# 1App2DbDemo Project

This project illustrate how a Spring applictaion can connect to MangoDB and MySQL together.

# Database setup

## MySQL setup

Pull image:

`
$ docker pull mysql
`

Set up database container:

`
$ docker run --name {db_container_name} -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD={your_password} mysql
`

Dive into the database container and create a test database:

`
$ docker exec -it {db_container_name} bash
`

`
> $ mysql -u root -p
`

After this command, you will be asked to enter the password

`
> $ Create database {your_database_name};
`

