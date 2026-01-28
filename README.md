# cinemind-user-service
Primary metadata repository for films and series. Implements optimized search and genre-based filtering

The movie-catalog-service is the System of Record.for your platform. 
While other services handle volatile data like "who is watching what," 
this service manages the permanent, structured data about the content itself.

Core Responsibilities 
Metadata Management: 
It acts as the "source of truth" for every movie, show, or web series. 
It stores static details: Title, Plot, Release Date, Cast, Director, and Genre tags.
Intelligent Search (The "Trie" Feature): 
Instead of simple SQL queries, it provides a high-speed autocomplete and prefix-search engine.
Categorization: 
It manages the genre hierarchy (e.g., Crime $\rightarrow$ Serial Killer), 
which the Recommendation Engine will later use for "Content-Based Filtering."
Data Provisioning: 
It serves other microservices. When the recommendation-service identifies that User A should watch Movie ID 505, 
it asks the catalog-service for the title and poster to show the user.(poster in progress)
