Oozie Job API example
```
mvn install

bin/oozie job -oozie http://localhost:11000/oozie -validatejar ~/org.apache.oozie-1.0-SNAPSHOT.jar 
bin/oozie job -oozie http://localhost:11000/oozie -runjar ~/org.apache.oozie-1.0-SNAPSHOT.jar -config  examples/apps/shell/job.properties -DnameNode=hdfs://localhost:9000  

```
