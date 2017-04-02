# DBProject
Our Coop website project for Database course

# Instruction
1. Clone into local directory
2. Create `db.properties` in `/src` and write
```
driver = org.postgresql.Driver
url = jdbc:postgresql://<url>:<port>/<db-name>?currentSchema=<schema-name>
username = <username>
password = <password>
```
3. Execute the following SQL files in `/etc` one by one
  - tables.sql
  - functions_triggers.sql
  - insert.sql
