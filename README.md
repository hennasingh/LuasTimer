# LuasTimer
This is a mini Luas app that shows *Inbound* trams from Stillorgan and *Outbound* trams from Marlborough using [LuasAPI](https://data.gov.ie/dataset/luas-forecasting-api) based on the time the app is opened

### Overview
Its a single screen app that uses MVVM and repository architecture pattern to display station name, direction of the trams and has a refresh button to refresh the data

### Libraries used in the Project
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [TikXml Parser](https://github.com/Tickaroo/tikxml)
- [Retrofit](https://square.github.io/retrofit/)
- [Dagger](https://github.com/google/dagger)
- [RxJava](https://github.com/ReactiveX/RxAndroid)

### Screenshots

**Nexus6P**

Stllorgan Inbound | Marlborough Outbound | New UI (Stillorgan Inbound)
--- | --- | ---
![Stillorgan Stop](/images/forecast.png) | ![Marlborough Stop](/images/marStop.png) | ![Stillorgan](/images/newSti.png)




### More Features to implement

- [ ] Write a test for ViewModel
- [ ] Error Handling for Http Responses
- [X] Updated UI


## License

Copyright (c) 2019 Henna Singh

```
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
