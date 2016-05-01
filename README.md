# LambdAndroid

## Usage

### ViewPager.OnPageChangedListener

Before:

```java
pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
       System.out.println(position);
    }
});
```

After:

```java
pager.setOnPageChangeListener(new ViewPagers.OnPageChangeListener().onPageSelected(position -> {
   System.out.println(position);
}));
```

or

```java
pager.setOnPageChangeListener(ViewPagers.OnPageChangeListener.onPageChange(position -> {
   System.out.println(position);
));
```

### AsyncTask

Before:

```java
new AysncTask<String, Integer, String>() {
    @Override protected String doInBackground(String... texts) {
    ...
    }
    @Override protected void onProgressUpdate(Integer progres) {
    ...
    }
    @Override protected void onPostExecute(String result) {
    ...
    }
}.execute(url);
```

After:

```java
new LambdaAsyncTask<String, Integer, String>().doInBackground(texts -> {})
    .onProgressUpdate(progress -> {})
    .onPostExecute(result -> {})
    .execute(url);
```

or

```java
LambdaAsyncTask<String, Integer, String>.on(texts -> {}, progress -> {}, result -> {})
    .execute(url);
```

### TextWatcher

### AnimatorListener

```java
anim.addListener(new Animations.AnimatorListener()
    .cancel(animation -> {})
    .end(animation -> {})
    .repeat(animation -> {})
    .start(animation -> {})
    );
```

or

```java
anim.addListener(Animations.AnimatorListener
    .on(animation -> {}, animation -> {}, animation -> {}, animation -> {});
```

## DrawerListener

```java
drawer.setDrawerListener(new DrawerLayouts.DrawerListener()
    .close(view -> {})
    .open(view -> {})
    .slide((view, offset) -> {})
    .state(state -> {})
    );
```

or

```java
drawer.setDrawerListener(DrawerLayouts.DrawerListener
    .on(view -> {}, view -> {}, (view, offset) -> {}, state -> {}));
```


## TODO

```java
String url = "https://github.com/yongjhih";
LambdaAsyncTask<String>.on(texts -> {}, progress -> {}, result -> {})
    .execute(url);
```

or

```java
String url = "https://github.com/yongjhih";
LambdaAsyncTask.of(url).on(texts -> {}, progress -> {}, result -> {})
    .execute();
```


## Installation

jitpack.io

```gradle
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih:lambdandroid:-SNAPSHOT'
    compile 'com.github.yongjhih:lambdandroid-support-v4:-SNAPSHOT'
}
```

## LICENSE

Copyright 2015 8tory, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
