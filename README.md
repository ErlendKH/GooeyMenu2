Hello,

This is an updated edition of the GooeyMenu library created by anshulagarwal06. 
As of 11th May 2020, he hasn't made any changes to it since Dec 26, 2016 (link: https://github.com/anshulagarwal06/GooeyMenu). 
I thought his menu has even more potential, and therefore I wanted to continue his work here.
This is my first library, so please have patience with me.

</br>

<h2>How to use the library</h2>

[![](https://jitpack.io/v/Erlend2/GooeyMenu2.svg)](https://jitpack.io/#Erlend2/GooeyMenu2)

</br>

**Step 1.** Add jitpack to the project build.gradle:
```gradle
allprojects {
    repositories {
        maven{url 'https://jitpack.io'}
    }
}
```

</br>

**Step 2.** Add it as an dependency to your app build.gradle:

```gradle
dependencies {
    implementation 'com.github.Erlend2:gooeymenu2:1.0.0'
}
```

</br>

**Step 3.** Add the GooeyMenu2 view to a xml layout:

```xml
    <com.package.name.GooeyMenu2
        android:id="@+id/gooey_menu"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        app:layout_constraintLeft_toLeftOf="parent" app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_marginBottom="64dp"
        app:no_of_menu="5"
        app:fab_radius="@dimen/big_circle_radius"
        app:menu_radius="@dimen/small_circle_radius"
        app:gap_between_menu_fab="@dimen/min_gap"
        app:menu_drawable="@array/drawable_array" />
```

Replace "com.package.name" with your app's package name. Layout properties can be changed as needed (I used ConstraintLayout).

As of now there are five particular properties of the GooeyMenu2 view:

* **no_of_menu**: Number of menu items.
* **fab_radius**: Radius or size of the main button that opens/hides the menu.
* **menu_radius**: Radius or size of the menu item buttons.
* **gap_between_menu_fab**: Distance between main button and the menu items.
* **menu_drawable**: A list of drawables. Can be set in xml by adding drawables to an array called "drawable_array" in array.xml.

</br>

**Step 4.** Add the interface and GooeyMenu2 view to an activity (sorry, I use kotlin for the testing):

Kotlin

```kotlin
class MainActivity:AppCompatActivity(), GooeyMenu2.GooeyMenuInterface {

    private var gooeyMenu:GooeyMenu2?=null    

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gooeyMenu=findViewById(R.id.gooey_menu)
        gooeyMenu!!.setOnMenuListener(this)
    }
    
    override fun menuItemClicked(menuNumber: Int) {
        // Interface: Triggers when pressing a menu item.
    }

    override fun menuOpen() {
        // Interface: Triggers when the menu opens.
    }

    override fun menuClose() {
        // Interface: Triggers when the menu closes.
    }

}
```

</br>

<h2>Current methods</h2>

Here are some of the programmatical options currently in place, and more are likely to be added as they get created:

* **isMenuOpen (boolean)**: Returns a boolean for whether the menu is open or closed.
* **borderColor (int)**: get/set the border color of the menu button.
* **circleColor (int)**: get/set the circle color of the menu button and items.
* **animationDuration (long)**: get/set the animation duration of opening/hiding the menu.
* **menuToItemDistance (int)**: get/set the distance between the menu button and the menu items. It converts a "dp" value to "int".
* **menuRadius (int)**: get/set the radius/size of the main button. It converts a "dp" value to "int".
* **itemRadius (int)**: get/set the radius/size of the menu items. It converts a "dp" value to "int".
* **getMenuIcons (List<Drawable>)**: Gets a list of drawables for the menu items.
* **setMenuIcons (Drawable, Drawable, Drawable, Drawable, Drawable)**: Sets new icons to the menu items programmatically. If less than five, just replace a drawable with "null".

</br>

<h2>Updates under development</h2>

This is still very much a work in progress, and I would very much appreciate help through pull requests. Here are some of the new functions I'd like to add:

* Set distance between menu items.
* Change/set menu item positions.
* Change/set nr of menu items dynamically.
* Create a GooeyMenu2 fully programmatically.
* Show an effect when pressing menu items.
* Add option to start the menu closed/open.
* Set colors for all menu items (multi-color support).
