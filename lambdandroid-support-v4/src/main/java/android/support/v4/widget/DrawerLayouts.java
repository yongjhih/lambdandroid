package android.support.v4.widget;

import android.view.View;

public class DrawerLayouts {
    private DrawerLayouts() {
    }

    public static class DrawerListener implements DrawerLayout.DrawerListener {
        @Override
        public void onDrawerClosed(View drawerView) {
            if (onDrawerClosed == null) return;
            onDrawerClosed.call(drawerView);
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            if (onDrawerOpened == null) return;
            onDrawerOpened.call(drawerView);
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            if (onDrawerSlide == null) return;
            onDrawerSlide.call(drawerView, slideOffset);
        }

        @Override
        public void onDrawerStateChanged(int newState) {
            if (onDrawerStateChanged == null) return;
            onDrawerStateChanged.call(newState);
        }

        Action1<View> onDrawerClosed;
        Action1<View> onDrawerOpened;
        Action2<View, Float> onDrawerSlide;
        Action1<Integer> onDrawerStateChanged;

        public DrawerListener close(Action1<View> onDrawerClosed) {
            onDrawerClosed = onDrawerClosed;
            return this;
        }

        public DrawerListener open(Action1<View> onDrawerOpened) {
            onDrawerOpened = onDrawerOpened;
            return this;
        }

        public DrawerListener slide(Action2<View, Float> onDrawerSlide) {
            onDrawerSlide = onDrawerSlide;
            return this;
        }

        public DrawerListener state(Action1<Integer> onDrawerStateChanged) {
            onDrawerStateChanged = onDrawerStateChanged;
            return this;
        }

        public static DrawerListener on(Action1<View> onDrawerClosed) {
            return new DrawerListener().close(onDrawerClosed);
        }

        public static DrawerListener on(Action1<View> onDrawerClosed, Action1<View> onDrawerOpened) {
            return new DrawerListener().close(onDrawerClosed).open(onDrawerOpened);
        }

        public static DrawerListener on(Action1<View> onDrawerClosed, Action1<View> onDrawerOpened, Action2<View, Float> onDrawerSlide) {
            return new DrawerListener().close(onDrawerClosed).open(onDrawerOpened).slide(onDrawerSlide);
        }

        public static DrawerListener on(Action1<View> onDrawerClosed, Action1<View> onDrawerOpened, Action2<View, Float> onDrawerSlide, Action1<Integer> onDrawerStateChanged) {
            return new DrawerListener().close(onDrawerClosed).open(onDrawerOpened).slide(onDrawerSlide).state(onDrawerStateChanged);
        }
    }

    interface Action1<T> {
        void call(T t);
    }

    interface Action2<T, T2> {
        void call(T t, T2 t2);
    }
}

