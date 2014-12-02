About this project
==================

Clone with caution.

Playground for my own self-learning in the area of [graph databases](http://en.wikipedia.org/wiki/Graph_database) with
[Titan graph database](http://thinkaurelius.github.io/titan/) and [Scala](http://www.scala-lang.org/).

There's a single integration test `HelloWorldSpec` that requires a running instance of Titan db.

Download the latest version of Titan (the latest tested one is `0.5.2`) and run `./bin/titan.sh -c cassandra-es start`.

    ➜  titan  ./bin/titan.sh -c cassandra-es start
    Forking Cassandra...
    Running `nodetool statusthrift`... OK (returned exit status 0 and printed string "running").
    Forking Elasticsearch...
    Connecting to Elasticsearch (127.0.0.1:9300)... OK (connected to 127.0.0.1:9300).
    Forking Titan + Rexster...
    Connecting to Titan + Rexster (127.0.0.1:8184)... OK (connected to 127.0.0.1:8184).
    Run rexster-console.sh to connect.

With the infrastucture running, switch to [IntelliJ IDEA](https://www.jetbrains.com/idea/) and execute the test.

You should see the following output.

    0    [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.diskstorage.cassandra.thrift.CassandraThriftStoreManager  - Closed Thrift connection pooler.
    10   [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.graphdb.configuration.GraphDatabaseConfiguration  - Generated unique-instance-id=c0a80b3051261-japila-local1
    27   [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.diskstorage.Backend  - Configuring index [search]
    153  [specs2.DefaultExecutionStrategy-1] INFO  org.elasticsearch.plugins  - [Paul Bailey] loaded [], sites []
    770  [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.diskstorage.es.ElasticSearchIndex  - Configured remote host: 127.0.0.1 : 9300
    932  [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.diskstorage.Backend  - Initiated backend operations thread pool of size 16
    1034 [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.diskstorage.log.kcvs.KCVSLog  - Loaded unidentified ReadMarker start time Timepoint[1417527850370000 μs] into com.thinkaurelius.titan.diskstorage.log.kcvs.KCVSLog$MessagePuller@65664f27
    1270 [specs2.DefaultExecutionStrategy-1] INFO  com.thinkaurelius.titan.diskstorage.cassandra.thrift.CassandraThriftStoreManager  - Closed Thrift connection pooler.The test should

Use [http://localhost:8182/doghouse](http://localhost:8182/doghouse) to view the graph (nodes and edges) of the Gods family.
