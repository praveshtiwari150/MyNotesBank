Below is a set of questions and answers derived directly from the content you provided for "Week 10.1: Understanding Postgres." These focus on the key concepts of PostgreSQL, database types, the advantages of SQL databases, and practical steps for creating and interacting with a PostgreSQL database, ensuring a comprehensive understanding of the material.

---

### **Types of Databases**

**Q1: What are the main characteristics of NoSQL databases?**  
**A1:** NoSQL databases are:  
- **Definition**: Designed for large volumes of unstructured or semi-structured data, offering flexibility and scalability.  
- **Schema-less**: Lack a predefined schema, allowing varied data formats.  
- **Use Cases**: Ideal for big data, real-time web apps, and non-relational data.  
- **Examples**: MongoDB, Cassandra, Redis, Couchbase.

**Q2: How do graph databases store and manage data?**  
**A2:** Graph databases:  
- **Definition**: Focus on storing and navigating relationships.  
- **Data Storage**: Use nodes (entities) and edges (relationships) for efficient querying of complex connections.  
- **Use Cases**: Suited for social networks, recommendation engines, and fraud detection.  
- **Examples**: Neo4j, Amazon Neptune, OrientDB.

**Q3: What is the purpose of vector databases, and how do they function?**  
**A3:** Vector databases:  
- **Definition**: Optimized for vector similarity searching, storing vector embeddings from machine learning models.  
- **Data Storage**: Store data as vectors (arrays of numbers) in high-dimensional space.  
- **Use Cases**: Used in ML applications like image recognition, NLP, and recommendation systems.  
- **Examples**: Pinecone, Milvus, Faiss.

**Q4: What defines SQL databases, and why are they widely used?**  
**A4:** SQL databases:  
- **Definition**: Relational databases storing data in tables with predefined schemas.  
- **Data Storage**: Organized in rows and columns, with each row having a unique primary key.  
- **Use Cases**: Common in full-stack apps due to ACID properties for reliable transactions.  
- **Examples**: MySQL, PostgreSQL, Oracle, SQL Server.

---

### **Why Not NoSQL**

**Q5: What does "schemaless" mean in the context of NoSQL databases?**  
**A5:** "Schemaless" means:  
- **Definition**: No predefined structure; each document can have different fields and types.  
- **Flexibility**: Allows storage of heterogeneous data without schema changes.

**Q6: What are the problems with schemaless NoSQL databases?**  
**A6:** Problems include:  
- **Inconsistent Database**: Data varies across documents, leading to unpredictable queries.  
- **Runtime Errors**: Missing fields or type mismatches cause errors during execution.  
- **Too Flexible**: Lack of structure can compromise data integrity in strict applications.

**Q7: What are the advantages of schemaless NoSQL databases?**  
**A7:** Advantages are:  
- **Speed**: Enables rapid development without schema constraints.  
- **Schema Evolution**: Adapts easily to changing data requirements without migrations.

**Q8: How does Mongoose address schema issues in MongoDB?**  
**A8:** Mongoose:  
- **Schemas**: Defines schemas at the application level for MongoDB.  
- **Application-Level Strictness**: Enforces structure in Node.js, but MongoDB remains schemaless.  
- **Limitation**: Erroneous data can still be inserted directly into the database, bypassing Mongoose.

---

### **Why SQL?**

**Q9: How does a strict schema benefit SQL databases?**  
**A9:** A strict schema:  
- **Definition**: Requires predefined table structures (columns, types, relationships).  
- **Data Integrity**: Ensures consistent data by enforcing type and relationship rules.  
- **Schema Updates**: Managed via migrations to evolve the structure safely.

**Q10: What is involved in running an SQL database?**  
**A10:** Running an SQL database involves:  
- **Database Server**: Hosted locally, on-premises, or in the cloud, configured for performance and security.

**Q11: How do you connect to and manipulate data in an SQL database?**  
**A11:** You:  
- **Use a Library**: Employ an ORM or library (e.g., `pg`) for abstracted interaction.  
- **Create Tables**: Define schemas with columns, types, and constraints.  
- **Run Queries**: Use SQL for INSERT, UPDATE, DELETE, and SELECT operations.

**Q12: What are the key benefits of SQL databases?**  
**A12:** Benefits include:  
- **Data Integrity and Consistency**: Ensured by strict schemas and relational models.  
- **ACID Properties**: Guarantees reliable transactions.  
- **Complex Queries**: Supports advanced querying with joins and conditions.  
- **Mature Ecosystem**: Offers robust tools and practices.

---

### **Creating a PostgreSQL Database**

**Q13: How can you create a PostgreSQL database using Neon?**  
**A13:** Using Neon:  
- Visit [neon.tech](https://neon.tech/), sign up, and create a server.  
- Get a connection string, e.g., `postgresql://username:password@ep-broken-frost-69135494.us-east-2.aws.neon.tech/calm-gobbler-41_db_2253874`.

**Q14: What are the steps to set up PostgreSQL with Docker locally?**  
**A14:** Steps:  
1. Install Docker.  
2. Run: `docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres`.  
3. Connection string: `postgresql://postgres:mysecretpassword@localhost:5432/postgres?sslmode=disable`.

**Q15: How do you use Docker to run PostgreSQL on Windows?**  
**A15:** On Windows:  
1. Install Docker Desktop.  
2. Run initial setup: `docker run --name my-postgres1 -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres`.  
3. Start existing container: `docker start my-postgres1`.  
4. Connect via CLI: `docker exec -it my-postgres1 psql -U postgres -d postgres`.  
5. List tables: `\dt`.

**Q16: What is the format of a PostgreSQL connection string, and what are its components?**  
**A16:** Format: `postgresql://[user]:[password]@[host]:[port]/[database]?[options]`  
- Components:  
  - `postgresql://`: Protocol.  
  - `user:password`: Credentials.  
  - `host`: Server address.  
  - `port`: Listening port (default 5432).  
  - `database`: Target database.  
  - `options`: Additional settings (e.g., `sslmode=disable`).

---

### **Understanding Vector Databases**

**Q17: How do vector databases use vectors to represent data, according to the example?**  
**A17:** Vector databases:  
- Represent statements as vectors (e.g., `[1, 2, 2, 2, 2, 2]` for "Harkirat lives in India").  
- Similar coordinates (e.g., repeated `2`s) indicate shared words or concepts, enabling similarity searches.

---

### **Interact with PostgreSQL**

**Q18: What is `psql`, and how do you connect to a database with it?**  
**A18:**  
- **Definition**: `psql` is PostgreSQL’s CLI tool for executing SQL and managing databases.  
- **Connection**: Use `psql -h [host] -d [database] -U [user]`, e.g., `psql -h p-broken-frost-69135494.us-east-2.aws.neon.tech -d database1 -U 100xdevs`.

**Q19: What is the `pg` library, and how do you install and use it?**  
**A19:**  
- **Definition**: `pg` (node-postgres) is a Node.js library for interacting with PostgreSQL.  
- **Install**: `npm install pg` or `yarn add pg`.  
- **Use**: Create a `Client` with a connection string and connect:  
```tsx
const { Client } = require('pg');
const client = new Client({ connectionString: '...' });
client.connect();
```

---

### **Creating a Table Schema**

**Q20: How do you create a `users` table in PostgreSQL, and what are its components?**  
**A20:** Command:  
```tsx
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
```  
- **Components**:  
  - `id SERIAL PRIMARY KEY`: Auto-incrementing unique identifier.  
  - `username VARCHAR(50) UNIQUE NOT NULL`: Up to 50 characters, unique, required.  
  - `email VARCHAR(255) UNIQUE NOT NULL`: Up to 255 characters, unique, required.  
  - `password VARCHAR(255) NOT NULL`: Up to 255 characters, required.  
  - `created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP`: Auto-set timestamp.

**Q21: How do you verify table creation in `psql`?**  
**A21:** Run `\dt` in `psql` to list all tables; `users` should appear if created successfully.

---

### **Interacting with the Database**

**Q22: How do you perform an INSERT operation on the `users` table?**  
**A22:** Command:  
```tsx
INSERT INTO users (username, email, password)
VALUES ('username_here', 'user@example.com', 'user_password');
```  
- Adds a new user; `id` and `created_at` are auto-filled.

**Q23: How do you update a user’s password in the `users` table?**  
**A23:** Command:  
```tsx
UPDATE users
SET password = 'new_password'
WHERE email = 'user@example.com';
```  
- Changes the password for the user with the specified email.

**Q24: How do you delete a user from the `users` table?**  
**A24:** Command:  
```tsx
DELETE FROM users
WHERE id = 1;
```  
- Removes the user with `id` 1.

**Q25: How do you retrieve a user from the `users` table?**  
**A25:** Command:  
```tsx
SELECT * FROM users
WHERE id = 1;
```  
- Fetches all columns for the user with `id` 1.

---

### **Database Operations with `pg`**

**Q26: How do you connect to a PostgreSQL database using the `pg` library?**  
**A26:** Example:  
```tsx
import { Client } from 'pg';
const client = new Client({
  host: 'my.database-server.com',
  port: 5334,
  database: 'database-name',
  user: 'database-user',
  password: 'secretpassword!!',
});
client.connect();
```

**Q27: How do you create a table using `pg` in Node.js?**  
**A27:** Example:  
```tsx
async function createUsersTable() {
  await client.connect();
  const result = await client.query(`
    CREATE TABLE users (
      id SERIAL PRIMARY KEY,
      username VARCHAR(50) UNIQUE NOT NULL,
      email VARCHAR(255) UNIQUE NOT NULL,
      password VARCHAR(255) NOT NULL,
      created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
    );
  `);
  console.log(result);
  await client.end();
}
createUsersTable();
```

---

### **Creating a Simple Node.js App**

**Q28: How do you set up a TypeScript Node.js project for PostgreSQL?**  
**A28:** Steps:  
1. `npm init -y` and `npx tsc --init`.  
2. Edit `tsconfig.json`: `"rootDir": "./src"`, `"outDir": "./dist"`.  
3. Install dependencies: `npm install pg` and `npm install @types/pg --save-dev`.

**Q29: How does the `insertData` function securely add data to the `users` table?**  
**A29:** Example:  
```tsx
async function insertData(username: string, email: string, password: string) {
  const client = new Client({ ... });
  try {
    await client.connect();
    const insertQuery = "INSERT INTO users (username, email, password) VALUES ($1, $2, $3)";
    const values = [username, email, password];
    const res = await client.query(insertQuery, values);
    console.log('Insertion success:', res);
  } catch (err) {
    console.error('Error during the insertion:', err);
  } finally {
    await client.end();
  }
}
insertData('username5', 'user5@example.com', 'user_password');
```  
- Uses parameterized queries (`$1`, `$2`, `$3`) to prevent SQL injection.

**Q30: How does the `getUser` function fetch a user securely?**  
**A30:** Example:  
```tsx
async function getUser(email: string) {
  const client = new Client({ ... });
  try {
    await client.connect();
    const query = 'SELECT * FROM users WHERE email = $1';
    const values = [email];
    const result = await client.query(query, values);
    if (result.rows.length > 0) {
      console.log('User found:', result.rows[0]);
      return result.rows[0];
    } else {
      console.log('No user found.');
      return null;
    }
  } catch (err) {
    console.error('Error during fetching user:', err);
    throw err;
  } finally {
    await client.end();
  }
}
getUser('user5@example.com');
```  
- Uses a parameterized query (`$1`) for secure email-based lookup.

---

These questions and answers cover the essential concepts from "Week 10.1: Understanding Postgres," including database types, PostgreSQL setup, schema creation, CRUD operations, and secure Node.js integration with TypeScript, providing a solid foundation for working with relational databases.

Below are essential questions and answers derived directly from the content you provided about "Week 12.4 - SQL Relationships & Joins." These focus on key concepts, relationships, transactions, joins, and their practical implementation, ensuring a solid understanding of the material.

---

### **Questions and Answers**

#### **1. What is the focus of today’s lecture by Harkirat?**
**Answer:**  
Today’s lecture revisits the `Fundamentals of SQL`, focusing on `relationships and transactions` in SQL databases. It provides a deeper understanding of structuring and querying relational data using `joins` and explores the various `types of joins` available in SQL.

#### **2. What are the two main types of databases discussed in the recap?**
**Answer:**  
- **Relational (SQL) Databases**: Organize data into tables with rows and columns, representing relations and individual records. Examples include MySQL, PostgreSQL, Microsoft SQL Server, and Oracle Database.  
- **Non-relational (NoSQL) Databases**: Use models like document-oriented, key-value, graph, and wide-column stores for flexible, scalable storage of unstructured or semi-structured data.

#### **3. Why are SQL databases preferred over NoSQL for certain applications?**
**Answer:**  
SQL databases are preferred for applications requiring strict data integrity, complex transactions, and relationships between data entities. They support ACID (Atomicity, Consistency, Isolation, Durability) properties, ensuring reliable transaction processing, making them ideal for e-commerce platforms and financial systems where data consistency is critical.

#### **4. How can you create a table in a PostgreSQL database?**
**Answer:**  
You create a table by defining its schema with a `CREATE TABLE` statement. For example:  
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
```  
This specifies columns, data types, and constraints like `PRIMARY KEY` and `NOT NULL`.

#### **5. How does MongoDB handle relationships in a NoSQL database?**
**Answer:**  
MongoDB allows flexible data modeling by storing related data in a single document with nested objects and arrays. For example:  
```json
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securepassword",
  "address": {
    "city": "New York",
    "country": "USA",
    "street": "123 Liberty St",
    "pincode": "10005"
  }
}
```  
This encapsulates user details and address in one document.

#### **6. How are relationships defined in SQL databases?**
**Answer:**  
In SQL databases, relationships are defined by creating separate tables for entities and linking them with keys. For example:  
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE addresses (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    street VARCHAR(255) NOT NULL,
    pincode VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```  
The `user_id` in `addresses` is a foreign key referencing the `id` in `users`.

#### **7. What is the purpose of transactions in SQL databases?**
**Answer:**  
Transactions ensure that a series of operations either all succeed or all fail, maintaining data integrity across multiple related operations. For example:  
```sql
BEGIN;
INSERT INTO users (username, email, password) VALUES ('john_doe', 'john_doe1@example.com', 'securepassword123');
INSERT INTO addresses (user_id, city, country, street, pincode) VALUES (currval('users_id_seq'), 'New York', 'USA', '123 Broadway St', '10001');
COMMIT;
```  
If any operation fails, the transaction is rolled back.

#### **8. How do you implement a transaction in Node.js using the `pg` library?**
**Answer:**  
You use the `pg` library to manage transactions programmatically:  
```jsx
async function insertUserAndAddress(username, email, password, city, country, street, pincode) {
    const client = new Client({ /* connection config */ });
    try {
        await client.connect();
        await client.query('BEGIN');
        const userRes = await client.query('INSERT INTO users (username, email, password) VALUES ($1, $2, $3) RETURNING id', [username, email, password]);
        const userId = userRes.rows[0].id;
        await client.query('INSERT INTO addresses (user_id, city, country, street, pincode) VALUES ($1, $2, $3, $4, $5)', [userId, city, country, street, pincode]);
        await client.query('COMMIT');
        console.log('User and address inserted successfully');
    } catch (err) {
        await client.query('ROLLBACK');
        console.error('Error during transaction, rolled back.', err);
        throw err;
    } finally {
        await client.end();
    }
}
```  
This ensures both inserts succeed or neither does.

#### **9. Why are joins preferred over separate queries for fetching related data?**
**Answer:**  
Joins are preferred because separate queries (e.g., one for `users` and one for `addresses`) require multiple database round trips, increasing latency and complicating application logic. A join retrieves related data in a single query, reducing latency and simplifying logic. For example:  
```sql
SELECT users.id, users.username, users.email, addresses.city, addresses.country, addresses.street, addresses.pincode
FROM users
JOIN addresses ON users.id = addresses.user_id
WHERE users.id = YOUR_USER_ID;
```

#### **10. How do you implement a join in a Node.js application using `pg`?**
**Answer:**  
You use a join query with the `pg` library:  
```jsx
async function getUserDetailsWithAddress(userId) {
    const client = new Client({ /* connection config */ });
    try {
        await client.connect();
        const query = `
            SELECT u.id, u.username, u.email, a.city, a.country, a.street, a.pincode
            FROM users u
            JOIN addresses a ON u.id = a.user_id
            WHERE u.id = $1
        `;
        const result = await client.query(query, [userId]);
        console.log('User and address found:', result.rows[0]);
        return result.rows[0];
    } catch (err) {
        console.error('Error during fetching user and address:', err);
        throw err;
    } finally {
        await client.end();
    }
}
```  
This fetches user and address data in one query.

#### **11. What is an INNER JOIN, and when should you use it?**
**Answer:**  
An `INNER JOIN` selects records with matching values in both tables. Use it when you only want rows with matches in both tables, e.g., users with addresses:  
```sql
SELECT users.username, addresses.city, addresses.country, addresses.street, addresses.pincode
FROM users
INNER JOIN addresses ON users.id = addresses.user_id;
```

#### **12. What does a LEFT JOIN do, and what is its use case?**
**Answer:**  
A `LEFT JOIN` returns all records from the left table and matched records from the right table, with `NULL` for non-matching right-side rows. Use it to list all users, including those without addresses:  
```sql
SELECT users.username, addresses.city, addresses.country, addresses.street, addresses.pincode
FROM users
LEFT JOIN addresses ON users.id = addresses.user_id;
```

#### **13. How does a RIGHT JOIN differ from a LEFT JOIN?**
**Answer:**  
A `RIGHT JOIN` returns all records from the right table and matched records from the left table, with `NULL` for non-matching left-side rows. For example:  
```sql
SELECT users.username, addresses.city, addresses.country, addresses.street, addresses.pincode
FROM users
RIGHT JOIN addresses ON users.id = addresses.user_id;
```  
It’s less common due to typical foreign key constraints but starts with the right table.

#### **14. What is the purpose of a FULL JOIN?**
**Answer:**  
A `FULL JOIN` returns all records when there is a match in either table, with `NULL` values for non-matching rows in either table. Use it to combine all users and addresses, including unmatched records:  
```sql
SELECT users.username, addresses.city, addresses.country, addresses.street, addresses.pincode
FROM users
FULL JOIN addresses ON users.id = addresses.user_id;
```

#### **15. What are the benefits of using joins in SQL queries?**
**Answer:**  
- **Reduced Latency**: Fewer database calls mean less overhead and faster responses.  
- **Simplified Application Logic**: A single result set is easier to handle than multiple query results.  
- **Transactional Integrity**: Ensures retrieved data is consistent at the time of the query.

---

These questions and answers cover the core concepts of relationships, transactions, and joins from your provided content, providing a comprehensive foundation for working with SQL databases effectively.

Here are questions and answers based on the "Week 22.3" lecture content about indexing in PostgreSQL, complex indexes, and indexing in Prisma. These are designed to build a strong conceptual understanding of database indexing and its application, with answers sourced directly from the provided content.

---

### Questions and Answers on Indexing in PostgreSQL

**Q1: What is indexing in PostgreSQL, and why is it important?**  
**A1:** Indexing is a technique in PostgreSQL that improves query performance by creating a data structure (usually a B-tree) to quickly locate records, reducing the need for full table scans. It’s crucial for optimizing database efficiency, especially with large datasets.

**Q2: How do you set up a PostgreSQL database locally using Docker?**  
**A2:**  
1. Run PostgreSQL: `docker run -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres`.  
2. Connect to the container: `docker exec -it <container_id> /bin/bash`, then `psql -U postgres`.

**Q3: How do you create a schema for a Medium-like app in PostgreSQL?**  
**A3:**  
1. Create the `users` table:  
   ```sql
   CREATE TABLE users (
       user_id SERIAL PRIMARY KEY,
       email VARCHAR(255) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL,
       name VARCHAR(255)
   );
   ```  
2. Create the `posts` table:  
   ```sql
   CREATE TABLE posts (
       post_id SERIAL PRIMARY KEY,
       user_id INTEGER NOT NULL,
       title VARCHAR(255) NOT NULL,
       description TEXT,
       image VARCHAR(255),
       FOREIGN KEY (user_id) REFERENCES users(user_id)
   );
   ```

**Q4: How do you insert dummy data into the `users` and `posts` tables?**  
**A4:**  
```sql
DO $$
DECLARE
    returned_user_id INT;
BEGIN
    FOR i IN 1..5 LOOP
        INSERT INTO users (email, password, name) VALUES
        ('user'||i||'@example.com', 'pass'||i, 'User '||i)
        RETURNING user_id INTO returned_user_id;
        FOR j IN 1..500000 LOOP
            INSERT INTO posts (user_id, title, description)
            VALUES (returned_user_id, 'Title '||j, 'Description for post '||j);
        END LOOP;
    END LOOP;
END $$;
```
This inserts 5 users, each with 500,000 posts.

**Q5: How do you measure query performance without an index in PostgreSQL?**  
**A5:** Run:  
```sql
EXPLAIN ANALYSE SELECT * FROM posts WHERE user_id=1 LIMIT 5;
```
Focus on the execution time, which reflects a full table scan without an index.

**Q6: How do you add an index to the `user_id` column and measure its impact?**  
**A6:**  
1. Create the index: `CREATE INDEX idx_user_id ON posts (user_id);`.  
2. Run the query again: `EXPLAIN ANALYSE SELECT * FROM posts WHERE user_id=1 LIMIT 5;`.  
The execution time decreases as the index allows faster row location.

**Q7: What are the key observations when comparing query performance with and without indexes?**  
**A7:**  
- **Without Indexes:** The query scans the entire `posts` table, which is slow for large datasets.  
- **With Indexes:** The query uses the index to quickly locate rows, significantly reducing execution time.

**Q8: How does indexing work in PostgreSQL, and what is its time complexity?**  
**A8:** An index creates a B-tree mapping the indexed column to record locations (page and offset). Without an index, a full table scan is $$O(n)$$; with an index, searching is $$O(\log n)$$, making it much faster.

**Q9: How is the table structure affected by indexing, as shown in the diagrams?**  
**A9:**  
- **Without Indexes:** The `posts` table has columns like `post_id`, `user_id`, etc., and a query performs a full scan ($$O(n)$$).  
- **With Indexes:** A `posts_index` table is created with `index_column` (e.g., `user_id`) and `location`, enabling $$O(\log n)$$ searches and $$O(1)$$ record retrieval.

---

### Questions and Answers on Complex Indexes

**Q10: What are complex indexes, and why are they useful?**  
**A10:** Complex indexes, or composite indexes, include multiple columns and optimize queries filtering on those columns (e.g., `user_id` and `title`). They’re useful for speeding up complex queries on large datasets.

**Q11: How do you create a composite index in PostgreSQL?**  
**A11:** Create it with:  
```sql
CREATE INDEX idx_posts_user_id_title ON posts (user_id, title);
```

**Q12: How do you measure the performance of a query before and after adding a composite index?**  
**A12:**  
1. Before: `EXPLAIN ANALYSE SELECT * FROM posts WHERE user_id=1 AND title='Title 1';`.  
2. Add the index: `CREATE INDEX idx_posts_user_id_title ON posts (user_id, title);`.  
3. After: `EXPLAIN ANALYSE SELECT * FROM posts WHERE user_id=1 AND title='Title 1';`.  
The execution time reduces after indexing.

**Q13: What are the observations when using a composite index?**  
**A13:**  
- **Before Indexing:** The query performs a full table scan or uses a single-column index, which is inefficient.  
- **After Indexing:** The query uses the composite index to locate rows quickly, reducing execution time.

**Q14: How does a composite index work, and what is its efficiency?**  
**A14:** A composite index creates a B-tree mapping the combination of indexed columns to record locations. Without it, queries may scan fully ($$O(n)$$; with it, searches are $$O(\log n)$$, improving efficiency.

**Q15: What is a practical example of using a composite index?**  
**A15:**  
1. Create: `CREATE INDEX idx_posts_user_id_title ON posts (user_id, title);`.  
2. Before: `EXPLAIN ANALYSE SELECT * FROM posts WHERE user_id=1 AND title='Title 1';` (full scan, slow).  
3. After: Same query uses the index, reducing execution time significantly.

---

### Questions and Answers on Indexes in Prisma

**Q16: What is the purpose of indexes in Prisma, and how do they improve performance?**  
**A16:** Indexes in Prisma optimize queries by creating indexes on fields, improving performance for filtering, sorting, or joining on those fields, thus minimizing query time.

**Q17: How do you define indexes in a Prisma schema?**  
**A17:** Use `@unique` for unique indexes or `@@index` for composite indexes. Example:  
```
model User {
  id        String   @id @default(uuid())
  username  String   @unique
  email     String   @unique
  posts     Post[]
  createdAt DateTime @default(now())
  updatedAt DateTime @updatedAt
}
model Post {
  id          String   @id @default(uuid())
  title       String
  content     String?
  published   Boolean  @default(false)
  createdAt   DateTime @default(now())
  updatedAt   DateTime @updatedAt
  userId      String
  user        User     @relation(fields: [userId], references: [id])
  @@index([userId])
}
```

**Q18: What do the indexes in the Prisma example schema achieve?**  
**A18:**  
- **User Model:** `@unique` on `username` and `email` ensures uniqueness.  
- **Post Model:** `@@index([userId])` optimizes queries filtering posts by `userId`.

**Q19: How do you introduce indexes in daily code using Prisma?**  
**A19:**  
1. Identify fields used in `WHERE`, `ORDER BY`, or `JOIN` (e.g., `userId`, `createdAt`).  
2. Add to schema:  
   ```
   model DailyCode {
     id        String   @id @default(uuid())
     userId    String
     code      String
     createdAt DateTime @default(now())
     updatedAt DateTime @updatedAt
     @@index([userId, createdAt])
   }
   ```  
3. Generate client: `npx prisma generate`.  
4. Query example:  
   ```jsx
   const dailyCodes = await prisma.dailyCode.findMany({
     where: { userId: 'some-user-id' },
     orderBy: { createdAt: 'desc' }
   });
   ```

**Q20: What are the steps to implement and use an index in Prisma effectively?**  
**A20:**  
1. Identify fields to index (e.g., frequent filters).  
2. Modify the schema with `@@index` or `@unique`.  
3. Generate the Prisma client with `npx prisma generate`.  
4. Use the index in queries to optimize performance.

---

### Verification of Coverage
These 20 questions and answers cover indexing fundamentals in PostgreSQL, setting up and testing indexes, complex (composite) indexes, and indexing in Prisma. All key concepts, code snippets, and diagrams from the content are addressed comprehensively. Let me know if you need further clarification!

Here are questions and answers based on the "Week 22.4" lecture content about database normalization, relationship types, and the normalization forms (1NF, 2NF, 3NF). These are designed to build a strong conceptual understanding of database normalization, with answers sourced directly from the provided content.

---

### Questions and Answers on Normalization in Databases

**Q1: What is database normalization, and what are its main goals?**  
**A1:** Normalization is a systematic approach to organizing data in a database by breaking it into multiple tables and defining relationships to reduce redundancy and improve data integrity. Its main goals are to eliminate redundant data and ensure data is stored logically and efficiently.

**Q2: What problems does data redundancy cause in a database?**  
**A2:** Redundant data leads to:  
1. **Data Inconsistency**: Updates in one place but not others cause inconsistencies.  
2. **Wasted Storage Space**: Duplicated data uses unnecessary space.  
3. **Update Anomalies**: Multiple updates increase error risk.  
4. **Insertion Anomalies**: Missing required data prevents inserts.  
5. **Deletion Anomalies**: Deleting data may lose related information.

**Q3: How does the example illustrate redundancy in a database?**  
**A3:** In this schema:  
```
users
+--------+----------+
| user_id| username |
+--------+----------+
|      1 | john     |
|      2 | jane     |
+--------+----------+
user_metadata
+--------+----------+------------+
| user_id| name     | email      |
+--------+----------+------------+
|      1 | John Doe | john@email.com |
|      2 | Jane Smith| jane@email.com|
+--------+----------+------------+
orders
+----------+----------+------------+
| order_id | user_id  | name       |
+----------+----------+------------+
|        1 |        1 | John Doe   |
|        2 |        2 | Jane Smith |
+----------+----------+------------+
```
The `name` in `orders` is redundant as it duplicates `name` from `user_metadata`, risking inconsistencies if not updated consistently.

**Q4: What is meant by "non-full proof data," and why does it matter?**  
**A4:** "Non-full proof data" refers to a database design lacking proper relationships, making data association unreliable. For example:  
```
users
+--------+----------+
| user_id| name     |
+--------+----------+
|      1 | John Doe |
|      2 | Jane Doe |
+--------+----------+
orders
+----------+----------+
| order_id | name     |
+----------+----------+
|        1 | John Doe |
|        2 | Jane Doe |
+----------+----------+
```
Without a `user_id` link, matching orders to users is ambiguous if names are duplicated, highlighting the need for proper relationships before normalization.

---

### Questions and Answers on Types of Relationships

**Q5: What is a one-to-one relationship, and how is it exemplified in a library system?**  
**A5:** A one-to-one relationship is when a record in one table links to at most one record in another, and vice versa. Example:  
```
Users
+--------+----------+
| user_id| username |
+--------+----------+
|      1 | john     |
|      2 | jane     |
+--------+----------+
Library Card
+----------+----------+
| card_id  | user_id  |
+----------+----------+
|        1 |        1 |
|        2 |        2 |
+----------+----------+
```
Each user has one library card, and each card links to one user via `user_id`.

**Q6: What defines a one-to-many relationship, and how does it apply to a library system?**  
**A6:** A one-to-many relationship is when one record in a table links to multiple records in another, but each record in the second table links to only one in the first. Example:  
```
Users
+--------+----------+
| user_id| username |
+--------+----------+
|      1 | john     |
|      2 | jane     |
+--------+----------+
Books
+----------+----------+------------+
| book_id  | user_id  | book_title |
+----------+----------+------------+
|        1 |        1 | Book A     |
|        2 |        1 | Book B     |
|        3 |        2 | Book C     |
+----------+----------+------------+
```
One user can borrow multiple books, but each book is borrowed by one user.

**Q7: How does a many-to-one relationship work, with an example from a library system?**  
**A7:** A many-to-one relationship is when multiple records in one table link to a single record in another. Example:  
```
Books
+----------+------------+
| book_id  | book_title |
+----------+------------+
|        1 | Book A     |
|        2 | Book B     |
|        3 | Book C     |
+----------+------------+
Genre
+----------+-------------+
| genre_id | genre_name  |
+----------+-------------+
|        1 | Fiction     |
|        2 | Non-Fiction |
+----------+-------------+
Book_Genre
+----------+----------+
| book_id  | genre_id |
+----------+----------+
|        1 |        1 |
|        2 |        1 |
|        3 |        2 |
+----------+----------+
```
Multiple books can belong to one genre, linked via the `Book_Genre` junction table.

**Q8: What is a many-to-many relationship, and how is it represented in a library system?**  
**A8:** A many-to-many relationship is when multiple records in one table can link to multiple records in another, and vice versa. Example:  
```
Books
+----------+------------+
| book_id  | book_title |
+----------+------------+
|        1 | Book A     |
|        2 | Book B     |
|        3 | Book C     |
+----------+------------+
Authors
+----------+---------------+
| author_id| author_name  |
+----------+---------------+
|        1 | Author X     |
|        2 | Author Y     |
|        3 | Author Z     |
+----------+---------------+
Book_Author
+----------+----------+
| book_id  | author_id|
+----------+----------+
|        1 |        1 |
|        1 |        2 |
|        2 |        2 |
|        3 |        3 |
+----------+----------+
```
A book can have multiple authors, and an author can write multiple books, linked via the `Book_Author` junction table.

**Q9: How does the final graph represent relationships in a library management system?**  
**A9:** The graph shows:  
```
+----------+    +----------+
|  Users   |1   1|Library  |
|          |    |  Card    |
+----------+    +----------+
     |
     |1
     |\\
     | \\
     |  \\
     |   \\
     |    \\
     |     \\
     N      1
     |       |
+----------+  +----------+
|  Books   |1 N|  Genre   |
+----------+  +----------+
     N      N
     |      |
+----------+
| Authors  |
+----------+
```
- `Users` to `Library Card`: One-to-one.  
- `Users` to `Books`: One-to-many.  
- `Books` to `Genre`: Many-to-one.  
- `Books` to `Authors`: Many-to-many.

---

### Questions and Answers on Normalizing Data

**Q10: What are the normal forms used in database normalization?**  
**A10:** The normal forms are:  
1. First Normal Form (1NF)  
2. Second Normal Form (2NF)  
3. Third Normal Form (3NF)  
4. Boyce-Codd Normal Form (BCNF)  
5. Fourth Normal Form (4NF)  
6. Fifth Normal Form (5NF)  
Most designs aim for 3NF or BCNF.

**Q11: What are the criteria for a table to be in First Normal Form (1NF)?**  
**A11:** A table is in 1NF if:  
1. **Atomicity**: Each cell holds one value, not multiple.  
2. **Primary Key**: It has a unique identifier for each row.  
3. **No Duplicated Rows**: All rows are unique.  
4. **Single Value per Column**: Each column holds one value per row.

**Q12: How does the 1NF example illustrate atomicity?**  
**A12:**  
- **Not in 1NF:**  
  ```
  +--------+---------------+
  | user_id| phone_numbers |
  +--------+---------------+
  |      1 | 123-456-7890, 987-654-3210 |
  |      2 | 555-123-4567 |
  +--------+---------------+
  ```  
  Multiple phone numbers in one cell violate atomicity.  
- **In 1NF:**  
  ```
  +--------+---------------+
  | user_id| phone_number  |
  +--------+---------------+
  |      1 | 123-456-7890  |
  |      1 | 987-654-3210  |
  |      2 | 555-123-4567  |
  +--------+---------------+
  ```  
  Each phone number is in a separate row, ensuring atomicity.

**Q13: What does it mean for a table to be in Second Normal Form (2NF)?**  
**A13:** A table is in 2NF if:  
1. It is in 1NF.  
2. It has no partial dependency, meaning non-key attributes depend on the entire composite primary key, not just part of it.

**Q14: What is a partial dependency, and how is it resolved in the 2NF example?**  
**A14:** A partial dependency occurs when a non-key attribute depends on only part of a composite primary key. Example:  
- **Before (Not in 2NF):**  
  ```
  Enrollments
  +------------+------------+---------------+---------------+
  | student_id | course_id  | course_name   | instructor_name|
  +------------+------------+---------------+---------------+
  |          1 |          1 | Introduction to Programming | John Doe |
  |          1 |          2 | Data Structures | Jane Smith|
  |          2 |          1 | Introduction to Programming | John Doe |
  +------------+------------+---------------+---------------+
  ```  
  `course_name` and `instructor_name` depend only on `course_id`, not the full `(student_id, course_id)`.  
- **After (2NF):**  
  ```
  Courses
  +------------+---------------+---------------+
  | course_id  | course_name   | instructor_name|
  +------------+---------------+---------------+
  |          1 | Introduction to Programming | John Doe |
  |          2 | Data Structures | Jane Smith|
  +------------+---------------+---------------+
  Enrollments
  +------------+------------+
  | student_id | course_id  |
  +------------+------------+
  |          1 |          1 |
  |          1 |          2 |
  |          2 |          1 |
  +------------+------------+
  ```  
  Splitting into two tables removes the partial dependency.

**Q15: What are the requirements for a table to be in Third Normal Form (3NF)?**  
**A15:** A table is in 3NF if:  
1. It is in 2NF.  
2. It has no transitive dependency, meaning non-key attributes do not depend on other non-key attributes.

**Q16: What is a transitive dependency, and how is it addressed in the 3NF example?**  
**A16:** A transitive dependency is when a non-key attribute depends on the primary key indirectly through another non-key attribute. Example:  
- **Before (Not in 3NF):**  
  ```
  Employees
  +-------------+---------------+---------------+
  | employee_id | employee_name | department_name |
  +-------------+---------------+---------------+
  |           1 | John Doe      | Sales         |
  |           2 | Jane Smith    | Marketing     |
  |           3 | Bob Johnson   | Sales         |
  +-------------+---------------+---------------+
  ```  
  `department_name` depends on `employee_id` via `employee_name`.  
- **After (3NF):**  
  ```
  Employees
  +-------------+---------------+---------------+
  | employee_id | employee_name | department_id |
  +-------------+---------------+---------------+
  |           1 | John Doe      |             1 |
  |           2 | Jane Smith    |             2 |
  |           3 | Bob Johnson   |             1 |
  +-------------+---------------+---------------+
  Departments
  +---------------+---------------+
  | department_id | department_name |
  +---------------+---------------+
  |             1 | Sales         |
  |             2 | Marketing     |
  +---------------+---------------+
  ```  
  Separating `department_name` into a new table removes the transitive dependency.

**Q17: Why is 3NF often a practical target for normalization?**  
**A17:** Most designs aim for 3NF or BCNF because going beyond can lead to excessive joins, impacting performance, while 3NF minimizes redundancy and anomalies effectively.

---

### Verification of Coverage
These 17 questions and answers cover the essentials of database normalization, including its purpose, issues with redundancy and poor relationships, types of relationships (one-to-one, one-to-many, many-to-one, many-to-many), and the normalization process up to 3NF with examples. All key concepts, examples, and diagrams from the content are addressed comprehensively. Let me know if you need further elaboration!