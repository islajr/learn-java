# LEARNING POSTGRESQL

Here, progress made in learning postgres is saved and documented.
Here are some commands and what they do, grouped into sections:

## INTRODUCTION
- `psql` opens an instance of postgres with the local user.
- `SELECT version();` outputs the version of postgres running on the machine.

On a typical postgres installation, a default user `postgres` is created during installation and this user can be accessed via the 'switch user' command: `sudo su postgres`.

Fundamental commands useful within the `psql` shell environment include:

- `\l` - this outputs a list of databases present on a machine, their owners, encodings, etc.
- `\du` - this outputs a list of all users (role names), their roles, and groups which they are a part of.

**To change the password of a user,** 

- `ALTER USER "user_name" WITH PASSWORD 'password';`
If successful, this will return an 'ALTER ROLE' text.

**To create a new user,**

- `CREATE USER "user_name" WITH PASSWORD 'password';`
If successful, a message 'CREATE ROLE' will be returned.

**To effectively alter the roles available to a user,**

- `ALTER USER "user_name" WITH required_role;`

If successful, as usual, an 'ALTER ROLE' text is returned.

**To remove a user,** 

- `DROP USER user_name;`
If successful, 'DROP ROLE' is returned

In order to properly interact with the database, it is necessary to install a front-end client (pgadmin)

## DEALING WITH DATABASES

**Creating a database:**

This can probably be done in more ways than one. One of such ways being as follows:

On a registered user, run the command `createdb myDatabaseName`.

This immediately creates a database with the name, myDatabaseName.

To access this database directly, `psql -d myDatabaseName` is used.

Another known way is to open the postgres shell with `psql` and within that shell, run `CREATE DATABASE myDatabaseName;`

This has the same effect as the other command, and it depends on choice.

**Transferring rights of a database to another user**

This is done with `GRANT ALL PRIVILEGES ON DATABASE "databaseName" TO "user";`

**To connect to a database as a user**

While logged into the postgres shell as a particular user, `\c databaseName` connects to the database as the logged-in user.

## DATATYPES IN SQL (POSTGRES)

Apart from the usual types, there is **point** for co-ordinate pairs, **real** for single precision floating numbers, **date** for dates, etc.




