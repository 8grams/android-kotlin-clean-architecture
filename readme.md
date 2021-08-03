# Android Kotlin Clean Architecture

This repository is used for demonstrating how to implement Clean Architecture approach on Android development.

The architecture of this application is heavily inspired by Antonio Leiva's [idea](https://antonioleiva.com/clean-architecture-android/) about pragmatic approach to the **Android Clean Architecture**, with a little *twist*, including leverage *Dagger Dependency Injection*, the implementation of *Repository Pattern*, and using Reactive Pattern to handle any asynchronous result. 

![image](https://i.ibb.co/kXWdz5Q/clean-architecture-own-layers.png)

It divides the application into 4 modules: `app, data, domain,` and `usecase` as described in the structure below:

```
+ app
  + src/main/java/dev/egrams/myapplication
    + infrastructures
    + api (Retrofit's interface)
    + di (Dagger component and modules)
      + components
      + modules
    + persistences (API or DB persistences)
    + ui
      + activities
      + adapters
      + presenters
    + MyApplication.kt
 
 + data
   + src/main/java/dev/egrams/data
      + payload
        + api (API Payload)
        + contracts (Payloads Interfaces)
      + persistences
        + contracts (Persistences Interfaces)
        + mappers (Domain mapper)
        + repositories
        
 + domain
   + src/main/java/dev/egrams/domain
     + User.kt
 
 + usecase
   + src/main/java/dev/egrams/usecases
     + GetUsers.kt
```

## Important Folders


### infrastructures (app)

This folder contains any class, usually class for library implementation, such as Retrofit API, component & modules for Dagger, or it can Android Room DAO

### payload (data)

It contains many data classes related to the request/response from API or local DB. Anytime you wanna add new endpoint or create new Room entities, you will start from this folder

### persistences (data)

This folder contains any necessary files related to persistence. Usually you will maintain two main data sources: API and local db. It consists of 3 folders. First is `contracts`, it holds interfaces for persistence. Every persistence should implements the interfaces there. Second is `mappers`, contains really important classes since its responsibility is ti map data from any data sources to domain. The last is `repositories`, basically it is an additional layer above persistence. Repository is not just a class that execute persistence class, but it also does another important job, for example usually, run mapper to convert response from data source to domain

## Notable Libraries

This small application depends on some notables libraries in order to achieve clean architecture approach.

### Retrofit

Retrofit is the backbone of all API Request implementation in this application.

### Dagger

This application really leverages the power of dependency injection. Almost no class is created manually, instead, we put them into Dagger IOC Container. So, it's very easy and expressive to get an object of a class

### RxJava & RxAndroid

Probably the most used library in this module. RxJava is the core of the reactive programming approached used in this module. RxJava is fully integrated to Retrofit.

