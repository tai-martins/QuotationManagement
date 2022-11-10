# QuotationManagement
Repository to store Quotation Management project

### Practical Project 1 (CLOSE SCOPE) - IDP

This work consists an application that register quotes from a stock of the stock martek 

#### Developed by 👩
Tainara Martins

### Necessary tools

Install the tools below on your computer

[Docker](https://www.docker.com/)  
First create the network:
```
docker network create inatel
```
Start the MySql database:
```
docker container run --name mysql --network=inatel -e MYSQL_ROOT_PASSWORD=root -e
MYSQL_DATABASE=bootdb -p 3306:3306 -p 33060:33060 -d mysql
```
Start the Stock Manager application:
```
docker container run –-name stockmanager --network=inatel -p 8080:8080 -d adautomendes/stock-manager
```
![image](https://user-images.githubusercontent.com/53630619/201181059-5928b7f5-6f70-428c-8f64-5fb81bb148fb.png)



[JDK JAVA 17](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) 

![image](https://user-images.githubusercontent.com/53630619/201180997-11fd8320-28fa-46d6-aca7-0f8de77a8a32.png)

[Maven](https://maven.apache.org/download.cgi) 
Install dependencies:
```
mvn install
```
![image](https://user-images.githubusercontent.com/53630619/201184866-d289df6d-f85d-4492-af30-cca7461feda4.png)


#### Clone this repository
```
git clone https://github.com/tai-martins/QuotationManagement.git
```

## End-Points
More details at swagger documentation

##### *QuotationManagement endpoints port 8081

 To read all stocks
#### GET ``` http://localhost:8081/stock```

 To read a stock by stockId
#### GET ``` http://localhost:8081/stock```

 To register a new quote on a stock 
#### POST ``` http://localhost:8081/stock```

##### *Use the following model

```
{
   "stockId": "mglu3",
    "quotesMap": {
        "2022-11-11": 3.90
    }
}
```

##### *StockManager endpoints port 8080

 To read all stocks
#### GET ``` http://localhost:8080/stock```

 To register a new stock 
#### POST ``` http://localhost:8081/stock```

##### *Use the following model

```
{
   "id": "mglu3",
    "description": "Magalu"
    }
}
```
