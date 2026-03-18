What is the difference between list, tuple, and set?

List: An ordered, mutable collection. Use it when you need a sequence that changes.
Tuple: An ordered, immutable collection. It is faster than a list and can be used as a dictionary key.Set: An unordered collection of unique elements. It uses a hash table, making lookups $O(1)$ on average.

What is the difference between deepcopy and shallow copy?
Shallow Copy vs. Deep Copy (You had these reversed!)
Shallow Copy: Creates a new object, but fills it with references to the child objects of the original. If you modify a nested list in a shallow copy, the original will change.

Deep Copy: Creates a new object and recursively copies every object found in the original. The two objects are entirely independent.

What are Python decorators?
Decorators are the python fucntions that doesnt change the inner implementtaion  of the method but it adds extra fucntionality tothe fuicntio s like if method deosmt have any debugging statements usinf decoreator we can add to that method withput changing the implementatin of that method

A decorator is a higher-order function that takes another function as an argument, extends its behavior without explicitly modifying its source code, and returns a new function.

What are generators and why are they memory efficient?

"A generator is a special type of function in Python that returns an iterator object. Instead of using return to send back a single value and destroy the function's local state, a generator uses the yield keyword. yield pauses the function's execution, saves all its local variables and state, and returns a value to the caller. When the generator is called again, it resumes exactly where it left off."

Why are they memory efficient? (The "Lazy Evaluation" Concept)
"Generators are highly memory efficient because they use lazy evaluation. Instead of computing an entire sequence of data and loading it all into memory at once (like a List does), a generator computes and yields only one item at a time."

What is the difference between iterables and iterators?
Iterable: Any object you can loop over (like a List or String). It has an __iter__() method that returns an iterator.

Iterator: The object that actually does the work. It has a __next__() method that fetches the next element and raises StopIteration when done.

How does Python garbage collection work?

Python manages memory automatically through two primary mechanisms that work together: Reference Counting and Generational Garbage Collection. 

1. Reference Counting (Main Strategy)
This is Python's "first line of defense." Every object created keeps a count of how many other variables or objects refer to it. 

Increase: When an object is assigned to a new name, added to a list, or passed to a function.
Decrease: When a reference is deleted (del), goes out of scope, or is reassigned.
Deallocation: As soon as an object's reference count drops to zero, Python immediately reclaims its memory. 

2. Generational Garbage Collection (The Cleanup Crew)
Reference counting has one major weakness: it cannot detect cyclic references (e.g., Object A points to B, and B points back to A). Even if your code stops using them, their counts never hit zero. 

To fix this, Python’s cyclic garbage collector uses a Generational approach: 

Three Generations: Objects are sorted into three lists (Generations 0, 1, and 2) based on how long they've lived.
Promotion: New objects start in Generation 0. If they survive a garbage collection cycle, they are "promoted" to an older generation.
Frequency: The collector checks newer objects (Gen 0) much more frequently than old timers (Gen 2). This follows the "Weak Generational Hypothesis"—the idea that most objects die young.
Thresholds: Collection is triggered automatically when the number of allocations minus deallocations exceeds a certain threshold (default is 700 for Gen 0). 

How to Interact with GC
While usually automatic, you can control this process using the gc module: 
gc.collect(): Manually triggers a collection.
gc.disable(): Turns off the automatic collector (useful in very high-performance scenarios).
gc.get_threshold(): Views the current triggers for each generation.

What is the Global Interpreter Lock (GIL)?
The GIL is a mutex that allows only one thread to execute Python bytecode at a time. This is necessary because Python’s memory management isn't thread-safe.

When should you use threading vs multiprocessing?
In a nutshell, choose Threading for I/O-bound tasks like web scraping or API calls where the program spends most of its time waiting for a response, as it is lightweight and shares memory efficiently. However, because of Python's Global Interpreter Lock (GIL), threading cannot run code on multiple CPU cores simultaneously. For CPU-bound tasks like data crunching or image processing, use Multiprocessing; it bypasses the GIL by creating entirely separate memory spaces and instances of the Python interpreter, allowing your code to achieve true parallelism across all available processor cores.

What is asyncio?
Asyncio is a library used to write concurrent code using the async/export syntax. It uses an Event Loop as a central scheduler to manage Coroutines, which are special functions that can voluntarily suspend (yield) and resume their execution. This allows a single thread to handle thousands of tasks (like network requests) simultaneously by switching to a new task whenever the current one is waiting for a resource, rather than sitting idle

What is the difference between async and await?
The async keyword is a modifier placed before a function definition (async def) to transform it into a Coroutine, ensuring that calling it returns a coroutine object instead of executing the code immediately. The await keyword can only be used inside an async function; it tells the Event Loop to pause the current coroutine’s execution until the awaited task is finished, allowing other tasks to run in the meantime without blocking the entire thread. 


What are Python context managers?
python context manager are like with thjat deosnt need a exit or closing the process, it automatically cl;oses

Context Managers are objects that simplify resource management (like opening files or database connections) by ensuring that setup and cleanup code is executed automatically. They are typically used with the with statement, which triggers the __enter__ method to start the process and the __exit__ method to safely close the resource or handle errors, even if the code inside the block crashes. 

What is the difference between __str__ and __repr__?
Both of these are dunder methods used to convert your object into a string. The difference comes down to who the string is meant for.
import datetime

# We create a simple date object
today = datetime.date(2026, 3, 17)

# ---------------------------------------------------------
# 1. __str__ (The "Pretty" version)
# Triggered when you use str() or print()
# ---------------------------------------------------------
print(str(today)) 
# Output: '2026-03-17'
# Why? Because a regular user just wants to see the date formatted nicely.

# ---------------------------------------------------------
# 2. __repr__ (The "Technical" version)
# Triggered when you use repr() or inspect the object in the terminal
# ---------------------------------------------------------
print(repr(today)) 
# Output: 'datetime.date(2026, 3, 17)'
# Why? Because a developer needs to know exactly what class this is. 
# Notice how the output is the EXACT valid Python code needed to recreate the object.


__str__ is for the User: It should be readable, pretty, and informative. It gets triggered automatically when you call print(my_object) or str(my_object).

__repr__ is for the Developer: It stands for "representation." It should be detailed, unambiguous, and used for debugging. Ideally, it should output a string that looks exactly like the valid Python code needed to recreate that object. It gets triggered when you inspect an object in the console or use repr(my_object).

What are Python dunder methods?
"Dunder" is just short for Double Underscore. They are the methods that have two underscores before and after their name, like __init__ or __len__.

The Interview Answer:
"Dunder methods—also known as Magic Methods—are special hooks that allow custom objects to interact with Python's built-in syntax. They let your classes behave like standard Python data types."

The "Why it matters" Example:
If you want to find the length of your custom object, you don't have to invent a new method like my_object.get_length(). Instead, you define the __len__() dunder method inside your class. Then, anyone using your code can just use the standard, built-in Python function: len(my_object). It makes your code "Pythonic."

What happens internally when you create a Python object?
When you instantiate a class, Python first calls __new__ to physically allocate memory for the object on the Heap, and then it calls __init__ to initialize the object's attributes. The object's data (attributes and methods) stays on the Heap, while the variable name (the pointer) is stored on the Stack, holding the memory address that links back to the actual object on the Heap.

# Python Concurrency

## What is the Global Interpreter Lock (GIL)?
The GIL is a mutex in CPython that allows only one thread to execute Python bytecode at a time. So even if multiple threads exist, only one runs Python code at a given instant.

## Why does Python have the GIL?
CPython uses reference counting for memory management. The GIL simplifies thread safety for object access and ref-count updates, making the interpreter implementation easier and faster for many single-threaded workloads.

## When should you use multithreading?
Use multithreading for I/O-bound tasks, such as API calls, file I/O, database queries, or web scraping, where threads spend time waiting. While one thread waits, another can run.

## When should you use multiprocessing?
Use multiprocessing for CPU-bound tasks, like image processing, numerical computation, or heavy data transformations. Separate processes bypass the GIL and can run on multiple CPU cores in true parallel.

## What are CPU-bound tasks vs I/O-bound tasks?
CPU-bound tasks spend most time doing computation on the CPU. I/O-bound tasks spend most time waiting on external resources, such as disk, network, or database responses.

## What is asyncio in Python?
asyncio is a standard library framework for asynchronous programming using async and await. It enables high-concurrency I/O handling in a single thread through cooperative scheduling.

## What is an event loop?
The event loop is the brain behind asynchronous Python (`asyncio`). It is an infinite loop that constantly monitors the status of different tasks. When an active task needs to wait for I/O (like a database query), the event loop pauses it and instantly switches the CPU to another task that is ready to run.

## What is the difference between synchronous and asynchronous programming?
In synchronous programming, tasks run one after another and blocking calls pause progress. In asynchronous programming, tasks can pause at await points so other tasks continue, improving throughput for I/O-heavy systems.

## How does async/await work internally?
An async function returns a coroutine object. When awaited, control is yielded to the event loop. The loop registers pending I/O, resumes the coroutine when ready, and repeats until completion.

## What is the difference between concurrency and parallelism?
* **Concurrency is about *managing* multiple tasks at once.** You start one task, pause it while waiting for something (like a network response), and work on another task. (Think of one chef cooking multiple dishes by switching between them).
* **Parallelism is about *executing* multiple tasks at exactly the same time.** This requires multiple CPU cores doing different things simultaneously. (Think of multiple chefs, each cooking their own dish).

## Why is Python multithreading bad for CPU tasks?
Because of the **Global Interpreter Lock (GIL)**. The GIL ensures that only *one* thread can execute Python bytecode at a time, regardless of how many cores your CPU has. If you use threading for heavy math (CPU-bound tasks), the threads will constantly fight for the GIL, and the overhead of context-switching will actually make your code run **slower** than single-threaded code.

## When should we use multiprocessing?
Use multiprocessing for **CPU-bound tasks** (e.g., image processing, machine learning models, heavy data crunching).
**The "Why":** Multiprocessing creates entirely separate OS processes, each with its own Python interpreter and memory space. This completely bypasses the GIL, allowing you to utilize all of your CPU cores in parallel.

## What are coroutines?
Coroutines are specialized functions defined with `async def`. Unlike standard functions that run from start to finish, coroutines can **pause their execution** (using the `await` keyword) to hand control back to the event loop, and then **resume** exactly where they left off once their awaited task finishes.

## How does FastAPI handle concurrent requests?
FastAPI runs on an **ASGI server** (like Uvicorn) and uses an event loop.

* **The Interview "Flex":** If you define a route with `async def`, FastAPI runs it directly in the event loop. However, if you use a standard `def` (synchronous), FastAPI is smart enough to run that function in an **external thread pool** so it doesn't accidentally block the main event loop.

## What happens if an async function blocks?
It causes a **catastrophe** for your application. If you put a synchronous blocking call (like `time.sleep()` or a standard `requests.get()`) inside an `async def` function, it will freeze the entire event loop. No other concurrent requests can be processed until that blocking call finishes. Always use async-compatible libraries (like `httpx` or `aiohttp`) inside async functions.

## What is non-blocking I/O?
It means your program doesn't sit idle while waiting for an external system. Instead of waiting (blocking) for a file to read or a network request to return, the system fires off the request and immediately moves on to execute other code. It will be notified via a callback or event loop when the data is finally ready.

## What is thread pool executor?
It's a utility from the `concurrent.futures` module that manages a "pool" of worker threads. Instead of manually creating, starting, and destroying threads (which is messy and resource-intensive), you just submit tasks to the pool, and the executor efficiently assigns them to available threads. It's the standard way to handle multiple **I/O-bound** tasks.

## What is process pool executor?
It is exactly like ThreadPoolExecutor, but it manages a pool of **processes** instead of threads. You use this when you have a batch of **CPU-bound** tasks that you want to distribute across your CPU cores in parallel.

# Object-Oriented Programming

## What are the four pillars of OOP?
The four pillars are Encapsulation, Abstraction, Inheritance, and Polymorphism. Together they improve modularity, reuse, and maintainability.

## What is inheritance in Python?
Inheritance allows a class to derive from another class and reuse or extend its behavior. The child class gets parent attributes and methods and can override them when needed.

## What is polymorphism?
Polymorphism means one interface, many implementations. Different objects can respond to the same method name in class-specific ways.

## What is encapsulation?
Encapsulation is bundling data and methods together and controlling direct access to internal state. In Python, this is mostly convention-based using naming patterns like _protected and __name-mangling.

## What is abstraction?
Abstraction means exposing essential behavior while hiding implementation details. In Python, abstract base classes (abc module) are commonly used to define required interfaces.

# Magic Methods

## What are dunder (magic) methods?
Dunder methods are special methods with double underscores, like __init__ or __len__. They let custom objects integrate with Python syntax and built-in functions.

## What does __init__ do?
__init__ initializes an object after it is created. It sets up instance attributes and initial state.

## What does __repr__ do?
__repr__ returns an unambiguous developer-focused string representation of an object, ideally one that could recreate the object.

## What does __str__ do?
__str__ returns a user-friendly readable string representation of an object, typically used by print.

## What is __call__ used for?
__call__ lets an instance behave like a function. If defined, you can execute object_instance(...) and route that call to custom logic.

# Web Frameworks

## What is FastAPI?
FastAPI is a modern, high-performance Python web framework for building APIs. It is built on top of Starlette (for the web layer) and Pydantic (for data validation and serialization). It is designed around Python type hints, so your function signatures become a source of truth for request parsing, validation, and documentation.

Interview-ready summary:
- It supports asynchronous programming with async def out of the box.
- It auto-generates interactive API documentation (Swagger UI and ReDoc).
- It provides strong editor support through typing, leading to fewer runtime bugs.
- It is well-suited for production APIs, microservices, and ML inference endpoints.

## Why is FastAPI faster than Flask?
FastAPI is often faster than Flask primarily because of its async-first architecture and underlying ASGI stack.

Key reasons:
- ASGI vs WSGI: FastAPI runs on ASGI servers like Uvicorn, which handle concurrent I/O more efficiently than traditional synchronous WSGI execution used by Flask by default.
- Non-blocking concurrency: FastAPI can process many waiting I/O requests concurrently in one event loop when endpoints are async.
- Efficient internals: Starlette and Pydantic are optimized for high-throughput API workflows.
- Reduced glue code: Built-in validation and serialization reduce custom parsing overhead and errors.

Important interview nuance:
- FastAPI is not automatically faster for every workload.
- For CPU-bound logic, both frameworks still need multiprocessing, workers, or background processing to scale.
- Performance depends on endpoint style, database driver choice, deployment config, and blocking calls.

## What is Pydantic?
Pydantic is a data validation and settings management library that uses Python type annotations to define schemas. In FastAPI, it is used to model request bodies, query payloads, and response formats.

What it gives you:
- Runtime validation of incoming data against declared types.
- Automatic parsing/coercion where valid (for example, string to int when safe).
- Clear structured error messages when validation fails.
- Serialization utilities for converting objects into JSON-friendly output.

In interview terms: Pydantic acts as the contract layer between external client data and internal application logic.

## How does FastAPI perform request validation?
FastAPI inspects endpoint function signatures and Pydantic models at startup. At request time, it extracts data from path params, query params, headers, cookies, and body, then validates and converts it based on your type hints.

Flow at runtime:
- Client sends request.
- FastAPI maps incoming fields to declared parameters.
- Pydantic validates and parses each value.
- If validation fails, FastAPI returns a 422 response with field-level error details.
- If validation passes, your endpoint receives already-typed, trusted data.

Why this matters in interviews:
- You write less manual validation code.
- API behavior is consistent and self-documented.
- Validation errors are standardized, making client integration easier.

## What is dependency injection in FastAPI?
Dependency injection in FastAPI is a mechanism to provide reusable components (like database sessions, auth checks, config objects, or shared services) to endpoints without manually wiring them everywhere.

FastAPI uses Depends to declare dependencies in function parameters. The framework resolves them automatically per request.

Benefits:
- Reusability: common logic is centralized.
- Testability: dependencies can be overridden in tests.
- Separation of concerns: endpoint handlers stay focused on business logic.
- Lifecycle management: setup/teardown patterns (such as DB sessions) are easier to manage.

Interview framing:
- It is inversion of control at the API layer.
- You declare what you need, and FastAPI provides it.

## What is Swagger UI?
Swagger UI is an interactive web interface for exploring and testing REST APIs from their OpenAPI specification. FastAPI auto-generates that specification and serves Swagger UI by default.

Why it is important:
- Developers can try endpoints directly from the browser.
- Request/response schemas are visible without external docs.
- It accelerates API onboarding, debugging, and cross-team collaboration.
- It stays in sync with code when your type hints and models change.

Interview-ready close:
- In FastAPI, Swagger UI is available automatically (commonly at /docs), making documentation a built-in feature rather than a separate maintenance task.

## What is WSGI?
WSGI (Web Server Gateway Interface) is the standard interface between Python web applications and web servers in the synchronous Python web world.

Interview-level explanation:
- It defines how a request is passed from a web server to a Python app and how the app sends a response back.
- It follows a request-response model where one worker typically handles one request at a time.
- It is ideal for traditional synchronous frameworks and apps.
- Popular WSGI servers include Gunicorn (WSGI mode) and uWSGI.

Limitation to mention in interviews:
- WSGI is not designed for long-lived, bidirectional, or highly concurrent async communication patterns like WebSockets.

## What is ASGI?
ASGI (Asynchronous Server Gateway Interface) is the successor-style interface designed for asynchronous Python applications.

Interview-level explanation:
- It supports both synchronous and asynchronous application patterns.
- It can handle protocols beyond plain HTTP, such as WebSockets and long-lived connections.
- It is event-loop friendly, making it suitable for high-concurrency I/O workloads.
- Popular ASGI servers include Uvicorn, Hypercorn, and Daphne.

Why it matters:
- ASGI enables modern Python frameworks to scale better for concurrent network workloads while still allowing sync endpoints when needed.

## What is the difference between WSGI and ASGI?
The core difference is execution model and protocol capability.

WSGI:
- Primarily synchronous interface.
- Built around one request/response cycle.
- Best fit for traditional sync applications.
- Limited for WebSockets and async-heavy communication.

ASGI:
- Asynchronous-first interface with support for sync code too.
- Handles HTTP plus long-lived protocols like WebSockets.
- Better for high-concurrency I/O workloads.
- Integrates naturally with async and await.

Interview one-liner:
- WSGI is great for classic synchronous apps; ASGI is built for modern concurrent, real-time, async-capable applications.

## Why does FastAPI use ASGI?
FastAPI uses ASGI because FastAPI is built to leverage async and await for high-concurrency API workloads.

Interview-grade reasons:
- Async performance: ASGI allows FastAPI to process many waiting I/O requests efficiently using the event loop.
- Real-time support: ASGI enables features like WebSockets and long-lived connections.
- Mixed execution: FastAPI can run async routes in the event loop and safely offload sync routes to thread pools.
- Modern ecosystem fit: FastAPI relies on Starlette, which is ASGI-native, making the stack consistent and efficient.

Short interview close:
- FastAPI uses ASGI because its design goal is modern, concurrent, production APIs, and ASGI is the interface that enables that model.

# Backend APIs (10 Questions)

## What is REST API?
REST API (Representational State Transfer API) is an architectural style for building networked services over HTTP. Resources are identified by URLs, and standard HTTP methods are used to act on those resources.

Interview-ready points:
- `GET` retrieves data, `POST` creates, `PUT/PATCH` updates, `DELETE` removes.
- REST is stateless: each request contains all the context needed by the server.
- It commonly uses JSON as the data format.
- Proper status codes (`200`, `201`, `400`, `401`, `404`, `500`) are part of good API design.

## What is FastAPI?
FastAPI is a modern Python framework for building APIs with high performance and strong typing. It is built on Starlette and Pydantic, and it uses Python type hints for parsing, validation, and documentation.

Why interviewers like this answer:
- Async support with `async def` is first-class.
- Automatic OpenAPI schema generation.
- Built-in interactive docs (Swagger UI / ReDoc).
- Cleaner, safer API code through type-driven development.

## Why is FastAPI faster than Flask?
FastAPI is typically faster for I/O-heavy workloads because it runs on ASGI and supports non-blocking async execution more naturally.

Key technical reasons:
- ASGI stack (often Uvicorn) handles high-concurrency I/O efficiently.
- Async endpoints avoid blocking while waiting on external systems.
- Starlette/Pydantic internals are optimized for API throughput.

Interview nuance:
- FastAPI is not magically faster for CPU-bound work.
- For CPU-heavy logic, use process workers, multiprocessing, or task queues regardless of framework.

## What is Pydantic?
Pydantic is a Python data validation and parsing library based on type annotations. In FastAPI, it defines request and response models and enforces schema correctness at runtime.

What it gives you:
- Automatic validation and type coercion.
- Structured validation errors.
- Serialization to JSON-friendly formats.
- Clear contracts between client and server.

## What is dependency injection in FastAPI?
Dependency injection in FastAPI is a way to provide reusable components to endpoints (like database sessions, auth checks, service classes, configuration) using `Depends(...)`.

Interview value:
- Reduces duplication of shared logic.
- Improves testability by overriding dependencies in tests.
- Keeps endpoint functions focused on business behavior.
- Helps manage lifecycle (setup/teardown) cleanly.

## What is middleware?
Middleware is code that runs before and/or after request handling, sitting between the client request and the route function.

Common use cases:
- Logging and tracing
- CORS handling
- Authentication pre-checks
- Request/response timing
- Global error shaping

Interview framing:
- Middleware is cross-cutting infrastructure logic that should not be repeated in every endpoint.

## What is request validation?
Request validation is the process of verifying incoming API data (path/query/body/header) against expected schema and constraints before business logic runs.

In FastAPI:
- Type hints and Pydantic models define constraints.
- Invalid input returns a `422 Unprocessable Entity` with field-level details.
- Endpoint code receives validated and typed data only.

Why it matters:
- Security: blocks malformed payloads early.
- Reliability: reduces runtime type errors.
- Better client experience: clear, consistent error messages.

## What is OpenAPI/Swagger?
OpenAPI is a machine-readable specification describing your API endpoints, request/response schemas, auth schemes, and metadata. Swagger UI is a browser interface that renders this spec and allows interactive testing.

In FastAPI:
- OpenAPI spec is generated automatically from your code.
- Swagger UI is available by default (commonly `/docs`).

Interview benefit:
- Documentation stays synchronized with implementation, reducing drift and integration confusion.

## What is rate limiting?
Rate limiting is a control mechanism that restricts how many requests a client can make within a time window (for example, `100 requests/minute`).

Why APIs use it:
- Protects against abuse and DDoS-like traffic spikes.
- Prevents one client from starving shared resources.
- Improves fairness and service stability.

Common strategies:
- Fixed window
- Sliding window
- Token bucket

## How do you handle API authentication?
API authentication verifies who the caller is and whether they can access a resource.

Practical approach in production APIs:
- Use OAuth2/JWT bearer tokens for stateless auth in distributed systems.
- Validate token signature, expiry, issuer, and audience on every protected request.
- Use HTTPS everywhere to protect credentials/tokens in transit.
- Separate authentication (identity) from authorization (permissions/roles/scopes).

Interview-level best practices:
- Prefer short-lived access tokens and token refresh flow.
- Store secrets and signing keys securely (vault/env-managed, never hardcoded).
- Add rate limiting and audit logging to auth-sensitive endpoints.

# Databases (10 Questions)

## What is normalization?
Normalization is the process of structuring relational database tables to reduce redundancy and improve data integrity. It splits data into related tables and defines clear relationships using keys.

Interview-ready view:
- Goal: avoid duplicate data and update anomalies.
- Common normal forms: 1NF, 2NF, 3NF, and sometimes BCNF.
- Tradeoff: highly normalized schemas improve consistency but may require more joins for reads.

## What are SQL joins?
SQL joins combine rows from two or more tables based on a related column (usually a primary key to foreign key relationship).

Core join types:
- `INNER JOIN`: returns only matching rows from both tables.
- `LEFT JOIN`: returns all rows from left table + matching rows from right (non-matches become `NULL`).
- `RIGHT JOIN`: returns all rows from right table + matching rows from left.
- `FULL OUTER JOIN`: returns all rows from both sides, matching where possible.
- `CROSS JOIN`: Cartesian product of both tables.

Interview tip:
- Choosing the right join is about handling unmatched records intentionally.

## What is indexing?
An index is a data structure (commonly B-tree, sometimes hash) that speeds up data retrieval by avoiding full table scans.

Why it matters:
- Faster `WHERE`, `JOIN`, `ORDER BY`, and lookup operations.
- Primary keys are usually indexed by default.

Tradeoffs:
- Indexes consume extra storage.
- Insert/update/delete can be slower because indexes must be maintained.
- Over-indexing hurts write-heavy systems.

## What are ACID properties?
ACID defines reliability guarantees for database transactions.

- Atomicity: all operations in a transaction succeed or all are rolled back.
- Consistency: transactions move data from one valid state to another.
- Isolation: concurrent transactions do not interfere in unsafe ways.
- Durability: once committed, data survives crashes (via logs/storage guarantees).

Interview one-liner:
- ACID is the foundation of correctness in transactional relational systems.

## What is transaction isolation?
Transaction isolation controls how and when changes made by one transaction become visible to others, balancing correctness and concurrency.

Typical levels:
- `Read Uncommitted`
- `Read Committed`
- `Repeatable Read`
- `Serializable`

Anomalies isolation tries to prevent:
- Dirty reads
- Non-repeatable reads
- Phantom reads

Interview insight:
- Higher isolation gives stronger correctness but can reduce throughput due to locking/contention.

## What is NoSQL?
NoSQL refers to non-relational databases designed for flexible schemas, horizontal scaling, and high-throughput distributed workloads.

Common categories:
- Document stores (MongoDB)
- Key-value stores (Redis)
- Wide-column stores (Cassandra)
- Graph databases (Neo4j)

When useful:
- Rapidly evolving schemas
- Very large scale and distribution needs
- Data that does not fit strict relational modeling well

## When should you use MongoDB vs SQL?
Use SQL databases when you need strong relational integrity, complex joins, and strict ACID transactional workflows. Use MongoDB when your data is document-centric, schema evolves frequently, and you prioritize rapid development and horizontal scaling.

Practical rule of thumb:
- SQL: finance, order systems, reporting with relational consistency.
- MongoDB: content systems, user profiles, event-style flexible documents.

Interview nuance:
- This is not either/or in large systems; polyglot persistence is common.

## What is database sharding?
Sharding is horizontal partitioning where data is split across multiple database nodes using a shard key (for example by user_id range/hash).

Benefits:
- Scales write and storage capacity.
- Distributes load across machines.

Challenges:
- Complex shard-key design.
- Harder cross-shard joins/transactions.
- Rebalancing and operational complexity.

## What is database replication?
Replication is maintaining copies of data across multiple database servers to improve availability, fault tolerance, and read scalability.

Common model:
- Primary (leader) handles writes.
- Replicas (followers) serve reads and provide failover readiness.

Interview nuance:
- Many systems are asynchronously replicated, so replicas can have replication lag.

## What is connection pooling?
Connection pooling is the practice of reusing a managed set of open database connections instead of creating a new connection for every request.

Why it is critical:
- Reduces connection setup latency.
- Prevents database overload from too many concurrent connection attempts.
- Improves throughput and resource utilization.

Interview best practice:
- Size the pool based on DB capacity and app concurrency, and always monitor pool exhaustion/timeouts. 