# Expense Tracker API

This is a simple API that lets users create and track their expenses for a particular period.

## Technologies Used:

- Java
- Spring Boot
- Postgresql
- Maven
- Git


## Functions


### 1. Create an Expense - POST
`/api/expense`

This creates a new expense for a specified category and date.

### 2. Edit an Expense - PUT
`/api/expense?cateory=<category>`

This edits an expense that corresponds with the provided category.

### 3. Get Expense(s) - GET
`/api/expense?filter=filter&category=<category>`

This returns the expense(s) that corresponds with the provided category, and/or filter, or an error message if not found.

### 4. Delete Expense - DELETE
`/api/expense?category=<category>`

This deletes the expense(s) that corresponds with the provided category, or an error message if not found.

