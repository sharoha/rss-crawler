# RSS Crawler
## Idea
As the name of the project suggests, the project aims to collate articles
from a given list of rss/atom article feed. This data can be used for a
a web/mobile application.

## Design
```puml
@startuml
[RSS Feed Crawler] as rssCrawler
[Kafka Producer] as kafkaProducer
cloud {
    [Kafka Server] as kafkaServer
}
database "PostgreSql" {
    
}

[Kafka Consumer] as kafkaConsumer
rssCrawler ..> HTTP : use
rssCrawler - kafkaProducer
kafkaProducer -- kafkaServer
kafkaConsumer -- kafkaServer
kafkaConsumer -- PostgreSql
@enduml
```
