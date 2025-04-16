# Simple Blog API

This is a simple API that lets users perform CRUD operations on blog posts.


## Functions


### 1. Create a Post - POST
`/blog/api/post`

This creates a new blog post and stores it in the database.

### 2. Edit a Post - PUT 
`/blog/api/post?id=<number>`

This edits a blog post that corresponds with the provided id. 

### 3. Get Specific Post - GET
`/blog/api/post?id=<number>`

This returns the blog post that corresponds with the provided id, or an error message if not found. 

### 4. Get Posts - GET
`/blog/api/post`

This returns a list of blog posts that lies within the user's range of authority.

### 5. Delete Post - DELETE
`/blog/api/post?id=<number>`

This deletes the blog post that corresponds with the provided id, or an error message if not found.
