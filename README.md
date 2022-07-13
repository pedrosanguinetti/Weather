# GOAL

Write a simple weather app that utilizes the OpenWeatherMap or any free weather API of
your choice to display the current and upcoming weather. Please do what you can between
2 hours on these features:
- Display current conditions
- Responsive display of upcoming 10-day forecast
- Allow users to refresh on demand

## GENERAL REQUIREMENTS

The app needs to be written in Kotlin. It’s expected to run in portrait orientation Android
mobile only (not tablet) and target Android 11 and above. There are a lot of data points
returned in a forecast response, but the app needs only display the most important
information. Use any third-party frameworks you deem fit.

## Architecture

- MVVM
- ViewBinding
- Coroutines
- Android KTX
- Retrofit
- Hilt for DI

## Others

- Picasso for images
- Swipe to refresh library
- Interceptors used to debug API responses