# Learning Appium
This is a personal project used for learning Appium for mobile automation.

It uses the [Minitask](https://github.com/redlor/Minitask) as the app under test.


## Toolset
This code is written in Java and uses the following libraries / frameworks

 - **Appium** for driving the application on a mobile device
 - **Cucumber** for writing scenarios in natural language
 - **JUnit** for assertions
 - **Spring** for dependency injection
 
## Page Objects
The PageObjects (PO)s abstracts the actual implementation from the screen and provides an interface to driving it naturally.

Ideally it shouldn't have methods like `fillEmailInput(String email)` or `tapOnSubmitButton()` because these names are about the screen implementation, not its features.

A good method should indicate the action that the application will receive, hiding the "how" from its user, like `authenticate(String email, String password)` or `nextPage()`.

It doesn't matter how the PO will achieve this actions.

### Split implementation for Android and iOS
Sometimes the application has different behavior between platforms, and the PO/Test can get messy if we start to write conditional code.

This is solved by using Spring dependency injection framework to inject the PO in to the step definitions.

All PO's should have an `interface` defined and this interface should be used in the tests.

If a PO is specific for a platform (Android/iOS), it should be implemented in the corresponding package: 
 - `com.learnappium.pageobject.impl.android` for Android PO's
 - `com.learnappium.pageobject.impl.ios` for iOS PO's
 
If a PO is generic and can be used for both platforms, it should be placed in the `com.learnappium.pageobject.impl.common` package.

> :warning: A interface cannot be implemented in the common package AND in the platform specific package.
>If this happens Spring will throw an error because it will not be able to decide which implementation should be injected. 

## Execution
TBD