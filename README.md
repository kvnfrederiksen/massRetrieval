Allows for the mass retrieval of deleted records from a Bullhorn Database without the need for username and password credentials.

From an open session of Bullhorn, right-click > View page source

Scroll all the way down to find the BhRestToken and restUrl (this is easier in S-Release than Novo, but it's still there).

Copy and paste each into the appropriate fields.

Type in the search criteria in Lucene format into the Criteria field (this is already set in the program to search for deleted records, along with this specified criteria).

Select your entity, and click "Go!"

Main class is found under src/main/java/massRetrieval
