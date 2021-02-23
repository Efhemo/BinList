# BinList


## Summary
The app pulls card information content from [BinList](​https://binlist.net/) API. It is built according to the `Model-View-ViewModel`(MVVM) architecture. This code architecture was inspired by [here](https://github.com/zizoh/ulesson)
## Architecture

The application follows clean architecture because of the benefits it brings to software which includes scalability, maintainability and testability.
It enforces separation of concerns and dependency inversion, where higher and lower level layers all depend on abstractions. In the project, the layers are separated into different gradle modules namely:

- presentation (as feature module)
- core
- Domain
- Remote (data-layer)


These modules are Kotlin modules except core and presentation module. The reason being that the low level layers need to be independent of the Android framework. One of the key points of clean architecture is that low level layers should be platform agnostic. As a result, the domain, data and presentation layers can be plugged into a kotlin multiplatform project for example, and it will run just fine because we don't depend on the android framework. 
The remote layers is an implementation details that can be provided in any form (Firebase, GraphQl server, REST, ROOM, SQLDelight, etc) as long as it conforms to the business rules / contracts defined in the data layer which in turn also conforms to contracts defined in domain.
The project has one feature module `cardinfo` that holds the UI code and presents data to the users. The main app module does nothing more than just tying all the layers of our app together. 

For dependency injection and asynchronous programming, the project uses Dagger Hilt and Coroutines. Dagger Hilt is a fine abstraction over the vanilla dagger boilerplate, and is easy to setup. Coroutines brings kotlin's expressibility and conciseness to asynchronous programming, along with a fine suite of operators that make it a robust solution. 

#### Presentation
The Viewmodel which is the presenter implementation is very lean. The reason for using the `Jetpack Viewmodel` is that it survives configuration changes, and thus ensures that the view state is persisted across screen rotation.  

MVVM is a good architecture to use when you don't want any surprises in user experience as state only comes from one source and is immutable. On the other hand, it does come with a lot of boilerplate.

#### Domain
The domain layer contains the app business logic. It defines contracts for data operations and domain models to be used in the app. All other layers have their own representation of these domain models, and Mapper classes (or adapters) are used to transform the domain models to each layer's domain model representation.
Usecases which represent a single unit of business logic are also defined in the domain layer, and are consumed by the presentation layer.
Writing mappers and models can take a lot of effort and result in boilerplate, but they make the codebase much more maintainable and robust by separating concerns.

#### Data
The Data layer implements the contract for providing data defined in the domain layer, and it in turn provides a contract that will be used to fetch data from the datasources.
We have only one data source - `Remote`. Remote relies on Retrofit library to fetch data from the binlist.net REST api.

## Features
* Clean Architecture with MVVM
* Kotlin Coroutines with Flow
* Dagger Hilt
* Kotlin Gradle DSL

## Prerequisite
To build this project, you require:
- Android Studio 4.1 or higher
- Gradle 6.5+



## Libraries
- [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Room](https://developer.android.com/training/data-storage/room)
- [Retrofit](https://square.github.io/retrofit/)  
- [Moshi](https://github.com/square/moshi)
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md)
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Truth](https://truth.dev/)
- [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)
- [Robolectric](http://robolectric.org/)
- [Kotlin coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Dagger Hilt](https://dagger.dev/hilt)
- [Kotlin Gradle DSL](https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin)
