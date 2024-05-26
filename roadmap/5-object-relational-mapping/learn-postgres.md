# Learning PostgreSQL

Here, progress made in learning postgres is saved and documented.
Here are some commands and what they do, grouped into sections:

## Introduction
- `psql` opens an instance of postgres with the local user.
- `SELECT version();` outputs the version of postgres running on the machine.

On a typical postgres installation, a default user `postgres` is created during installation and this user can be accessed via the 'switch user' command: `sudo su postgres`.

Fundamental commands useful within the `psql` shell environment include:

- `\l` - this outputs a list of databases present on a machine, their owners, encodings, etc.
- `\du` - this outputs a list of all users (role names), their roles, and groups which they are a part of.

To change the password of a user, 

- `ALTER USER user_name WITH PASSWORD 'password';`
If successful, this will return an 'ALTER ROLE' text.
