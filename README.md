NOTE: . is current directory and in window we use back slash

Step 1 : Start Zookeeper server
D:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Step 2 : Start Kafka server
D:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties

Step 3 : Create Kafka topic
D:\kafka>.\bin\windows\kafka-topics.bat --create --topic kafkaTopicNameExample --bootstrap-server localhost:9092

     Response - Created topic kafkaTopicNameExample.

Step 4 : Start Producer server

D:\kafka>.\bin\windows\kafka-console-producer.bat  --topic kafkaTopicNameExample --bootstrap-server localhost:9092

Step 5 : Start Consumer server

      D:\kafka>.\bin\windows\kafka-console-consumer.bat --topic kafkaTopicNameExample --from-beginning  --bootstrap-server localhost:9092