# nyt-most-popular

This is a small project that shows how to create a lean but flexible architecture in Android.
The app is very simple, it consists of 2 screens: Article List and Article Details.

The app displays the most popular articles from the [NYTimes API](https://developer.nytimes.com/apis) (currently hard-coded to 7 days).

In order to compile the app you need to obtain an API Token following the steps described [in the documentation](https://developer.nytimes.com/get-started).
Once you have the API Token, you have to place it in the `local.properties` file of this project's root directory, like so:

```
apiToken=your_api_token_here
```

I've included a `local.properties.sample` file as an example.

## Building the app

Once you've put the API Token in the `local.properties` file, you can build the app from the IDE or by running this gradle command:

```
./gradlew build
```

This command will build the APK, run the unit tests and the static analysis.
You can also install the app directly to an attached Android device by running:

```
./gradlew installDebug
```

## Tests

Some unit tests exist in the project to ensure the critical parts of the code works as expected. These tests are written in JUnit 4 and can be executed from the command line with the following command:

```
./gradlew test
```

Additionally, very simple Espresso tests have been created. They're inside the `app/src/androidTest` folder and only cover a basic use case of opening the app and tapping on an article.
These can be run from the IDE or from the command line by executing the following command:

```
./gradlew connectedCheck
```

The code coverage can be checked in the IDE (Android Studio and IntelliJ IDEA) as explained [here](https://developer.android.com/studio/test/#view_test_coverage).

## Architecture

The project architecture attempts to be simple but flexible. It resembles the MVP architecture:
 - The View is defined as an interface and there are specific implementations of these that communicate with Android views. This means that Android views are not leaked outside the View implementation classes.
 - The Presenter is platform-agnostic. This means that the presenter doesn't know about any Android framework classes, therefore it could be reused for the web client, for example. It uses the Model to fetch the data and passes it to the View.
 - The Model has been renamed to UseCase. This is in order to adhere a bit to the Clean Architecture. A UseCase is responsible for collecting data and transforming it so that it can be consumed by the Presenter. This includes networking, parsing data, caching it, etc.

Following this architecture allows for great testability, since the business logic sits in the UseCase (which is a plain java class), and the presentation logic sits in the Presenter (which is also a plain java class).

## Static analysis

The project only runs the Android Lint static analysis. This can be executed from the IDE or by running the following command:

```
./gradlew check
```

---

Note that I was unable to implement a nice design, but the app is responsive and it does work for both phones (separate screens for article list and details) and tablets (2-pane layout with article list and details in the same screen).
Additionally, since the NYTimes API doesn't provide the full article content, I decided to add a Floating action button in the Article Details screen that opens the full Article using [Chrome custom tabs](https://developer.chrome.com/multidevice/android/customtabs).
